package com.leng.analizador.analyzer.controller.parser.jss;

import com.leng.analizador.analyzer.controller.parser.Parseable;
import com.leng.analizador.analyzer.models.State;
import com.leng.analizador.analyzer.models.Token;
import com.leng.analizador.analyzer.utils.FilePosition;
import com.leng.analizador.analyzer.utils.ManagedFiles;

import java.io.IOException;

public class JSSParser implements Parseable {

  private final TransitionFunctionController transictionFunction = new TransitionFunctionController();
  private int line;
  private int column;
  private int positionContent;
  private String path;
  private String content;
  private boolean isFileRead = false;
  private AlphabetSymbolController alphabetSymbol = new AlphabetSymbolController();
  private StringBuilder temporalWord = new StringBuilder();

  @Override
  public boolean readFile(String path) {
    this.path = path;
    try {
      content = ManagedFiles.readTextFile(path);
    } catch (IOException e) {
      return false;
    }
    isFileRead = true;
    line = 0;
    column = 0;
    positionContent = 0;
    return true;
  }

  @Override
  public boolean isEndOfFile() {
    ignoreWhiteSpace();
    if (positionContent == content.length()) {
      return true;
    }
    return false;
  }

  @Override
  public Token getToken() {
    ignoreWhiteSpace();
    temporalWord = new StringBuilder();
    State actualState = transictionFunction.getInitState();
    char actualChar = content.charAt(positionContent);
    do {
      actualChar = content.charAt(positionContent);
      actualState =
        transictionFunction.delta(
          actualState,
          alphabetSymbol.getAlphabetSymbol(actualChar)
        );
      column++;
      temporalWord.append(actualChar);
    } while (
      (positionContent < content.length()) &&
      (
        ((positionContent + 1) < content.length()) &&
        (
          transictionFunction.isFinishToken(
            actualState,
            alphabetSymbol.getAlphabetSymbol(
              content.charAt(positionContent + 1)
            )
          )
        )
      )
    );

    FilePosition filePosition = new FilePosition(line, column, path);

    return new Token(
      transictionFunction.getTokenType(actualState),
      filePosition,
      temporalWord.toString()
    );
  }

  private void ignoreWhiteSpace() {
    while (
      (positionContent < content.length()) &&
      (alphabetSymbol.isWhiteSpace(content.charAt(positionContent)))
    ) {
      if (alphabetSymbol.isNewLine(content.charAt(positionContent))) {
        positionContent++;
        line++;
        column = 0;
        continue;
      }

      if (alphabetSymbol.isWhiteSpace(content.charAt(positionContent))) {
        column++;
        continue;
      }
      break;
    }
  }
}
/*
  

0101010 1 01 01 01 01 01 
1 01 0 10 10        
   1 01 01 01 0
10           




 */

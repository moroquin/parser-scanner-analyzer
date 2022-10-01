package com.leng.analizador.analyzer.controller.parser.jss;

import com.leng.analizador.analyzer.controller.parser.Parseable;
import com.leng.analizador.analyzer.models.Token;
import com.leng.analizador.analyzer.models.parser.AlphabetSymbol;
import com.leng.analizador.analyzer.models.parser.State;
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
  private AcceptanceStateController accpentanceStates = new AcceptanceStateController();

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
    State temporalState = actualState;

    do {
      temporalState = actualState;
      actualChar = content.charAt(positionContent);
      temporalState =
        transictionFunction.delta(
          actualState,
          alphabetSymbol.getAlphabetSymbol(actualChar)
        );
      if (temporalState != State.SA) {
        column++;
        positionContent++;
        temporalWord.append(actualChar);
        if (
          alphabetSymbol.getAlphabetSymbol(actualChar) == AlphabetSymbol.NEWLINE
        ) {
          line++;
        }
      }
    } while (
      (positionContent + 1 < content.length()) &&
      (temporalState != State.SA && temporalState != State.SR)
    );

    FilePosition filePosition = new FilePosition(line, column, path);

    return new Token(
      accpentanceStates.getTokenType(actualState),
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

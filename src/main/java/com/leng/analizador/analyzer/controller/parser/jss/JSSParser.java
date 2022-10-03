package com.leng.analizador.analyzer.controller.parser.jss;

import com.leng.analizador.analyzer.controller.ErrorController;
import com.leng.analizador.analyzer.controller.parser.Parseable;
import com.leng.analizador.analyzer.models.Token;
import com.leng.analizador.analyzer.models.error.ErrorType;
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
  private AlphabetSymbolController alphabetSymbolController = new AlphabetSymbolController();
  private StringBuilder temporalWord = new StringBuilder();
  private AcceptanceStateController accpentanceStates = new AcceptanceStateController();
  private ErrorController errorController = new ErrorController();

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
  public boolean isEndOfFile() throws IOException {
    if (!isFileRead) throw new IOException("Should read a file before");
    ignoreWhiteSpace();
    if (positionContent >= content.length()) {
      return true;
    }
    return false;
  }

  /* (non-Javadoc)
   * @see com.leng.analizador.analyzer.controller.parser.Parseable#getToken()
   */
  @Override
  public Token getToken() throws IOException {
    if (!isFileRead) throw new IOException("Should read a file before");

    ignoreWhiteSpace();

    temporalWord = new StringBuilder();

    State actualState = transictionFunction.getInitState();
    char actualChar = content.charAt(positionContent);
    State temporalState = actualState;
    AlphabetSymbol alphabetSymbol = null;
    int initialLine = line;
    int initialColumn = column;

    do {
      actualState = temporalState;
      actualChar = content.charAt(positionContent);
      alphabetSymbol = alphabetSymbolController.getAlphabetSymbol(actualChar);
      temporalState = transictionFunction.delta(actualState, alphabetSymbol);

      if (temporalState.equals(State.SA)) {
        //System.out.println("break");
        break;
      }

      column++;
      positionContent++;
      temporalWord.append(actualChar);
      /*System.out.println(temporalWord);
      System.out.println("temporal State: "+temporalState.name());
      System.out.println("actual State: "+temporalState.name());
      System.out.println(alphabetSymbol.name());
      System.out.println("\n");*/

      if (alphabetSymbol == AlphabetSymbol.NEWLINE) {
        line++;
      }

      if (temporalState.equals(State.SE)) {
        break;
      }
    } while (positionContent + 1 < content.length());

    FilePosition filePosition = new FilePosition(
      initialLine,
      initialColumn,
      path
    );

    if (temporalState.equals(State.SE)) {
      errorController.appendLexical(
        transictionFunction.getExpectedSymbols(actualState),
        alphabetSymbol,
        new FilePosition(line, column-1, path)
      );
      actualState = temporalState;
    }

    return new Token(
      accpentanceStates.getTokenType(actualState),
      filePosition,
      temporalWord.toString()
    );
  }

  private void ignoreWhiteSpace() {
    while (positionContent < content.length()) {
      if (alphabetSymbolController.isNewLine(content.charAt(positionContent))) {
        positionContent++;
        line++;
        column = 0;
        continue;
      }

      if (
        alphabetSymbolController.isWhiteSpace(content.charAt(positionContent))
      ) {
        positionContent++;
        column++;
        continue;
      }

      break;
    }
  }
}

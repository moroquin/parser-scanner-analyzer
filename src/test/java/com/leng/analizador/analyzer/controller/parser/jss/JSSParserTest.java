package com.leng.analizador.analyzer.controller.parser.jss;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.leng.analizador.analyzer.controller.parser.Parseable;
import com.leng.analizador.analyzer.models.Token;
import com.leng.analizador.analyzer.models.TokenType;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Before;
import org.junit.Test;

public class JSSParserTest {

  private final Path resourceDirectory = Paths.get(
    "src",
    "test",
    "resources",
    "file1.txt"
  );
  private final Path resourceDirectoryEmpty = Paths.get(
    "src",
    "test",
    "resources",
    "file2.txt"
  );
  private final Path resourceDirectoryIncorrect = Paths.get(
    "src",
    "test",
    "resources",
    "file0.txt"
  );
  private final String absolutePath = resourceDirectory
    .toFile()
    .getAbsolutePath();
  private final String incorrectAbsolutePath = resourceDirectoryIncorrect
    .toFile()
    .getAbsolutePath();
  private final String emptyAbsolutePath = resourceDirectoryEmpty
    .toFile()
    .getAbsolutePath();
  private Parseable jssParser;

  @Before
  public void setup() {
    jssParser = new JSSParser();
  }

  @Test
  public void shouldReadFileReturnTrue() {
    assertTrue(jssParser.readFile(absolutePath));
  }

  @Test
  public void shouldntReadFileReturnFalse() {
    assertFalse(jssParser.readFile(incorrectAbsolutePath));
  }


  @Test
  public void shouldReturnIsEndOfFile() throws IOException{
    jssParser.readFile(emptyAbsolutePath);
    assertTrue(jssParser.isEndOfFile());
  }

  @Test
  public void shouldReturnIsNotEndOfFile() throws IOException{
    jssParser.readFile(absolutePath);
    assertFalse(jssParser.isEndOfFile());
  }



  @Test(expected = IOException.class)
  public void shouldReturnIOExceptionEndOfFile() throws IOException{
    //jssParser.readFile(incorrectAbsolutePath);
    jssParser.isEndOfFile();
  }



  @Test(expected = IOException.class)
  public void shouldReturnIOExceptionInGetToken() throws IOException{
    //jssParser.readFile(incorrectAbsolutePath);
    jssParser.getToken();
  }

  @Test
  public void shouldReturnFirstTokenInGetToken() throws IOException{
    jssParser.readFile(absolutePath);
    Token token = jssParser.getToken();
    assertEquals("123456", token.getLexeme());
    assertEquals(TokenType.NUMBER, token.getTokenType());
    assertEquals(0, token.getLine());
    assertEquals(0, token.getColumn());
  }


  @Test
  public void shouldReturnSecondTokenInGetToken() throws IOException{
    jssParser.readFile(absolutePath);
    Token token = jssParser.getToken();
    token = jssParser.getToken();
    assertEquals("asdf", token.getLexeme());
    assertEquals(TokenType.ID, token.getTokenType());
    assertEquals(0, token.getLine());
    assertEquals(7, token.getColumn());
  }


  @Test
  public void shouldReturnFirstErrorTokenInGetToken() throws IOException{
    jssParser.readFile(absolutePath);
    Token token = jssParser.getToken();
    token = jssParser.getToken();
    token = jssParser.getToken();
    token = jssParser.getToken();
    assertEquals("12d", token.getLexeme());
    assertEquals(TokenType.ERROR, token.getTokenType());
    assertEquals(0, token.getLine());
    assertEquals(21, token.getColumn());
  }


  @Test
  public void shouldReturnFirstTokenSecondLineInGetToken() throws IOException{
    jssParser.readFile(absolutePath);
    Token token = jssParser.getToken();//123456
    token = jssParser.getToken(); //asdf
    token = jssParser.getToken();//a123dfs
    token = jssParser.getToken();//12d
    token = jssParser.getToken();//asdf
    assertEquals("asdf", token.getLexeme());
    assertEquals(TokenType.ID, token.getTokenType());
    assertEquals(1, token.getLine());
    assertEquals(0, token.getColumn());
  }

  @Test
  public void shouldReadAllTokensTillEndOfFile() throws IOException{
    jssParser.readFile(absolutePath);
    
    int cont = 0;
    while(!jssParser.isEndOfFile()){
      cont++;
      jssParser.getToken();
    }
    assertEquals(8, cont);

  }


}

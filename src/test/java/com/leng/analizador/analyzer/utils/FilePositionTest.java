package com.leng.analizador.analyzer.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FilePositionTest {

  private final String path = "/home/moroquin/file1.txt";
  private final int line = 5;
  private final int column = 7;

  private final FilePosition filePosition = new FilePosition(
    line,
    column,
    path
  );

  @Test
  public void testShouldGetColumn() {
    assertEquals(column, filePosition.getColumn());
  }

  @Test
  public void testShouldGetFilePath() {
    assertEquals(path, filePosition.getFilePath());
  }

  @Test
  public void testShouldGetLine() {
    assertEquals(line, filePosition.getLine());
  }
}

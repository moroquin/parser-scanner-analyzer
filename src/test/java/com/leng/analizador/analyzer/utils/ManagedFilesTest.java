package com.leng.analizador.analyzer.utils;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Test;

public class ManagedFilesTest {
 
  private final Path resourceDirectory = Paths.get("src", "test", "resources","file1.txt");
  private final String absolutePath = resourceDirectory
    .toFile()
    .getAbsolutePath();

  @Test
  public void shouldReadFile() throws IOException {
    String infoFile1 = "123456 asdf a123dfs  12d\nasdf asd 123 654 ";
    String pathFile1 = absolutePath;
    String readFile1 = "";
    readFile1 = ManagedFiles.readTextFile(pathFile1);
    assertEquals(infoFile1, readFile1);
  }

  @Test(expected = IOException.class)
  public void shouldThrowException() throws IOException {
    String pathFile1 = absolutePath + "/file0.txt";
    ManagedFiles.readTextFile(pathFile1);
  }
}

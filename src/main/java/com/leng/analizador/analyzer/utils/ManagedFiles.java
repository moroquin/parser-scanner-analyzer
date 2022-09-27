package com.leng.analizador.analyzer.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ManagedFiles {
    public static String readTextFile(String path) throws IOException{
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(path)));
        return data;
    }
}

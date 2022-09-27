package com.leng.analizador.analyzer.controller.parser;

import com.leng.analizador.analyzer.models.Token;

public interface Parseable {

    boolean readFile(String path);

    boolean isEndOfFile();

    Token getToken();
    
}

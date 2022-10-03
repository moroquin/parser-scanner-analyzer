package com.leng.analizador.analyzer.controller.parser;

import java.io.IOException;

import com.leng.analizador.analyzer.models.Token;

public interface Parseable {

    boolean readFile(String path) ;

    boolean isEndOfFile() throws IOException ;

    Token getToken() throws IOException ;
    
}

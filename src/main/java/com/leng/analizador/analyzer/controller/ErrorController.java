package com.leng.analizador.analyzer.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.leng.analizador.analyzer.models.error.ErrorType;
import com.leng.analizador.analyzer.models.error.Error;
import com.leng.analizador.analyzer.models.parser.AlphabetSymbol;
import com.leng.analizador.analyzer.utils.FilePosition;

public class ErrorController {

    private final List<Error> errorList = new ArrayList<Error>();

    public boolean getErrors() {
        return false;
    }

    

    public void appendLexical(List<AlphabetSymbol> expectedSymbols, AlphabetSymbol unexpectedAlphabetSymbol, FilePosition filePosition) {
        String symbolsExpected = "s,l"; //expectedSymbols.stream().collect(Collectors.joining(","));
        
        errorList.add(new Error(ErrorType.LEXICAL, symbolsExpected, filePosition.toString()+", expected: "+expectedSymbols+", unexpected"+unexpectedAlphabetSymbol));
    }
    
}

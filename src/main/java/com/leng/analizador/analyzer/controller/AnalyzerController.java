package com.leng.analizador.analyzer.controller;

import com.leng.analizador.analyzer.controller.parser.Parseable;
import com.leng.analizador.analyzer.controller.scanner.Scannable;

public class AnalyzerController {

    private Scannable scanner;
    private Parseable parser;
    private SymbolTableController symbolTable;
    private ErrorController error;


    public boolean setSource(String firstPath) {
        return false;
    }

    public boolean doAnalysis() {
        return false;
    }

    public boolean areErrors() {
        return false;
    }

    public char[] getSyntaxTree() {
        return null;
    }

    public char[] getSymbolTable() {
        return null;
    }

}

package com.leng.analizador.analyzer.controller;

import com.leng.analizador.analyzer.controller.parser.Parseable;
import com.leng.analizador.analyzer.controller.parser.ParserFactory;
import com.leng.analizador.analyzer.controller.scanner.Scannable;
import com.leng.analizador.analyzer.controller.scanner.ScannerFactory;
import com.leng.analizador.analyzer.models.SymbolTable;
import com.leng.analizador.analyzer.models.SyntaxTree;

public class AnalyzerController {

    private Scannable scanner;
    private Parseable parser;
    private SymbolTableController symbolTable;
    private ErrorController error;
    private boolean isSourceLoaded = false;
    private boolean isAnalized = false;

    public AnalyzerController(ScannerFactory scannerF, ParserFactory parserF){
        this.parser = parserF.getParser();
        this.scanner = scannerF.getScanner();
        this.scanner.setParser(this.parser);
        this.parser.setSymbolTable(this.symbolTable);
        this.scanner.setSymbolTable(this.symbolTable);
    }

    public boolean setSource(String path) {
        if (parser.setSource(path)){
            isSourceLoaded = true;
        }
        return isSourceLoaded;
    }

    public boolean doAnalysis() {
        if (!isSourceLoaded ){
            return false;
        }
        
        isAnalized = true;
        if (scanner.verifyGrammar()){
            return true;
        }
        return false;

    }

    public boolean areErrors() {
        if (!isSourceLoaded || !isAnalized){
            return true;
        }

        return error.getErrors();
    }

    public SyntaxTree getSyntaxTree() {
        if (!isSourceLoaded || !isAnalized){
            return null;
        }
        return scanner.getSyntaxTree();
    }

    public SymbolTable getSymbolTable() {
        return SymbolTableController.getSymbolTable();
    }

}

package com.leng.analizador.analyzer.controller.parser;

import com.leng.analizador.analyzer.controller.SymbolTableController;

public interface Parseable {

    boolean setSource(String path);

    void setSymbolTable(SymbolTableController symbolTable);
    
}

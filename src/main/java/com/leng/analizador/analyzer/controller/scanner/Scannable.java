package com.leng.analizador.analyzer.controller.scanner;

import com.leng.analizador.analyzer.controller.SymbolTableController;
import com.leng.analizador.analyzer.models.SyntaxTree;
import com.leng.analizador.analyzer.controller.parser.Parseable;

public interface Scannable {

    void setParser(Parseable parser);

    boolean verifyGrammar();

    void setSymbolTable(SymbolTableController symbolTable);

    SyntaxTree getSyntaxTree();
    
}

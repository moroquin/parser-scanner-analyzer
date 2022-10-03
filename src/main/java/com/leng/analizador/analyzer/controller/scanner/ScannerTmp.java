package com.leng.analizador.analyzer.controller.scanner;

import java.io.IOException;

import com.leng.analizador.analyzer.controller.SymbolTableController;
import com.leng.analizador.analyzer.controller.parser.Parseable;
import com.leng.analizador.analyzer.models.SyntaxTree;

public class ScannerTmp implements Scannable {

    private Parseable parser;

    @Override
    public void setParser(Parseable parser) {
        this.parser = parser;
        
    }

    @Override
    public boolean verifyGrammar() {
        parser.readFile("/home/oliver/tmp.txt");
        try {
            while (!parser.isEndOfFile()) {
                System.out.println(parser.getToken());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        
        return false;
    }

    @Override
    public void setSymbolTable(SymbolTableController symbolTable) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public SyntaxTree getSyntaxTree() {
        // TODO Auto-generated method stub
        return null;
    }
    
}

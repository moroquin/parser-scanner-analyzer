package com.leng.analizador.analyzer.controller.parser;

import com.leng.analizador.analyzer.controller.parser.jss.JSSParser;


import java.util.function.Supplier;

public enum ParserFactory {
    JSSPARSER(()-> new JSSParser());
    ;

    private final Supplier<Parseable> parser;

    ParserFactory(Supplier<Parseable> parser){
        this.parser = parser;
        
    }

    public Parseable getParser() {
        return null;
    }
    
}

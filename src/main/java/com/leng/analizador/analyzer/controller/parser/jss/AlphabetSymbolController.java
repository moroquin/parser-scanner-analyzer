package com.leng.analizador.analyzer.controller.parser.jss;

import com.leng.analizador.analyzer.models.parser.AlphabetSymbol;

public class AlphabetSymbolController {

    public boolean isWhiteSpace(char charAt) {
        return Character.isWhitespace(charAt)||isNewLine(charAt);
    }

    public boolean isNewLine(char charAt) {
        return (charAt=='\r')||(charAt=='\n');
    }

    public AlphabetSymbol getAlphabetSymbol(char charAt) {
        for (AlphabetSymbol alphabetSymbol : AlphabetSymbol.values()) {
            if (alphabetSymbol.isA(charAt)){
                return alphabetSymbol;
            }
        }
        
        return AlphabetSymbol.ERROR;
    }

}

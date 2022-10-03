package com.leng.analizador.analyzer.controller.parser.jss;

import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;

import com.leng.analizador.analyzer.models.parser.AlphabetSymbol;

public class AlphabetSymbolControllerTest {

    private AlphabetSymbolController alphabetSymbol;

    @Before
    public void setUp(){
        alphabetSymbol = new AlphabetSymbolController();
    }

    @Test
    public void shouldReturnErrorSymbolType(){
        assertEquals(AlphabetSymbol.ERROR, alphabetSymbol.getAlphabetSymbol('%'));
        assertEquals(AlphabetSymbol.ERROR, alphabetSymbol.getAlphabetSymbol('*'));
        assertEquals(AlphabetSymbol.ERROR, alphabetSymbol.getAlphabetSymbol('-'));
        assertEquals(AlphabetSymbol.ERROR, alphabetSymbol.getAlphabetSymbol('/'));
    }

    @Test
    public void shouldReturnWhiteSpaceSymbolType(){
        assertEquals(AlphabetSymbol.ESPACE, alphabetSymbol.getAlphabetSymbol(' '));
        
    }

    @Test
    public void shouldReturnNewLineSymbolType(){
        assertEquals(AlphabetSymbol.NEWLINE, alphabetSymbol.getAlphabetSymbol('\n'));
        assertEquals(AlphabetSymbol.NEWLINE, alphabetSymbol.getAlphabetSymbol('\r'));
        
    }

    @Test
    public void shouldReturnExactSymbolType(){
        assertEquals(AlphabetSymbol.DIGIT, alphabetSymbol.getAlphabetSymbol('4'));
        assertEquals(AlphabetSymbol.DIGIT, alphabetSymbol.getAlphabetSymbol('9'));
        assertEquals(AlphabetSymbol.LETTER, alphabetSymbol.getAlphabetSymbol('l'));
        assertEquals(AlphabetSymbol.LETTER, alphabetSymbol.getAlphabetSymbol('P'));
        
    }
}

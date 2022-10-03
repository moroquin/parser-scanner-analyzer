package com.leng.analizador.analyzer.models.parser;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;


public class AlphabetSymbolTest {

    @Test
    public void shuldHasErrorSymbol(){
        assertTrue(Arrays.asList(AlphabetSymbol.values()).stream().anyMatch(s -> s.name().equals("ERROR")));
    }

    @Test
    public void shuldHasLeastOneExtraSymbol(){
        assertTrue(AlphabetSymbol.values().length >=2);
    }

    @Test
    public void shouldReturnTrueWithALetterInput() {
        assertTrue(AlphabetSymbol.LETTER.isA('a'));
        assertTrue(AlphabetSymbol.LETTER.isA('f'));
        assertTrue(AlphabetSymbol.LETTER.isA('e'));
        assertTrue(AlphabetSymbol.LETTER.isA('z'));
    }


    @Test
    public void shouldReturnFalseWithALetterInput() {
        assertFalse(AlphabetSymbol.LETTER.isA('3'));
        assertFalse(AlphabetSymbol.LETTER.isA('$'));
        assertFalse(AlphabetSymbol.LETTER.isA('*'));
        assertFalse(AlphabetSymbol.LETTER.isA('/'));
    }



    @Test
    public void shouldReturnTrueWithADigitInput() {
        assertTrue(AlphabetSymbol.DIGIT.isA('1'));
        assertTrue(AlphabetSymbol.DIGIT.isA('2'));
        assertTrue(AlphabetSymbol.DIGIT.isA('3'));
        assertTrue(AlphabetSymbol.DIGIT.isA('4'));
    }


    @Test
    public void shouldReturnFalseWithADigitInput() {
        assertFalse(AlphabetSymbol.DIGIT.isA('a'));
        assertFalse(AlphabetSymbol.DIGIT.isA('f'));
        assertFalse(AlphabetSymbol.DIGIT.isA('*'));
        assertFalse(AlphabetSymbol.DIGIT.isA('/'));
    }


    @Test
    public void shouldReturnTrueWithAErrorInput() {
        assertTrue(AlphabetSymbol.ERROR.isA('#'));
        assertTrue(AlphabetSymbol.ERROR.isA('&'));
        assertTrue(AlphabetSymbol.ERROR.isA('*'));
        assertTrue(AlphabetSymbol.ERROR.isA('('));
    }


    @Test
    public void shouldReturnFalseWithAErrorInput() {
        assertFalse(AlphabetSymbol.ERROR.isA('a'));
        assertFalse(AlphabetSymbol.ERROR.isA('f'));
        assertFalse(AlphabetSymbol.ERROR.isA('4'));
        assertFalse(AlphabetSymbol.ERROR.isA('5'));
    }
}

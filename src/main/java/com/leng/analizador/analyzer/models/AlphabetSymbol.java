package com.leng.analizador.analyzer.models;

import java.util.function.Predicate;

public enum AlphabetSymbol {
    DIGIT((c)->Character.isDigit(c)), 
    LETTER((c)->Character.isLetter(c)),
    ERROR((c)->!(AlphabetSymbol.DIGIT.isA(c)||AlphabetSymbol.LETTER.isA(c)));

    private final Predicate<Character> isThisType;

    AlphabetSymbol(Predicate<Character> isThisType){
        this.isThisType = isThisType;
    }

    public boolean isA(Character character){
        return isThisType.test(character);
    }

}

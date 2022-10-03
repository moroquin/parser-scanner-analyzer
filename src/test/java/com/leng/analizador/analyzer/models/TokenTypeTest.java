package com.leng.analizador.analyzer.models;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class TokenTypeTest {

    @Test
    public void shouldHasAErrorType(){
        assertTrue(Arrays.asList(TokenType.values()).stream().anyMatch(t->t.name().equals("ERROR")));
    }

    @Test
    public void shouldHasAtLeastOneExtraTokenType(){
        assertTrue(TokenType.values().length>=2);
    }
}

package com.leng.analizador.analyzer.models.parser;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class StateTest {

    @Test
    public void shouldHasAErrorState(){
        assertTrue(Arrays.asList(State.values()).stream().anyMatch(s -> s.name().equals("SE")));
    }

    @Test
    public void shouldHasAAcceptaneState(){
        assertTrue(Arrays.asList(State.values()).stream().anyMatch(s -> s.name().equals("SA")));
    }

    @Test
    public void shouldAtLeastOneExtraState(){
        assertTrue(State.values().length >=3);
    }

}

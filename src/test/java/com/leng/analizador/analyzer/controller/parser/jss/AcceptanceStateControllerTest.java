package com.leng.analizador.analyzer.controller.parser.jss;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.leng.analizador.analyzer.models.TokenType;
import com.leng.analizador.analyzer.models.parser.State;

public class AcceptanceStateControllerTest {

    private final AcceptanceStateController acceptanceState = new AcceptanceStateController();

    @Test
    public void shouldReturnAcceptanceState(){
        assertEquals(TokenType.ID, acceptanceState.getTokenType(State.S1));
        assertEquals(TokenType.NUMBER, acceptanceState.getTokenType(State.S2));
    }

    @Test
    public void shouldReturnErrorAcceptanceState(){
        assertEquals(TokenType.ERROR, acceptanceState.getTokenType(State.SE));
    }


    @Test
    public void shouldReturnErrorAcceptanceStateIfTheStateDoesntExist(){
        assertEquals(TokenType.ERROR, acceptanceState.getTokenType(State.S0));
    }


}

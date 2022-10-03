package com.leng.analizador.analyzer.controller.parser.jss;

import java.util.HashMap;

import com.leng.analizador.analyzer.models.TokenType;
import com.leng.analizador.analyzer.models.parser.State;

public class AcceptanceStateController {

    private final HashMap<State, TokenType> mapAcceptanceStates;

    {
        mapAcceptanceStates = new HashMap<>();
        mapAcceptanceStates.put(State.S1, TokenType.ID);
        mapAcceptanceStates.put(State.S2, TokenType.NUMBER);
        mapAcceptanceStates.put(State.SE, TokenType.ERROR);

    }

    public TokenType getTokenType(State actualState) {
        TokenType result = mapAcceptanceStates.get(actualState);
        if (result != null)
            return mapAcceptanceStates.get(actualState);

        return TokenType.ERROR;
    }

}

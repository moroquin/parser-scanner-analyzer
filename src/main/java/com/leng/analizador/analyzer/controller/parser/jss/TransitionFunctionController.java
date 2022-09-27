package com.leng.analizador.analyzer.controller.parser.jss;

import com.leng.analizador.analyzer.models.State;

public class TransitionFunctionController {

    public State getInitState() {
        return null;
    }

    public State delta(State actualState, Object alphabetSymbol) {
        return null;
    }

    public boolean isFinishToken(State actualState, Object alphabetSymbol) {
        return false;
    }

    public Object getTokenType(State actualState) {
        return null;
    }

}

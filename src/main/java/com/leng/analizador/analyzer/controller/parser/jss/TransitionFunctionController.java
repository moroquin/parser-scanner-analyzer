package com.leng.analizador.analyzer.controller.parser.jss;

import java.util.List;

import com.leng.analizador.analyzer.models.parser.AlphabetSymbol;
import com.leng.analizador.analyzer.models.parser.State;

public class TransitionFunctionController {

    private final State[][] statesMatrix;

    private final State INITSTATE = State.S0;

    {
        statesMatrix = new State[State.values().length-2][AlphabetSymbol.values().length];

        statesMatrix[State.S0.ordinal()][AlphabetSymbol.LETTER.ordinal()]= State.S1;
        statesMatrix[State.S0.ordinal()][AlphabetSymbol.DIGIT.ordinal()]= State.S2;
        statesMatrix[State.S0.ordinal()][AlphabetSymbol.ESPACE.ordinal()]= State.S0;
        statesMatrix[State.S0.ordinal()][AlphabetSymbol.ERROR.ordinal()]= State.SE;
        
        statesMatrix[State.S1.ordinal()][AlphabetSymbol.LETTER.ordinal()]= State.S1;
        statesMatrix[State.S1.ordinal()][AlphabetSymbol.DIGIT.ordinal()]= State.S1;
        statesMatrix[State.S1.ordinal()][AlphabetSymbol.ESPACE.ordinal()]= State.SA;
        statesMatrix[State.S1.ordinal()][AlphabetSymbol.ERROR.ordinal()]= State.SE;
        
        statesMatrix[State.S2.ordinal()][AlphabetSymbol.LETTER.ordinal()]= State.SE;
        statesMatrix[State.S2.ordinal()][AlphabetSymbol.DIGIT.ordinal()]= State.S2;
        statesMatrix[State.S2.ordinal()][AlphabetSymbol.ESPACE.ordinal()]= State.SA;
        statesMatrix[State.S2.ordinal()][AlphabetSymbol.ERROR.ordinal()]= State.SE;

    }


    public State getInitState() {
        return INITSTATE;
    }

    public State delta(State actualState, AlphabetSymbol alphabetSymbol) {
        

        if (actualState != State.SA && actualState!=State.SE){
            return statesMatrix[actualState.ordinal()][alphabetSymbol.ordinal()];
        }
        return actualState;
    }

    public List<AlphabetSymbol> getExpectedSymbols(State actualState) {
        return null;
    }

}

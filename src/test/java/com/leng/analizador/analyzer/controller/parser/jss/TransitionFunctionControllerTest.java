package com.leng.analizador.analyzer.controller.parser.jss;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.leng.analizador.analyzer.models.parser.AlphabetSymbol;
import com.leng.analizador.analyzer.models.parser.State;

public class TransitionFunctionControllerTest {

    private final TransitionFunctionController transitionFunctionController = new TransitionFunctionController();

    @Test
    public void shouldReturnInitialState(){
        assertEquals(State.S0, transitionFunctionController.getInitState());
    }

    @Test
    public void shouldTheTracsitionFunctionWorksWell(){
        //letter
        assertEquals(State.S1, transitionFunctionController.delta(State.S0, AlphabetSymbol.LETTER));

        //numero
        assertEquals(State.S2, transitionFunctionController.delta(State.S0, AlphabetSymbol.DIGIT));

        
    }
    
    @Test
    public void shouldReturnErrorState(){
        assertEquals(State.SE, transitionFunctionController.delta(State.S1, AlphabetSymbol.ERROR));

        
    }

    @Test
    public void shouldReturnAcceptanceState(){
        assertEquals(State.SA, transitionFunctionController.delta(State.SA, AlphabetSymbol.ESPACE));

        assertEquals(State.SA, transitionFunctionController.delta(State.S2, AlphabetSymbol.ESPACE));
    }

    
}

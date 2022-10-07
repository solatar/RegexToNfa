package regextonfa.test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import regextonfa.main.Nfa;
import regextonfa.main.ShuntingYard;

public class NfaTest {
    
    Nfa nfa;
    ShuntingYard sy;
    
    public NfaTest() {
    }    
    
    @Before
    public void setUp() {
        sy = new ShuntingYard();
    }

    @Test
    public void graphSizeIsCorrect() {
        sy.setRegex("a*.s.i.a*");
        String regex = sy.infixToPostfix();
        nfa = new Nfa(regex);
        nfa.constructNfa();
        assertEquals("10", Integer.toString(nfa.getGraph().length));
    }
    
    @Test
    public void goalNodeIscorrect() {
        sy.setRegex("(ai)*ja*");
        sy.addConcatSymbols();
        String regex = sy.infixToPostfix();
        nfa = new Nfa(regex);
        nfa.constructNfa();
        assertEquals("6", Integer.toString(nfa.getGoal()));
    }
    @Test
    public void startNodeIscorrect() {
        sy.setRegex("(Y|L|E)*N");
        sy.addConcatSymbols();
        String regex = sy.infixToPostfix();
        nfa = new Nfa(regex);
        nfa.constructNfa();
        assertEquals("5", Integer.toString(nfa.getStart()));
    }

    @Test
    public void returnTrueWhenStringBelongsToLanguage() {
        sy.setRegex("(0|1)*|(0.1)*");
        String regex = sy.infixToPostfix();
        nfa = new Nfa(regex);
        nfa.constructNfa();  
        assertTrue(nfa.simulate("01"));
    }    
}

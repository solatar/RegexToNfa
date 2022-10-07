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
        String regex = sy.infixToPostfix("a*.s.i.a*");
        nfa = new Nfa(regex);
        nfa.constructNfa();
        assertEquals("10", Integer.toString(nfa.getGraph().length));
    }
    
    @Test
    public void goalNodeIscorrect() {
        String regex = sy.infixToPostfix("(a.i)*.j.a*");
        nfa = new Nfa(regex);
        nfa.constructNfa();
        assertEquals("6", Integer.toString(nfa.getGoal()));
    }
    @Test
    public void startNodeIscorrect() {
        String regex = sy.infixToPostfix("(Y|L|E)*.N");
        nfa = new Nfa(regex);
        nfa.constructNfa();
        assertEquals("5", Integer.toString(nfa.getStart()));
    }

    @Test
    public void returnTrueWhenStringBelongsToLanguage() {
        String regex = sy.infixToPostfix("(0|1)*|(0.1)*");
        nfa = new Nfa(regex);
        nfa.constructNfa();  
        assertTrue(nfa.simulate("01"));
    }    
}

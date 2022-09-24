
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import tira.regextonfa.Nfa;
import tira.regextonfa.ShuntingYard;

public class NfaTest {
    
    Nfa nfa;
    ShuntingYard sy;
    
    public NfaTest() {
    }    
    
    @Before
    public void setUp() {
        sy = new ShuntingYard();
        String regex = sy.infixToPostfix("a*.s.i.a*");
        nfa = new Nfa(regex);
    }

    @Test
    public void graphSizeIsCorrect() {
        char[][] graph = nfa.constructNfa();
        assertEquals("10", Integer.toString(nfa.getGraph().length));
    }
}


import tira.regextonfa.ShuntingYard;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ShuntingYardTest {
    
    ShuntingYard sy;
    
    @Before
    public void setUp() {   
        sy = new ShuntingYard();
    }    
    
    @Test
    public void invalidRegexesAreHandled() {
        String result = sy.infixToPostfix("(a+b)*(c+d");
        assertEquals("This expression is invalid", result);
    }    
    
    @Test
    public void postFixIsReturned() {
        String result = sy.infixToPostfix("(a+b)*(c+d)");
        assertEquals("ab+cd+*", result);  
    }
    
    @Test
    public void precedenceOfOperatorsIsCorrect() {
        String chars = "a|b.c*";
        int l = chars.length();
        int sum = 0;
        for (int i = 0; i < l; i++) {
            char c = chars.charAt(i);
            sum = sum += sy.getPrecedence(c);
        }
        assertEquals(3, sum);
    }    
}

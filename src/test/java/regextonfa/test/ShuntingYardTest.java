package regextonfa.test;

import regextonfa.main.ShuntingYard;
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
    public void concatSymbolsAreAdded() {
        sy.setRegex("(a|b|c)*abc");
        sy.addConcatSymbols();
        assertEquals("(a|b|c)*.a.b.c", sy.getRegex());
    }
    
    @Test
    public void missingParenthesesAreHandled() {
        sy.setRegex("(a+b)*(c+d");
        String result = sy.infixToPostfix();
        assertEquals("This expression is invalid", result);
    }    
    
    @Test
    public void postFixIsReturned() {
        sy.setRegex("(a+b)*(c+d)");
        String result = sy.infixToPostfix();
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
    
    @Test
    public void invalidCharactersAreHandled() {
        sy.setRegex("(m|(ad)|d)#agio");
        String result = sy.infixToPostfix();
        assertEquals("This expression is invalid", result);    
    }
}

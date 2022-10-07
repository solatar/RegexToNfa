
package regextonfa.main;

import java.util.Stack;

public class ShuntingYard {   

    public boolean letterOrDigit(char c) {
	if (!Character.isLetterOrDigit(c)) {
            return false;
	}
        return true;
    }    
    /**
     * @param ch
     * @return an Integer value representing the precedence
     * of an operator in a regular expression
     */   
    public int getPrecedence(char ch)	{
	if (ch == '.') {
            return 1;
        }
        else if (ch == '|') {
            return 2;
        } 
        else if (ch == '*') {
            return 3;
        }
        else  return -1;               
    }

    /**
     * Checks if an operator has Left -> Right associativity
     * 
     * @param char 
     * @return boolean value
     */
    public boolean hasLeftAssociativity(char ch) {
	if (ch == '.' || ch == '|' || ch == '*') {
            return true;
	} else {
            return false;
        }
    }   

    /**
     * Converts a regex from infix to postfix     * 
     * @param expression
     */
    public String infixToPostfix(String expression){
        // Initialising an empty String
        // (for output) and an empty stack
        Stack<Character> stack = new Stack<>();
            // Initially empty string taken
        String output = new String("");
            // Iterating over tokens using inbuilt
            // .length() function
        for (int i = 0; i < expression.length(); ++i) {
            // Finding character at 'i'th index
            char c = expression.charAt(i);
            // If the scanned Token is an
            // operand, add it to output
            if (letterOrDigit(c)) {
                output += c;
            }              
            // If the scanned Token is an '('
            // push it to the stack
            else if (c == '(') {
                stack.push(c);
            }
            // If the scanned Token is an ')' pop and append
            // it to output from the stack until an '(' is
            // encountered
            else if (c == ')') {
                while (!stack.isEmpty() 
                    && stack.peek() != '(') {
                    char next = stack.pop();
                    System.out.println(next);
                    output += next;     
                }
                stack.pop();
            }
            // If an operator is encountered then taken the
            // further action based on the precedence of the
            // operator
            else if (!letterOrDigit(c) && stack.isEmpty()) {
                stack.push(c);
            }
            else {
                while (!stack.isEmpty() && 
                        getPrecedence(c)<= getPrecedence(stack.peek())
                        && hasLeftAssociativity(c)) {
                    output += stack.pop();
                }
                stack.push(c);
            }     
        }
        // pop all the remaining operators from
        // the stack and append them to output
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "This expression is invalid";
            }
                output += stack.pop();
            }          
        return output;
    }
}

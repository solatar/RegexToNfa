package tira.regextonfa;

import java.util.HashSet;
import java.util.Stack;

public class Nfa {
    public String regex;
    public Node[] graph;

    public Nfa(String regex) {
        this.regex = regex;
    }   
    
    //UNDER CONSTRUCTION
    public Fragment constructNfa() {
        int n = regex.length();      
        int nodeNumber = n/2;
        Stack<Fragment> stack = new Stack<>();
        Character e = 'e';
        for (int i=0; i<n; i++) {
            char current = regex.charAt(i);
            if (Character.isLetterOrDigit(current)) {
                Node node = new Node(i+nodeNumber);
                Transition trans = new Transition(node, current);
                Fragment frag = new Fragment(node);
                frag.pointers.add(trans);
                stack.push(frag);
            }
            //concatenation
            if (current == '.') {
                Fragment second = stack.pop();
                Fragment conc = stack.pop();               
                for (Transition trans : conc.getPointers()) {
                    trans.setY(second.getStart());
                }   
                conc.setPointers(second.getPointers());
                stack.push(conc); 
            }
            //alternation
            if (current == '|') {
                Fragment second = stack.pop();
                Fragment first = stack.pop();       
                Node newStart = new Node(i+nodeNumber);
                newStart.getEdges().add(new Transition(newStart, e, first.getStart()));
                newStart.getEdges().add(new Transition(newStart, e, second.getStart()));
                Fragment alt = new Fragment(newStart);
                HashSet<Transition> newPointers = alt.merge(first, second);
                stack.push(alt);                
            }
            //closure
            if (current == '*') {
                Fragment closure = stack.pop();
                Node newStart = new Node (i+nodeNumber);
                newStart.getEdges().add(new Transition(newStart, e, closure.getStart()));
                closure.setStart(newStart);
                Node newEnd = new Node(i+nodeNumber);
                for (Transition trans : closure.getPointers()) {
                    trans.setY(newEnd);
                }
                Transition trans = new Transition(newStart, e, newEnd);
                stack.push(closure);             
            }
        }
        Fragment automaton = stack.pop();
        return automaton;
    }
}

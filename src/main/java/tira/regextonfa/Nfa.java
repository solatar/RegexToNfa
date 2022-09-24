package tira.regextonfa;

import java.util.Stack;

public class Nfa {
    String regex;
    char[][] graph;

    public Nfa(String regex) {
        this.regex = regex;
    }   
    /**
     * Constructs a non-finite automata representing the regular 
     * expression that the Nfa object has as a parameter. The method
     * is based on Thompson's construction algorithm.
     * @return a two-dimensional array. Character in [x][y] means
     * an edge from node x to node y labeled with that character.
     */
    public char[][] constructNfa() {
        int n = regex.length();   
        graph = new char[n+1][n+1];
        Stack<Fragment> stack = new Stack<>();
        Character e = 'e';
        for (int i = 0; i < n; i++) {
            char current = regex.charAt(i);     
            //a single character creates a starting node and an outgoing edge to null.
            if (Character.isLetterOrDigit(current)) { 
                Node node = new Node(i);
                Transition trans = new Transition(node, current);
                Fragment frag = new Fragment(node);
                frag.pointers.add(trans);
                stack.push(frag);
            }
            //concatenation: the edges of first fragment are connected to the starting 
            //node of second fragment
            if (current == '.') {
                Fragment second = stack.pop();
                Node yNode = second.getStart();
                Fragment conc = stack.pop(); 
                for (Transition trans : conc.getPointers()) {
                    int xNode = trans.getX().getName();
                    char c = trans.getValue();
                    trans.setY(yNode);
                    graph[xNode][yNode.getName()] = c;                    
                }   
                conc.setPointers(second.getPointers());
                stack.push(conc); 
            }
            //alternation: a new starting node is created and its edges are connected to
            //the starting nodes of two topmost fragments. The pointer lists of the two
            //fragments are merged.
            if (current == '|') {
                Fragment second = stack.pop();
                Fragment alt = stack.pop();       
                Node newStart = new Node(i);
                graph[i][alt.getStart().getName()] = e;
                graph[i][second.getStart().getName()] = e;
                alt.merge(second);
                alt.setStart(newStart);
                stack.push(alt);         
            }
            //closure: a new starting node is created. The pointers of the topmost
            //fragment are connected to the new start. The edges of new start are
            //connedted to the popped fragment's (old) starting node. The pointer list
            //contains new edge from new starting node to null.
            if (current == '*') {
                Fragment closure = stack.pop();
                Node newStart = new Node (i);
                for (Transition trans : closure.pointers) {
                    trans.setY(newStart);
                    char c = trans.getValue();
                    graph[trans.getX().getName()][i] = c;
                }
                graph[i][closure.getStart().getName()] = e; 
                Transition trans = new Transition(newStart, e);
                closure.pointers.clear();
                closure.pointers.add(trans);
                closure.setStart(newStart);
                stack.push(closure);         
            }
        }    
        //When the regex has been handled, an accepting state and required edges
        //are greated. The final fragment can be popped but it is not needed.
        Fragment automaton = stack.pop();
        Node newEnd = new Node(n);        
        for (Transition trans : automaton.getPointers()) {
            int xNode = trans.getX().getName();
            char c = trans.getValue();
            trans.setY(newEnd);
            graph[xNode][n] = c;                   
        } 
        automaton.pointers.clear();
        Transition trans = new Transition(newEnd, e, automaton.getStart());
        graph[n][automaton.getStart().getName()] = e;
        //The graph contains all edges of the NFA.
        return graph;
    } 

    public String getRegex() {
        return regex;
    }

    public char[][] getGraph() {
        return graph;
    }
}

package tira.regextonfa;

import java.util.Stack;

public class Nfa {
    String regex;
    char[][] graph;
    int n;
    int start;
    int goal;
    int nodeName;

    public Nfa(String regex) {
        this.regex = regex;
        n = regex.length();
        graph = new char[n+1][n+1];
        for (int i=0; i<n+1; i++) {
            for (int j=0; j<n+1; j++) {
                graph[i][j] = '#';
            }
        }
    }   
    /**
     * Constructs a non-finite automata representing the regular 
     * expression that the Nfa object has as a parameter. The method
     * is based on Thompson's construction algorithm.
     * @return a two-dimensional array. Character in [x][y] means
     * an edge from node x to node y labeled with that character.
     */
    public char[][] constructNfa() {
        Stack<Fragment> stack = new Stack<>();
        Character e = 'e';
        nodeName = 0;
        for (int i = 0; i < n; i++) {
            char current = regex.charAt(i);     
            //a single character creates a starting node and an outgoing edge to null.
            if (Character.isLetterOrDigit(current)) { 
                Node node = new Node(nodeName);
                Transition trans = new Transition(node, current);
                Fragment frag = new Fragment(node);
                frag.pointers.add(trans);
                stack.push(frag);
                nodeName++;
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
                Node newStart = new Node(nodeName);
                graph[nodeName][alt.getStart().getName()] = e;
                graph[nodeName][second.getStart().getName()] = e;
                alt.merge(second);
                alt.setStart(newStart);
                stack.push(alt);         
                nodeName++;
            }
            //closure: a new starting node is created. The pointers of the topmost
            //fragment are connected to the new start. The edges of new start are
            //connedted to the popped fragment's (old) starting node. The pointer list
            //contains new edge from new starting node to null.
            if (current == '*') {
                Fragment closure = stack.pop();
                Node newStart = new Node (nodeName);
                for (Transition trans : closure.pointers) {
                    trans.setY(newStart);
                    char c = trans.getValue();
                    graph[trans.getX().getName()][nodeName] = c;
                }
                graph[nodeName][closure.getStart().getName()] = e; 
                Transition trans = new Transition(newStart, e);
                closure.pointers.clear();
                closure.pointers.add(trans);
                closure.setStart(newStart);
                stack.push(closure);         
                nodeName++;
            }
            System.out.println(stack);
        }    
        //When the regex has been handled, an accepting state is created and
        //final pointers connected to it. The final fragment is popped but it 
        //is only needed for setting the starting node of the NFA. 
        Fragment automaton = stack.pop();
        Node newEnd = new Node(nodeName);        
        for (Transition trans : automaton.getPointers()) {
            int xNode = trans.getX().getName();
            char c = trans.getValue();
            trans.setY(newEnd);
            graph[xNode][nodeName] = c;                   
        } 
        automaton.pointers.clear();
        //set the start and goal nodes
        start = automaton.getStart().getName();
        goal = nodeName;
        //The graph contains all edges of the NFA.
        for (int i=0; i<n+1; i++) {
            for (int j=0; j<n+1; j++)
                System.out.print(graph[j][i]);         
                System.out.println();
        }        
        return graph;
    } 
    
    /**
     * Simulates the NFA with the given string. If a node has only e-transitions
     * or no matching transitions at all the loop will not process a character of the 
     * string. When all characters of the string have been processed the automaton
     * will either be in the goal node or can move to the goal node with an e-transition,
     * if the string belongs to the language. Otherwise, it is not a match.
     * @param candidate
     * @return match or not
     */
    boolean simulate(String candidate) {
        int l = candidate.length();
        Stack<Integer> clist = new Stack<>();
        clist.push(start);
        int i = 0;
        while (!clist.isEmpty()) {
            System.out.println(clist);
            int current = clist.pop();
            if (i == l && current == goal) {
                return true;
            }
            for (int j = 0; j <= nodeName; j++) {
                System.out.println(graph[current][j]);
                if (i == l && (graph[current][j] == 'e') && j == goal) {
                    return true;
                } else if (graph[current][j] == 'e') {
                    clist.push(j);
                } else if (i < l && graph[current][j] == candidate.charAt(i)) {
                    clist.push(j);
                    i++;
                }      
            }
        }      
        return false;
    }
    

    public String getRegex() {
        return regex;
    }

    public char[][] getGraph() {
        return graph;
    }
}

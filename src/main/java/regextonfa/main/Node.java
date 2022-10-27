package regextonfa.main;

/**
 * An NFA parsed from a regex of length n will have maximum n+1 nodes.
 * The last one is the matching state. Nodes will be
 * named with an integer between 0...n+1 according to nodeName variable
 * in class Nfa. Node class does not track edges.
 */
public class Node {
    public int name;

    public Node(int name) {
        this.name = name;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }       

    @Override
    public String toString() {
        return "Node: " + this.name;
    }    
}

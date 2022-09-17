package tira.regextonfa;

import java.util.HashSet;

public class Node {
    public int name;
    public HashSet<Transition> edges;

    public Node(int name) {
        this.name = name;
        this.edges = new HashSet<>();    
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }   
    

    public HashSet<Transition> getEdges() {
        return edges;
    }

    public void setEdges(HashSet<Transition> edges) {
        this.edges = edges;
    }

    @Override
    public String toString() {
        return "Node: " +this.name;
    }
    
}

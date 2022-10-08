package regextonfa.main;

import java.util.HashSet;

public class Fragment {
    Node start;
    HashSet<Transition> pointers;

    /**
     * A fragment is a partial NFA represented by its starting node
     * and outgoing arrows. Other nodes and edges are not tracked. 
     * A fragment does not have an accept state.
     * @param start 
     */
    public Fragment(Node start) {
        this.start = start;
        this.pointers = new HashSet<>();
    }

    public Node getStart() {
        return start;
    }

    public void setStart(Node start) {
        this.start = start;
    }

    /**
     * @return outgoing edges of a fragment
     */ 
    public HashSet<Transition> getPointers() {
        return pointers;
    }

    public void setPointers(HashSet<Transition> pointers) {
        this.pointers = pointers;
    }
    
    public void addPointer(char c) {
        this.pointers.add(new Transition(this.start, c));
    }

    /**
     * Merges the pointers list of a fragment with the pointers
     * list of another fragment
     * @param other node
     */
    public void merge(Fragment other) {
        for (Transition trans : other.getPointers()) {
            this.pointers.add(trans);
        }    
    }
           
    @Override
    public String toString() {
        return "Starting node: " + this.start + ", pointers: " + this.pointers;
    }
}

package tira.regextonfa;

import java.util.HashSet;

public class Fragment {
    public Node start;
    public HashSet<Transition> pointers;

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

    public HashSet<Transition> getPointers() {
        return pointers;
    }

    public void setPointers(HashSet<Transition> pointers) {
        this.pointers = pointers;
    }

    public HashSet<Transition> merge(Fragment first, Fragment second) {
        HashSet<Transition> newPointers = second.getPointers();
        for (Transition trans : first.getPointers()) {
            newPointers.add(trans);
        }   
        return newPointers;
    }
           
    @Override
    public String toString() {
        return "Starting node: " +this.start+ ", pointers: " +this.pointers;
    }
}

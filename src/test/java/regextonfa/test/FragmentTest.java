package regextonfa.test;

import java.util.HashSet;
import regextonfa.main.Fragment;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import regextonfa.main.Node;
import regextonfa.main.Transition;


public class FragmentTest {
    
    Fragment fragment;
    Fragment fragment2;
    Character a = 'a';
    Character b = 'b';
    
    public FragmentTest() {
        
    }    
    
    @Before
    public void setUp() {
        fragment = new Fragment(new Node(1));
        fragment.getPointers().add(new Transition(this.fragment.getStart(), a));
        fragment2 = new Fragment(new Node(2));
        fragment2.addPointer(b);
    }
    
    @Test
    public void pointersAreMerged() {
        fragment2.getPointers().add(new Transition(this.fragment.getStart(), b));
        fragment.merge(fragment2);
        assertEquals("3", Integer.toString(fragment.getPointers().size()));        
    }    
}

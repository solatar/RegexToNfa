## Implementation report ##

The application has a graphic user interface implemented with JavaFx, and five other classes.

The main algorithm consists of two parts:

1) construction of a non-deterministic finite automaton

2) simulating the automaton

The first part is implemented based on Thompson's construction. The time complexity of this
part is *O(n)* where *n* is the length of the regular expression as a string, without parentheses.
there will be maximum *n* nodes in the automata and each node has maximum two edges, so the space
complexity is also linear.

The simulation part requires *O(mn)* time, where *n* is the length of the regex and *m* is the length
of the string to be matched against it. 


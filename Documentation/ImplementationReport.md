## Implementation report ##

The application has a graphic user interface implemented with JavaFx, a main class and five other classes.

User enters a regular expression and a string to test against it. The regex is manipulated by two methods to
enable building an automaton. First, the regex is checked for the need for concatenation symbols. This takes
*O(n)* time where *n* is the length of the regex. Second, the regex is transformed into postfix notation with
Shunting-Yard algorithm. This method uses stack and its worst-case time complexity and space complexity are
*O(n)*.  

The automata algorithm consists of two parts:

1) construction of a non-deterministic finite automaton

2) simulating the automaton

The first part is implemented based on Thompson's construction. The time complexity of this
part is *O(n)* where *n* is the length of the regular expression as a string, without parentheses.
there will be maximum *n* nodes in the automata and each node has maximum two edges, so the space
complexity is also linear.

The simulation part requires *O(mn)* time, where *n* is the length of the regex and *m* is the length
of the string to be matched against it. 


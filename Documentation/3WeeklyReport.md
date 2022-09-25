## Third week ##

This week I included Javadoc and Checkstyle into the project,created testing report, added
comments and tried to improve the test coverage.

Javadoc generation caused a lot of headache and waste of time. The workaround was to add <source>8</source>
into Javadoc Maven plugin. I also learned I need to add a new Main class because Java 11 with JavaFX
won't generate a runnable jar otherwise.

The constructNfa() method now returns an automaton as a two-dimensional graph. Next step is to
perform a depth-first search with the string that is going to be tested. The graph becomes very sparse;
its size is [n+1][n+1], where n is the length of regex without parentheses, and there are only values
in those x,y pairs where an edge from x to y exists. This can be considered waste of space. On the
other hand, regular expressions are rarely very long so graphs are not supposed to become very large.

I am unsure whether I should divide the constructNfa() method into several methods after all. Testing
the Nfa class would be more sensible if one method didn't do everything. 

I also wonder what to do with concatenation. If one concatenation symbol is forgotten from the user 
input, the app will have separate Nfa fragments and the resulting graph will also not be correct. I 
might have to invent one more method to detect the need for concatenation symbols from the input.

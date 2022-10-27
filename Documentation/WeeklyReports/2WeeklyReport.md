## Second week ##

This week I've been revising depth-first search and breadth-first search for another course and this clarified to me that my 
NFA simulation will use DFS. But first I'll need to have the NFA in a graph form. So  I started coding Thompson's construction algorithm
which would convert a regex to an NFA object. This turned out to be more complicated than I anticipated.

I tried to avoid creating too many objects but I figured that before I can convert my NFA into a graph I need to have nodes,
edges and fragments of NFA. I've been changing their stucture on the fly when I've realized that something does not work.  

The app will initially support concatenation, alternation and closure operators. Concatenation does not have an explicit operator
in regular expressions and my sources suggest adding one in between two characters so that the algorithm knows to handle them
as concatenated characters. I will have to modify my Shunting-Yard method accordingly.

The parsing method in Nfa.java class is not yet ready and, therefore, there are no tests for this class. Generally, testing and
documentation have been on hold this week. I'll try to catch up next week.

Sunday update: I fixed an error in operator precedence in my Shunting-Yard algorithm and modified the user interface. User is now 
instructed to use concatenation operator '+'. Parsing method is almost ready but the resulting in NFA is not yet in a graph (array)
form.

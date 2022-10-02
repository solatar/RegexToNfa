## Fourth week ##

This week I got stuck and had to leave most of the documentation for Sunday. I've tried to follow Russ Cox's
article mentioned in requirements specification but the simulation part was too confusing. Another approach
was to use dfs for simulation but the structure of my Nfa didn't seem to support it. The simulation method I
ended up with is not very elegant but I works on all cases I've tried.

I improved the user interface so that it will display the result (true/false) and warn about empty inputs.
I thought about methods to detect for missing concatenation symbols. The easiest I could come up with was
checking whether the stack is empty at the end of the constructNfa() method or not. So I made stack a global
variable and the ui now displays a warning based on that. The design of the UI could be improved but it's
not the priority at this point.

Thompson's construction doesn't create a new node in the case of concatenation. Therefore, the number of
nodes in nfa could be less than the number of characters in regex. That's why I introduced a new variable
nodeName for naming the nodes so that the resulting array won't have empty rows and columns inbetween.
I also noticed there won't be nodes having both epsilon transitions and transitions with a character.
This makes simulating the automaton a bit more simple.

I started writing the implementation report but was unsure what to include in it. 

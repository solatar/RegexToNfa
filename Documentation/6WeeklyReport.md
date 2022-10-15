## Sixth week ## 

I've tested the app with different types of inputs. It turned out my solution for simulating NFA was too simple 
did not always return correct result. I also found flaws in addConcatsymbols() method. So, this week I've been trying 
to fix these errors and I believe I've managed to do so. The simulate() method now uses two stacks: one containing
the nodes the automaton is currently in and another for the nodes it will be in, after processing current character.
The method changed quite a bit but it shouldn't be less efficient. It still needs to be tested with very long
regexes and strings, though. 

During development I've been printing the NFA graph into console to ensure it is formed correctly. It would be nice
to visualize the graph in the UI but I'm not sure how to implement it. I made a minor change in the UI - it now gives
a warning if user enters other characters than letters, digits or allowed operators. 

I started writing the user manual and moved some info from README into it. I also generated a jar of the project but
haven't tried to run it yet.



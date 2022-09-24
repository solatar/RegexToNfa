## Testing report ##


Three classes in the application are helper objects for constructing non-deterministic automata. A user
cannot directly manipulate classes Node, Transition and Fragment but their parameters are determined by
the regular expression the user enters.

Nfa.java is the most important class of the application but for efficiency reasons it does not have many
separate methods. This is a challenge for testing.

ShuntingYard.java class is responsible for checking the user input and there are several things to consider.
Currently the app accepts any sign as a character but that is not a good idea. Also, if the user enters 
a regex without concatenation symbols, the app ends up with separate Nfa fragments that do not form a correct
Nfa graph.

User interface is excluded from automatic tests. 

So far, the application has not been tested on any other than a Linux device.

![Jacoco didn't pick up Nfa.java for this report](Pictures/TestCoverage24.9.png)

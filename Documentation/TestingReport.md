## Testing report ##


Three classes in the application are helper objects for constructing non-deterministic automata. A user
cannot directly manipulate classes Node, Transition and Fragment but their parameters are determined by
the regular expression the user enters.

Nfa.java is the most important class of the application but for efficiency reasons it does not have many
separate methods. It does, however, have several gloabal variables and the accuracy of methods is tested
by checking values of these variables.

ShuntingYard.java class is responsible for checking the user input and there are several things to consider.
Currently the app accepts any sign as a character but that is not a good idea. If the user enters 
a regex without concatenation symbols, the app ends up with separate Nfa fragments. In this case, user gets
a warning to check for missing concatenation symbols.

Spaces are eliminated with .trim() method. In case of empty input, user gets a warning and the app won't
proceed.

User interface is excluded from automatic tests. 

So far, the application has not been tested on any other than a Linux device. Because of JavaFx components
it will also need a separate main class for generating a runnable JAR file.

Unit test coverage is checked with JaCoCo. Run the report form command line:
```
mvn jacoco:report
```

![Jacoco report ](Pictures/Coverage021022.png)

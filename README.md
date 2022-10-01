## RegexToNfa Application ##

University course project on Data Structures and Algorithms.

The app takes a regular expression and a string as input, builds an NFA fron the regex and checks whether it accepts the string.

JavaFx requires you have JavaFx SDK installed and VM options pointing to its location. For example in Netbeans: Project Properties -> Run ->
VM Options -> --module-path "/home/**username**/javafx-sdk-18.0.1/lib" --add-modules javafx.base,javafx.controls,javafx.fxml,javafx.graphics
-> OK

The application uses Shunting-Yard and Thompson's construction algorithms. Due to the nature of the latter, regular expression needs to be 
entered with symbol '.' between concatenated characters. For example, (a|b|c)\*abc becomes (a|b|c)\*.a.b.c.

Run the app from command line:

```
mvn exec:java -Dexec.mainClass=tira.regextonfa.RegexToNfa
```

### Weekly progress ###

[Week 1](https://github.com/solatar/RegexToNfa/blob/master/Documentation/1WeeklyReport.md)

[Week 2](https://github.com/solatar/RegexToNfa/blob/master/Documentation/2WeeklyReport.md)

[Week 3](https://github.com/solatar/RegexToNfa/blob/master/Documentation/3WeeklyReport.md)

[Week 4](https://github.com/solatar/RegexToNfa/blob/master/Documentation/4WeeklyReport.md)

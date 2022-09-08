## RegexToNfa Application ##

University course project on Data Structures and Algorithms.

The app takes a regular expression and a string as input, builds an NFA fron the regex and checks whether it accepts the string.

JavaFx requires you have JavaFx SDK installed and VM options pointing to its location. For example in Netbeans: Project Properties -> Run -> 
VM Options -> 
--module-path "/home/**username**/javafx-sdk-18.0.1/lib" --add-modules javafx.base,javafx.controls,javafx.fxml,javafx.graphics
-> OK

Run the app from command line: 

```
mvn exec:java -Dexec.mainClass=tira.regextonfa.RegexToNfa
```


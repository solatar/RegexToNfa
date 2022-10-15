## User Manual ##

RegexToNfa application has a graphic user interface that requires you have JavaFx components installed
and the installation path added to VM options. For example, in Netbeans:

![VM options](Pitures/VMoptions.png)

On command line:

```
--module-path /your path/javafx-sdk-18.0.1/lib --add-modules javafx.controls,javafx.fxml
```
Run the app from command line:

```
mvn exec:java -Dexec.mainClass=regextonfa.main.Main
```
Generate Javadoc:
```
mvn javadoc:javadoc
```
Generate jar:
```
mvn package
``` 

### General use ###

The application supports regular expressions consisting of letters and digits. It is case-sensitive, so *A* 
will not match *a*. The supported operations are  | for alternation, . for concatenation and * for closure
(zero or more). It does not (yet) support operations ? (zero or one) or + (one or more). Unsupported 
characters will produce an error:

![Illegal characters](illegal.png)


## User Manual ##

RegexToNfa application has a graphic user interface that requires you have JavaFx components installed
and the installation path added to VM options. For example, in Netbeans:

![VM options](Pictures/VMoptions.png)

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
will not match *a*. The supported operations are  | for alternation, . for concatenation, * for closure
(zero or more) and + for one or more. It does not (yet) support operation ? (zero or one). Unsupported 
characters will produce an error:

![Illegal characters](Pictures/illegal.png)

In this application alternation has precedence over concatenation. For example, aba|baba* means that *a* and
*b* are alternated. Use parentheses if you want to alternate concatenated characters, such as (aba)|(baba)*



## RegexToNfa Application ##

University course project on Data Structures and Algorithms.

The app takes a regular expression and a string as input, builds an NFA fron the regex and checks whether it accepts the string.

The application uses Shunting-Yard and Thompson's construction algorithms. Due to the nature of the latter, the app adds character '.' between
concatenated characters. For example, (a|b|c)\*abc becomes (a|b|c)\*.a.b.c. User may enter their regex in regular form. Parentheses are used
for grouping characters but they are dropped when regex is converted into postfix form.

Currently the app supports these regular expression operations (in the order of precedence): . for concatenation, | for alternation * for closure (zero or more) and /+ for one or more. 

[Requirements specification](https://github.com/solatar/RegexToNfa/blob/master/Documentation/RequirementsSpecification.md)

[User Manual](https://github.com/solatar/RegexToNfa/blob/master/Documentation/UserManual.md)

[Implementation report](https://github.com/solatar/RegexToNfa/blob/master/Documentation/ImplementationReport.md)

[Testing report](https://github.com/solatar/RegexToNfa/blob/master/Documentation/TestingReport.md)

[Weekly progress](https://github.com/solatar/RegexToNfa/tree/master/Documentation/WeeklyReports)


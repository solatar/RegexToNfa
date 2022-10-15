## RegexToNfa Application ##

University course project on Data Structures and Algorithms.

The app takes a regular expression and a string as input, builds an NFA fron the regex and checks whether it accepts the string.

The application uses Shunting-Yard and Thompson's construction algorithms. Due to the nature of the latter, the app adds character '.' between
concatenated characters. For example, (a|b|c)\*abc becomes (a|b|c)\*.a.b.c. User may enter their regex in regular form. Parentheses are used
for grouping characters but they are dropped when regex is converted into postfix form.

Currently the app supports these regular expression operations: | for alternation, . for concatenation and * for closure (zero or more).
It does not (yet) support operations ? (zero or one) or + (one or more). 

[User Manual](https://github.com/solatar/RegexToNfa/blob/master/Documentation/UserManual.md)

### Weekly progress ###

[Week 1](https://github.com/solatar/RegexToNfa/blob/master/Documentation/1WeeklyReport.md)

[Week 2](https://github.com/solatar/RegexToNfa/blob/master/Documentation/2WeeklyReport.md)

[Week 3](https://github.com/solatar/RegexToNfa/blob/master/Documentation/3WeeklyReport.md)

[Week 4](https://github.com/solatar/RegexToNfa/blob/master/Documentation/4WeeklyReport.md)

[Week 5](https://github.com/solatar/RegexToNfa/blob/master/Documentation/5WeeklyReport.md)

[Week 6](https://github.com/solatar/RegexToNfa/blob/master/Documentation/6WeeklyReport.md)

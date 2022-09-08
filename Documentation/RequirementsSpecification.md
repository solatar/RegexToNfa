## Requirements Specification ##

### Program of study: Bachelor of Computer Science (Tietojenkäsittelytieteen kandiohjelma) ###

Project language is Java 11. I don't know other high-level languages well enough for peer review.

The purpose of RegexToNfa application is very simple:

A user can

-[] enter a regular expression and a string of their choice into the graphic user interface

-[] check whether the string belongs to the language specified by the regular expression

The application will
-[] build a non-finite automaton from the given regex

-[] simulate the NFA with the given string to see whether it is accepted

-[] display the result (true/false) 

Possible other functions

-[] display the formulated NFA in some form

The allowed operations in the regular expression are concatenation, closure, binary or and parentheses. The app will convert the regex entered by user
to postfix notation using Shunting-Yard algorithm. I plan to use  Thompson's construction for building an NFA from the regex.

I selected this topic because regular expressions have so many practical applications and I wanted to understand them better. 
The time complexity of Shunting-Yard algorithm is *O(n)*, linear to the length of the regular expression. Thompson's algorithm is able to process a regex of length *m*
in *O(m^2^) time and simulating it with a string of length on *n* will take *O(mn) time.

### References ###

Russ Cox: [Regular Expression Matching Can Be Simple And Fast](https://swtch.com/~rsc/regexp/regexp1.html)

Gregory Cernera: [Shunting-Yard Algorithm](https://blog.cernera.me/tag/shunting-yard-algorithm/)

Gregory Cernera:
[Visualizing Thompson’s Construction Algorithm for NFAs, step-by-step](https://medium.com/swlh/visualizing-thompsons-construction-algorithm-for-nfas-step-by-step-f92ef378581b)


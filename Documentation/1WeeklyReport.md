## First week of the course ##

Due to time constraints it was necessary to read the course material and  start planning and coding the project before the course officially started. During August
I searched for ideas and algorithms for building automata. I realized it was important to differentiate between pattern matching and regex matching.DFA would have
been easier to simulate but building it seemed time-consuming. I found some helpful articles according towhich regex matching should be fast enough with so-called
Thompson's NFA, or McNaughton–Yamada–Thompson algorithm, so I settled for that.

I have coded the very base of the project. I wanted a graphic user interface so the project will use JavaFx. I coded some tests and wrote requirements specification.

During the first week I atteded the opening lecture of the course. Out of habit I used Maven in my project but during the lecture I heard we were supposed to use
Gradle with Java. This recommendation was not in the course material and I'm not sure if I will change the  build tool at this point. However, several useful
instructions were given during the lecture:

- methods do not need to be short and compact; subroutines calling subroutines make the code less efficient -> change Checkstyle settings accordingly

- objects withing objects should be avoided

- several ways to implement a regex parser are acceptable

I haven't decided which data structures to use for implementing NFA. My app is already using Java Stack class but I'm unsure if these ready-made data structures
are allowed? The structure of the NFAs should be such that they are easy to merge and concatenate. Most likely it should be some sort of a graph. 



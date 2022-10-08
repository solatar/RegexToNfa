## Fifth week ##

I thought that adding concatenation symbols into a regular expression programmatically is fairly easy so I 
modified my app to do that, instead of asking the user to add them. However, the method still needs more
testing and currenty it does not always give desired output.  

The default icon of JavaFx window does not look very nice so I tried to set a custom image there. The image
would not display. I've been searching for solutions but it seems this is a common problem when running 
JavaFx programs on Ubuntu. I also had a problem viewing images when peer-reviewing another JavaFx project.
I didn't want to spend too much time on this issue but I hope to be able to solve it by the final submission.

A separate main class has been added to the app so creating a runnable jar should not be possible (still have
to check what to add to the POM).

I also corrected some of the Checkstyle errors, though many of them seemed meaningless. In some methods I have
comments in between if-else blocks which causes some blocks to be on 'incorrect' levels.

# Feedback - Exercise 01

**Exercise**
You implemented your own recursive algorithm. The algorithm passes the specified tests. The idea of the algorithm is good, however is not 100% correct.

The way you handle the * does not allow having a
* in the pattern after the .
For instance
("*.*").matches("example.txt") returns false.
Another bug is the handling of two stars and stars combined with ?. For instance
("*?.txt").matches("abc.txt")) returns false



The algorithm is difficult to understand and hence to debug (see comments below). Bugs are hidden in the code.

**Comments:**


It is always a good idea to write code in a way that it explains itself, i. e. it does not require additional comments. When the code is complicated comments can and should be used.
In this case I think you should have written some small comment explaining the recursion in your code. This could have helped you detecting the bugs mentioned above. Having good comments allows also helps yourself find bugs.

**Git messages**
Your git messages are okay, but some of them could be more expressive. For instance, a message just saying "still 2 failures" doesn't give you any information on what was changed in that commit. Remember that these messages are there to help you go back to an older version, should you ever destroy something.

Moreover, you should try to write the git messages in one language, preferably English.



**Encapsulation and Information Hiding:**
You set the instance variables to `private`. Well done.


**Naming:**
As we will see in the course, it is very important to choose the variable names carefully.
You have done this good, already! A name like starposition is perfect since it explains exactly the content. Well done!


In Java it is good practice to use camelCase for instance starPosition instead of starposition. Your IDE has a rename function for such cases, try to learn to use it. Sometimes you did it right, sometimes not.


## Status

accepted (ok)
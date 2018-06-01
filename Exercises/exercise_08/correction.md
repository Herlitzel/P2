# Exercise 8 Corrections


**1. Initialization of address book using CSV files**

Standard cases:

- Address not being part of a group (with and without semicolon at the end): Your solution supports this even if the semicolon is missing
- Address being part of one group: works
- Address being part of several groups: works
- Empty group: works
- Group being part of some other group: works

Border cases:


- creating address before group is created:works
- semicolons missing (wrong syntax): This does not work. An empty line in the csv leads to an OutOfBoundsException

**2. Search address **

Standard cases:

- Empty search (should return all addresses): Well done
- Single field search with no corresponding address in the database: Well done, the program gives just an emty list.
- Single field search with one corresponding address in the database: This works well. 
- Single field search with several corresponding addresses in the database: This works well
- "any" search: Works
- case insesitive search:  works
- Multiple fields should be used with conjunction: works
Border cases:
- wrong syntax: You return the whole address book if the search command is wrong.

**3. Print the result **


Works perfectly.

**4. Export the result**

Works

**5. Design patterns **

- You use the iterator pattern correctly. However you did not implement it yourself but you used the standard library.
- You implemented the composite pattern correctly. The usage makes sense.
- You implemented the visitor pattern correctly. The usage makes sense, you could think about using it also for the search.


**6. Documentation **


* Your documentation is most of the time very clear.
* Your usage of JavaDoc is correct.

**7. Testing **


Your tests are well done and your coverage is high. Avoid using bad words in your code in a real life project :-)

**8. Design by contract **


* Most of your classes do have a invariant. 
* Preconditions are well done, but often not documented. 



**8. Responsibility driven design **

* Most of the time responsibilities are well distributed.
 

## Status
You have provided a solid solution. The solution is tested and documented and you have understood design patterns.

*ok*





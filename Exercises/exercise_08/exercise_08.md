# Exercise 8

In this exercise, you will apply your knowledge on design patterns to 
implement an address book application, where you parse an input file and 
provide features such as searching in entries, writing a subset of the book to 
a new file, and pretty-printing the book or parts of it to the command line.


## Address book specification and features

In this simple format, an address book entry consists of the following fields:
- Name
- Physical address
- Phone number
- Email address

In addition, there are groups of addresses, which is a collection of addresses 
and possibly other (nested) groups. Each group has a group name.


### Input format

Address books are stored as CSV (comma-separated values) files. However, to 
separate fields, we use the semicolon (;), as addresses tend to contain commas 
themselves. There are two kinds of lines; the first describes an address entry 
as follows:
```
Name;physical address;phone number;email address;groups
```
The first four fields are as described above. The `groups` field is a list of 
numbers (e.g., `1,3,4`) that correspond to unique group numbers.

The second type of lines describes groups and consists of three fields as 
follows:
```
Group name;group number;groups
```
The group number must be unique across all groups. Furthermore, a group can be 
part of another group, which is indicated in the last field.

In both cases, the last field is optional. If omitted, the last semicolon can 
be omitted as well.

For example, the following snippet describes two addresses and two groups. 
Elvis is part of group 1, while Robert is part of group 2. Furthermore, group 
2 is part of group 1.

```
Elvis Presley;Elvis Presley Boulevard, Memphis, Tennessee 38116, USA;012 345
67 89;elvis.presley@example.com;1
Robert DeNiro;Bleecker Street, New York, NY, USA;987 654 32 
10;robert@example.com;2
Famous people;1
Actors;2;1
```


### Searching

To quickly locate a contact in larger address books, you have to implement 
a function for searching in the contacts and groups. A search string is 
a simple string that specifies search terms and the fields in which you want 
to search. It is a simple composition of key-value pairs. The following keys 
are possible:
- name: name of a single address (not groups)
- address: physical address
- email: email address
- phone: phone number
- group: group name
- any: special field matching any of the fields
A search term describes parts of a field (or the full field) and are case 
insensitive; so if you look for `name:elv`, then Elvis' address is a match. 
Multiple terms are interpreted as a logical conjunction (e.g., if there are 
two terms, both must match).
Examples for search terms are as follows:
```
name:"elv"
name:"elv" address:"tennessee"
any:"usa"
```



### Pretty-printing

To make the address book more readable, you have to provide a pretty-printer 
that takes addresses and groups and creates a string representation as in the 
following example (based on the sample csv above):
```
  Name: Elvis Presley
  Address: Elvis Presley Boulevard, Memphis, Tennessee 38116, USA
  Phone: 012 345 67 89
  Email: elvis.presley@example.com
  Groups: Famous people

  Group: Famous people
  Members:
    - Elvis Presley
    - Group: Actors
      Members:
      - Robert DeNiro

  Group: Actors
  Members:
    - Robert DeNiro

  Name: Robert DeNiro
  Address: Bleecker Street, New York, NY, USA
  Phone: 987 654 32 10
  Groups: Actors, Famous people
```


### Interactive search, print, and export

To obtain a fully functional address book, your application will consist of 
a simple, interactive command line interfaces for searching, printing, and 
exporting the address book.

To pass the exercise, you have to implement a main method that reads input 
line by line and performs actions accordingly. Three commands need to be 
supported:
- search: search in address book. when searching without any text specifying 
  a query, the full address book should be matched
- print: pretty-print the last search result (or the complete address book if 
  no search has been performed)
- export: print the csv representation of the last search result (or the 
  complete address book if no search has been performed)

An example session looks as follows. Lines starting with $ mean that this is 
what the user enters (without the $ at the beginning). Other lines are what is 
printed by your application and lines starting with // are comments we insert 
for better understanding of the example.
```
$search name:elvis
$print
  Name: Elvis Presley
  Address: Elvis Presley Boulevard, Memphis, Tennessee 38116, USA
  Phone: 012 345 67 89
  Email: elvis.presley@example.com
  Groups: Famous people

$export
Elvis Presley;Elvis Presley Boulevard, Memphis, Tennessee 38116, USA;012 345 
67 89;elvis.presley@example.com;1
// note that this does not directly match group 1. If you want, you can
// implement the export function such that group dependencies are also
// included

$search group:actors
$print
  Group: Actors
  Members:
    - Robert DeNiro

  Name: Robert DeNiro
  Address: Bleecker Street, New York, NY, USA
  Phone: 987 654 32 10
  Groups: Actors, Famous people
// when groups are in the results, include the members as well

$search
// resets the search, matching everything

$export
// output not shown; print all entries such that it looks like the
// example in section "Pretty-printing" above
```

When reviewing your solution, we will use the main method to test whether your 
program works as intended.


## Tasks

Your task is to implement the address book application as described above. In 
your implementation, you need to use at least 3 of the following patterns:
- Singleton
- Iterator
- Composite
- Visitor
Create a file `patterns.md` in which you describe how and where you use the 
patterns (indicate which classes are involved, what the benefits of using this 
pattern in that situations are, ...).

Other than that, you are free to design your program as you wish, as long it 
behaves according to the specification. You also need to fulfil the following 
requirements:

- For each class, have at least one test class. You need to write proper for 
  the full program.
- Name the test methods clearly: Start with verbs like `should...` or 
  `test...` and indicate what is tested with the method.
- Write JavaDoc comments for your program. For each class, describe it 
  according to what was covered in the lectures and the JavaDoc exercise hour; 
  do not forget to describe responsibilities.
- Use design by contract where appropriate (both as JavaDoc comments and using 
  assertions).
- In general, follow the best practices presented throughout the semester. If 
  you are unsure about anything, ask us.


## Deadline

Submit your solutions by pushing your code to the git repository by 
___Thursday, 24 May, 13:00___.

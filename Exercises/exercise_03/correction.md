# Exercise 3 Corrections

Your turtle program supports the different directions we ask you for. It does not run stable, because it breaks when you disable assertions in the VM (see below)
You decided to just ignore lines with invalid commands and execute the others.


**1. Split parsing and execution of programs in separate classes / objects**

You fulfill this requirement.

**2. In your API documentation, explicitly state pre- and postconditions**

You miss to explicitly state very relevant preconditions.
Example:
In the comment of
`Turtle#moveLeft()` you should have stated that a precondition is that the turtle is has at least one square to its left (you check it using the assert() method).
The same holds for the `Turtle#moveRight()`,... methods.

It is good practice to document pre-conditions directly after @param tag in the comment:
Example for `CommandParser#parse(String eingabe)`
@param eingabe, cannot be empty

**3. Check pre- and postconditions using the assert keyword**

Mostly you checked stated pre- and postconditions.
There are checks on non-stated conditions.
In the Turtle you use preconditions wrong.
You have the following code in the Turtle class:

	/**
	 * moves this turtle one step to the left
	 */

	public void moveLeft() {
		assert(this.pos.x > 0);
		this.pos.x--;
		board.drawTrail(pos.x, pos.y);
		assert(invariant());
	}

and the following code in the command class

		else {
			for(int i=0; i < steps; i++)
				try {
					moveTurtle(turtle);
				} catch(AssertionError e) {
					// do nothing if commands leads to turtle wandering over the field
				}
		}
		assert(invariant());
	}

This is bad because of the following reasons:

- Your code will not work as soon as you disable assertions. Look at slide 58 of the lecture 3.
- An assertion is a declaration of a boolean expression that the programmer believes must hold at some point in a program. If an assertion is false, there is a bug in the program. Assertions should NEVER affect the logic of the program. You should not use assertions to catch the case where the turtle would leave the board. If you want to stick to your approach you should throw an exception in the Turtle.moveLeft() method. The command class then may catch it. Make sure to understand the difference between assertions and exceptions. This is relevant for the further course and for the exam.

**4. Check class invariants**

You check the class invariants in all classes.


**5. Reasonably deal with all input programs, in exactly the place that your contracts prescribe**

You do not really fulfill this requirement because of the issue above. Moreover, there are some other cases where it is really hard to check whether you really catch invalid states (example: what happens if you create a turtle using new Turtle(200, 200, board) and the board has size 100 x100)

**6. Write proper class comments. You should explain the class responsibilities and state invariants**

Your class comments are OK-ish. I miss clear and concise information on how to use a particular class. I am thinking about the CommandParser class. There you should in my opinion explain how a programmer can use it. I. e. you could write something like call `CommandParser#parse()` then retrieve the commands using `getCommands()`  and after completion call `deleteCommands()`.

**7. UML diagrams**

Your class diagram was generated automatically. Note that this is was not allowed. Moreover, there is a lot unneeded information for a draft (a draft should
explain the important parts of your solution to somebody else).

Same holds true for the sequence diagram.

**Other**

*API Documentation*

Explain not obvious things. e.g. in `Position` you don't need to comment the constructor but you
need to explain at least in the class comment **how** the two integers will specify the direction.

*OO design principles*

I think your Command class is not well done. You mix the two relatively different commands (diagonal and straight moves) in one class and you have a lot of if statements to take care of which command case you use. This is a code smell. It would have been better to split the class up and use a interface implemented by both classes. You do not have to correct it if you don't want to, but keep it in mind.


*Git messages:*

Your commit messages sometimes very good and sometimes not at all expressive (You should avoid using asdf as a commit message).

## Status

revise (revision required)

Please change the following:
- do not use assertions the way you did it in the turtle class (see comments above). Look again at the slides of lecture 3. Use an exception instead of an assertion if you want to keep your design.
- Redo the class and sequence diagram by hand. Make sure your diagram only shows the important aspects.

Submit your revised solution until **Thursday, 5th April 2018 13:00**

## Status (after revison)

ok

You have used a TurtleRunoverException insted of using assertions. Well done.
You have written an e-mail where you explained that the class diagrams were not generated automatically. 


# Exercise 4 Corrections



**1. Testing Game#play(Die) using a MockDie class **

Very well done. I liked that you implemented some logic to count the number of times the die was called! 

**2. Testing Game#play(Die) using Mockito **

Your tests are extensive and well done.. You tested more than standard scenarios (3 players) You used the verify method correctly to make sure the die was rolled. 
You also verified the number of times a method was called using the (optional) times() argument of the verify method. Perfect!

**3. Compare 1 and 2 **

Good insight on mocking. 

**4. Testing all squares **

You tested all the squares extensively. You covered all the important cases. You looked at special cases (like invalid transports, occupied special squares). In the WormholeEntranceSquare you could have checked that indeed both exists are used by running the tests several (let's say 500 times in a loop)..

**5.  Adding the SlowDownSquare, commenting and testing it **

You did not provide any comment on the SlowDownSquare. This was required. 
Your implementation does not satisfy OO design principles.
- The logic is distributed among the Player, Game and SlowDownSquare class.
- The player's slowDownNextTurn is public and changed outside the class. You should declare your varialbes private or protected and use access methods.
  

## Status

*wow*
wow for the tests!
ok for the slowDownSquare.



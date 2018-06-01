# Exercise 2 Corrections



The numbers in the following list correspond to the tasks in `exercise_02.md`.

1.
 You implemented all squares. Individual comments below.
  - `SkipSquare`: Your solution is very elegant and well done! This is exactly OO programming!
  - `SwapSquare`: I like that you implemented the logic of the swapping in the SwapSquare and not in the Game class. However, you violated an important  principle, namely "Separate interface and implementation" (see Lecture 2). Your Player.GoTo method does only accept a Square and not an ISquare. 
  You should try to make it work with ISquare. If you have good reasons why not, you could have written a small comment explaining your choice.
  Note that your code has a bug: If you enter a Swap Square and the next player is on a WormholeExit or on the FirstSquare the casting:
  Square nextSquare = (Square) next.square();
 in the SwapSquare.enter() method will fail.
 *You have to correct this*
  
  I also do not see why you need this finalEnter() method. I think in the SwapSquare.enter() method you could make sure that both player's have left their squares before placing a player on a square using player.GoTo. But you do NOT have to correct this. 
  
  - `WormholeEntranceSquare` and `WormholeExitSquare`: Your solution very clean and well done! I like how your perfect implementation of the getRandomExitSquare() method!
2.
You only added one test each for the skip and swap square. There are still some more cases you could test for these two (not just more players, but different relative positions of the players, players standing on special fields, etc.).
Note that the bug reported in 1 should have been detected by such a test.
* Please write an additional test for the SwapSquare, where you reproduce the issue reported above * (as you will see later in the course, it is good practice to always write a test that reproduces a bug before fixing it.)
3. 
Well done! 
4. 
Done.
5. 
Only partly OK.
The idea of documenting the interface is to document its general tasks and not those of the implmentation.
For instance you write for the enter method:
It can only be called if this Square is already empty (because only one player can be on one square).
This is wrong: for instance on the FirstSquare (which implements this interface) you can call this method always.
You do not have to correct this, but keep it in mind for the next exercises
6. Well done!



## Status
You have done a good job and you have understood responability driven design, well done! However, you did not do enough testing and you could improve Documentation.

*revise*

Revision required until Thursday, March 22th

Please change the following things:
Fix the bug in the SwapSquare (see above)
Add one more test for the swap square which reproduces the bug.

## Status (after revision)

*ok (accepted) *
You fixed the bug and you changed the test in the SwapSquare such that it reproduces the bug.
# Exercise 6

In this exercise, we continue working on the Ludo board game. So far, we only initialized the game and created the important components. However, no logic for actually playing the game has been implemented.

The goal in this exercise is to implement the rules for a Ludo game and a random driver that executes the game automatically. Similar to the snakes and ladders game, the game is printed after each step.

To pass this exercise, you have to implement iterations 3 and 4 as described below. As a prerequisite, you need to have finished iterations 1 and 2 in exercise 5; if you have not done so yet, you first have to complete exercise 5.


## Iteration 3: Game Logic

In the previous exercise, you implemented the basic structures to represent a Ludo game and functions for basic movement. However, the bulk of the logic is still missing. The goal of this iteration is to provide a fully functional game that corresponds to the described rules. It consists of doing the following tasks:

- Implement a `Die` class that is used by the players.
- Implement the remaining actions a player can make (for example, rolling the die, moving from the home box to the board, moving a token into the goal tile, sending other player’s tokens home, …).
- Keep track of the game state. This includes things like remembering which player’s turn it is next, determining whether the game is over, etc.
- Implement any other missing features to obtain a fully functional game.

If you are unsure about rules, you can either ask us or decide on your own how your game should behave. Either way, you should have test cases that make sure that the rules are implemented correctly and the game behaves as expected.

Note that in this iteration, you don’t have to implement functionality to play the game automatically or manually yet. However, there should be functions to execute all necessary steps to execute a game from start to end.

Once done, mark the third iteration as follows.
```
git tag -a v3 -m "Ludo stage 3"
```


## Iteration 4: Random game runner

In the final stage, we make the game playable by implementing a class `RandomGameRunner`, which initializes a new game with two to four players. The class must contain a method `play()` that plays the game with a random die (like in the Snakes and Ladders game). After each roll, print the player name (A, B, C, or D), the rolled number, and the board *after* the move is executed. The game is played until a player wins.

In some instances, there are different actions possible; for example, when rolling a six, a player can move a token further along the path or put one of the tokens that have note entered the game yet on the starting square. In this case, you can choose yourself what to do; either implement a fixed strategy (e.g., always move the first token if possible, then the second, and so on) or choose at random what to do.

Once done, mark the fourth iteration as follows.
```
git tag -a v4 -m "Ludo stage 4"
```


## Notes

If you are unsure about the specific rules, you are free to decide for yourself. However, please include a file README where you explain your decision.


## Deadline

Submit your solutions by pushing your code to the git repository by ___Thursday, 3 May, 13:00___.

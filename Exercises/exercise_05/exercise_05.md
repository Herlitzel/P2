# Exercise 5

In the upcoming exercises, we will implement *Ludo* (see its [Wikipedia article](https://en.wikipedia.org/wiki/Ludo_(board_game)), a simple board game that can be played by up to four people. By applying the concepts that have been covered so far (for example, object-oriented design principles, unit testing, responsibility driven design), we aim for a well-designed implementation of some basic features in this exercises. In later exercises, we will continue to add features until we have a fully functional game. Therefore, building a solid foundation in this exercise will pay off in the long run.


## Problem Description

*Ludo* is a board game that requires at least 2 players. The board is rectangular with tiles (or squares; we use both terms interchangeably here) that represent paths along which a player has to walk. Starting with four pieces each, the goal of the player is to move the pieces around the board and land at their goal tiles. The first player who reaches the goal tile with all pieces wins the game.


### Ludo Rules

We use the following rules for our Ludo game. If something is unclear or missing, refer to the original rules stated on [Wikipedia](https://en.wikipedia.org/wiki/Ludo_(board_game)#Rules) (not the variations, just the ones stated in section Rules). However, if the rules stated here differ, they take precedence over the ones on Wikipedia.

- Two, three, or four players can play.
- Each player starts with four pieces (also called tokens) in one corner.
- Players move their tokens clockwise along the board.
- Players take turns rolling the die.
- When rolling a six, a player can either move a piece on the board, or move a piece from the start area to the first square; furthermore, a player can roll again after rolling a six.
- When rolling any other number, a piece on the route can be moved.
- When a token lands on a token of another player, the player's token that was already there is reset to their home square.
- When approaching the goal, one has to roll the exact number required to get onto the goal tile; otherwise, the player cannot be moved at all on that round.
- Players that have multiple tokens in play can choose freely which one to move.

Note that you will not have to implement the rules in this exercise yet. However, you may want to keep them in mind when designing and implementing your game basics.


## Tasks

In order to pass this exercise, you need to do the tasks state here. Note that exercises 6 and 7 will build on top of this one. You will have to implement the parts described here in any case.

Before you get started, make sure you understand the game by reading the description on Wikipedia and clearing up any questions that you might have. Once this is clear, you can start designing and implementing the game.


### Iteration 1: Initialization

In the first phase, we implement basic features of the game. In this stage, the game does not have to be playable yet. Instead, you will create the basic classes, properly distribute responsibilities, and test the game setup. Implement the following.

- Representations:
  - Board,
  - players,
  - squares/tiles,
  - tokens,
  - the game (bringing it all together, similar to the Snakes & Ladders `Game` class).

  You can decide yourself what kinds of classes you will use. However, you need to have at least dedicated classes for board, game, players, tokens, and squares. Add additional classes if needed.

- Ability to:
  - Initialize a new board that places two players in opposite corners,
  - place players on specific squares,
  - move players along the route.

  Note that the last point just means that you can do something like `token.move(3)`, which moves the selected token by 3 steps. You do not have to implement logic that checks, for example, whether the move is valid, whether it is a winning move, etc. It’s just about moving along the route in a “normal” case.

Make sure you follow the principles you have learned so far. You should document your code (e.g., class, method comments) and write tests, apply responsibility-driven design, and use design by contract where appropriate.

In order to mark milestones, we will start using git's tag feature. Tags are used to mark important commits with a name, for example, with a version number. The feature is thoroughly documented on  [git-scm.com](https://git-scm.com/book/en/v2/Git-Basics-Tagging).

Once you finished reading the documentation, use git to create a tag that marks the finished first stage. Here, we will use annotated tags, which you can create as follows.
```
git tag -a v1 -m "Ludo stage 1"
```

This part of the exercise is due on ___Thursday, 12 April, 13:00___.


### Iteration 2: Rendering the board

A Ludo board contains a large amount of information; creating output that contains all of it is non-trivial. Again, you are free to represent the board however you want. Nevertheless, we provide an example board here that you can choose to use, but you are not obliged to. (In case the board is not displayed properly, check out the file `ludo_board.txt`, which contains the same board.)

    ######---######
    A2  ##-|*##  B3
        ##*|-##
        ##-|C##
        ##C|-##
    ######-|-######
    -*--A-#$#-A-*--
    ->>>>>$#$<<<<<-
    --*-C-#$#----B-
    ######-|-######
        ##2|C##
        ##-|-##
        ##-|*##
    C0  ##*|-##  D4
    ######---######

In this board, the following symbols are used:

- `#`, `␣` (space): Drawing; these are non-functional and just serve to give a better idea of the board.
- `-`: Unoccupied field.
- `*`: Unoccupied special square.
- Numbers `1-9`: If multiple tokens are on the same square, show the number of tokens.
- `>`, `|`, `<`: A player's “home road”.
- `$`: Goal square.
- `A`, `B`, `C`, `D`: Player tokens.
- `A0`, `A1`, `A2`, `A3`, `A4` in the corners (and same for B, C, D): Number of tokens still not on the board. For example, `A4` means that player A does not have any tokens on the board yet. `B3` means that player B has a single token on the board.

In this iteration, your task is to implement and test a board renderer. To do that, create a class that can render a given board by generating a string representation. This can then be used in tests or printed using `System.out.print...` methods (more information on this below).

You should write tests that ensure that your game correctly renders different game configurations, not only the initial state. For example, you should write a test that ensures that tokens are correctly rendered when on an specific tile.

Hint: Think about what “units” you are testing. For example, rendering tiles with different things occupying them can be done in isolation, you do not have to test the full board. If rendering individual tiles works, then you can use this in the main board renderer. You should also think about who is responsible for rendering what. Should a single `Renderer` class take care of everything? Or should there be, for example, classes like `BoardRenderer`, `TileRenderer`, `PlayerRenderer` that can be composed?

Once done, mark the second iteration as follows.
```
git tag -a v2 -m "Ludo stage 2"
```


## Notes

- You are free to design the game as you want, but you should follow the design principles that you learned so far. You can take a look at the Snakes & Ladders implementations we provided in exercise 4 to get an idea of how your class structures could look like.

- We added some classes (without implementations) in the template. You can use them, but if you want, you can also modify or change them (or change them into interfaces if necessary).

- You do not have to implement a fully functional game yet! In this exercise, we focus on initialization, rendering, and (very) basic player movement. You do not need to implement any additional game logic.

- Write proper JavaDoc class and method comments.

- Do not forget about design by contract.

- If you are struggling with the exercise, you are not alone. Get help on Piazza, during pool hours, or via assistant mailing list.

- Manage your time responsibly. Do not just start the day before the exercise is due.


## Deadline

This exercise has two deadlines. The first iteration (marked with the `v1` git tag) is due on ___Thursday, 12 April, 13:00___. The second iteration (marked with the `v2` tag) is due on ___Thursday, 19 April, 13:00___.

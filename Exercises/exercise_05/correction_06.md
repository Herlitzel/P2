# Exercise 6 Corrections


**1. Implement a `Die` class **

Clean and straight forward implementation.

**2. Implement the remaining actions a player can take **

- rolling the die

Works well.
- moving from the home box to the board

This works well using the `Token#join` method
- moving a token into the goal tile

This works, but please read the hint below.
- sending other player’s tokens home

This works, but your solution also sends home the player's own tokens.


**3. Keep track of the game state **


Works perfectly.

**4. RandomGameRunner **


Wow, very clean!

**5. Documentation **


* Your documentation is most of the time very clear and helpful
* Sometimes an additional comment is required.
in the `CrossingSquare#getNextSquare()` you have the following Code

	@Override
    public ISquare getNextSquare(Token token){
        if(token == null)
            return super.getNextSquare(token);
        return this.color == token.getPlayer().getColor() ? couloir : super.getNextSquare(token);
    }
	}

There you should explain in a comment, why the token could be null.


**6. Testing **


* You did not write enough tests, I think the `Player#act()` method should be tested with mocking the relevant objects.
* Also your `Player#wins` code is not tested although it is quite important.


**7. Design by contract **


* Most of your classes do have a invariant. You added some invariants, relative to last time. Well done!
* Preconditions are well done and documented. 



### Hints
* Try to name your variables better. In the `Board` class you have a variable called `winner` I would have expected a Player but it is an ArrayList of tokens.
* I do not see why the variables in the `Game` class are static. I think it is not necessary and thus bad practice.
* You should create an abstract class (or interface) called `Player` and then rename your `Player` class into `HumanPlayer`. Afterwards you should let both `HumanPlayer` and `RandomPlayer` extend (or implement) `Player`. The reason is that it clarifies your code and it models the conceptual Hirarchie correctly: both `HumanPlayer` and `RandomPlayer` are Players.  


* Your `NormalSquare` does still have the useless invariant
	
	    protected boolean invariant(){
        return (token != null || token == null);
    }

although I already wrote in the last exercise that you should not do this.



## Status
You have provided a good solution, most parts are well done. You could have tested your code better, especially the Player class. Try to use inheritance as a conceptual modeling tool.

*ok*





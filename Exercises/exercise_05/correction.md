# Exercise 5 Corrections


**1. Initialization of players **


Your solution supports 2-4 players and places them correctly. The code in the `Board#initialize` method is however very long and contains a lot of very similar code passages. You should try to think about a private method, that just takes a color and a position and initializes the crossing Squares. The same holds for the Couloir. There you could easily factor out a method. Try to avoid hard coded magic numbers in your code. If you use them, try to code them at the beginning and all together, i. e. 

	final int HOMES [] = {13,39,26,0};
	

**2. Place players on specific squares **


Works perfectly.

**3. Move tokens along the route **


Works only partly. I like that you have a `ISquare` interface, where the different squares just overwrite the `getNextSquare()` method. But as far as I see, the `getNextSquare()` method should depend on the token. This would allow you to implement the `CrossingSquare` correctly. Until now, the tokens do never enter the Coloir as far as I see. 
You decided that only one token can be on a square at some given point in time. So the player will send home his own tokens under certain circumstances. This is not exactly the specification we gave you.

**4. Renderer **

The `Renderer` interface does only have one method, namely `toString`. Note that it is not necessary to specify the `toString` method since every class in Java implicitly extends the Object class, which itself has a toString method.
Your idea of having a renderer for each Square is good!
I do not see the purpose of the `TMPRenderMainClass`. It is not tested and not documented. Is it obsolete?

**5. Documentation **


* Your documentation is most of the time clear and helpful!
* Your usage of JavaDoc is correct.

**6. Testing **

Your tests are most of the time OK and the coverage is high. You do never use mocks in your tests. 


**7. Design by contract **

* Most of your classes do have an invariant.  
* The invariant of the NormalSquare is not OK. You have:

    protected boolean invariant(){
        return (token != null || token == null);
    }
This holds always and does not make sense. You should ask for instance:

    protected boolean invariant(){
        return (nextSquare != null);
    }
* Note that you should test invariants at the end of every public method call. Most of the time you test it at the beginning. Make sure to have a look at the relevant slides again.
* Mostly you stated meaninful preconditions, well done!

**8. Responsibility driven design **

* Most responsibilities are well distributed, most of the methods are short and well named. Good job!
* The Game does essentially nothing. I think, this will I think change, when you implement the logic.
* The idea of using a `ISquare#getNextSquare()` method is very good and object oriented. Well done!


### Hints
* Avoid using hard coded numbers in your code as much as possible.
* Try to use a enum to code your Colors instead of a String. I do not think it is a good idea to code colors as strings.
* Instead of (in your `GameTest` class)


	assertTrue(route[i] != null);

you can use:

	assertNotNull(route[i]);




## Status

*ok*

Responsibility driven design is well done. Overall you did a good job. 
For the next iteration, please change the following:
- Please make sure to improve your Design by contract.
- Try to improve your `Board#initialize()` method. I think it's a good exercise.





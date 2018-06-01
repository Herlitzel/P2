package snakes.squares;

import static org.junit.Assert.*;

import org.junit.Test;

import snakes.GameTest;

public class LadderSquareTest extends GameTest{
	
	@Test
	public void testLadderGeneration() {
		newGame(10);
		game.setSquare(4, new LadderSquare(4, game, 4)); //Initializes a ladder from 4 to 8
		assertEquals(game.getSquare(4).toString(), "[4->8]");
	}
	@Test
	public void testLadderGenerationTwo() {
		newGame(10);
		game.setSquare(2, new LadderSquare(5, game, 2)); //Initializes a ladder from 2 to 7
		assertEquals(game.getSquare(2).toString(), "[2->7]");
	}
	@Test
	public void testLadderFunctionJack() {
		newGame(10);
		game.setSquare(4, new LadderSquare(4, game, 4)); //Initializes a ladder from 4 to 8
		
		game.movePlayer(3);
		assertEquals(jack.position(), 8); //jack goes up the ladder to 8
	}
	@Test
	public void testLadderFunctionDavid() {
		newGame(10);
		game.setSquare(4, new LadderSquare(4, game, 4)); //Initializes a ladder from 4 to 8
		
		game.movePlayer(1);
		game.movePlayer(3);
		assertEquals(jack.position(), 2); //Jack is on 2
		assertEquals(david.position(), 8); //David goes up the ladder to 8
	}
	@Test
	public void testLadderToOccupiedSquare() {
		newGame(10);
		game.setSquare(4, new LadderSquare(4, game, 4)); //Initializes a ladder from 4 to 8
		
		game.movePlayer(3);	//Moves jack
		assertEquals(jack.position(), 8); //Jack goes up the ladder to 8
		game.movePlayer(3);	//Moves David to ladder and should land on 1
		assertEquals(david.position(), 1); //David is on 1
	}
	@Test(expected = AssertionError.class)
	public void checkInvalidTransport() {
		newGame(5);
		game.setSquare(4, new LadderSquare(4, game, 4));	//wants to set a ladder destination outside of field
		
	}
}

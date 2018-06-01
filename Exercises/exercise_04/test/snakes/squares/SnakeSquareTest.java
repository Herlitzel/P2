package snakes.squares;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import snakes.GameTest;

public class SnakeSquareTest extends GameTest{
	@Test
	public void testSnakeGeneration() {
		newGame(10);
		game.setSquare(5, new SnakeSquare(-2, game, 5)); //Initializes a Snake from 6 to 2
		assertEquals(game.getSquare(5).toString(), "[3<-5]");
	}
	@Test
	public void testSnakeGenerationTwo() {
		newGame(10);
		game.setSquare(9, new SnakeSquare(-5, game, 9)); //Initializes a Snake from 9 to 4
		assertEquals(game.getSquare(9).toString(), "[4<-9]");
	}
	@Test
	public void testSnakeFunctionJack() {
		newGame(10);
		game.setSquare(5, new SnakeSquare(-2, game, 5));
		
		game.movePlayer(4);
		assertEquals(jack.position(), 3); //jack goes down the snake to 3
	}
	@Test
	public void testSnakeFunctionDavid() {
		newGame(10);
		game.setSquare(5, new SnakeSquare(-2, game, 5));
		
		game.movePlayer(1);
		game.movePlayer(4);
		assertEquals(jack.position(), 2); //Jack is on 2
		assertEquals(david.position(), 3); //David goes down the snake to 3
	}
	@Test
	public void testSnakeToOccupiedSquare() {
		newGame(10);
		game.setSquare(5, new SnakeSquare(-2, game, 5));
		
		game.movePlayer(2);
		game.movePlayer(4);
		assertEquals(jack.position(), 3); //Jack is on 1
		assertEquals(david.position(), 1); //David returns home
	}
	@Test(expected = AssertionError.class)
	public void checkInvalidTransportDestination() {
		newGame(10);
		game.setSquare(4, new SnakeSquare(-10, game, 4));	//wants to set a snake destination outside of field
	}
	@Test(expected = AssertionError.class)
	public void checkInvalidTransportPositive() {
		newGame(10);
		game.setSquare(4, new SnakeSquare(2, game, 4));	//wants to set a snake destination positive
	}
}

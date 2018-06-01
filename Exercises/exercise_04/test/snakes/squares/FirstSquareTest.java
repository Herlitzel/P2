package snakes.squares;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import snakes.*;

public class FirstSquareTest extends GameTest{
	
	@Test
	public void testIsFirstSquare() {
		newGame(10);
		assertTrue(game.getSquare(1).isFirstSquare());
	}
	@Test
	public void testLabelling() {
		newGame(10);
		assertEquals(game.getSquare(1).toString(), "[1<Jack Sparrow><David Jones>]");
	}
	@Test
	public void testEnter() {
		newGame(5);
		game.getSquare(1).enter(new Player("joe"));
		assertEquals(game.getSquare(1).toString(), "[1<Jack Sparrow><David Jones><joe>]");
	}
	@Test
	public void testIsEmpty() {
		newGame(5);
		game.movePlayer(1);
		game.movePlayer(2);
		assertFalse(game.getSquare(1).isOccupied());
	}
	@Test
	public void testLandHereOrGoHome() {
		newGame(5);
		assertEquals(game.getSquare(1).landHereOrGoHome(),game.getSquare(1).landHereOrGoHome());
	}
	@Test
	public void testLandHereOrGoHomeInGame() {
		newGame(5);
		game.movePlayer(2);
		game.movePlayer(2);
		assertTrue(game.getSquare(1).isOccupied());
	}
}

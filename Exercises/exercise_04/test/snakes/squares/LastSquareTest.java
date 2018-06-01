package snakes.squares;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import snakes.*;

public class LastSquareTest extends GameTest{
	
	@Test
	public void testIsLastSquare() {
		newGame(10);
		assertTrue(game.getSquare(10).isLastSquare());
	}
	@Test
	public void testIsLastSquareTwo() {
		newGame(20);
		assertTrue(game.getSquare(20).isLastSquare());
	}
	@Test
	public void testLabelling() {
		newGame(10);
		assertEquals(game.getSquare(10).toString(), "[10]");
	}
	@Test
	public void testLabellingEndOfGame() {
		newGame(10);
		game.movePlayer(9);
		assertEquals(game.getSquare(10).toString(), "[10<Jack Sparrow>]");
	}
	
}

package snakes.squares;

import static org.junit.Assert.*;

import org.junit.Test;

import snakes.GameTest;

public class SwapSquareTest extends GameTest{
	
	@Test
	public void testLabellingAndGeneration() {
		newGame(10);
		game.setSquare(5, new SwapSquare(game, 5));
		
		assertEquals(game.getSquare(5).toString(), "[5 (Swap)]");
	}
	
	@Test
	public void testJackSwap() {
		newGame(10);
		game.setSquare(5, new SwapSquare(game, 5));
		
		game.movePlayer(4);					//moves jack
		assertEquals(jack.position(), 1);	//jack swapped with david
		assertEquals(david.position(), 5);
	}
	@Test
	public void testDavidSwap() {
		newGame(10);
		game.setSquare(5, new SwapSquare(game, 5));
		
		game.movePlayer(6);					//moves jack
		game.movePlayer(4);					//moves david
		assertEquals(jack.position(), 5);	//david swapped with jack
		assertEquals(david.position(), 7);	//"
	}
	@Test
	public void testSwapMorePlayers() {
		newGameThreePlayers(10);
		game.setSquare(5, new SwapSquare(game, 5));
		
		game.movePlayer(1);					//moves jack
		game.movePlayer(2);					//moves david
		game.movePlayer(4);					//moves joe to swap
		
		assertEquals(joe.position(), 2);		//joe should swap with jack
		assertEquals(jack.position(), 5);	//"
		assertEquals(david.position(), 3);	//david remains	
	}
}

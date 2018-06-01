package snakes.squares;

import static org.junit.Assert.*;

import org.junit.Test;

import snakes.GameTest;

public class SkipSquareTest extends GameTest{
	
	@Test
	public void SkipSqureGenerationAndlabellingTest() {
		newGame(10);
		game.setSquare(3, new SkipSquare(game, 3));
		assertEquals(game.getSquare(3).toString(),"[3 (Skip)]");
	}
	@Test
	public void SkipSqureJack() {
		newGame(10);
		game.setSquare(3, new SkipSquare(game, 3));
		
		game.movePlayer(2);
		assertEquals(jack.position(), 3); 	//Moves Jack to SkipSquare
		game.movePlayer(2);					//Moves Jack again (to 5)
		assertEquals(jack.position(), 5);
	}
	@Test
	public void SkipSqureDavid() {
		newGame(10);
		game.setSquare(3, new SkipSquare(game, 3));
		
		game.movePlayer(1);
		game.movePlayer(2);
		assertEquals(jack.position(), 2); 	//Jack is on 2
		assertEquals(david.position(), 3);	//david on 3, so skip jack
		game.movePlayer(3);					//Moves david to 6
		assertEquals(david.position(), 6);
		game.movePlayer(2);					//Now jack again
	}
	@Test
	public void checkOccupiedAlready() {
		newGame(10);
		game.setSquare(3, new SkipSquare(game, 3));
		game.setSquare(6, new SkipSquare(game, 6));
		
		game.movePlayer(2);					//Jack moves to skip
		david.moveForward(2);				//Now david wants to get there too
		assertEquals(david.position(), 1); 	//..So david is sent back
		assertEquals(jack.position(), 3);	//Jack on skip, still
		game.movePlayer(3);					//jack keeps going
		assertEquals(jack.position(), 6);
	}
}

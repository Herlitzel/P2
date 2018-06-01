package snakes.squares;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import snakes.*;

public class SlowDownSquareTest extends GameTest{
	
	@Test
	public void testSlowDownJack() {
		newGame(10);
		game.setSquare(5, new SlowDownSquare(game, 5));
		
		assertEquals(game.getSquare(5).toString(),"[5 (Slowdown)]");
		
		game.movePlayer(4);	//Moves Jack to the slowdownsquare
		game.movePlayer(1);	//Moves David to 2
		assertEquals(5,jack.position());
		assertEquals(2,david.position());
		game.movePlayer(4);	//Jack is slowed down, so must land on 7 instead 9
		game.movePlayer(1);	//David moves to 3
		assertEquals(7, jack.position());
		assertEquals(3, david.position());
	}
	
	@Test
	public void testSlowDownDavid() {
		newGame(10);
		game.setSquare(5, new SlowDownSquare(game, 5));
		
		assertEquals(game.getSquare(5).toString(),"[5 (Slowdown)]");
		
		game.movePlayer(1);	//Moves Jack to 2
		game.movePlayer(4);	//Moves David to slowdownsquare
		assertEquals(2,jack.position());
		assertEquals(5,david.position());
		game.movePlayer(1);	//Jack moves to 3
		game.movePlayer(4);	//David moves to 7 instead of 9
		assertEquals(3, jack.position());
		assertEquals(7, david.position());
	}

	@Test
	public void testContinueMovingNormal() {
		newGame(15);
		game.setSquare(5, new SlowDownSquare(game, 5));
		assertEquals(game.getSquare(5).toString(),"[5 (Slowdown)]");
		
		game.movePlayer(1);	//Moves Jack to 2
		game.movePlayer(4);	//Moves David to slowdownsquare
		assertEquals(2,jack.position());
		assertEquals(5,david.position());
		game.movePlayer(1);	//Jack moves to 3
		game.movePlayer(4);	//David moves to 7 instead of 9
		assertEquals(3, jack.position());
		assertEquals(7, david.position());
		game.movePlayer(1);	//Jack moves to 4
		game.movePlayer(6);	//David moves normal again
		assertEquals(4, jack.position());
		assertEquals(13, david.position());
	}
	
	@Test
	public void testLandOnSlowDownTwice() {
		newGame(15);
		game.setSquare(5, new SlowDownSquare(game, 5));
		game.setSquare(7, new SlowDownSquare(game, 7));
		assertEquals(game.getSquare(5).toString(),"[5 (Slowdown)]");
		
		game.movePlayer(1);	//Moves Jack to 2
		game.movePlayer(4);	//Moves David to slowdownsquare
		assertEquals(2,jack.position());
		assertEquals(5,david.position());
		game.movePlayer(1);	//Jack moves to 3
		game.movePlayer(4);	//David moves to 7 instead of 9
		assertEquals(3, jack.position());
		assertEquals(7, david.position());
		game.movePlayer(1);	//Jack moves to 4
		game.movePlayer(6);	//David moves to 10 instead of 13
		assertEquals(4, jack.position());
		assertEquals(10, david.position());
	}
	
	@Test
	public void testRoundUp() {
		newGame(10);
		game.setSquare(5, new SlowDownSquare(game, 5));
		
		assertEquals(game.getSquare(5).toString(),"[5 (Slowdown)]");
		
		game.movePlayer(4);	//Moves Jack to the slowdownsquare
		game.movePlayer(1);	//Moves David to 2
		assertEquals(5,jack.position());
		assertEquals(2,david.position());
		game.movePlayer(5);	//Jack has thrown 5, so should go 3 (round up)
		game.movePlayer(1);	//David moves to 3
		assertEquals(8, jack.position());
		assertEquals(3, david.position());
	}
	
	@Test
	public void testSlowDownThreePlayers() {
		newGameThreePlayers(10);
		game.setSquare(5, new SlowDownSquare(game, 5));
		
		assertEquals(game.getSquare(5).toString(),"[5 (Slowdown)]");
		
		game.movePlayer(1);	//Moves Jack to 2
		game.movePlayer(2);	//Moves David to 3
		game.movePlayer(4);	//Moves Joe to slowdown square (5)
		assertEquals(2,jack.position());
		assertEquals(3,david.position());
		assertEquals(5,joe.position());
		game.movePlayer(4);	//Jack is moved to 6
		game.movePlayer(1);	//David moves to 4
		game.movePlayer(4);	//Joe is slowed down and moves to 7
		assertEquals(6, jack.position());
		assertEquals(4, david.position());
		assertEquals(7, joe.position());
		game.movePlayer(2);	//Jack is moved to 8
		game.movePlayer(1);	//David moves to slowDownSquare
		game.movePlayer(2);	//Joe keeps going normally to 9
		assertEquals(8, jack.position());
		assertEquals(5, david.position());
		assertEquals(9, joe.position());
		assertTrue(david.slowDownNextTurn);
	}
	
}

package snakes.squares;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import snakes.*;

public class StandardSquareTest extends GameTest{
	@Test
	public void testLabelling() {
		newGame(5);
		
		assertEquals(game.getSquare(1).toString(),"[1<Jack Sparrow><David Jones>]");
		assertEquals(game.getSquare(2).toString(),"[2]");
		assertEquals(game.getSquare(3).toString(),"[3]");
		assertEquals(game.getSquare(4).toString(),"[4]");
		assertEquals(game.getSquare(5).toString(),"[5]");
	}
	
	@Test
	public void testLabellingMoveJack() {
		newGame(5);
		
		game.movePlayer(2);	//Moves Jack to 3
		
		assertEquals(3,jack.position());
		assertEquals(game.getSquare(3).toString(),"[3<Jack Sparrow>]");

	}
	
	@Test
	public void testLabellingMoveDavid() {
		newGame(5);
		
		game.movePlayer(2);	//Moves Jack to 3
		game.movePlayer(3);	//Moves Jack to 4
		
		assertEquals(4,david.position());
		assertEquals(game.getSquare(4).toString(),"[4<David Jones>]");

	}

	@Test
	public void testMovePlayer() {
		newGame(10);
		
		game.movePlayer(4);	//Moves Jack to 5
		assertEquals(5,jack.position());
		game.movePlayer(1);	//Moves David to 2
		assertEquals(2,david.position());
		game.movePlayer(1);	//Moves Jack
		assertEquals(6,jack.position());
		game.movePlayer(1);	//Moves David
		assertEquals(3, david.position());
	}
	
	@Test
	public void testGoHome() {
		newGame(10);
		
		game.movePlayer(4);	//Moves Jack to 5
		assertEquals(5,jack.position());
		game.movePlayer(4);	//Moves David to 5, so lands on 1
		assertEquals(1,david.position());
	}
	
	@Test
	public void testNoWormholeExit() {
		newGame(10);
		for(int i=1; i<=10; i++)
			assertFalse(game.getSquare(i).isWormholeExit());
	}

	@Test
	public void testIsFirstSquare() {
		newGame(10);
		
		for(int i=2; i<=10; i++)
			assertFalse(game.getSquare(i).isFirstSquare());
		
	}
	
	@Test
	public void testIsLastSquare() {
		newGame(10);
		
		for(int i=1; i<=9; i++)
			assertFalse(game.getSquare(i).isLastSquare());
		
	}
	
	@Test(expected = AssertionError.class)
	public void testAssertionErrorOnOccupiedSquare() {
		newGame(10);
		
		game.getSquare(2).enter(jack);
		game.getSquare(2).enter(david);
	}

	@Test (expected = AssertionError.class)
	public void testAssertionErrorLeaveEmptySquare() {
		newGame(10);
		
		game.getSquare(2).leave(jack);
	}
	
	@Test (expected = AssertionError.class)
	public void testCreateSquareOffBoard() {
		newGame(5);
		
		StandardSquare s = new StandardSquare(game, 10);
	}
	
	@Test (expected = AssertionError.class)
	public void testCreateSquareOnEmptyBoard() {
		StandardSquare s = new StandardSquare(null, 10);
	}
}

package snakes.squares;

import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;

import java.util.List;
import java.util.LinkedList;

import org.junit.*;

import snakes.Game;
import snakes.GameTest;

public class WormholeTest extends GameTest{
	@Before
	public void initWormholeGame() {
		newGame(20);
		game.setSquare(5, new WormholeEntranceSquare(game, 5));
		game.setSquare(10, new WormholeExitSquare(game, 10));
		game.setSquare(2, new WormholeExitSquare(game, 2));
	}
	
	@Test
	public void testWormholeGeneration() {
		assertEquals(game.getSquare(5).toString(), "[5 (Entrance)]");
		assertEquals(game.getSquare(10).toString(), "[10 (Exit)]");
		assertEquals(game.getSquare(2).toString(), "[2 (Exit)]");
	}
	
	@Test
	public void testWormholeExits() {
		List<Square> expected = new LinkedList<Square>();
		expected.add(game.getSquare(2));
		expected.add(game.getSquare(10));
		
		assertEquals(game.wormholeExits(), expected);
	}
	
	@Test
	public void testWormholeGamejack() {
		game.movePlayer(4);		//Moves Jack
		assertTrue(jack.position()==10 || jack.position()==2);	//Jack lands on either exit
	}
	
	@Test
	public void testWormholeGameDavid() {
		game.movePlayer(2);		//Moves Jack
		game.movePlayer(4);		//Moves David
		assertTrue(david.position()==10 || david.position()==2);	//Jack lands on either exit
	}
	
	@Test
	public void testWormholeLandOnOccupiedSquare() {
		game.setSquare(10, new StandardSquare(game, 10));
		game.movePlayer(1);		//Moves Jack
		game.movePlayer(4);		//Moves David
		assertEquals(david.position(), 1);	//David lands home
	}
	
	@Test
	public void testWormholeNoExitSquares() {
		game.setSquare(10, new StandardSquare(game, 10));
		game.setSquare(2, new StandardSquare(game, 2));
		game.movePlayer(4);		//Moves Jack
		assertEquals(jack.position(), 5);	//David lands home
	}
}

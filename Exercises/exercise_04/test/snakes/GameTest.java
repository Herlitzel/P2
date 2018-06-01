package snakes;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Before;
import org.junit.Test;

import snakes.squares.SwapSquare;

/**
 * Mother class of all testing. Assertiones ar not always tested, because
 * one branch is always with assertions off and this test is not necessary.
 * 
 * @author nicolasmueller, cedricaebi
 *
 */
public class GameTest {
	
	protected Player jack;
	protected Player david;
	protected Player joe;
	
	protected Game game;
	
	public Game newGame(int fields) {
		jack = new Player("Jack Sparrow");
		david = new Player("David Jones");
		Queue<Player> players = new LinkedList<Player>();
		players.add(jack);
		players.add(david);
		game = new Game(fields, players, 6);
		assertTrue(game.notOver());
		assertTrue(game.firstSquare().isOccupied());
		assertEquals(1, jack.position());
		assertEquals(1, david.position());
		assertEquals(jack, game.currentPlayer());
		return game;
	}
	
	public Game newGameThreePlayers(int fields) {
		jack = new Player("Jack Sparrow");
		david = new Player("David Jones");
		joe = new Player("Joe");
		Queue<Player> players = new LinkedList<Player>();
		players.add(jack);
		players.add(david);
		players.add(joe);
		game = new Game(fields, players, 6);
		assertTrue(game.notOver());
		assertTrue(game.firstSquare().isOccupied());
		assertEquals(1, jack.position());
		assertEquals(1, david.position());
		assertEquals(1, joe.position());
		assertEquals(jack, game.currentPlayer());
		return game;
	}

}

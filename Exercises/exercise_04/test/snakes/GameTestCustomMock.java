package snakes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Before;
import org.junit.Test;

public class GameTestCustomMock extends GameTest{
	
	private MockDie mockDie;
	
	@Before
	public void instDie() {
		mockDie = new MockDie();
	}
	
	@Test
	public void testThreeRolls() {
		newGame(11);
		mockDie.setValue(5);
		game.play(mockDie);
		
		assertEquals(3, mockDie.getRollCount());
		
		assertTrue(game.isOver());
		assertFalse(game.notOver());
	}
	
	@Test
	public void testNineRolls() {
		newGame(6);
		mockDie.setValue(1);
		game.play(mockDie);
		
		assertEquals(9, mockDie.getRollCount());
		
		assertTrue(game.isOver());
		assertFalse(game.notOver());
	}
	
	@Test
	public void testJackIsWinner() throws GameNotOverException {
		newGame(4);
		mockDie.setValue(3);
		game.play(mockDie);
		
		assertEquals(game.winner(), jack);
		assertTrue(game.isOver());
		assertFalse(game.notOver());
	}
	
	@Test
	public void testThreeParticipants() throws GameNotOverException{
		newGameThreePlayers(7);
		mockDie.setValue(1);
		
		game.play(mockDie);
		
		assertEquals(game.winner(), jack);
		assertTrue(game.isOver());
		assertFalse(game.notOver());
	}
}

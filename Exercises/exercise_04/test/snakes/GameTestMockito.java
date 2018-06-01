package snakes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import snakes.squares.SwapSquare;

public class GameTestMockito extends GameTest{
	
	private IDie mockedDie;
	
	@Test(expected = AssertionError.class)
	public void GameWithLessThanThreeFields() throws AssertionError{
		newGame(2);
	}
	
	@Test
	public void verifyFiveRolls() {
		newGame(10);
		mockedDie = mock(IDie.class);
		when(mockedDie.roll()).thenReturn(3);
		game.play(mockedDie);
		
		verify(mockedDie, times(5)).roll();
		
		assertTrue(game.isOver());
		assertFalse(game.notOver());
	}
	
	@Test
	public void verifyOneRoll() {
		newGame(5);
		mockedDie = mock(IDie.class);
		when(mockedDie.roll()).thenReturn(4);
		game.play(mockedDie);
		verify(mockedDie, times(1)).roll();
	}
	
	@Test
	public void testJackWinns() {
		newGame(5);
		mockedDie = mock(IDie.class);
		when(mockedDie.roll()).thenReturn(4);
		game.play(mockedDie);
		try {
		assertEquals(game.winner(), jack);
		} catch (GameNotOverException e) {}
	}
	
	@Test
	public void testDavidWinnsWithSwapSquare() {
		newGame(7);
		mockedDie = mock(IDie.class);
		when(mockedDie.roll()).thenReturn(3);
		
		assertTrue(game.notOver());
		game.setSquare((4), new SwapSquare(game, 4));
		game.play(mockedDie);
		try {
			assertEquals(game.winner(), david);
		} catch (GameNotOverException e) {}
	}
	
	@Test
	public void testGameOver() {
		newGame(5);
		mockedDie = mock(IDie.class);
		when(mockedDie.roll()).thenReturn(4);
		
		assertTrue(game.notOver());
		assertFalse(game.isOver());
		game.play(mockedDie);
		assertFalse(game.notOver());
		assertTrue(game.isOver());
		
	}
	
	@Test(expected = GameNotOverException.class)
	public void testGameNotOverException() throws GameNotOverException {
		newGame(5);
		Game spiedGame = spy(game);
		mockedDie = mock(IDie.class);
		when(mockedDie.roll()).thenReturn(4);
		when(spiedGame.winner()).thenThrow(new GameNotOverException());
		
		spiedGame.play(mockedDie);
	}
	
	@Test
	public void testGameNoWinner(){	//game not yet over & no winner
		newGame(5);
		Game spiedGame = spy(game);
		mockedDie = mock(IDie.class);
		when(mockedDie.roll()).thenReturn(4);
		when(spiedGame.notOver()).thenReturn(false);
		try {
		when(spiedGame.winner()).thenThrow(new GameNotOverException());
		} catch (GameNotOverException e) {}
		
		spiedGame.play(mockedDie);
		
		assertFalse(spiedGame.notOver());
		assertTrue(spiedGame.isOver());
	}
}

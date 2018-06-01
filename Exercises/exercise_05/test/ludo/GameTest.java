package ludo;

import ludo.*;
import ludo.square.*;

import org.junit.Test;

import static junit.framework.TestCase.*;

public class GameTest {

	@Test
	public void gameTwoPlayersTest(){
		Game game = new Game(2, false);
		assertEquals(2, game.getPlayers().size());
		assertEquals(Color.RED, game.getPlayers().remove().getColor());
		assertEquals(Color.YELLOW, game.getPlayers().remove().getColor());
	}

	@Test
	public void gameThreePlayersTest(){
		Game game = new Game(3, false);
		assertEquals(3, game.getPlayers().size());
		assertEquals(Color.RED, game.getPlayers().remove().getColor());
		assertEquals(Color.GREEN, game.getPlayers().remove().getColor());
		assertEquals(Color.YELLOW, game.getPlayers().remove().getColor());
	}

	@Test
	public void gameFourPlayersTest(){
		Game game = new Game(4, false);
		assertEquals(4, game.getPlayers().size());
		assertEquals(Color.RED, game.getPlayers().remove().getColor());
		assertEquals(Color.GREEN, game.getPlayers().remove().getColor());
		assertEquals(Color.YELLOW, game.getPlayers().remove().getColor());
		assertEquals(Color.BLUE, game.getPlayers().remove().getColor());
	}

	@Test
	public void boardTestInitialization(){
		Board board = new Board();
		ISquare[] route = board.getRoute();
		for(int i = 0; i < 52; i++)
			assertTrue(route[i] != null);
	}

	@Test
	public void boardTestHomeSquares(){
		Board board = new Board();
		assertEquals(board.redHome.getNextSquare(null), board.getRoute()[1]);
		assertEquals(board.greenHome.getNextSquare(null), board.getRoute()[14]);
		assertEquals(board.yellowHome.getNextSquare(null), board.getRoute()[27]);
		assertEquals(board.blueHome.getNextSquare(null), board.getRoute()[40]);
	}

	@Test
	public void testEndingSquares(){
		Board board = new Board();
		assertEquals(board.getRedCouloir()[4].getNextSquare(null), board.endSquare);
		assertEquals(board.getGreenCouloir()[4].getNextSquare(null), board.endSquare);
		assertEquals(board.getYellowCouloir()[4].getNextSquare(null), board.endSquare);
		assertEquals(board.getBlueCouloir()[4].getNextSquare(null), board.endSquare);
	}

	@Test
	public void boardInitTestConnection(){
		Board board = new Board();
		ISquare[] route = board.getRoute();
		for(int i = 0; i < 52; i++)
			assertTrue(route[i].getNextSquare(null) != null);
		assertEquals(route[1].getNextSquare(null), route[2]);
	}
}

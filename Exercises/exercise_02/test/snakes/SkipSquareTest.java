package snakes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SkipSquareTest extends SquareTest {
	@Override
	@Before
	public void newGame() {
		initializeGame(15);
		game.setSquare(7, new SkipSquare(game, 7));
		game.setSquare(10, new SkipSquare(game, 10));
	}

	@Test
	public void moveToSkipSquare() {
		game.movePlayer(6); // moves Jack
		assertEquals(7, jack.position());
		assertEquals(1, jill.position());
		game.movePlayer(5); // moves Jack
		assertEquals(12, jack.position());
		assertEquals(1, jill.position());
		game.movePlayer(6); // now it's Jill's turn
		assertEquals(12, jack.position());
		assertEquals(7, jill.position());
		game.movePlayer(3); // now it's Jill's turn
		assertEquals(12, jack.position());
		assertEquals(10, jill.position());
		game.movePlayer(1); // now it's Jill's turn
		assertEquals(12, jack.position());
		assertEquals(11, jill.position());
	}
}

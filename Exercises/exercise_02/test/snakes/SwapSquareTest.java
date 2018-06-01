package snakes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SwapSquareTest extends SquareTest {
    @Override
    @Before
    public void newGame() {
    		initializeGame(15);
		game.setSquare(4, new SwapSquare(game, 4));
		game.setSquare(7, new WormholeExit(game, 7));
    }

    @Test
    public void moveToSwapSquare() {
    		game.movePlayer(3); // moves Jack
		assertEquals(4, jill.position());
		assertEquals(1, jack.position());
		game.movePlayer(3); // moves Jill
		assertEquals(1, jack.position());	
		assertEquals(7, jill.position());	//Jill is on WormholeExit
		game.movePlayer(3); // moves Jack
		assertEquals(4, jill.position());
		assertEquals(7, jack.position());	//Now Jack is on WormholeExit
    }

    // Can you think of more game scenarios you need/want to cover to make sure your implementation is correct?
}
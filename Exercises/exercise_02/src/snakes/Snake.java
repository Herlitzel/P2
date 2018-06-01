package snakes;
/**
 * The Snake square moves the player that lands on it some fields back on the board
 * depending on how long the snake is.
 */
public class Snake extends Ladder {

	public Snake(int transport, Game game, int position) {
		super(transport, game, position);
	}

	@Override
	protected String squareLabel() {
		return this.destination().position() + "<-" + position;
	}

}

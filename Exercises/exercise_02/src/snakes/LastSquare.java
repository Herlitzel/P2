package snakes;
/**
 * Provides the Information that it is the last square of the board.
 * This is used by the Game class to know when a Player finishes the Game.
 */
public class LastSquare extends Square {

	public LastSquare(Game game, int position) {
		super(game, position);
	}

	@Override
	public boolean isLastSquare() {
		return true;
	}
}

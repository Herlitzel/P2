package snakes;
/**
 * The SwapSquare swaps the Players Position that lands on it with the position
 * of the Player that has the next turn.
 */
public class SwapSquare extends Square {

	public SwapSquare(Game game, int position) {
		super(game, position);
	}

	@Override
	public void enter(Player player) {
		Player next = game.currentPlayer();
		ISquare nextSquare = next.square();
		nextSquare.leave(next);
		player.goTo(nextSquare);
		next.goTo(this);
	}
	
	public String squareLabel() {
	        return String.format("%d (Swap)", position);
	    }
}
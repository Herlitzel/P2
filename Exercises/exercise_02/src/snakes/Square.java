package snakes;
/**
 * Square is responsible for holding a Player on it.
 * 
 * It knows at what position it stands on the Board and what Player that stands on it.
 * Furthermore, it can distinguish whether it is occupied or not. The Square always knows
 * its neighboring squares and whether it is the first or the last one on the board or not
 * and whether it is a WormholeExit or not.
 * 
 * It can enter and exit Players on it. Because it knows whether there is already
 * a Player on it, Square provides the Information about where to go else.
 * 
 * The class is being used by the game and the player.
 * 
 * The class should be used when a player moves on the board.
 */
public class Square implements ISquare {
	
 /**
 *  @param position - The position where this Square stands on the Board.
 * @param game - The Game this Square is standing in.
 * @param player - The Player that stands on the Square.
 */

	protected int position;
	protected Game game;
	protected Player player;

	private boolean invariant() {
		return game != null
				&& game.isValidPosition(position);
	}

	public Square(Game game, int position) {
		this.game = game;
		this.position = position;
		assert invariant();
	}

	public int position() {
		return this.position;
	}

	public ISquare moveAndLand(int moves) {
		return game.findSquare(position, moves).landHereOrGoHome();
	}

	protected ISquare nextSquare() {
		return game.getSquare(position+1);
	}

	protected ISquare previousSquare() {
		return game.getSquare(position-1);
	}

	public ISquare landHereOrGoHome() {
		return this.isOccupied() ? game.firstSquare() : this;
	}

	@Override
	public boolean isWormholeExit() {
		return false;
	}

	public String toString() {
		return "[" + this.squareLabel() + this.player() + "]";
	}

	protected String squareLabel() {
		return Integer.toString(position);
	}

	public boolean isOccupied() {
		return player != null;
	}

	public void enter(Player player) {
		assert this.player == null;
		this.player = player;
	}
	
	public void finalEnter(Player player) {
		this.player = player;
	}

	public void leave(Player player) {
		assert this.player == player;
		this.player = null;
	}

	public boolean isFirstSquare() {
		return false;
	}

	public boolean isLastSquare() {
		return false;
	}

	protected String player() {
		return this.isOccupied() ? ("<" + this.player + ">") : "";
	}
}

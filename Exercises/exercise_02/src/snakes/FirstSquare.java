package snakes;
/**
 * The First square is the starting square on the Board.
 * It can hold several Players on it and knows all of them.
 * 
 * It is a subclass of Square and therefore holds all the functionality of Square itself.
 * 
 * @Param List<Player> - Contains all the players on it.
 */
import java.util.ArrayList;
import java.util.List;

public class FirstSquare extends Square {

	private List<Player> players;

	public FirstSquare(Game game, int position) {
		super(game, position);
		players = new ArrayList<Player>();
	}

	public ISquare landHereOrGoHome() {
		return this;
	}

	@Override
	public boolean isOccupied() {
		return !players.isEmpty();
	}

	@Override
	public void enter(Player player) {
		assert !players.contains(player);
		players.add(player);
	}
	
	@Override
	public void finalEnter(Player player) {
		enter(player);
	}

	@Override
	public void leave(Player player) {
		assert players.contains(player);
		players.remove(player);
	}

	@Override
	public boolean isFirstSquare() {
		return true;
	}

	@Override
	protected String player() {
		StringBuffer buffer = new StringBuffer();
		for (Player player : players) {
			buffer.append("<" + player + ">");
		}
		return buffer.toString();
	}
}

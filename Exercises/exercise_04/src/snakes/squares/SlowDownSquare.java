package snakes.squares;

import snakes.Game;
import snakes.Player;

public class SlowDownSquare extends StandardSquare{

	public SlowDownSquare(Game game, int position) {
		super(game, position);
	}
	
	@Override
	public void enter(Player player) {
		player.slowDownNextTurn = true;
		super.enter(player);
	}
	
	public void leave(Player player) {
		player.slowDownNextTurn = false;
		super.leave(player);
	}

	public String toString() {
		return "[" + this.squareLabel() + this.player() + "]";
	}
	
	public String squareLabel() {
		return super.squareLabel() + " (Slowdown)";
	}

}

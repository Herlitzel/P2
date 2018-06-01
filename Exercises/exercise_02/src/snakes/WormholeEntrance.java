package snakes;
/**
 * The Wormhole Entrance square transports the player that lands on it to an random
 * Wormhole Exit square on the board. When there is already a Player on the exit,
 * the player is being transportet to the start field, as usual.
 */
import java.util.List;
import java.util.Random;

public class WormholeEntrance extends Square {

	public WormholeEntrance(Game game, int position) {
		super(game, position);
	}
	
	private Square getRandomExitSquare() {
		Random rand = new Random();
		List<ISquare> exits = game.wormholeExits();
		return (Square) exits.get(rand.nextInt(exits.size()));
	}
	
	@Override
	public void enter(Player player) {
		Square exit = getRandomExitSquare();
		player.goTo(exit);
	}
	
	public String squareLabel() {
        return String.format("%d (Entrance)", position);
    }

}
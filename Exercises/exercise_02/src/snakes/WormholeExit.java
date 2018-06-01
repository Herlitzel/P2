package snakes;
/**
 * The Wormhole Exit square is where the players are randomly transproted to when
 * they reach an entrance.
 * 
 * It just knows whether it is an exit or not. This Information is used by the entrance
 * to know where to randomly let the player spawn.
 */
public class WormholeExit extends Square {

	public WormholeExit(Game game, int position) {
		super(game, position);
	}
	
	@Override
	public boolean isWormholeExit() {
		return true;
	}
	
	public String squareLabel() {
        return String.format("%d (Exit)", position);
    }

}
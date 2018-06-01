package snakes;
/**
 * SkipSquare is another special square: When a player lands on it, the next Player
 * has to skip his turn.
 */
public class SkipSquare extends Square {

    public SkipSquare(Game game, int position) {
        super(game, position);
    }
    
    

    @Override
    public void enter(Player player) {
		super.enter(player);
		game.skipPlayer();
	}
    
    public String squareLabel() {
        return String.format("%d (Skip)", position);
    }
}

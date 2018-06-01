package snakes;

/**
 * This Interface provides the Structure for a Square. The Square is what the Game
 * consists of and where the Players can stand on whilst playing the game.
 * <p>
 * The ISquare Interface provides Methods for moving the Player onto and away from
 * a square.
 * <p>
 * It also provides some Informations needed by both the Game and the Players.
 * These Informations include its position, whether it is the first or the last square,
 * whether it is occupied and if it is a Wormhole exit or not.
 * <p>
 * The Interface is implemented by the Square class and mostly used by the Game, that
 * consists of several Squares and the Player, that stands on Squares.
 * 
 * @author Nicolas Müller 17-122-094
 * @author Cedric Aebi 17-103-235
 * 
 * @version 07.03.2018
 * @since 1.0
 */

public interface ISquare {
	/**
	 * @return the Position this Square is standing on in the Game.
	 */
	public int position();
	/**
	 * Calculates which square is the given amount of squares apart from this one
	 * (towards the end of the game).
	 * 
	 * @param moves 		How much squares the player should move.
	 * @return the Square on which the Player should land on.
	 */
	public ISquare moveAndLand(int moves);
	/**
	 * @return 	<code>true</code> if it is the first square of the board
	 * 			<code>false</code> else
	 */
	public boolean isFirstSquare();
	/**
	 * @return	<code>true</code> if it is the last square of the board
	 * 			<code>false</code> else
	 */
	public boolean isLastSquare();
	/**
	 * Final Step of a Player to enter this square. It can only be called if this
	 * Square is already empty (because only one player can be on one square)
	 * 
	 * @param player		The Player which enters the square
	 */
	public void enter(Player player);
	/**
	 * A Method used by the Wormhole and Swapsquare function of the Game. It is used
	 * for entering a special kind of square, finally.
	 * 
	 * @param player		The Player which enters the square
	 */
	public void finalEnter(Player player);
	/**
	 * Makes the square leave the specified player.
	 * 
	 * @param player		The Player which has to leave this square
	 */
	public void leave(Player player);
	/**
	 * @return		<code>true</code> if the square is occupied
	 * 				<code>false</code> else
	 */
	public boolean isOccupied();
	/**
	 * Makes sure the Player that wants to enter this Square is sent back to the first
	 * square if this one already has a Player on it.
	 * 
	 * @return		Either this square (if it is empty)
	 * 				Else the first Square
	 */
	public ISquare landHereOrGoHome();
	/**
	 * 
	 * @return		<code>true</code> whether it is a wormhole exit
	 * 				<code>false</code> else
	 */
	boolean isWormholeExit();
}

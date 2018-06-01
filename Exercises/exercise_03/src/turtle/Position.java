package turtle;

/**
 * Class that stores a position on the board. The Position is stored in an x and y variable.
 * Both has to be positive, because there are no negative coordinates on the board.
 * 
 * @author Nicolas Müller, Cedric Aebi
 *
 */

public class Position {
	
	/**
	 * @param x		x coordinate of this position, has to be positive! (regarding to the board)
	 * @param y		y coordinate of this position, has to be positive! (regarding to the board)
	 */
	
	protected int x, y;
	
	/**
	 * Class invariant of position: x and y have to be positive.
	 * @return	true if both x and y are positive.
	 */
	
	protected boolean invariant() {
		return (x >= 0 && y >= 0);
	}
	
	/**
	 * instantiates a new Position class with the specified coordinates.
	 * @param x		the x coordinate this position should have at the beginning.
	 * @param y		the y coordinate this position should have at the beginning.
	 */
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
		
		assert(invariant());
	}
	
	/**
	 * sets the x coordinate of this position.
	 * @param x		The x-coordinate this position is wished to set
	 */
	
	public void setX(int x) {this.x = x;}
	
	/**
	 * sets the y coordinate of this position.
	 * @param y		The y-coordinate this position is wished to set
	 */
	
	public void setY(int y) {this.y = y;}
}

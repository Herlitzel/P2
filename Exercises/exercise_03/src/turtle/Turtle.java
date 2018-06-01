package turtle;

/**
 * This is the turtle that can be moved on the board. It stores its position and can move one step in either direction.
 * It can also teleport itself across the board. The turtle stands on the board and leaves a red trail everywhere
 * it moves. except when it moves diagonally to a specific coordinate. It can be commanded by a command class which
 * delegates its movements. But the movements itself are made by Turtle itself!
 * 
 * 
 * @author Nicolas Müller, Cedric Aebi
 *
 */

public class Turtle {
	
	/**
	 * @param pos		Stores the position of this turtle
	 * @param board		Points to the board this turtle is standing on
	 */
	
	protected Position pos;
	private Board board;
	
	/**
	 * Class invariant of Turtle: Checks if position is correct and it has a board referenced to.
	 * @return		true, if the variant is ok.
	 */

	protected boolean invariant() {
		return (pos.invariant() && board != null);
	}
	
	/**
	 * Initializes the turtle at the specified position (x and y coordinates) and on the board referenced to.
	 * 
	 * @param x			The x-coordinate of this turtle's starting position
	 * @param y			The y-coordinate of this turtle's starting position
	 * @param board		The board this turtle is created on.
	 */
	
	public Turtle(int x, int y, Board board) {
		this.pos = new Position(x,y);
		this.board = board;
		
		assert(invariant());
	}
	
	/**
	 * Initializes the turtle in the middle of the specified board.
	 * 
	 * @param board		The board this turtle is being created on.
	 */
	
	public Turtle(Board board) {
		int x = board.getSize()/2;
		int y = board.getSize()/2;
		this.pos = new Position(x,y);
		this.board = board;
		
		assert(invariant());
	}
	
	/**
	 * moves this turtle one step to the left
	 */
	
	public void moveLeft() throws TurtleRunoverException{
		if(!(this.pos.x > 0))
			throw new TurtleRunoverException("Left");
		assert(this.pos.x > 0);
		this.pos.x--;
		board.drawTrail(pos.x, pos.y);
		assert(invariant());
	}
	
	/**
	 * moves this turtle one step to the right
	 */
	
	public void moveRight() throws TurtleRunoverException {
		if(!(this.pos.x < board.getSize()))
			throw new TurtleRunoverException("Right");
		assert(this.pos.x < board.getSize());
		this.pos.x++;
		board.drawTrail(pos.x, pos.y);
		assert(invariant());
	}
	
	/**
	 * moves this turtle one step up
	 */
	
	public void moveUp() throws TurtleRunoverException {
		if(!(this.pos.y > 0))
			throw new TurtleRunoverException("Up");
		assert(this.pos.y > 0);
		this.pos.y--;
		board.drawTrail(pos.x, pos.y);
		assert(invariant());
	}
	
	/**
	 * moves this turtle one step down
	 */
	
	public void moveDown() throws TurtleRunoverException {
		if(!(this.pos.y < board.getSize()))
			throw new TurtleRunoverException("Down");
		assert(this.pos.y < board.getSize());
		this.pos.y++;
		board.drawTrail(pos.x, pos.y);
		assert(invariant());
	}
	/**
	 * Teleports this turtle to the specified coordinate on the board
	 * @param x		the x coordinate to teleport to.
	 * @param y		the y coordinate to teleport to.
	 */
	
	public void moveDiagonal(int x, int y) {
		assert (x >= 0 && x < board.getSize() &&
				y >= 0 && y < board.getSize());
		this.pos.x = x;
		this.pos.y = y;
		board.drawTrail(pos.x, pos.y);
		assert(invariant());
	}
	
	/**
	 * returns the position of this Turtle
	 * @return		Position of this Turtle (as a "Position")
	 */
	
	public Position getPosition() {return pos;}

}

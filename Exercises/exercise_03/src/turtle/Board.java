package turtle;


/**
 * Board represents the space where the turtle can move. It is holding a boolean matrix in the given size.
 * It holds the turtle on it and draws the trails the Turtle makes.
 * 
 * @author Nicolas Müller, Cedric Aebi
 *
 */

public class Board {
	/**
	 * @param board		Boolean matrix that keeps track of the trails the Turtle makes.
	 * 					{@link SIZE} defines the size of the board (it is a square.)
	 * 					A variable at the given position in the matrix is set to true, if the turtle was or is there.
	 * 					@see TurtleRenderer.java
	 * @param SIZE		Defines the size of the board at its inizialisation
	 * @param Turtle		Holds an instance of the turtle on this board.
	 */
	private boolean[][] board;
	private final static int SIZE = 100;
	Turtle joe;
	
	/**
	 * Invariant of the Board class. It looks whether the turtle exists and lies on its board.
	 * 
	 * @return 		true, if variant is OK.
	 */
	private boolean invariant() {
		return (joe != null &&
				0 <= joe.pos.x && joe.pos.x <= SIZE &&
				0 <= joe.pos.y && joe.pos.y <= SIZE);
	}
	
	/**
	 * Initializes the new board
	 */
	public Board() {
		joe = new Turtle(this);
		board = initialBoard();
		assert(invariant());
	}

	/**
	 * Parses the given turtle program and evaluate it. Renders the trail according to the
	 * defined commands one can make on the Turtle and returns the new board.
	 *
	 * @param turtleProgram input program according to specification.
	 * @return SIZExSIZE boolean board, where true values denote "red trail".
	 */
	public boolean[][] makeBoardFrom(String turtleProgram){
		assert(!turtleProgram.equals(""));
		CommandParser parser = new CommandParser();
		parser.parse(turtleProgram);
		
		for(Command cmd : parser.getCommands()) {
			cmd.execute(joe);
		}
		parser.deleteCommands();
		
		assert(invariant());
		return board;
	}
	
	/**
	 * Draws the trail at the specified position with a red dot. @see TurtleRenderer.java
	 * 
	 * @param x		The x -coordinate of the dot to draw.
	 * @param y		The y -coordinate of the dot to draw.
	 */
	public void drawTrail(int x, int y) {
		assert (x >= 0 && x < SIZE && y >= 0 && y < SIZE);
		board[x][y] = true;
		assert(invariant());
	}

	/**
	 * Creates a new board and returns it.
	 * 
	 * @return board		the SIZExSIZE board that was initialized.
	 */
	public boolean[][] initialBoard() {
		boolean[][] board = new boolean[SIZE][SIZE];
		board[joe.pos.x][joe.pos.y] = true;
		return board;
	}
	/**
	 * 
	 * @return SIZE	the size of the board. (Used by the Turtle to get a starting position.)
	 */
	
	public int getSize() {return SIZE;}
}
package turtle;
/**
 * Command saves and executes a command on the Turtle. It is created by the CommandParser class that parses
 * a String and stores the information in this Class. It makes the turtle move in either direction by
 * a specified amount of steps or puts him to a specified coordinate.
 * 
 * It uses two constructors, one for the normal move command and one for the teleport (or diagonal) command.
 * 
 * @author Nicolas Müller, Cedric Aebi
 *
 */
public class Command {
	
	/**
	 * @param direction			The direction to move the turtle (Stored in String)
	 * @param steps				The amount of steps to move the turtle
	 * @param diag_x, diag_y		The coordinates to teleport the turtle in case of a "Digonal" command
	 * @param digonal			true, if it is a "diagonal" command
	 * 							false else
	 */
	
	private String direction;
	private int steps;
	private int diag_x = -100;
	private int diag_y = -100;
	private boolean diagonal;
	
	/**
	 * Invariant: 	either it has a direction and an amount of steps
	 * 				or it is diagonal and has valid coordinates.
	 * @return
	 */
	
	protected boolean invariant() {
		return ((steps != 0 && !direction.equals(""))||
				(diagonal && diag_x != -100 && diag_y != -100));
	}
	
	/**
	 * Initializes this class as a MOVE command
	 * 
	 * @param direction		stores the direction in which the turtle to move
	 * @param steps			stores the amount of steps to move the Turtle
	 */
	
	public Command (String direction, int steps) {
		this.direction = direction;
		this.steps = steps;
		
		assert(invariant());
	}
	
	/**
	 * Initializes the class as a DIAGONAL command
	 * @param x		The x coordinate of the teleporting position of the Turtle
	 * @param y		The x coordinate of the teleporting position of the Turtle
	 */
	
	public Command (int x, int y) {
		diag_x = x;
		diag_y = y;
		diagonal = true;
		
		assert(invariant());
	}
	
	/**
	 * Executes this command according to its parameters on the Turtle
	 * 
	 * @param turtle		The Turtle on which to execute the command
	 */
	
	public void execute(Turtle turtle){
		assert(turtle != null && turtle.invariant());
		if(diagonal)
			try {
				turtle.moveDiagonal(diag_x, diag_y);
			} catch(AssertionError e) {
				//do nothing if Teleport leads to Turtle landing outside the field.
			}
		else {
			for(int i=0; i < steps; i++)
				try {
					moveTurtle(turtle);
				} catch(TurtleRunoverException e) {
					// do nothing if commands leads to turtle wandering over the field
				}
		}
		assert(invariant());
	}
	
	/**
	 * Tells the given Turtle to move him (by one step)
	 * 
	 * @param turtle		The turtle you wont to move
	 */
	
	private void moveTurtle(Turtle turtle) throws TurtleRunoverException{
		assert(turtle != null);
		switch(direction) {
		case "left":
			turtle.moveLeft();
			break;
		case "right":
			turtle.moveRight();
			break;
		case "up":
			turtle.moveUp();
			break;
		case "down":
			turtle.moveDown();
			break;
		}
		
		assert(invariant());
	}
}

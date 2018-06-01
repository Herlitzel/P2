package turtle;

import java.util.*;
import java.util.regex.*;

/**
 * The Task of CommandParser is to parse commands out of the entry (eingabe). I is used by the board
 * whenever a new entry is made on the Textfield. It ignores bad entries and stores a command as soon
 * as the entry line is being pressed. It then stores the commands read from the entry in an
 * arrayList that is used by the board to command the Turtle.
 * 
 * @author Nicolas Müller, Cedric Aebi
 *
 */

public class CommandParser {
	
	/**
	 * @param commands			stores the commands parsed by the parser from their string.
	 * @param commandStrings		Stores the commands as a String (array).
	 * @param pattern			Pattern that matches with a number.
	 */
	
	protected ArrayList<Command> commands = new ArrayList<Command>();
	private String[] commandStrings;
	private Pattern pattern = Pattern.compile("[0-9]+");
	
	/**
	 * Invariant: checks if commandStrings and commands are initiated
	 * @return true, if both commandStrings and commands are initiated
	 */
	
	protected boolean invariant() {
		return (commandStrings != null && commands != null);
	}
	
	/**
	 * parses the text from the textfield into commands. It takes a String as entry, splits it and adds the latest
	 * to the commands list. It is used by the board to parse commands out of Strings into a command list.
	 * It ignores unknown commands and only adds a command to the list if enter is pressed.
	 * 
	 * Commands are accepted as follows whereas n is the amount of steps:
	 * 		-up n
	 * 		-right n
	 * 		-down n
	 * 		-left n
	 * 		-diagonal x y	(here, the turtle is being teleported to the given x and y coordinate).
	 * 
	 * @param eingabe		Text from the textfield from which commands are being parsed by this method.
	 */
	
	public void parse(String eingabe){
		
		assert(!eingabe.equals(""));
		
		int linebreaks = eingabe.length() - eingabe.replace("\n", "").length(); 	// Number of line breaks 
																				//Used to check command entry
		commandStrings = eingabe.split("\n");									//Splits eingabe into seperate commands
		String command = commandStrings[commandStrings.length-1];					//Gets the latest entry
		Matcher m = pattern.matcher(command);
		if(linebreaks == commandStrings.length) {
			System.out.println(command);
			assert(!command.equals(""));
			if(command.contains("right"))
				createMoveCommand(m, "right");
			else if(command.contains("left"))
				createMoveCommand(m, "left");
			else if(command.contains("up"))
				createMoveCommand(m, "up");
			else if(command.contains("down"))
				createMoveCommand(m, "down");
			else if(command.contains("diagonal"))
				createDiagonalCommand(command);
		}
		
		assert(invariant());
	}
	
	/**
	 * Helper method used by the parse method to create diagonal commands.
	 * 
	 * @param command		The latest command that is entered.
	 */
	
	private void createDiagonalCommand(String command) {
		assert(invariant());
		String[] diagonalCommand = command.split(" ");
		Matcher m;
		if(diagonalCommand.length == 3) {
			int x = 0;
			int y = 0;
			m = pattern.matcher(diagonalCommand[1]);
			if(m.find()) {
				x = Integer.parseInt(m.group(0));
			}
			m = pattern.matcher(diagonalCommand[2]);
			if(m.find()) {
				y = Integer.parseInt(m.group(0));
				commands.add(new Command(x, y));
			}
		}
		assert(commands.size() >= 0);
	}
	
	/**
	 * Helper method used by the parse method to create move commands.
	 * 
	 * @param matcher	Matcher, used to find the amount of septs to move in the string	
	 * @param direction	Direction in which to move the turtle
	 */
	
	private void createMoveCommand(Matcher matcher, String direction) {
		assert(invariant());
		if(matcher.find()) {				
			int steps = Integer.parseInt(matcher.group().trim());
			commands.add(new Command(direction, steps));						
		}
		assert(commands.size() >= 0);
	}
	
	/**
	 * Returns the list with the commands
	 * 
	 * @return ArrayList<Command> the list the commands are stored in.
	 */
	
	public ArrayList<Command> getCommands(){
		return commands;
	}
	
	/**
	 * Empties the List that stores the commands.
	 */
	
	public void deleteCommands() {
		commands = new ArrayList<Command>();
		assert(commands.size() == 0);
	}
	
	
}

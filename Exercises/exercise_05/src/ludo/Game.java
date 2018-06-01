package ludo;


import ludo.render.BoardRenderer;
import ludo.square.EndSquare;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * The Game class is responsible for tha game logic. It can be initialized with 2 to 4 players.
 *
 * It contains 4 players, according to each color red, green, yellow and blue.
 * Then, it contains the queue including the players actually playing in the game.
 * And the board on which the players play the game.
 */
public class Game {

	private Queue<Player> playerQueue;
	protected static Player red, green, yellow, blue;
	private static Board ludo;
	private static BoardRenderer boardRenderer;
	private ArrayList<Token> winner;
	private Die die;

	/**
	 * Class invariant of the game. Checks the amount of players.
	 * @return		true, if there are between 2 and four players playing the game.
	 */
	private boolean invariant(){
		return(playerQueue.size() >= 2 &&
				playerQueue.size() <= 4);
	}

	/**
	 * Initialize the game with the given number of players.

	 * @param players		The amount of player wished to play the game.
	 * @param random		true, if the game is a random game and contains random players
	 *                      false, if the game contains normal players
	 */
	public Game(int players, boolean random) {
		assert players >= 2 && players <= 4;

		this.die = new Die();

		playerQueue = new ArrayDeque<Player>();

		//Initialize the Board
		ludo = new Board();

		//Inizialize the BoardRenderer
		boardRenderer = new BoardRenderer(ludo);

		//Inizialize the players (random)
		if(random) {
			red = new RandomPlayer(Color.RED, ludo, ludo.redHome);
			green = new RandomPlayer(Color.GREEN, ludo, ludo.greenHome);
			yellow = new RandomPlayer(Color.YELLOW, ludo, ludo.yellowHome);
			blue = new RandomPlayer(Color.BLUE, ludo, ludo.blueHome);
		}

		//Initialize the players (not random)
		if(!random) {
			red = new Player(Color.RED, ludo, ludo.redHome);
			green = new Player(Color.GREEN, ludo, ludo.greenHome);
			yellow = new Player(Color.YELLOW, ludo, ludo.yellowHome);
			blue = new Player(Color.BLUE, ludo, ludo.blueHome);
		}

		//Initialize the game according to the given players.
		switch(players){
			case 2:
				playerQueue.add(red);
				playerQueue.add(yellow);
				break;
			case 3:
				playerQueue.add(red);
				playerQueue.add(green);
				playerQueue.add(yellow);
				break;
			case 4:
				playerQueue.add(red);
				playerQueue.add(green);
				playerQueue.add(yellow);
				playerQueue.add(blue);
				break;
		}

		assert(invariant());
	}

	/**
	 * Plays the game until someone wins.
	 */
	public void play(){
		System.out.println("Initial state: \n" + boardRenderer);
		while(true){
			int roll = die.roll();
			System.out.println(this.currentPlayer().getColor() + " rolls " + roll + ":  \n");
			currentPlayer().act(roll);
			if(currentPlayer().wins()) {
				winner = ludo.endSquare.getFinishedTokens();
				break;
			}
			System.out.println(boardRenderer);
			Player currentPlayer = playerQueue.remove(); // from front of queue
			playerQueue.add(currentPlayer); // to back of the queue
		}
		System.out.println("Final state:   \n" + boardRenderer);
		System.out.println(this.winner() + " won!");
		assert invariant();
	}

	/**
	 * Returns the Player, which is in front of the queue
	 * @return CurrentPlayer
	 */
	public Player currentPlayer() {
		return playerQueue.peek();
	}

	/**
	 * @return ArrayList which belongs to the Endsquare. It contains the Tokens that won.
	 */
	public ArrayList<Token> winner() {
		return winner;
	}

	/**
	 * Returns the players playing the game.
	 * @return			The queue of players that play in the game.
	 */
	public Queue<Player> getPlayers(){
		return this.playerQueue;
	}

	/**
	 * Returns the board of the current game
	 * @return			The Board of the current game
	 */
	public Board getBoard() {
		return ludo;
	}


}

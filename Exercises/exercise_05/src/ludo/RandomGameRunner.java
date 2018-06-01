package ludo;

/**
 * Runs a random Ludo Game. This calss includes the main method and there, runs a random game that is printed
 * in the console repectively.
 */
public class RandomGameRunner{

    private Game randomGame;

    /**
     * Runs a random game with the specified amount of players.
     * @param players           the number of players in the random game.
     */
    public RandomGameRunner(int players){
        randomGame = new Game(players, true);
        randomGame.play();
    }

    /**
     * Main Method, runs a random game
     * @param args
     */
    public static void main(String[] args){
        RandomGameRunner randomGame = new RandomGameRunner(4);
    }
}

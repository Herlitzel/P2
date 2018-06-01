package ludo;


import ludo.square.*;

import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Player represents the people playing the game. Each player contains four Tokens with which can be played.
 * Each player also posesses a home square, where its tokens find themselves in the beginning.
 * The player also holds the information of its color. This is either red, green, yellow or blue.
 *
 * Player is used by the game class. In the game logic, each round a player has his turn and can roll a die
 * and play one of its tokens.
 */
public class Player {
    protected Token[] token;
    protected ArrayList<Token> inGameTokens;
    protected Board ludo;
    private Color color;
    protected HomeSquare home;

    /**
     * Class invariant of the Player. Checks if there are always four tokens and the home and the board are present.
     * @return          True, if there are four tokens and the home and board are connected.
     */
    protected boolean invariant(){
        return (token.length == 4 &&
                this.home != null &&
                this.ludo != null);
    }

    /**
     * Creates the player. In order to be created, it must know the color, the board and its home.
     *
     * @param color         The color of this player. Stored in a string. (red, green, yellow, blue)
     * @param ludo          The board of the actual game.
     * @param home          The home square of this player.
     */
    public Player(Color color, Board ludo, HomeSquare home){
        this.ludo = ludo;
        this.home = home;
        home.setPlayerHome(this);
        this.color = color;
        token = new Token[4];
        token[0] = new Token(this, 0);
        token[1] = new Token(this, 1);
        token[2] = new Token(this, 2);
        token[3] = new Token(this, 3);
        inGameTokens = new ArrayList<Token>();
        assert(invariant());
    }

    /**
     * This lets the player move the tokens around the board till someone wins. The tokens which the player
     * wants to move are chosen randomly. The only time it's not chosen randomly is when the player
     * gets a 6 so he can move out of the homesquare, then it first checks if he can move out.
     */
    public void act(int roll){
        assert(roll >= 1 && roll <= 6);
        if(roll == 6 && home.getTokenList().size() > 0) {
            home.getToken().moveForward(1);
        } else if(home.getTokenList().size() < 4) {
            getTokenFromUser().moveForward(roll);
        }
    }

    /**
     * Gets the Token from a user input. !!Not yet testet or really used!!
     */
    private Token getTokenFromUser(){
        System.out.println(""+this.getColor()+": Chose a Token to move with:");
        updateInGameList();
        for(int i = 0; i < inGameTokens.size(); i++)
            System.out.println(inGameTokens.get(i));
        Scanner scan = new Scanner(System.in);
        return token[scan.nextInt()];
    }

    /**
     * Moves a token to a specific square.
     *
     * @param tokenNumber       The number of the token to be moved (0-3)
     * @param square            The square where the token should go to.
     */
    public void moveTokenTo(int tokenNumber, ISquare square){
        token[tokenNumber].moveTo(square);
    }

    /**
     * Move tha player along the route.
     *
     * @param tokenNumber       The number of the token from this player.
     * @param count             The amount of fields to move forward.
     */
    public void moveTokenForward(int tokenNumber, int count){
        assert(tokenNumber >= 0 && tokenNumber <= 3);
        token[tokenNumber].moveForward(count);
    }

    /**
     * checks for every token the player has if the token stands on the end square, and so if the
     * player which the token belongs to wins
     * @return true if the player won
     */
    public boolean wins() {
        for(int i = 0; i <= 3; i++) {
            if(getToken(i).checkFinished() == true)
                return true;
        }
        return false;
    }

    /**
     * This is used by the getRandomInGameToken. It checks if a token is playing on the board, or if
     * the token stands on the home square, and therefore can't be moved around by the player.
     * If the token is playing on the board, it gets added to an ArrayList which contains all the
     * playing tokens.
     */
    protected void updateInGameList(){
        for(int i = 0; i < 4; i++) {
            if (getToken(i).getSquare() != home && !inGameTokens.contains(getToken(i)))
                inGameTokens.add(getToken(i));
        }
    }

    /**
     * @return          The color of this plyer, in the Color enum format.
     */
    public Color getColor(){
        return this.color;
    }

    /**
     * @return          The home of this player. This is a HomeSquare.
     */
    public HomeSquare getHomeSquare(){
        return this.home;
    }

    /**
     * Returns the Token from the array with the passed index.
     * @param tokenNumber       The Index wished to get from the token array
     * @return                  The Token with the specified Index
     */
    public Token getToken(int tokenNumber){
        assert(tokenNumber >= 0 && tokenNumber < 4);
        return token[tokenNumber];
    }

}

package ludo.square;


import ludo.Player;
import ludo.Token;

import java.util.Stack;

/**
 * Home square represents the place where tokens are that have not entered the game yet. They belong to a
 * specific color and exist four times on the board. One on either side. It can hold no more than four
 * tokens and in order to leave, the player must throw a 5.
 *
 * On the initialization of the game, the Board class connects its starting squares and the tokens of the
 * right player set themseelves on this square because it is their home.
 *
 * This is also the square whare the tokens come if they are "overset" by another token.
 *
 * It knows the player it belongs to and the square in the route where the token starts his round.
 */
public class HomeSquare implements ISquare {
    /**
     * @param startSquare       The square in the route where the tokens start when the player throws a 5.
     * @param tokens            The tokens that are on this homeSquare. Stored i a stack and can have
     *                          the maximum size of 4.
     * @param player            The player of this home square.
     */
    private ISquare startSquare;
    private Stack<Token> tokens;
    private Player player;

    /**
     * Initializes the stack of tokens
     */
    public HomeSquare(){
        tokens = new Stack<Token>();
        assert(invariant());
    }

    /**
     * Stores the player this home belongs to in its variable. This is called while initializing the game.
     *
     * @param player        The player this home is connected to.
     */
    public void setPlayerHome(Player player){
        this.player = player;
    }

    /**
     * Invariante von HomeSquare. Prüft, ob ein anfangs square definiert ist.
     * @return      true, wenn ein StartSquare definiert ist.
     */
    private boolean invariant(){
        return (tokens.size() <= 4);
    }

    /**
     * Checks if this square is already occupied or not
     * @return      true, if the stack has already four tokens on it
     *              false else
     */
    @Override
    public boolean isOccupied() {
        return (tokens.size() > 0);
    }

    /**
     * Enters a token on this HomeSquare. It pushes the token on its stack where they are saved.
     * @param enterToken        The Token to enter this homesquare
     */
    @Override
    public void enter(Token enterToken) {
        tokens.push(enterToken);
    }

    /**
     * Return the Starting square of this home (according to the player's color). This has to be defined by the board
     * @return      The players starting square.
     */
    @Override
    public ISquare getNextSquare(Token token) {
        assert(invariant() && startSquare != null);
        return startSquare;
    }

    /**
     * Sets the Starting square of the player. Should be called while initializing the board and according to the
     * Player's color.
     * @param nextSquare        The square to be difined as the starting square of the player.
     */
    @Override
    public void setNextSquare(ISquare nextSquare) {
        this.startSquare = nextSquare;
        assert(invariant() && startSquare != null);
    }

    /**
     * Makes  a token leave his homeSquare.
     * @param token     The token that finds himself on this field and is expected to leave.
     */
    @Override
    public void leave(Token token) {
        assert(tokens.size() >= 1);
        tokens.pop();
    }

    @Override
    public void setCouloirEnter(CouloirSquare square) {}

    /**
     * Gives out one token on the home. It is always the one that finds
     * himself on top of the stack.
     * @return              The token that lies on top of the "Tokens" stack.
     */
    @Override
    public Token getToken(){return tokens.peek();}

    /**
     * Gives the entire list of tokens from this homesquare. The list is given out as a stack.
     * @return              A Stack with the tokens in this square.
     */
    public Stack<Token> getTokenList(){return tokens;}

    /**
     * Returns the player of this homesquare.
     *
     * @return              The Player of this homeSquare.
     */
    public Player getPlayer(){
        return this.player;
    }

}

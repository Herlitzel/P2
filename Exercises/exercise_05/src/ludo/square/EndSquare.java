package ludo.square;

import ludo.Token;

import java.util.ArrayList;

/**
 * The last square on the board. This is where the token land when they are finished. It can hold several Tokens.
 * They are stored in an ArrayList.
 */
public class EndSquare implements ISquare {

    /**
     * @param finishedTokens        Contains the tokens that finished the game in an arrayList.
     */
    private ArrayList<Token> finishedTokens;

    /**
     * Initializes the EndSquare and creates the ArrayList of the finished tokens.
     */
    public EndSquare(){
        finishedTokens = new ArrayList<Token>();
    }

    /**
     * Returns always false, because there is no really a good border for the maximum of tokens that can be here.
     * @return          false
     */
    @Override
    public boolean isOccupied() {
        return false;
    }

    /**
     * ASets a token on this square. It adds this one to the squares List of tokens.
     *
     * @param enterToken        The token to enter the EndingSquare and thus to finish in the game.
     */
    @Override
    public void enter(Token enterToken) {
        enterToken.finish();
        finishedTokens.add(enterToken);
    }

    /**
     * @return      null because this is the last square on the board and of all routes.
     */
    @Override
    public ISquare getNextSquare(Token token) {
        return new InvalidSquare();
    }

    /**
     * Should not be called, because there is no following square. Does nothing if called, though.
     * @param nextSquare        The square to be difined as the follower of this one.
     */
    @Override
    public void setNextSquare(ISquare nextSquare) {

    }

    /**
     * Should not be called, because no token is meant to leave this ending square. Does nothing if called, else.
     * @param token     The token that finds himself on this field and is expected to leave.
     */
    @Override
    public void leave(Token token) {

    }

    /**
     * @param square        The first square of the respective couloir
     */
    @Override
    public void setCouloirEnter(CouloirSquare square) {

    }

    /**
     * Should not be called at this endsquare. Always returns null.
     * @return              null
     */
    @Override
    public Token getToken() {
        return null;
    }

    /**
     * Gets all the tokens on the ending square: All the finished Tokens.
     * @return          The Arraylist of the finished Tokens
     */
    public ArrayList<Token> getFinishedTokens(){
        return this.finishedTokens;
    }
}

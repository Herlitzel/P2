package ludo.square;

import ludo.Token;

/**
 * This is the normal square that finds itself along the main route. It can accept, hold and leave a token on it.
 * It knows the square that follows this one.
 */
public class NormalSquare implements ISquare {
    private Token token;
    private ISquare nextSquare;

    /**
     * Initializes a normal square on the board.
     */
    public NormalSquare(){
        token = null;
        assert(invariant());
    }

    /**
     * Class Invariant of Square. Checks whether it is either occupied or not.
     * @return
     */
    protected boolean invariant(){
        return (token != null || token == null);
    }

    /**
     * Returns the square to that follows this one. Used to determine where to move the token.
     * @return      The square that follows
     */
    public ISquare getNextSquare(Token token){
        assert(nextSquare != null);
        return nextSquare;
    }

    /**
     * Sets the next square of this one. This is used in order to initialize the board, to connect
     * the different squares eith each others.
     * @param nextSquare
     */
    public void setNextSquare(ISquare nextSquare){
        this.nextSquare = nextSquare;
    }

    /**
     * Makes the token in on this square leave. Sets this square's token to null.
     * @param leaveToken    The token that is expected to leave this square. Should match the one
     *                      that is actually on it.
     */
    public void leave(Token leaveToken){
        assert(this.token == leaveToken);
        this.token = null;
    }

    @Override
    public void setCouloirEnter(CouloirSquare square) {

    }

    /**
     * Makes a Token enter this square. If there is already a token on this square, the one that
     * was already there is sent home.
     *@param enterToken     The token that should be placed on this square.
     */
    @Override
    public void enter(Token enterToken) {
        assert(invariant());
        if(this.isOccupied())
            token.sendHome();
        this.token = enterToken;
    }

    /**
     * @return      true, if the square has no token on it
     *              false otherwise.
     */
    @Override
    public boolean isOccupied(){
        assert(invariant());
        return token != null;
    }

    /**
     * Returns the token lying on this square. Null if there is none.
     * @return          The token on this square.
     */
    @Override
    public Token getToken() {
        return this.token;
    }
}

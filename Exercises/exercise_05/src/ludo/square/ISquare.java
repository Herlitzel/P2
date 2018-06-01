package ludo.square;

import ludo.*;

/**
 * Interface for all the square classes. The squares are the fields on the ludo board where tokens can be set
 * and moved around. It is implemented by the following specific squares:
 *
 * @see NormalSquare
 * @see CouloirSquare
 * @see CrossingSquare
 * @see HomeSquare
 * @see EndSquare
 */
public interface ISquare {
    /**
     * Returns true, if there is a token on this square.
     * @return      true, if this square is occupied
     *              false else
     */
    boolean isOccupied();

    /**
     * Makes a token enter this square.
     * @param enterToken
     */
    void enter (Token enterToken);

    /**
     * Returns the square following this one on the board
     * @return the square that follows on the board
     *
     * @param token         The Token that asks the next square. Used to determine its way at the crossing square.
     */
    ISquare getNextSquare(Token token);

    /**
     * Setter to define the square following this one on the board. Used by the board to initialize it.
     * @param nextSquare        The square to be difined as the follower of this one.
     */
    void setNextSquare(ISquare nextSquare);

    /**
     * Makes the token leave this field. Sets the parameter "Token" to null.
     * @param token     The token that finds himself on this field and is expected to leave.
     */
    void leave (Token token);

    /**
     * Used to connect outer route to the inner couloirs. Only used by CrossingSquare.
     * @param square        The first square of th erespective couloir
     */
    void setCouloirEnter(CouloirSquare square);

    /**
     * Returns the Token on this square. Null, if there is no one.
     */
    Token getToken();
}

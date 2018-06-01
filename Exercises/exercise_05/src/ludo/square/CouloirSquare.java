package ludo.square;

import ludo.Token;
/**
 * The CouloirSquares are the ones in the middle of the field that lead from the main route to the ending square.
 * It exists in four seperate linked routes in the game (one for each color). The crossings lead into it and the
 * endingSquare represents the end of every couloir.
 *
 * The difference to the normal square is, that it has to check whether the right amount is rolled in order
 * to reach the ending square. The token can not be moved otherwise.
 */
public class CouloirSquare extends NormalSquare {

    @Override
    public ISquare getNextSquare(Token token) {
        return super.getNextSquare(token);
    }
}

package ludo.square;

import ludo.*;

/**
 * CrossingSquare is the intersection between the outer main route and the couloirs in the middle.
 * So if a token reaches the crossing square of its color, it is moved into its couloir in the middle of the
 * field.
 *
 * So it is connected with the next square on the route and additionally with the couloir of its color.
 *
 * It knows
 *  -its color
 *  -the starting square of the respective couloir.
 *
 *  @Param couloir      The first square of the couloir from its Player
 *  @Param Player       The Player to whom the couloir it refers to belongs.
 */
public class CrossingSquare extends NormalSquare {
    private CouloirSquare couloir;
    private Color color;

    public CrossingSquare(Color color){
        super();
        this.color = color;
    }

    /**
     * Sets the first Square of the couloir. Should be the one from its player. This method is called
     * at the initialization of the board to set the intersection.
     *
     * @param couloir       The first square of the couloir it has to intersect.
     */
    public void setCouloirEnter(CouloirSquare couloir){
        this.couloir = couloir;
    }

    /**
     * Marks the crossing that moves Tokens into the couloir.
     *
     * @return          Either the next square, if the token is not from its player
     *                  Or the first CouloirSquare from the player the token belongs to that finds himself on this
     *                  square.
     */
    @Override
    public ISquare getNextSquare(Token token){
        if(token == null)
            return super.getNextSquare(token);
        return this.color == token.getPlayer().getColor() ? couloir : super.getNextSquare(token);
    }
}

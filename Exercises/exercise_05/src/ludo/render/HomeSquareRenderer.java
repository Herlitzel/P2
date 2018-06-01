package ludo.render;

import ludo.square.HomeSquare;

/**
 * Used to visualize a HomeSquare on the Board. This is done by a String that is two letters long
 * and contains the Information about the HomeSquare's Player (Color) and the amount of Tokens on it.
 *
 * So for example, if Green has still two Tokens on its HomeSquare, it is printed out as "G2".
 */
public class HomeSquareRenderer implements Renderer{

    private HomeSquare square;
    private String rep = "HM";

    protected boolean invariant(){
        return (this.square != null);
    }

    /**
     * Defines the HomeSquare it has to visuqlize in its Initialization
     * @param homeSquare            The HomeSquare it has to render.
     */
    public HomeSquareRenderer(HomeSquare homeSquare) {
        this.square = homeSquare;
        assert(invariant());
    }

    /**
     * Returns the string representation of its homeSquare. This is done by a String that is two letters long
     * and contains the Information about the HomeSquare's Player (Color) and the amount of Tokens on it.
     *
     * So for example, if Green has still two Tokens on its HomeSquare, it is printed out as "G2".
     *
     * @return          The String visualization of the HomeSquare. Two letters long.
     */
    public String toString(){
        assert(invariant());
        update();
        return rep;
    }

    private void update() {
        if(square.getPlayer() != null) {
            String playerStr = square.getPlayer().getColor().toString();
            String tokenCount = "" + square.getTokenList().size();
            rep = playerStr.concat(tokenCount);
        } else
            rep = "HM";
        assert(invariant());
    }
}

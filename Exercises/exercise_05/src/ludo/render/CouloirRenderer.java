package ludo.render;

import ludo.square.ISquare;

/**
 * Represents a CouloirSquare on the Board. Does the same as its SuperClass RouteRenderer
 * but the square looks different: "▣".
 *
 * @see RouteRenderer
 */
public class CouloirRenderer extends RouteRenderer {

    /**
     * Connects this Renderer to the "real" Square it has to render. But makes this Renderer to draw
     * an Empty Square as "▣" instead of "▢". Makes the board look better and for the people to get a
     * better Idea of the Board itself when it is rendered.
     *
     * @param square        The Square this Renderer has to represent.
     *
     * @see RouteRenderer
     */
    public CouloirRenderer(ISquare square){
        super(square);
        super.rep = "▣ ";
        assert(invariant());
    }
}

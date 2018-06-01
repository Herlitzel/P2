package ludo.render;

import ludo.square.ISquare;

/**
 * Used to render a Square on the main route.
 * It is used by the BoardRenderer to represent one normal square.
 * It containts the toString method that represents the square either as "▢" if it is empty or the
 * color of the player the token belongs to.
 *
 * It knows which square on the board it has to render.
 */
public class RouteRenderer implements Renderer{
    protected ISquare route;
    protected String rep;

    protected boolean invariant(){
        return(route != null && (rep.equals("▢ ")|| rep.equals("▣ ")));
    }

    /**
     * Connects this renderer to the "real" square it has to render.
     * @param route         the "real" (ISquare) it has to render
     */
    public RouteRenderer(ISquare route){
        this.route = route;
        rep = "▢ ";
        assert(invariant());
    }

    /**
     * Represents its square. It gives out a String of Length One. The String looks as follows:
     * "▢" if the square is empty
     * "R" if the token on it belongs to the red Player
     * "G" if the token on it belongs to the green Player
     * "Y" if the token on it belongs to the yellow Player
     * "B" if the token on it belongs to the blue Player
     *
     * @return       "▢" if the square is empty
     *               "R" if the token on it belongs to the red Player
     *               "G" if the token on it belongs to the green Player
     *               "Y" if the token on it belongs to the yellow Player
     *               "B" if the token on it belongs to the blue Player
     */
    public String toString(){
        assert(invariant());
        return route.isOccupied() ? route.getToken().toString() : rep;
    }
}

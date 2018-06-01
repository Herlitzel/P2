package ludo.render;

/**
 * The Renderer Interface defines the methods used to render an Object in the Ludo game.
 * The Idea is to put all the Information from the Ludo Game into a String that somehow draws the
 * Game board in its correct state.
 *
 * @see BoardRenderer
 *
 * It is used by three main classes to render their own objects:
 *
 * -BoardRenderer (rendering the whole board)
 * -RouteRenderer (rendering the squares along the main route)
 *      --> CouloirRendeerer (rendering the couloirs leading to the end squares)
 * -HomeSquareRenderer (rendering the HomeSquares of the Players.)
 *
 */
public interface Renderer {

    /**
     * Every renderer should contain the toString() method. This way it is printed out by the boardrenderer.
     * @return      The String representation of the specific Object
     */
    String toString();

}

package ludo;

/**
 * Represents the color of the players in the game.
 * Can be either
 *      -RED
 *      -GREEN
 *      -YELLOW
 *      -BLUE
 */
public enum Color {
    RED("R"),
    GREEN("G"),
    YELLOW("Y"),
    BLUE("B");

    private final String init;

    /**
     * initializes the color
     * @param init
     */
    Color(String init) {
        this.init = init;
    }

    /**
     * Representation of the color.
     *
     * @return          R, if red
     *                  G, if green
     *                  Y, if yellow
     *                  B, if blue
     */
    @Override
    public String toString(){
        return init;
    }
}

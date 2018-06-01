package ludo;

import java.util.Random;

/**
 * The Die Class represents the Die in the game. It can be rolled. @see roll()
 */
public class Die {
    private Random rand;

    /**
     * Class invariant of the Die. Checks if the random is initialized.
     * @return      true, if Random is initialized.
     */
    protected boolean invariant(){
        return rand != null;
    }

    /**
     * Initializes the random generator of this Die.
     */
    public Die(){
        rand = new Random();
        assert (invariant());
    }

    /**
     * Rolls the Die and therefore returns a random number between 1 and 6
     * @return      a random integer between 1 and 6
     */
    public int roll(){
        assert(invariant());
        return rand.nextInt(6) + 1;
    }
}

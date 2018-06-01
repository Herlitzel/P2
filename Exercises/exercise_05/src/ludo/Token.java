package ludo;


import ludo.square.*;
import java.io.*;

/**
 * The token represents the tokens that can be moved along the route. Each player can have four tokens.
 * They can leave and enter squares and move along the route. When a Token reaches the ending square,
 * it is finished and cannot be moved anymore.
 */
public class Token {
    private boolean isFinished;
    private Player player;
    private ISquare square;
    private int tokenNumber;

    /**
     * Class invariant of the token. Checks if it stands on a square. (It should always stand on one!)
     * and if the player is being initailized or not.
     * @return      true, if the token is standing on a square and the player is initialized.
     */
    private boolean invariant(){
        return this.square != null && this.player != null;
    }

    /**
     * Creates a Token from the given player. Sets then the created token onto the homesquare of the player.
     * @param player        The player this token is wished to belong to.
     */
    Token(Player player, int number){
        this.tokenNumber = number;
        this.player = player;
        this.square = player.getHomeSquare();
        square.enter(this);
        assert(invariant());
    }

    /**
     * Used to check if this token is finished.
     * @return          true, if the token is on the ending square and therefore finished.
     */
    public boolean checkFinished(){
        return isFinished;
    }

    /**
     * Makes the token know it finished the game and stands on the end square.
     */
    public void finish(){
        isFinished = true;
    }

    /**
     * Makes the token move some fields forward along its route.
     * @param fields            The amount of fields to move the token forward along its route.
     */
    public  void moveForward(int fields){
        ISquare square = this.square;
        while(fields > 0) {
            square = square.getNextSquare(this);
            fields--;
        }
        if(!(square instanceof InvalidSquare))
            this.moveTo(square);
        //Do Stuff if player has thrown over the endsquare

    }

    /**
     * Sets the token to a specific square.
     * @param moveToSquare          The square the token is wished to go.
     */
    public void moveTo(ISquare moveToSquare){
        this.square.leave(this);
        this.square = moveToSquare;
        moveToSquare.enter(this);
    }

    /**
     * Sends this token back to the home. This happens if another token lands on the same field as this one.
     */
    public void sendHome(){
        this.moveTo(this.player.getHomeSquare());
    }

    /**
     * Used to get the Player of the token.
     * @return              The player this token belongs to.
     */
    public Player getPlayer(){
        return this.player;
    }

    /**
     * Representation of the Token. Used to render the board.
     *
     * @return          R, if the token belongs to red player
     *                  G, if the token belongs to green player
     *                  Y, if the token belongs to yellow player
     *                  B, if the token belongs to blue player
     */
    public String toString(){
        return this.player.getColor().toString() + tokenNumber;
    }

    public ISquare getSquare(){
        return this.square;
    }
}

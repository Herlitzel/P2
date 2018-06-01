package ludo;

import ludo.square.HomeSquare;

import java.util.Random;

/**
 * This is a player that plays autonomous. It overrides the act method and moves random tokens around.
 * However, can do the same as a normal Player and is also a player.
 */
public class RandomPlayer extends Player{

    /**
     * Initializes a random Player with the specified parameters:
     * @param color     The color of this player. Stored in a string. (red, green, yellow, blue)
     * @param ludo          The board of the actual game.
     * @param home          The home square of this player.
     */
    public RandomPlayer(Color color, Board ludo, HomeSquare home){
        super(color, ludo, home);
    }

    /**
     * This lets the player move the tokens around the board till someone wins. The tokens which the player
     * wants to move are chosen randomly. The only time it's not chosen randomly is when the player
     * gets a 6 so he can move out of the homesquare, then it first checks if he can move out.
     */
    @Override
    public void act(int roll){
        assert(roll >= 1 && roll <= 6);
        if(roll == 6 && home.getTokenList().size() > 0) {
            home.getToken().moveForward(1);
        } else if(home.getTokenList().size() < 4) {
            getRandomInGameToken().moveForward(roll);
        }
    }

    /**
     * @return Token from all the inGameTokens
     */
    private Token  getRandomInGameToken(){
        Random rand = new Random();
        super.updateInGameList();
        return inGameTokens.get(rand.nextInt(inGameTokens.size()));
    }
}

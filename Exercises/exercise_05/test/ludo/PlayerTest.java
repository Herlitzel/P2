package ludo;

import org.junit.Test;

import java.util.Queue;

import static junit.framework.TestCase.*;

public class PlayerTest {

    Queue<Player> players;

    Player red;
    Player yellow;

    Board ludo;

    private void initGame(){
        Game game = new Game(2, false);
        players = game.getPlayers();

        red = players.remove();
        yellow = players.remove();

        assertEquals(Color.RED, red.getColor());
        assertEquals(Color.YELLOW, yellow.getColor());

        ludo = game.getBoard();
    }

    @Test
    public void moveTokenTest(){
        initGame();
        red.moveTokenTo(0, ludo.getRoute()[1]);
        assertTrue(ludo.getRoute()[1].getToken().getPlayer() != null);
        assertEquals(red, ludo.getRoute()[1].getToken().getPlayer());
    }

    @Test
    public void moveTwoTokensTest(){
        initGame();
        red.moveTokenTo(0, ludo.getRoute()[1]);
        yellow.moveTokenTo(0, ludo.getRoute()[20]);
        assertTrue(ludo.getRoute()[1].getToken().getPlayer() != null);
        assertTrue(ludo.getRoute()[20].getToken().getPlayer() != null);
        assertEquals(red, ludo.getRoute()[1].getToken().getPlayer());
        assertEquals(yellow, ludo.getRoute()[20].getToken().getPlayer());
    }

    @Test
    public void moveTokenTwiceTest(){
        initGame();
        red.moveTokenForward(0, 5);
        assertEquals(red, ludo.getRoute()[5].getToken().getPlayer());
        red.moveTokenForward(0, 2);
        assertEquals(red, ludo.getRoute()[7].getToken().getPlayer());
    }

    @Test
    public void moveTokenAlongTheRouteTest(){
        initGame();
        for(int i = 0; i < 51; i++){
            red.moveTokenForward(0,1);
            assertEquals(red.getToken(0), ludo.getRoute()[i+1].getToken());
        }
    }

}

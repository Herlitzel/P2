package ludo;

import ludo.square.CouloirSquare;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class GameRulesTest {

    Game game;
    Board board;
    Player red;

    private void init(){
        game = new Game(2, false);
        board = game.getBoard();
        red = game.getPlayers().peek();
    }

    @Test
    public void testThrowOverEndOne(){
        init();
        red.moveTokenTo(0, board.getRedCouloir()[3]);
        assertEquals(red.getToken(0), board.getRedCouloir()[3].getToken());
        red.moveTokenForward(0,10);
        assertEquals(red.getToken(0), board.getRedCouloir()[3].getToken());
    }

    @Test
    public void testThrowOverEndTwo(){
        init();
        red.moveTokenTo(0, board.getRedCouloir()[3]);
        assertEquals(red.getToken(0), board.getRedCouloir()[3].getToken());
        red.moveTokenForward(0,4);
        assertEquals(red.getToken(0), board.getRedCouloir()[3].getToken());
    }

    @Test
    public void testLandOnEnd(){
        init();
        red.moveTokenTo(0, board.getRedCouloir()[2]);
        assertEquals(red.getToken(0), board.getRedCouloir()[2].getToken());
        red.moveTokenForward(0,3);
        assertEquals(red.getToken(0), board.endSquare.getFinishedTokens().get(0));
        assertTrue(red.getToken(0).checkFinished());
    }

    @Test
    public void sendHomeTest(){
        init();
        Player yellow = board.yellowHome.getPlayer();
        red.moveTokenTo(0, board.getRoute()[10]);
        assertEquals(board.getRoute()[10].getToken(), red.getToken(0));
        yellow.moveTokenTo(0, board.getRoute()[10]);
        assertEquals(board.redHome, red.getToken(0).getPlayer().getHomeSquare());
        assertEquals(board.getRoute()[10].getToken(), yellow.getToken(0));
    }
}

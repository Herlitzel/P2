package ludo;

import ludo.square.CrossingSquare;
import ludo.square.HomeSquare;
import ludo.square.ISquare;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class SquareTest {

    private Game game;
    private Board board;
    private Player red;

    private void init(){
        game = new Game(2, false);
        board = game.getBoard();
        red = game.getPlayers().peek();
    }

    @Test
    public void homeSquareTest(){
        init();
        HomeSquare redHome = board.redHome;
        assertEquals(Color.RED, redHome.getPlayer().getColor());
    }

    @Test
    public void homeSquareMoveOutTest(){
        init();
        red.moveTokenForward(0, 5);
        assertEquals(red.getToken(0), board.getRoute()[5].getToken());
    }

    @Test
    public void CrossingSquareTest(){
        init();
        CrossingSquare cs = (CrossingSquare) board.getRoute()[13];
        red.moveTokenTo(0, cs);
        assertTrue(cs.isOccupied());
        assertEquals(red.getToken(0), cs.getToken());
    }

    @Test
    public void moveToCrossingSquareTest(){
        Game game = new Game(2, false);
        Board board = game.getBoard();
        ISquare[] route = board.getRoute();
        Player red = game.getPlayers().peek();

        assertFalse(route[13].isOccupied());
        red.moveTokenForward(0, 13);
        assertEquals(route[13], red.getToken(0).getSquare());
        assertEquals(red.getToken(0), route[13].getToken());
        assertTrue(route[13].isOccupied());
    }

    @Test
    public void crossingSquareCrossingTest(){
        init();
        red.moveTokenTo(0,board.getRoute()[50]);
        red.moveTokenForward(0,3);
        assertEquals(red.getToken(0), board.getRedCouloir()[0].getToken());
    }

    @Test
    public void crossingSquareNotCrossingTest(){
        init();
        red.moveTokenTo(0,board.getRoute()[11]);
        red.moveTokenForward(0,5);
        assertEquals(red.getToken(0), board.getRoute()[16].getToken());
    }
}

package ludo;

import ludo.render.BoardRenderer;
import ludo.render.CouloirRenderer;
import ludo.render.HomeSquareRenderer;
import ludo.render.RouteRenderer;
import ludo.square.*;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RenderTest {
    Game game;
    Board board;
    Player red;

    private void init(){
        game = new Game(2, false);
        board = game.getBoard();
        red = game.getPlayers().peek();
    }

    @Test
    public void routeRenderTest(){
        init();

        NormalSquare square = new NormalSquare();
        RouteRenderer rr = new RouteRenderer(square);

        assertEquals("▢ ", rr.toString());

        red.moveTokenTo(0, square);
        assertEquals(red, square.getToken().getPlayer());

        assertEquals("R0", rr.toString());
    }

    @Test
    public void couloirRenderTest(){
        init();

        CouloirSquare square = new CouloirSquare();
        CouloirRenderer cr = new CouloirRenderer(square);

        assertEquals("▣ ", cr.toString());

        red.moveTokenTo(0, square);
        assertEquals(red, square.getToken().getPlayer());

        assertEquals("R0", cr.toString());
    }

    @Test
    public void HomeSquareRenderTest(){
        init();

        HomeSquare square = new HomeSquare();
        HomeSquareRenderer hsr = new HomeSquareRenderer(square);
        assertEquals("HM", hsr.toString());

        square.setPlayerHome(red);
        assertEquals("R0", hsr.toString());

        red.moveTokenTo(0, square);
        assertEquals("R1", hsr.toString());

        red.moveTokenTo(1, square);
        assertEquals("R2", hsr.toString());
    }

    @Test
    public void CrossingSquareRenderTest(){
        init();

        CrossingSquare cs = new CrossingSquare(Color.RED);
        CouloirRenderer cr = new CouloirRenderer(cs);
        assertEquals("▣ ", cr.toString());

        red.moveTokenTo(0, cs);
        assertEquals("R0", cr.toString());
    }

    @Test
    public void BoardStartGameRenderTest(){
        init();

        BoardRenderer br = new BoardRenderer(board);
        assertEquals("__         ▢ ▢ ▢         __\n" +
                "G4|        ▢ ▣ ▣        |Y4\n" +
                "⎺⎺         ▢ ▣ ▢         ⎺⎺\n" +
                "           ▢ ▣ ▢           \n" +
                "           ▢ ▣ ▢           \n" +
                "           ▢ ▣ ▢           \n" +
                "▢ ▣ ▢ ▢ ▢ ▢ ___ ▢ ▢ ▢ ▢ ▢ ▢ \n" +
                "▢ ▣ ▣ ▣ ▣ ▣ END ▣ ▣ ▣ ▣ ▣ ▢ \n" +
                "▢ ▢ ▢ ▢ ▢ ▢ ⎺⎺⎺ ▢ ▢ ▢ ▢ ▣ ▢ \n" +
                "           ▢ ▣ ▢           \n" +
                "           ▢ ▣ ▢           \n" +
                "           ▢ ▣ ▢           \n" +
                "__         ▢ ▣ ▢         __\n" +
                "R4|        ▣ ▣ ▢        |B4\n" +
                "⎺⎺         ▢ ▢ ▢         ⎺⎺\n", br.toString());
    }

    @Test
    public void BoardDuringGameRenderTest(){
        init();

        red.moveTokenForward(0, 3);
        red.moveTokenForward(1, 1);
        game.getPlayers().poll();
        Player yellow = game.getPlayers().peek();
        yellow.moveTokenForward(0, 3);
        BoardRenderer br = new BoardRenderer(board);
        assertEquals("__         ▢ ▢ ▢         __\n" +
                "G4|        ▢ ▣ ▣        |Y3\n" +
                "⎺⎺         ▢ ▣ ▢         ⎺⎺\n" +
                "           ▢ ▣ ▢           \n" +
                "           ▢ ▣ Y0          \n" +
                "           ▢ ▣ ▢           \n" +
                "▢ ▣ ▢ ▢ ▢ ▢ ___ ▢ ▢ ▢ ▢ ▢ ▢ \n" +
                "▢ ▣ ▣ ▣ ▣ ▣ END ▣ ▣ ▣ ▣ ▣ ▢ \n" +
                "▢ ▢ ▢ ▢ ▢ ▢ ⎺⎺⎺ ▢ ▢ ▢ ▢ ▣ ▢ \n" +
                "           ▢ ▣ ▢           \n" +
                "           R0▣ ▢           \n" +
                "           ▢ ▣ ▢           \n" +
                "__         R1▣ ▢         __\n" +
                "R2|        ▣ ▣ ▢        |B4\n" +
                "⎺⎺         ▢ ▢ ▢         ⎺⎺\n", br.toString());
    }
}

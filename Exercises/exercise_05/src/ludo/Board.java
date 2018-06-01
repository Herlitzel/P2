package ludo;

import ludo.square.*;

import java.util.Queue;

/**
 * The board stores all the squares in the game and connects them correctly. The board consists of a main route
 * containing normal squares that is 52 fields long. Along this routes there are four intersections for each
 * colour that lead into their respective Couloir. Ther are also four HomeSquares for each colour and an ending
 * square.
 *
 * Its task is to initialize everything and connect everything correctly. The board then represents an important
 * part of the game containing a lot of infomrations about the squares and, the board.
 *
 */
public class Board {
    /**
     * @param route             An array of 52 fields that represents the main route along the board.
     * @param redHome           The home of the red player.
     * @param greenHome         The home of the green player.
     * @param yellowHome        The home of the yellow player.
     * @param blueHome          The home of the blue player.
     */
    private ISquare[] route;

    private CouloirSquare[] redCouloir;
    private CouloirSquare[] greenCouloir;
    private CouloirSquare[] yellowCouloir;
    private CouloirSquare[] blueCouloir;

    public HomeSquare redHome;
    public HomeSquare greenHome;
    public HomeSquare yellowHome;
    public HomeSquare blueHome;

    public EndSquare endSquare;

    /**
     * Initializes the board. @see initialize()
     */
    public Board(){
        initialize();
    }

    /**
     * Initializes the list of squares and connects all the squares correctly. This is done according to
     * the following hierarchy:
     *
     * -Inizialize the main route
     * -Connect all squares along the route
     * -last one to first one
     * -Initialize crossing squares along the route which lead into the couloirs and connect them along the main route.
     * -Initialize the couloirs that lead to the ending square
     * -Connect the couloirs
     * -Connect Couloirs to the end square
     * -Connect the crossing to the couloirs
     * -Initialize the HomeSquares
     * -Connect HomeSquares to their starting square
     *
     */
    public void initialize(){

        //Inizialize the main route
        route = new ISquare[52];
        for(int i = 0; i < route.length; i++)
            route[i] = new NormalSquare();

        //Connect all squares along the route
        for(int i = 1; i < route.length; i++)
            route[i - 1].setNextSquare(route[i]);

        //last one to first one
        route[51].setNextSquare(route[0]);

        //Initialize crossing squares along the route which lead into the couloirs and connect them along the
        //main route.
        route[0]  = new CrossingSquare(Color.RED);
        route[51].setNextSquare(route[0]);
        route[0].setNextSquare(route[1]);

        route[13] = new CrossingSquare(Color.GREEN);
        route[12].setNextSquare(route[13]);
        route[13].setNextSquare(route[14]);

        route[26] = new CrossingSquare(Color.YELLOW);
        route[25].setNextSquare(route[26]);
        route[26].setNextSquare(route[27]);

        route[39] = new CrossingSquare(Color.BLUE);
        route[38].setNextSquare(route[39]);
        route[39].setNextSquare(route[40]);

        //Initialize the couloirs that lead to the ending square
        redCouloir = new CouloirSquare[5];
        for(int i = 0; i < redCouloir.length; i++)
            redCouloir[i] = new CouloirSquare();
        greenCouloir = new CouloirSquare[5];
        for(int i = 0; i < greenCouloir.length; i++)
            greenCouloir[i] = new CouloirSquare();
        yellowCouloir = new CouloirSquare[5];
        for(int i = 0; i < yellowCouloir.length; i++)
            yellowCouloir[i] = new CouloirSquare();
        blueCouloir = new CouloirSquare[5];
        for(int i = 0; i < blueCouloir.length; i++)
            blueCouloir[i] = new CouloirSquare();

        //Connect the couloirs
        for(int i = 1; i <= 4; i++) {
            redCouloir[i - 1].setNextSquare(redCouloir[i]);
            greenCouloir[i - 1].setNextSquare(greenCouloir[i]);
            yellowCouloir[i - 1].setNextSquare(yellowCouloir[i]);
            blueCouloir[i - 1].setNextSquare(blueCouloir[i]);
        }

        //Connect Couloirs to the end square
        endSquare = new EndSquare();
        redCouloir[4].setNextSquare(endSquare);
        greenCouloir[4].setNextSquare(endSquare);
        yellowCouloir[4].setNextSquare(endSquare);
        blueCouloir[4].setNextSquare(endSquare);

        //Connect the crossing to the couloirs
        route[0].setCouloirEnter(redCouloir[0]);
        route[13].setCouloirEnter(greenCouloir[0]);
        route[26].setCouloirEnter(yellowCouloir[0]);
        route[39].setCouloirEnter(blueCouloir[0]);

        //Initialize the HomeSquares
        redHome = new HomeSquare();
        greenHome = new HomeSquare();
        yellowHome = new HomeSquare();
        blueHome = new HomeSquare();

        //Connect HomeSquares to their starting square
        redHome.setNextSquare(route[1]);
        greenHome.setNextSquare(route[14]);
        yellowHome.setNextSquare(route[27]);
        blueHome.setNextSquare(route[40]);

    }

    /**
     * @return          The main route. Array of 52 ISquares, containing nomral and crossings.
     */
    public ISquare[] getRoute(){
        return route;
    }

    /**
     * @return          The red couloir, an array of 5 CouloirSquares. @see CouloirSquare
     */
    public ISquare[] getRedCouloir(){
        return redCouloir;
    }

    /**
     * @return          The green couloir, an array of 5 CouloirSquares. @see CouloirSquare
     */
    public ISquare[] getGreenCouloir(){
        return greenCouloir;
    }

    /**
     * @return          The yellow couloir, an array of 5 CouloirSquares. @see CouloirSquare
     */
    public ISquare[] getYellowCouloir(){
        return yellowCouloir;
    }

    /**
     * @return          The blue couloir, an array of 5 CouloirSquares. @see CouloirSquare
     */
    public ISquare[] getBlueCouloir(){
        return blueCouloir;
    }
}

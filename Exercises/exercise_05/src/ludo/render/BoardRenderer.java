package ludo.render;

import ludo.Board;

/**
 * This is the main Class within the Rendering mechanism. ONLY THIS ONE IS USED TO VISUALIZE A GAME.
 * It gives out the Board in its correct state and handles the other rendering classes.
 * The Information from its Board is printed into a String that is given out within the toString() method.
 *
 * The String looks as follows at the initial state of the board, at the Beginning of the game:
 *<code>
 *  __         ▢ ▢ ▢         __<br>
 *  G4|        ▢ ▣ ▣        |Y4<br>
 *  ⎺⎺         ▢ ▣ ▢         ⎺⎺<br>
 *             ▢ ▣ ▢<br>
 *             ▢ ▣ ▢<br>
 *             ▢ ▣ ▢<br>
 *  ▢ ▣ ▢ ▢ ▢ ▢ ___ ▢ ▢ ▢ ▢ ▢ ▢<br>
 *  ▢ ▣ ▣ ▣ ▣ ▣ END ▣ ▣ ▣ ▣ ▣ ▢<br>
 *  ▢ ▢ ▢ ▢ ▢ ▢ ⎺⎺⎺ ▢ ▢ ▢ ▢ ▣ ▢<br>
 *             ▢ ▣ ▢<br>
 *             ▢ ▣ ▢<br>
 *             ▢ ▣ ▢<br>
 *  __         ▢ ▣ ▢         __<br>
 *  R4|        ▣ ▣ ▢        |B4<br>
 *  ⎺⎺         ▢ ▢ ▢         ⎺⎺<br>
 *
 *</code>
 *
 * Explaination:
 * -On the Edges, there are the HomeSquares of each player marked by the Color of the player and the
 *  amount of Tokens on it.
 * -The Main Route are the outernmost squares marked as a "▢".
 * -The four crossing squares along the main route are marked as a "▣"
 * -The Couloirs in the middle of the Arms are also drawn as "▣".
 * -In the Middle, there is the End. It is static and remains.
 *
 * The Tokens are Represented as the first Letter of their Player. So "B" means a Token from the blue Player.
 * They are rendered on the correct Position on the Board.
 *
 * The HomeSquares are also marked as the Color of their player and the amount of Tokens in the homeSquare.
 *
 * So here is an example of a board in the middle of the Game:
 *
 *
 *  __         ▢ ▢ ▢         __
 *  G1|        ▢ ▣ ▣        |Y3
 *  ⎺⎺         ▢ ▣ ▢         ⎺⎺
 *             ▢ ▣ G1
 *             ▢ ▣ ▢
 *             ▢ ▣ ▢
 *  ▢ ▣ ▢ ▢ Y2▢ ___ ▢ ▢ ▢ ▢ ▢ ▢
 *  ▢ ▣ ▣ ▣ ▣ ▣ END ▣ B1▣ ▣ ▣ ▢
 *  ▢ ▢ G0▢ ▢ ▢ ⎺⎺⎺ ▢ ▢ R1▢ ▣ ▢
 *             ▢ ▣ ▢
 *             ▢ R0▢
 *             ▢ ▣ ▢
 *  __         ▢ ▣ B0        __
 *  R2|        ▣ ▣ ▢        |B2
 *  ⎺⎺         ▢ ▢ ▢         ⎺⎺
 *
 * @See RouteRenderer
 * @See CouloirRenderer
 * @See HomeSquareRenderer
 *
 */
public class BoardRenderer implements Renderer {

    private Board ludo;

    private RouteRenderer[] route;
    private CouloirRenderer[] redCouloir, greenCouloir, yellowCouloir, blueCouloir;
    private HomeSquareRenderer redHome, greenHome, yellowHome, blueHome;

    protected boolean invariant(){
        return (ludo != null);
    }

    /**
     * Used to initialize the needed renderer correctly. It only takes the Board and does then connects its
     * renderers correctly.
     *
     * @param board         The board that has to be rendered.
     */
    public BoardRenderer(Board board){
        this.ludo = board;

        route = new RouteRenderer[52];

        for(int i = 0; i < 52; i++)
            route[i] = new RouteRenderer(ludo.getRoute()[i]);

        route[13] = new CouloirRenderer(ludo.getRoute()[13]);
        route[26] = new CouloirRenderer(ludo.getRoute()[26]);
        route[39] = new CouloirRenderer(ludo.getRoute()[39]);
        route[0] = new CouloirRenderer(ludo.getRoute()[0]);

        redCouloir = new CouloirRenderer[5];
        greenCouloir = new CouloirRenderer[5];
        yellowCouloir = new CouloirRenderer[5];
        blueCouloir = new CouloirRenderer[5];

        for(int i = 0; i < 5; i++) {
            redCouloir[i] = new CouloirRenderer(ludo.getRedCouloir()[i]);
            greenCouloir[i] = new CouloirRenderer(ludo.getGreenCouloir()[i]);
            yellowCouloir[i] = new CouloirRenderer(ludo.getYellowCouloir()[i]);
            blueCouloir[i] = new CouloirRenderer(ludo.getBlueCouloir()[i]);
        }
        redHome = new HomeSquareRenderer(ludo.redHome);
        greenHome = new HomeSquareRenderer(ludo.greenHome);
        yellowHome = new HomeSquareRenderer(ludo.yellowHome);
        blueHome = new HomeSquareRenderer(ludo.blueHome);

        assert(invariant());
    }

    /**
     * This is the method that gives out the String with the representation of the Board. For more Information,
     * See this Class description.
     * @See BoardRenderer
     */
    public String toString(){
        return "__         "+                                                                              route[23]+       route[24]+        route[25]+            "        __\n"
                +  greenHome+"|        "+                                                                  route[22]+    yellowCouloir[0]+    route[26]+"       |"+yellowHome+"\n"
                +  "⎺⎺         "+                                                                          route[21]+    yellowCouloir[1]+    route[27]+            "        ⎺⎺\n"
                +  "           "+                                                                          route[20]+    yellowCouloir[2]+    route[28]+            "          \n"
                +  "           "+                                                                          route[19]+    yellowCouloir[3]+    route[29]+            "          \n"
                +  "           "+                                                                          route[18]+    yellowCouloir[4]+    route[30]+            "          \n"
                +route[12]    +      route[13]+          route[14]+       route[15]+       route[16]+       route[17]+          "___ "+                route[31]+         route[32]+         route[33]+         route[34]+         route[35]+    route[36]+"\n"
                +route[11]    +greenCouloir[0]+    greenCouloir[1]+ greenCouloir[2]+ greenCouloir[3]+   greenCouloir[4]+        "END "+           blueCouloir[4]+    blueCouloir[3]+    blueCouloir[2]+    blueCouloir[1]+    blueCouloir[0]+    route[37]+"\n"
                +route[10]    +       route[9]+           route[8]+        route[7]+        route[6]+       route[5]+           "⎺⎺⎺ "+                route[43]+         route[42]+         route[41]+         route[40]+         route[39]+    route[38]+"\n"
                +  "           "+                                                                             route[4]+    redCouloir[4]+    route[44]+            "          \n"
                +  "           "+                                                                             route[3]+    redCouloir[3]+    route[45]+            "          \n"
                +  "           "+                                                                             route[2]+    redCouloir[2]+    route[46]+            "          \n"
                +  "__         "+                                                                             route[1]+    redCouloir[1]+    route[47]+            "        __\n"
                +  redHome+"|        "+                                                                       route[0]+    redCouloir[0]+    route[48]+  "       |"+blueHome+"\n"
                +  "⎺⎺         "+                                                                             route[51]+     route[50]+      route[49]+            "        ⎺⎺\n";
    }

}

package tanktrouble;

import java.util.ArrayList;
import java.awt.Color;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.events.Key;
import edu.macalester.graphics.ui.Button;
import edu.macalester.graphics.Image;

/**
* Utility class. Manages most static aesthetics and screens in TankTrouble. Checks Wins/Loses
*/
public class GameManager {
   private static GraphicsText player1Points;
   private static GraphicsText player2Points;
   private ArrayList<Ball> Balls;
   private boolean stopRemaking;
   private static int pointsToWin;
   private static int p1Points;
   private static int p2Points;

   public GameManager() {
       player1Points = new GraphicsText("", 0, 0);
       player2Points = new GraphicsText("",0,0);
       pointsToWin = 10;
       stopRemaking = false;
   }


   /**
    * Sets up the starting screen of the game
    * @param canvas The given canvas
    * @param tank1  The tank controlled by player one
    * @param tank2  The tank controlled by player two
    */
   public void startScreen(CanvasWindow canvas,Tank tank1, Tank tank2) {
       GraphicsText titleScreen = new GraphicsText("Tank Trouble!");
       titleScreen.setCenter(canvas.getCenter());
       titleScreen.setFont(FontStyle.BOLD, 15);
       canvas.add(titleScreen);

       GraphicsGroup instructions = addIntructions(titleScreen);
       canvas.add(instructions);

       Image tankImage = new Image("TankTroubleTank.png");
       tankImage.setCenter(titleScreen.getX() + titleScreen.getWidth() / 2, titleScreen.getY() - tankImage.getHeight());
       canvas.add(tankImage);

       Button startButton = new Button("START GAME");
       startButton.setCenter(titleScreen.getX() + titleScreen.getWidth() / 2, titleScreen.getY() + 250);
       canvas.add(startButton);

       startButton.onClick(() -> setUpGame(canvas,tank1,tank2));
   }


   /**
    * Returns a graphics group with the instructions to the game. Centers the graphics group off of the titleScreen graphics text
    * @param titleScreen    A graphics text that is usually centered at the middle of the canvas
    * @returns              The list of instructions within a graphics group
    */
   public GraphicsGroup addIntructions(GraphicsText titleScreen) {
       GraphicsGroup instructionsGroup = new GraphicsGroup();
       GraphicsText instructionsLine1 = new GraphicsText("Welcome to Tank Trouble! Your objective is to guide your tank around the maze in order to shoot your opponent.");
       GraphicsText instructionsLine2 = new GraphicsText("To score a point, you must destroy your opponent's tank by shooting it, or if your opponent self destructs.");
       GraphicsText instructionsLine3 = new GraphicsText("Player 1 uses keys 'ESDF' to move and 'Q' to shoot. Player 2 uses the arrow keys to move and 'M' to shoot");
       GraphicsText instructionsLine4 = new GraphicsText("Player 1's points will be indicated by 'P1 points' while Player 2's points will be indicated by 'P2 points'");
       GraphicsText instructionsLine5 = new GraphicsText("When both players are ready, press the start button to begin the game");
       GraphicsText instructionsLine6 = new GraphicsText("First to 10 points wins!");
       instructionsLine1.setCenter(titleScreen.getX() + titleScreen.getWidth() / 2, titleScreen.getY() + titleScreen.getLineHeight() * 3);
       instructionsLine2.setCenter(titleScreen.getX() + titleScreen.getWidth() / 2, titleScreen.getY() + instructionsLine1.getLineHeight() * 5);
       instructionsLine3.setCenter(titleScreen.getX() + titleScreen.getWidth() / 2, titleScreen.getY() + instructionsLine2.getLineHeight() * 7);
       instructionsLine4.setCenter(titleScreen.getX() + titleScreen.getWidth() / 2, titleScreen.getY() + instructionsLine2.getLineHeight() * 9);
       instructionsLine5.setCenter(titleScreen.getX() + titleScreen.getWidth() / 2, titleScreen.getY() + instructionsLine2.getLineHeight() * 11);
       instructionsLine6.setCenter(titleScreen.getX() + titleScreen.getWidth() / 2, titleScreen.getY() + instructionsLine2.getLineHeight() * 13);
       instructionsGroup.add(instructionsLine1);
       instructionsGroup.add(instructionsLine2);
       instructionsGroup.add(instructionsLine3);
       instructionsGroup.add(instructionsLine4);
       instructionsGroup.add(instructionsLine5);
       return instructionsGroup;
   }


    /**
    * Creates the maze and adds the tanks to the canvas
     * @param canvas    The given canvas
     * @param tank1     The tank controlled by player 1
     * @param tank2     The tank controlled by player 2
     */
   public void setUpGame(CanvasWindow canvas, Tank tank1, Tank tank2) {
       canvas.removeAll();
      
       ArrayList<Wall> list = MazeManager.createMaze(canvas);
       for (Wall wall : list) {
           canvas.add(wall);
       }

       player1Points = new GraphicsText("P1 Points: " + p1Points, canvas.getWidth() * 0.1, canvas.getHeight() * 0.05);
       player1Points.setFontSize(20);
       player1Points.setFillColor(new Color(255,0,0));
       canvas.add(player1Points);
      
       player2Points = new GraphicsText("P2 Points: " + p2Points, canvas.getWidth() * 0.85 - player1Points.getWidth() / 2, canvas.getHeight() * 0.05);
       player2Points.setFillColor(new Color(0,0,225));
       player2Points.setFontSize(20);
       canvas.add(player2Points);

       tank1.addTank(canvas);
       tank2.addTank(canvas);
   }


   /**
    * Sets up the winning screen of the game
    * @param canvas  The given canvas
    */
   public void winScreen(CanvasWindow canvas) {
        Image winImage = new Image("Trophy.png");
        Button quitButton = new Button("QUIT GAME");
        GraphicsText winnerText = new GraphicsText();
        if(!stopRemaking) {
            canvas.removeAll();
            winImage.setCenter(canvas.getCenter());
            winImage.setScale(0.125);
            if (p1Points > p2Points) {
                winnerText.setText("Player 1 Wins!");
            }
            else {
                winnerText.setText("Player 2 Wins!");
            }
            winnerText.setFontSize(canvas.getHeight() * 0.125);
            winnerText.setCenter(canvas.getWidth() / 2, (canvas.getHeight() / 4));

            quitButton.setCenter(canvas.getWidth() / 2, canvas.getHeight() * 0.85);
            canvas.add(quitButton);
            canvas.add(winnerText);
            canvas.add(winImage);

            stopRemaking = true;
        }
       quitButton.onClick(() -> canvas.closeWindow());
   }


    /**
    * Returns the number of points player 1 has earned.
    */
    public int getP1PointCount() {
        return p1Points;
    }


    /**
     * Returns the number of points player 2 has earned.
     */
    public int getP2PointCount() {
        return p2Points;
    }


    /**
     * Updates a player's score on the screen and internally.
     * @param count             How much the player's score is incremented by
     * @param playerPoints      How many points the player current has
     * @param pointsText        The graphical text of the player's points
     * @return                  The updated number of points the player has.
     */
    public int updatePlayerPointCount(int count,int playerPoints, GraphicsText pointsText) {
        int points = playerPoints + count;
        if(pointsText.getText().contains("P1")){
            pointsText.setText("P1 Points: " + points);
            pointsText.setFillColor(new Color(225, 0, 0));
        }
        else {
            pointsText.setText("P2 Points: " + points);
            pointsText.setFillColor(new Color(0, 0, 225));
        }
        playerPoints = points;
        return playerPoints;
    }


    /**
    * Moves the tank by checking if the user presses the up or down button,
    * and calls checkFront() and checkBack() from tank to make sure there is
    * no wall interference.
    * @param canvas The given canvas
    * @param dt     The incremenet value of the ball movement
    * @param up     The key that moves the tank up
    * @param down   The key that moves the tank down
    * @param tank   The tank being controlled
    */
   public void tankMoveVertical(CanvasWindow canvas, double dt, Key up, Key down, Tank tank) {
       if(canvas.getKeysPressed().contains(up) && !tank.checkFront(canvas)) {
           tank.moveUp(dt);
       }
       else if(canvas.getKeysPressed().contains(down) && !tank.checkBack(canvas)) {
           tank.moveDown(dt);
       }
       else {
           tank.setRadiusToZero();
       }
       tank.updatePosition();
   }


    /**
    * Controls of the tank on the left/right key press by rotating the tank left and right
    * @param canvas     The given canvas
    * @param dt         The incremenet value of the ball movement
    * @param left       The key that causes the tank to rotate to the left
    * @param right      The key that causes the tank to rotate to the right
    * @param Tank       The tank that is being rotated
    */
   public void tankRotate(CanvasWindow canvas, double dt, Key right, Key left, Tank tank) {
       if(canvas.getKeysPressed().contains(right)) {
           tank.rotateRight(dt);
       }
       else if(canvas.getKeysPressed().contains(left)) {
           tank.rotateLeft(dt);
       }
       tank.updatePosition();
   }


   /**
    * Moves each ball player 2 has and calls ballWallCollision() from ball to check for a collision
    * @param canvas     The given canvas
    * @param Tank       The tank the ball is shot from
    * @param wallList   The arraylist of walls the ball checks collision with
    * @param dt         The increment value of the ball movement
    */
   public void moveBalls(CanvasWindow canvas, Tank tank, ArrayList<Wall> wallList, double dt) {
       for(Ball ball : tank.getTankBalls()) {
           ball.moveBall(canvas, wallList, dt);
           ball.ballWallCollision(canvas, wallList);
           if(ball.getBallLife() > 10000) {
               tank.getTankBalls().remove(ball);
               ball.removeFromCanvas(canvas);
               break;
           }
       }
   }


   /**
   * If player 1's and player 2's points is less than threshold of points to win (pointsToWin), 
   * game manager resets the canvas for the next round.
   * @param canvas   The given canvas
   * @param tank1    The tank controlled by player 1
   * @param tank2    The tank controlled by player 2
   */
   public void nextTurn(CanvasWindow canvas,Tank tank1, Tank tank2) {
       if (p1Points < pointsToWin && p2Points < pointsToWin) {
           canvas.pause(3000);
           whichPlayerHit(tank1, tank2).addTank(canvas);
           tank2.setTankPosition(canvas.getWidth() * .175, canvas.getHeight() * .175);
           tank1.setTankPosition(canvas.getWidth() * .85, canvas.getHeight() * .85);
       }
   }


   /**
    * Adds to the score of player 1 or player 2 based on which tank was destroyed. Updates the text on screen
    * @param tank1    The tank controlled by player 1
    * @param tank2    The tank controlled by player 2
    */
   public void updateScores(Tank tank1, Tank tank2) {
        if(tank1.getHitDetection()) {
            p1Points = updatePlayerPointCount(1,p1Points,player1Points);
        }
        else {
            p2Points = updatePlayerPointCount(1,p2Points,player2Points);
        }
   }


   /**
    * Returns the tank was hit by a ball. Resets the hit detection within the tank
    * @param tank1  The tank controlled by player one
    * @param tank2  The tank controlled by player two
    * @return       The tank that was hit by the ball
    */
   public Tank whichPlayerHit(Tank tank1, Tank tank2) {
       if(tank1.getHitDetection()) {
           tank1.setHitDetection(false);
           return tank1;
       }
       else {
           tank2.setHitDetection(false);
           return tank2;
       }
   }


   /**
   * Checks if a player has reached threshold of points to win (pointsToWin). If so, a win screen is presented.
   * @param canvas   The given canvas
   */
   public void playerHasWon(CanvasWindow canvas) {
       if (p1Points == pointsToWin || p2Points == pointsToWin) {
           winScreen(canvas);
       }
   }


    @Override
    public String toString() {
        return "GameManager [Balls=" + Balls + ", stopRemaking=" + stopRemaking + "]";
    }
   
}

package tanktrouble;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.Rectangle;
import java.awt.Color;
import java.util.ArrayList;
import java.lang.Math;

/**
 * The ball in the game TankTrouble
 */
public class Ball {   
   public static final double BALL_RADIUS = 3;
   private static final Color BALL_COLOR = Color.RED;
   private static double initalSpeed = 200;
   private double ballLife = 10;
   private double deltaX, deltaY;
   private double ballX1, ballY1;
   private double angleDegrees, angleRadians;
   private Ellipse ballShape;


   public Ball(double ballX1, double ballY1) {
       this(ballX1, ballY1, 45);
   }


   public Ball(double ballX1, double ballY1, double angleDegrees) {
       this.angleDegrees = angleDegrees;
       angleRadians = Math.toDegrees(angleDegrees/(1045*Math.PI));
       deltaX = -initalSpeed * Math.cos(angleRadians);
       deltaY = -initalSpeed * Math.sin(angleRadians);
       this.ballX1 = ballX1 + deltaX/7;
       this.ballY1 = ballY1 + deltaY/7;
       ballShape = new Ellipse(this.ballX1-BALL_RADIUS/2, this.ballY1-BALL_RADIUS/2, BALL_RADIUS*2, BALL_RADIUS*2);
       ballShape.setFillColor(BALL_COLOR);
   }


   /**
   * Moves and detects collision with the wall.
   * @param canvas       The given canvas
   * @param wallList     The walls the ball checks collision with
   * @param dt           The increment value of movement
   */
   public void moveBall(CanvasWindow canvas, ArrayList<Wall> wallList, double dt) {
        if(ballShape.getX() < (canvas.getWidth() * 0.1) && deltaX < 0) {
            deltaX = deltaX * -1;
        }
        if(ballShape.getX() + (BALL_RADIUS) > (canvas.getWidth() * 0.9) && deltaX > 0) {
            deltaX = deltaX * -1;
        }
        if(ballShape.getY() < (canvas.getHeight() * 0.1) && deltaY < 0) {
            deltaY = deltaY * -1;
        }
        if(ballShape.getY() + (BALL_RADIUS) > (canvas.getHeight() * 0.9) && deltaY > 0) {
            deltaY = deltaY * -1;
        }
       ballWallCollision(canvas, wallList);
       ballLife++;
       ballShape.setPosition(ballShape.getX() + deltaX * dt, ballShape.getY() + deltaY * dt);
   }


   /**
   * It calls helper functions to check how the ball collides with a wall of the maze to determine the direction the ball should move after collision.
   * @param canvas     CanvasWindow object
   */
   public void checkNorthSouthEastWest(CanvasWindow canvas) {
       //Check Middle Left of Ball
       if(canvas.getElementAt(ballShape.getX()-1, ballShape.getY()+BALL_RADIUS) instanceof Rectangle &&
          deltaX < 0) {
           deltaX = deltaX * -1;
       }
       //Check Middle Right of Ball
       if(canvas.getElementAt(ballShape.getX() +1 + 2* BALL_RADIUS, ballShape.getY()+BALL_RADIUS) instanceof Rectangle &&
          deltaX > 0) {
           deltaX = deltaX * -1;
       }
       //Check Middle Bottom of Ball
       if(canvas.getElementAt(ballShape.getX() + BALL_RADIUS, ballShape.getY()+2*BALL_RADIUS+1) instanceof Rectangle &&
          deltaY > 0) {
           deltaY = deltaY * -1;
       }
       //Check Middle Top of Ball
       if(canvas.getElementAt(ballShape.getX() + BALL_RADIUS, ballShape.getY()-1) instanceof Rectangle &&
          deltaY < 0) {
           deltaY = deltaY * -1;
       }
   }


   /**
   * A helper functions that checks for ball collision with the top left corner of a wall and determines the direction the ball should move after collision.
   * @param canvas     CanvasWindow object
   */
   public void checkTopLeft(CanvasWindow canvas) {
       //Check Left Bounce
       if(canvas.getElementAt(ballShape.getX(),ballShape.getY()) instanceof Rectangle &&
           canvas.getElementAt(ballShape.getX()-1, ballShape.getY()+BALL_RADIUS) instanceof Rectangle &&
           deltaX < 0) {
               deltaX = deltaX * -1;
       }
       //Check Top Bounce
       if(canvas.getElementAt(ballShape.getX(),ballShape.getY()) instanceof Rectangle &&
           canvas.getElementAt(ballShape.getX() + BALL_RADIUS, ballShape.getY()-1) instanceof Rectangle &&
           deltaY < 0) {
               deltaY = deltaY * -1;
       }
   }


   /**
   * A helper functions that checks for ball collision with the top right corner of a wall and determines the direction the ball should move after collision.
   * @param canvas     CanvasWindow object
   */
   public void checkTopRight(CanvasWindow canvas) {
       //Check Right Bounce
       if(canvas.getElementAt(ballShape.getX()+2*BALL_RADIUS,ballShape.getY()) instanceof Rectangle &&
           canvas.getElementAt(ballShape.getX() +1 + 2* BALL_RADIUS, ballShape.getY()+BALL_RADIUS) instanceof Rectangle &&
           deltaX > 0) {
               deltaX = deltaX * -1;
       }
       //Check Top Bounce
       if(canvas.getElementAt(ballShape.getX()+2*BALL_RADIUS,ballShape.getY()) instanceof Rectangle &&
           canvas.getElementAt(ballShape.getX() + BALL_RADIUS, ballShape.getY()-1) instanceof Rectangle &&
           deltaY < 0) {
               deltaY = deltaY * -1;
       }
   }


   /**
   * A helper functions that checks for ball collision with the bottom left corner of a wall and determines the direction the ball should move after collision.
   * @param canvas     CanvasWindow object
   */
   public void checkBottomLeft(CanvasWindow canvas) {
       //Check Left Bounce
       if(canvas.getElementAt(ballShape.getX(),ballShape.getY()+2*BALL_RADIUS) instanceof Rectangle &&
           canvas.getElementAt(ballShape.getX()-1, ballShape.getY()+BALL_RADIUS) instanceof Rectangle &&
           deltaX < 0) {
               deltaX = deltaX * -1;
       }
       //Check Bottom Bounce
       if(canvas.getElementAt(ballShape.getX(),ballShape.getY()+2*BALL_RADIUS) instanceof Rectangle &&
           canvas.getElementAt(ballShape.getX() + BALL_RADIUS, ballShape.getY()+2*BALL_RADIUS+1) instanceof Rectangle &&
           deltaY > 0) {
               deltaY = deltaY * -1;
       }
   }


   /**
   * A helper functions that checks for ball collision with the bottom right corner of a wall and determines the direction the ball should move after collision.
   * @param canvas     CanvasWindow object
   */
   public void checkBottomRight(CanvasWindow canvas) {
       //Check Left Bounce
       if(canvas.getElementAt(ballShape.getX(),ballShape.getY()+2*BALL_RADIUS) instanceof Rectangle &&
           canvas.getElementAt(ballShape.getX() +1 + 2* BALL_RADIUS, ballShape.getY()+BALL_RADIUS) instanceof Rectangle &&
           deltaX > 0) {
           deltaX = deltaX * -1;
       }
       //Check Bottom Bounce
       if(canvas.getElementAt(ballShape.getX(),ballShape.getY()+2*BALL_RADIUS) instanceof Rectangle &&
           canvas.getElementAt(ballShape.getX() +1 + 2* BALL_RADIUS, ballShape.getY()+BALL_RADIUS) instanceof Rectangle &&
          deltaX > 0) {
           deltaX = deltaX * -1;
       }
   }
  

   /**
   * It calls helper functions to check how the ball collides with a wall of the maze to determine the direction the ball should move after collision.
   * @param canvas     CanvasWindow object
   * @param wallList     an array list of Wall objects
   */
   public void ballWallCollision(CanvasWindow canvas, ArrayList<Wall> wallList) {
       checkBottomLeft(canvas);
       checkBottomRight(canvas);
       checkTopLeft(canvas);
       checkTopRight(canvas);
   }
  
   
   /**
   * Returns the value of getX1 (left most point of ball).
   */
   public double getX() {
       return ballX1;
   }


   /**
   * Returns the value of getY1 (top most point of ball).
   */
   public double getY() {
       return ballY1;
   }


   /**
   * Returns the value of getX2 (right most point of ball).
   */
   public double getX2() {
       return this.getX() + (BALL_RADIUS*2);
   }


   /**
   * Returns the value of getY2 (bottom most point of ball).
   */
   public double getY2() {
       return this.getY() + (BALL_RADIUS*2);
   }


   /**
   * Assigns a value to getX1 (left most point of ball).
   */
   public void setX1(double newX1) {
       ballX1 = newX1;
   }


   /**
   * Assigns a value to getY1 (left most point of ball).
   */
   public void setY1(double newY1) {
       ballY1 = newY1;
   }


   /**
   * Sets the value of detlaY (change in y direction).
   */
   public void setDeltaX(int newDelta) {
       deltaX = newDelta;
   }


   /**
   * Sets the value of detlaY (change in y direction).
   */
   public void setDeltaY(int newDelta) {
       deltaY = newDelta;
   }
 

   /**
   * Returns the value of detlaX (change in x direction).
   */
   public double getDeltaX() {
       return deltaX;
   }


   /**
   * Returns the value of detlaY (change in y direction).
   */
   public double getDeltaY() {
       return deltaY;
   }


   /**
   * Returns the angle of the ball's motion in degrees.
   */
   public double getAngleDegrees() {
       return angleDegrees;
   }


   /**
   * Returns the value of getX1 (left most point of ball).
   */
   public double getBallRadius() {
       return BALL_RADIUS;
   }


   /**
   * Adds the ball's shape to the given canvas.
   */
   public void addToCanvas(CanvasWindow canvas) {
       canvas.add(ballShape);
   }


   /**
   * Adds the ball's shape to the given canvas.
   */
   public double getBallLife() {
       return ballLife;
   }


   /**
   * Removes the ball's shape from the given canvas.
   */
   public void removeFromCanvas(CanvasWindow canvas) {
       canvas.remove(ballShape);
   }


   /**
   * Adds the ball's shape to the given canvas.
   */
   public Ellipse getBallShape() {
       return ballShape;
   }


   @Override
   public String toString() {
       return "Ball [ballLife=" + ballLife + ", deltaX=" + deltaX + ", deltaY=" + deltaY + ", ballX1=" + ballX1
           + ", ballY1=" + ballY1 + ", angleDegrees=" + angleDegrees + ", angleRadians=" + angleRadians + "]";
   }
}

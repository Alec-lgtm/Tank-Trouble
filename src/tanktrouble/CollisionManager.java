package tanktrouble;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.events.Key;

import java.util.ArrayList;

/**
 * Utility Class. Manages and abstracts all ball player collision logic 
 */
public class CollisionManager {
   private static GameManager gameManager;
   private static ArrayList<Ball> allBalls = new ArrayList<>();


   public CollisionManager() {
       gameManager = new GameManager();
   }


    /**
    * Shoots a ball from the tank's cannon
    * @param canvas     The given canvas
    * @param Tank       The tank the ball is being shot from
    * @param keyDown    The key that shoots the ball
    */
    public void registerShoot(CanvasWindow canvas, Tank tank, Key key) {
       canvas.onKeyDown((event) -> {
           if (tank.getTankBalls().size() <= 4) {
               if (event.getKey() == key) {
                   Ball ball = new Ball(tank.getTankCannon().getX(), tank.getTankCannon().getY(), tank.getAngleDegrees());
                   tank.getTankBalls().add(ball);
                   ball.addToCanvas(canvas);
                   allBalls.add(ball);
               }
           }
       });
   }

   
   /**
    * Checks to see if a player is it. If so, the function updates the score and 
    * checks whether a player has won or not. If a player has not won, the function
    * resets the canvas for the next round
    * @param canvas     The given canvas
    * @param tank1      The tank controlled by player 1
    * @param tank2      The tank controlled by player 2
    */
   public void ballHitAPlayer(CanvasWindow canvas,Tank tank1, Tank tank2) {
       if (tank1.getHitDetection()||tank2.getHitDetection()) {
           gameManager.updateScores(tank1, tank2);
           gameManager.playerHasWon(canvas);
           gameManager.nextTurn(canvas,tank1,tank2);
       }
   }


   /**
    * Checks for player ball collision. If collision occurs, the tank and ball in collision are removed from the canvas.
    * @param canvas     The given canvas
    * @param tank1      The tank controlled by player 1
    * @param tank2      The tank controlled by player 2
    */
   public void ballPlayerCollision(CanvasWindow canvas,Tank tank1, Tank tank2) {
       int b = 0;
       while (b < allBalls.size()) {
           Ball ball = allBalls.get(b);
           GraphicsObject object = ballPlayerCollisionBoolean(canvas,ball);
           if (object != null) {
               if (object == tank1.getTankBody(canvas)) {
                   hitPlayer(canvas,ball,tank1);
                   removeAllBallsForNextTurn(canvas, tank1, tank2);
               }
               if (object == tank2.getTankBody(canvas)) {
                   hitPlayer(canvas,ball,tank2);
                   removeAllBallsForNextTurn(canvas, tank1, tank2);
               }
           }
           else {
               b++;
           }
       }
   }


   /**
    * Sets the tank's hit detection to true. Removes that singular ball in collision from it's respective Arraylists
    * @param canvas     The given canvas
    * @param ball       The ball that hit the tank
    * @param tank       The tank that collided with the ball
    */
   public void hitPlayer(CanvasWindow canvas, Ball ball, Tank tank) {
       tank.setHitDetection(true);
       tank.removeTank(canvas);
       canvas.remove(ball.getBallShape());
       allBalls.remove(ball);
       if (tank.getTankBalls().contains(ball)) {
           tank.getTankBalls().remove(ball);
       }
       else {
           tank.getTankBalls().remove(ball);
       }
       canvas.draw();
   }


  /**
   * Returns the tank image that collided with a ball if any collision occurred.
   * @param canvas   The given canvas
   * @param ball     The ball that is tested for collision
   */
   public GraphicsObject ballPlayerCollisionBoolean(CanvasWindow canvas, Ball ball) {
       Double ballDiameter = 2 * Ball.BALL_RADIUS;
       Ellipse ballShape = ball.getBallShape();
       GraphicsObject object = getBallCollidedImage(canvas,ballShape.getX(), ballShape.getY());
       if (object != null) {
           return object;
       }
       object = getBallCollidedImage(canvas, ballShape.getX() + (2 * Ball.BALL_RADIUS), ballShape.getY());
       if ( object != null) {
           return object;
       }
       object = getBallCollidedImage(canvas, ballShape.getX(), ballShape.getY() + ballDiameter);
       if (object != null) {
           return object;
       }
       object = getBallCollidedImage(canvas, ballShape.getX() + ballDiameter, ballShape.getY() + ballDiameter);
       if (object != null) {
           return object;
       }
       return null;
   }


   /**
   * Returns the Image that the ball has collided with. If any other graphics object collided with the ball, the function returns null.
   * @param canvas      The given canvas
   * @param x           The x-position of the ball
   * @param y           The y-position of the ball
   */
   public GraphicsObject getBallCollidedImage(CanvasWindow canvas, double x, double y) {
       if (canvas.getElementAt(x, y) != null && canvas.getElementAt(x, y) instanceof Image) {
           return canvas.getElementAt(x, y);
       }
       else {
           return null;
       }
   }


   /**
    * Removes all instances of all balls from every arraylist containing balls. 
    * Separate from hitPlayer because hitPlayer only removes one ball
    * @param canvas     The given canvas
    * @param tank1      The tank controlled by player 1
    * @param tank2      The tank controlled by player 2
    */
   public void removeAllBallsForNextTurn(CanvasWindow canvas,Tank tank1, Tank tank2) {
       for(Ball ball : allBalls) {
           canvas.remove(ball.getBallShape());
       }
       allBalls.clear();
       tank1.getTankBalls().clear();
       tank2.getTankBalls().clear();
   }


    @Override
    public String toString() {
        return "CollisionManager []";
    }

}
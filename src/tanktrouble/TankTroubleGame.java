package tanktrouble;


import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.events.Key;

import java.util.ArrayList;

/**
 * The game of TankTrouble!
 */
public class TankTroubleGame {
   private CanvasWindow canvas;
   private Tank player1, player2;
   private static CollisionManager collisionManager;
   private static GameManager gameManager;
   private ArrayList<Wall> wallList = new ArrayList<Wall>();

   private static final double startAngleP1 = 225;
   private static final double startAngleP2 = 45;
   public static final int CANVAS_WIDTH = 800;
   public static final int CANVAS_HEIGHT = 800;

   public TankTroubleGame() {
       canvas = new CanvasWindow("TANK TROUBLE!", CANVAS_WIDTH, CANVAS_HEIGHT);
       player1 = new Tank(canvas,startAngleP1, new Image(0,0,"RedTank2.0.png"), canvas.getWidth() * .175, canvas.getHeight() * .175);
       player2 = new Tank(canvas,startAngleP2, new Image(0,0,"BlueTank2.0.png"),canvas.getWidth() * .85, canvas.getHeight() * .85);
       collisionManager = new CollisionManager();
       gameManager = new GameManager();
       gameManager.startScreen(canvas,player1,player2);
   }


   public static void main(String[] args) {
       TankTroubleGame tankTrouble = new TankTroubleGame();
       tankTrouble.run();
   }

   
   public void run() {
       collisionManager.registerShoot(canvas,player1,Key.Q);
       collisionManager.registerShoot(canvas,player2,Key.M);
       canvas.animate((dt) -> {
           animateTanks(canvas,player1,player2,dt);
           animateBalls(canvas, player2, player1, wallList, dt);
           animateballCollision(canvas, player2, player1);
       });
   }
   

   /**
    * Animates and moves the tank.
    * @param dt double value increment of change in movement
    */
   public void animateTanks(CanvasWindow canvas,Tank tank1, Tank tank2,double dt) {
       gameManager.tankMoveVertical(canvas, 0.1,Key.E,Key.D,tank1);
       gameManager.tankRotate(canvas,0.1,Key.F,Key.S,tank1);
      
       gameManager.tankMoveVertical(canvas, 0.1,Key.UP_ARROW,Key.DOWN_ARROW,tank2);
       gameManager.tankRotate(canvas,0.1,Key.RIGHT_ARROW,Key.LEFT_ARROW,tank2);
   }


    /**
    * Animates and moves the ball.
    * @param dt     The increment of change in movement of the ball
    */
   public void animateBalls(CanvasWindow canvas,Tank tank1,Tank tank2,ArrayList<Wall> wallist,double dt) {
       gameManager.moveBalls(canvas, player1, wallList, dt);
       gameManager.moveBalls(canvas, player2, wallList, dt);
   }


    /**
    * Checks ball-player collision. If a ball-player collision occurs, it resets the round or presents a win screen.
    * @param dt     The increment of change in movement
    */
   public void animateballCollision(CanvasWindow canvas, Tank tank1, Tank tank2) {
       collisionManager.ballPlayerCollision(canvas, tank1, tank2);
       collisionManager.ballHitAPlayer(canvas, tank1, tank2);
   }


   /**
   * Returns the canvas's width.
   */
   public int getCanvasWidth() {
       return CANVAS_WIDTH;
   }


   /**
   * Returns the canvas's width.
   */
   public int getCanvasHeight() {
       return CANVAS_HEIGHT;
   }


   /**
   * Returns the canvas's width.
   */
   public CanvasWindow getCanvas() {
       return canvas;
   }
}
package tanktrouble;

import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.Image;

import java.util.ArrayList;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Point;

/**
 * The tank in the TankTrouble
 */
public class Tank {
    private ArrayList<Ball> Balls;
    private boolean hitPlayer;
    private int playerPoints;
    private double centerX, centerY;
    private double radius, angleRadians, angleDegrees;
    private double angleRadiansBall;
    private double turnSpeed;
    private Image tankBody;
    private final double tankSize;
    private final double movementSpeed;
    public static final double CANNON_LENGTH = 25;
    
    public Tank(CanvasWindow canvas, double angleDegrees, Image image, double centerX, double centerY) {
        tankSize = 30;
        radius = 0;
        movementSpeed = 50; 
        turnSpeed = 5;
        hitPlayer = false;

        this.centerX = centerX;
        this.centerY = centerY;

        tankBody = image;
        tankBody.setMaxHeight(tankSize);    
        tankBody.rotateBy(angleDegrees);

        this.angleDegrees = angleDegrees;
        angleRadians = Math.toRadians(angleDegrees);
        Balls = new ArrayList<>();
        
    }


    /**
     * Returns the central X Coordinate of the Tank
     */
    public double getCenterX() {
        return centerX;
    }


    /**
     * Returns the central Y Coordinate of the Tank
     */
    public double getCenterY() {
        return centerY;
    }


    /**
     * Return the width of the tank
     */
    public double getWidth() {
        return tankBody.getWidth();
    }

    
    /**
     * Returns the height of the tank
     */
    public double getHeight() {
        return tankBody.getHeight();
    }


    /**
     * Returns whether the tank has been hit by the ball
     */
    public boolean getHitDetection() {
        return hitPlayer;
    }


    /**
     * Sets the hit detection variable using an external parameter hit
     */
    public void setHitDetection(boolean hit) {
        hitPlayer = hit;
    }


    /**
     * Returns the center of the Tank as a Point
     */
    public Point getTankCannon() {
        angleRadiansBall = Math.toRadians(angleDegrees/(1045*Math.PI));
        return new Point(tankBody.getX() + Math.cos(angleRadiansBall) * (tankBody.getWidth()/2) ,
                         tankBody.getY() + Math.cos(angleRadiansBall) * (tankBody.getHeight()/2));
    }


    /**
     * Returns the angle in degrees of the tank
     */
    public double getAngleDegrees() {
        return Math.toDegrees(angleRadians);
    }


    /**
     * Sets the angle of the tank to newAngleDegrees
     * @param newAngleDegrees   Desired new value for angleDegrees
     */
    public double setAngleDegrees(double newAngleDegrees) {
        return newAngleDegrees;
    }


    /**
     * Sets tankBody's center point to the given x and y values
     * @param x sets centerX to x
     * @param y sets centerY to y
     */
    public void setTankPosition(double x, double y) {
        centerX=x;
        centerY=y;
        tankBody.setCenter(new Point(x, y));
    }


    /**
     * Returns the tank image from canvas
     * @param canvas    CanvasWindow object
     */
    public Image getTankBody(CanvasWindow canvas) {
        return tankBody;
    }


    /**
     * Returns the number of points the tank has earned
     */
    public int getPlayerPoints() {
        return playerPoints;
    }


    /**
     * Sets the number of points the tank has earned
     */
    public void setPlayerPoints(int newPoints) {
        playerPoints = newPoints;
    }


    /**
     * Adds the tank to canvas
     * @param canvas    CanvasWindow object
     */
    public void addTank(CanvasWindow canvas) {
        canvas.add(tankBody);
    }


    /**
     * Removes the tank from canvas
     * @param canvas    CanvasWindow object
     */
    public void removeTank(CanvasWindow canvas) {
        canvas.remove(tankBody);
    }


    /**
     * Gets the tank image from canvas
     * @param canvas    CanvasWindow object
     */
    public ArrayList<Ball> getTankBalls() {
        return Balls;
    }


    /**
     * Calculates the angle and rotates the tank to the right by said angle
     * Rotates the tank to the right
     * @param dt    The increment value for movement
     */
    public void rotateRight(double dt) {
        angleDegrees = angleDegrees + turnSpeed*dt*10;
        angleRadians = Math.toRadians(angleDegrees);
        tankBody.setRotation(angleDegrees);
    }
    

    /**
     * Rotates the tank to the left
     * @param dt    The increment value for movement
     */
    public void rotateLeft(double dt) {
        angleDegrees = angleDegrees - turnSpeed*dt*10;
        angleRadians = Math.toRadians(angleDegrees);
        tankBody.setRotation(angleDegrees);
    }


    /**
     * Moves the tank forwards
     * @param dt    The increment value for movement
     */
    public void moveUp(double dt) {
        radius = -movementSpeed * dt * 0.3;
    }


    /**
     * Moves the tank backwards
     * @param dt    The increment value for movement
     */
    public void moveDown(double dt) {
        radius = movementSpeed * dt * 0.3;
    }


    /**
     * Resets the center of tank's polar coordinates to the current center of the tank
     */
    public void setRadiusToZero() {
        radius = 0;
    }


    /**
     * Checks the points in the front of the tank to see if there is a wall touching the tank
     * @return returns true if there is an instance of a Rectangle/Wall and returns false if not
     * @param canvas    The given canvas
     */
    public boolean checkFront(CanvasWindow canvas) {
        if(checkEveryPointsInLine(canvas, centerX - 22 * Math.cos(angleRadians),centerY - 22 * Math.sin(angleRadians),centerX - 25 * Math.cos(angleRadians+0.7),centerY - 25 * Math.sin(angleRadians+0.7)) || 
           checkEveryPointsInLine(canvas, centerX - 22 * Math.cos(angleRadians),centerY - 22 * Math.sin(angleRadians),centerX - 25 * Math.cos(angleRadians-0.7),centerY - 25 * Math.sin(angleRadians-0.7)) ||
           checkFrontSide(canvas)) {
            return true;
        }
        else {
            return false;
        }
    }


     /**
     * Checks the back of the tank for a wall. If there is a wall, this function returns true
     * @param canvas    The given canvas
     */
    public boolean checkBack(CanvasWindow canvas) {
        return checkEveryPointsInLine(canvas, centerX + 27 * Math.cos(angleRadians+0.6),centerY + 27 * Math.sin(angleRadians+0.6), centerX + 27 * Math.cos(angleRadians-0.6),centerY + 27 * Math.sin(angleRadians-0.6));
    }

    /**
     * Checks the sides of the tank starting from the midpoint to the top corners of the tank. 
     * @return returns true if there is an instance of a Rectangle/Wall on those sides and returns false if not
     * @param canvas    The given canvas
     */
    public boolean checkFrontSide(CanvasWindow canvas) {
        if(checkEveryPointsInLine(canvas, centerX - 27 * Math.cos(angleRadians+0.6),centerY - 27 * Math.sin(angleRadians+0.6),centerX + 18 * Math.cos(angleRadians-1.3),centerY + 18 * Math.sin(angleRadians-1.3)) ||
            checkEveryPointsInLine(canvas, centerX - 18 * Math.cos(angleRadians-1.3),centerY - 18 * Math.sin(angleRadians-1.3),centerX - 27 * Math.cos(angleRadians-0.6),centerY - 27 * Math.sin(angleRadians-0.6))) {
            return true;
        }
        else {
            return false;
        }

    }

    /**
     * Checks if the line between two points (x1,y1) and (x2,y2) is an instance of a rectangle.  
     * 
     * @param canvas    The given canvas
     * @param x1        The first X Coordinate of the Line
     * @param y1        The first Y Coordinate of the Line
     * @param x2        The second X Coordinate of the Line
     * @param y2        The second Y Coordinate of the Line
     * @returns         True if the line is touching a rectangle
     */
    public boolean checkEveryPointsInLine(CanvasWindow canvas, double x1, double y1, double x2, double y2) {
        for(int i = 0; i<50;i++) {
            if(canvas.getElementAt(x1+i*((x2-x1)/50), y1+i*((y2-y1)/50)) instanceof Rectangle) {
                return true;
            }
        }
        return false;
    }

    /**
     * Updates the position of the Tank while moving. Converts polar coordinates to cartesian coordinates.
     */
    public void updatePosition(){
        centerX = centerX + radius * Math.cos(angleRadians);
        centerY = centerY + radius * Math.sin(angleRadians);
        tankBody.setCenter(centerX,centerY);
    }

    
    @Override
    public String toString() {
        return "Tank [Balls=" + Balls + ", centerX=" + centerX + ", centerY=" + centerY + ", tankSize=" + tankSize
            + ", radius=" + radius + ", angleRadians=" + angleRadians + ", angleDegrees=" + angleDegrees
            + ", angleRadiansBall=" + angleRadiansBall + ", movementSpeed=" + movementSpeed + ", turnSpeed=" + turnSpeed
            + ", tankBody=" + tankBody + "]";
    }
}
package tanktrouble;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import edu.macalester.graphics.CanvasWindow;

/**
 * Creates the maze of walls tanks have to navigate over to 
 */
public class MazeManager {
    private static ArrayList<Wall> wallList;
    private static List<List<Double>> coordinates;
    private double wallWidth = Wall.WALL_WIDTH;
    private double wallLength = Wall.WALL_LENGTH;

    public MazeManager() {}

    /** 
     * Sets up the maze by running through the list of wall coordinates and creating walls from it.
     * @param canvas    The given canvas
     */
    public static ArrayList<Wall> createMaze(CanvasWindow canvas) {
        wallList = new ArrayList<>();
        List<List<Double>> coordinateList = getCoordinates(canvas);
        for (List<Double> list : coordinateList) {
            Wall wall = new Wall(list.get(0), list.get(1), list.get(2), list.get(3));
            wall.setFillColor(new Color(255, 0, 0));
            wallList.add(wall);
        }
        return wallList;
    }


    /** 
     * Returns a list of lists containing the X and Y coordinates of the walls and the width and length.
     * @param canvas    The given canvas
     */
    public static List<List<Double>> getCoordinates(CanvasWindow canvas) {
        coordinates = new ArrayList<>();
        List<Double> w1 = List.of(canvas.getWidth() * 0.1, canvas.getHeight() * 0.1, Wall.WALL_WIDTH, Wall.WALL_LENGTH);
        coordinates.add(w1);
        List<Double> w2 = List.of(canvas.getWidth() * 0.3, canvas.getHeight() * 0.1, Wall.WALL_WIDTH, Wall.WALL_LENGTH);
        coordinates.add(w2);
        List<Double> w3 = List.of(canvas.getWidth() * 0.1, canvas.getHeight() * 0.2, Wall.WALL_WIDTH, Wall.WALL_LENGTH);
        coordinates.add(w3);
        List<Double> w4 = List.of(canvas.getWidth() * 0.2, canvas.getHeight() * 0.2, Wall.WALL_WIDTH, Wall.WALL_LENGTH);
        coordinates.add(w4);
        List<Double> w5 = List.of(canvas.getWidth() * 0.4, canvas.getHeight() * 0.2, Wall.WALL_WIDTH, Wall.WALL_LENGTH);
        coordinates.add(w5);
        List<Double> w6 = List.of(canvas.getWidth() * 0.6, canvas.getHeight() * 0.2, Wall.WALL_WIDTH, Wall.WALL_LENGTH);
        coordinates.add(w6);
        List<Double> w7 = List.of(canvas.getWidth() * 0.3, canvas.getHeight() * 0.3, Wall.WALL_WIDTH, Wall.WALL_LENGTH);
        coordinates.add(w7);
        List<Double> w8 = List.of(canvas.getWidth() * 0.4, canvas.getHeight() * 0.3, Wall.WALL_WIDTH, Wall.WALL_LENGTH);
        coordinates.add(w8);
        List<Double> w9 = List.of(canvas.getWidth() * 0.1, canvas.getHeight() * 0.4, Wall.WALL_WIDTH, Wall.WALL_LENGTH);
        coordinates.add(w9);
        List<Double> w10 = List.of(canvas.getWidth() * 0.3, canvas.getHeight() * 0.4, Wall.WALL_WIDTH, Wall.WALL_LENGTH);
        coordinates.add(w10);
        List<Double> w11 = List.of(canvas.getWidth() * 0.4, canvas.getHeight() * 0.4, Wall.WALL_WIDTH, Wall.WALL_LENGTH);
        coordinates.add(w11);
        List<Double> w12 = List.of(canvas.getWidth() * 0.2, canvas.getHeight() * 0.5, Wall.WALL_WIDTH, Wall.WALL_LENGTH);
        coordinates.add(w12);
        List<Double> w13 = List.of(canvas.getWidth() * 0.4, canvas.getHeight() * 0.5, Wall.WALL_WIDTH, Wall.WALL_LENGTH);
        coordinates.add(w13);
        List<Double> w14 = List.of(canvas.getWidth() * 0.5, canvas.getHeight() * 0.5, Wall.WALL_WIDTH, Wall.WALL_LENGTH);
        coordinates.add(w14);
        List<Double> w15 = List.of(canvas.getWidth() * 0.7, canvas.getHeight() * 0.5, Wall.WALL_WIDTH, Wall.WALL_LENGTH);
        coordinates.add(w15);
        List<Double> w16 = List.of(canvas.getWidth() * 0.2, canvas.getHeight() * 0.6, Wall.WALL_WIDTH, Wall.WALL_LENGTH);
        coordinates.add(w16);
        List<Double> w17 = List.of(canvas.getWidth() * 0.1, canvas.getHeight() * 0.7, Wall.WALL_WIDTH, Wall.WALL_LENGTH);
        coordinates.add(w17);
        List<Double> w18 = List.of(canvas.getWidth() * 0.3, canvas.getHeight() * 0.7, Wall.WALL_WIDTH, Wall.WALL_LENGTH);
        coordinates.add(w18);
        List<Double> w19 = List.of(canvas.getWidth() * 0.5, canvas.getHeight() * 0.7, Wall.WALL_WIDTH, Wall.WALL_LENGTH);
        coordinates.add(w19);
        List<Double> w20 = List.of(canvas.getWidth() * 0.2, canvas.getHeight() * 0.8, Wall.WALL_WIDTH, Wall.WALL_LENGTH);
        coordinates.add(w20);
        List<Double> w21 = List.of(canvas.getWidth() * 0.7, canvas.getHeight() * 0.1, Wall.WALL_WIDTH, Wall.WALL_LENGTH);
        coordinates.add(w21);
        List<Double> w22 = List.of(canvas.getWidth() * 0.7, canvas.getHeight() * 0.3, Wall.WALL_WIDTH, Wall.WALL_LENGTH);
        coordinates.add(w22);
        List<Double> w23 = List.of(canvas.getWidth() * 0.6, canvas.getHeight() * 0.7, Wall.WALL_WIDTH, Wall.WALL_LENGTH);
        coordinates.add(w23);
        List<Double> w24 = List.of(canvas.getWidth() * 0.8, canvas.getHeight() * 0.2, Wall.WALL_WIDTH, Wall.WALL_LENGTH); 
        coordinates.add(w24);
        List<Double> w25 = List.of(canvas.getWidth() * 0.8, canvas.getHeight() * 0.5, Wall.WALL_WIDTH, Wall.WALL_LENGTH); 
        coordinates.add(w25);
        List<Double> w26 = List.of(canvas.getWidth() * 0.8, canvas.getHeight() * 0.6, Wall.WALL_WIDTH, Wall.WALL_LENGTH); 
        coordinates.add(w26);
        List<Double> w27 = List.of(canvas.getWidth() * 0.1, canvas.getHeight() * 0.4, Wall.WALL_LENGTH, Wall.WALL_WIDTH); 
        coordinates.add(w27);
        List<Double> w28 = List.of(canvas.getWidth() * 0.2, canvas.getHeight() * 0.2, Wall.WALL_LENGTH, Wall.WALL_WIDTH); 
        coordinates.add(w28);
        List<Double> w29 = List.of(canvas.getWidth() * 0.2, canvas.getHeight() * 0.8, Wall.WALL_LENGTH * 2, Wall.WALL_WIDTH); 
        coordinates.add(w29);
        List<Double> w30 = List.of(canvas.getWidth() * 0.3, canvas.getHeight() * 0.6, Wall.WALL_LENGTH, Wall.WALL_WIDTH); 
        coordinates.add(w30);
        List<Double> w31 = List.of(canvas.getWidth() * 0.4, canvas.getHeight() * 0.2, Wall.WALL_LENGTH, Wall.WALL_WIDTH); 
        coordinates.add(w31);
        List<Double> w32 = List.of(canvas.getWidth() * 0.4, canvas.getHeight() * 0.7, Wall.WALL_LENGTH, Wall.WALL_WIDTH); 
        coordinates.add(w32);
        List<Double> w33 = List.of(canvas.getWidth() * 0.5, canvas.getHeight() * 0.4, Wall.WALL_LENGTH, Wall.WALL_WIDTH); 
        coordinates.add(w33);
        List<Double> w34 = List.of(canvas.getWidth() * 0.5, canvas.getHeight() * 0.6, Wall.WALL_LENGTH, Wall.WALL_WIDTH); 
        coordinates.add(w34);
        List<Double> w35 = List.of(canvas.getWidth() * 0.6, canvas.getHeight() * 0.3, Wall.WALL_LENGTH, Wall.WALL_WIDTH); 
        coordinates.add(w35);
        List<Double> w36 = List.of(canvas.getWidth() * 0.6, canvas.getHeight() * 0.4, Wall.WALL_LENGTH, Wall.WALL_WIDTH); 
        coordinates.add(w36);
        List<Double> w37 = List.of(canvas.getWidth() * 0.6, canvas.getHeight() * 0.5, Wall.WALL_LENGTH, Wall.WALL_WIDTH); 
        coordinates.add(w37);
        List<Double> w38 = List.of(canvas.getWidth() * 0.6, canvas.getHeight() * 0.8, Wall.WALL_LENGTH, Wall.WALL_WIDTH); 
        coordinates.add(w38);
        List<Double> w39 = List.of(canvas.getWidth() * 0.7, canvas.getHeight() * 0.7, Wall.WALL_LENGTH, Wall.WALL_WIDTH); 
        coordinates.add(w39);
        List<Double> w40 = List.of(canvas.getWidth() * 0.7, canvas.getHeight() * 0.8, Wall.WALL_LENGTH, Wall.WALL_WIDTH); 
        coordinates.add(w40);
        List<Double> w41 = List.of(canvas.getWidth() * 0.8, canvas.getHeight() * 0.4, Wall.WALL_LENGTH, Wall.WALL_WIDTH); 
        coordinates.add(w41);
        List<Double> bottomWall = List.of(canvas.getWidth() * 0.1, canvas.getHeight() * 0.9, canvas.getHeight() * 0.84, Wall.WALL_WIDTH * 4);
        coordinates.add(bottomWall);
        List<Double> topWall = List.of(canvas.getWidth() * 0.1, canvas.getHeight() * 0.1, canvas.getHeight() * 0.81, Wall.WALL_WIDTH * 4);
        coordinates.add(topWall);
        List<Double> leftWall = List.of(canvas.getWidth() * 0.1, canvas.getHeight() * 0.1, Wall.WALL_WIDTH * 4, canvas.getHeight() * 0.8);
        coordinates.add(leftWall);
        List<Double> rightWall = List.of(canvas.getWidth() * 0.9, canvas.getHeight() * 0.1, Wall.WALL_WIDTH * 4, canvas.getHeight() * 0.8);
        coordinates.add(rightWall);
      
        return coordinates;
    }


    /** 
     * @returns the list of coordinates of the maze's walls
     */
    public static List<List<Double>> getCoordinates() {
        return coordinates;
    }
    

    @Override
    public String toString() {
        return "MazeManager [wallList=" + wallList + ", coordinates=" + coordinates + ", wallWidth=" + wallWidth
            + ", wallLength=" + wallLength + "]";
    }
}

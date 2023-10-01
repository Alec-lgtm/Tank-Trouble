package tanktrouble;

import java.util.ArrayList;
import edu.macalester.graphics.Point;
import java.awt.Color;
import edu.macalester.graphics.Rectangle;

/**
 * The Wall in the game of TankTrouble
 */
public class Wall extends Rectangle {
   public static final double WALL_LENGTH = 80; 
   public static final double WALL_WIDTH = 6;

   public ArrayList<Point> listOfPoints = new ArrayList<Point>();
  
   public Wall(double x1, double y1, double wallWidth, double wallLength) {
       super(x1, y1, wallWidth, wallLength);
       setStrokeColor(Color.red);
   }
   

    @Override
    public String toString() {
        return "Wall [listOfPoints=" + listOfPoints + "]";
    }
}

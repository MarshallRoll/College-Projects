package breakout;

import edu.macalester.graphics.Rectangle;
import java.awt.Color;

public class Brick extends Rectangle {
    /**
     * Creates a brick that can redirect and be destroyed by a ball
     * @param x top left x-coordinate of initial position
     * @param y top left y-coordinate of initial position
     */
    public Brick(double x, double y, double width, double height, Color color) {
        super(x, y, width, height);
        setFillColor(color);
    }
    
}

package SpaceForce;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Point;
import edu.macalester.graphics.Rectangle;

/**
 * Authors: Curran Middleton, Ross Kogel, Marshall Roll
 * Macalester College
 * Professor Hillman
 * COMP-127
 */
public class SpaceLazer extends Rectangle{
    public final static double SIZE = 5;
    private final static double SPEED = 3;

    private double xPosition;
    private double yPosition;
    private double xSpeed;
    private double ySpeed;
    public double initialAngleRadians;
    private int maxXVal;
    private int maxYVal;

    /**
     * creates a SpaceLazer object (yes I know Im spelling laser wrong. I've committed at this point)
     *  @param canvasMaxX the maximum x-position for which the lazer can be on the canvas
     *  @param canvasMaxY the maximum y-position for which the lazer can be on the canvas
     *  @param spaceshipAngle the angle in degrees that the spaceship is facing
     */ 
    public SpaceLazer(double centerX, double centerY, int canvasMaxX, int canvasMaxY, CanvasWindow canvas, double spaceshipAngle) {
        super(0, 0, SIZE, SIZE);
        this.setCenter(centerX, centerY);
        this.setFillColor(Color.WHITE);

        xPosition = centerX;
        yPosition = centerY;
        maxXVal = canvasMaxX;
        maxYVal = canvasMaxY;

        initialAngleRadians = Math.toRadians(spaceshipAngle);
        xSpeed = SPEED * Math.cos(initialAngleRadians);   
        ySpeed = SPEED * Math.sin(initialAngleRadians);  
    }

    /**
     * checks to see if a space lazer intersects asteroid
     * @return true if space lazer object intersects an asteroid
     */
    public boolean intersects (CanvasWindow canvas, Asteroid asteroid) {
        if (canvas.getElementAt(getLeft()) == asteroid.getIcon(canvas) || canvas.getElementAt(getRight()) == asteroid.getIcon(canvas) ||
        canvas.getElementAt(getTop()) == asteroid.getIcon(canvas) || canvas.getElementAt(getBottom()) == asteroid.getIcon(canvas)) {
            return true;
        } else { 
            return false;
        }
    }

    
    /**
     * Getters
     */
    
    /**
     * gets the topmost point of the lazer rectangle
     */
    private Point getTop() {
        Point top = new Point(this.getX() + (this.getWidth() / 2), this.getY());
        return top;
    }

    /**
     * gets the bottom-most point of the lazer rectangle
     */
    private Point getBottom() {
        Point bottom = new Point(this.getX() + (this.getWidth() / 2), this.getY() + this.getHeight());
        return bottom;
    }
    
    /**
     * gets the leftmost point of the lazer rectangle
     */
    private Point getLeft() {
        Point left = new Point(this.getX(), this.getY() + (this.getHeight() / 2));
        return left;
    }

    /**
     * gets the rightmost point of the lazer rectangle
     */
    private Point getRight() {
        Point right = new Point(this.getX() + this.getWidth(), this.getY() + (this.getHeight() / 2));
        return right;
    }
    /**
     * gets the x-componant of the lazer's position
     */
    public double getCenterX() {
        return xPosition;
    }

    /**
     * gets the y-componant of the lazer's position
     */
    public double getCenterY() {
        return yPosition;
    }

    /**
     * gets the angle the lazer is traveling in.
     */
    public double getLazerAngle() {
        return initialAngleRadians;
    }

    /**
     * gets the shape of the lazer which extends rectangle
     */
    public Rectangle getLazerShape() {
        return this;
    }

    /**
     * checks whether the lazer is within the bounds of the canvas
     * @return true if spaceship is in bounds
     */
    public boolean isInBounds() {
        if ((0 < xPosition && xPosition < maxXVal) && (0 < yPosition && yPosition < maxYVal)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * updates the position of the lazer and manages its movement
     */
    public void updatePosition(CanvasWindow canvas) {
        xPosition += xSpeed*3;
        yPosition += ySpeed*3;

        if(isInBounds()) {
            this.setPosition(xPosition, yPosition);
        } else {
            this.setPosition(-1000, -1000);
        }
    }
    
}

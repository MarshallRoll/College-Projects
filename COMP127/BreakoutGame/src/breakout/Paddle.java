package breakout;

import edu.macalester.graphics.Rectangle;

/**
 * Paddle which can redirect ball when it hits
 */
public class Paddle extends Rectangle {

    public static final double PADDLE_LENGTH = 30;
    public static final double PADDLE_HEIGHT = 10;
    public static final double Y_POSITION = 640;
    private static final double SPEED = 7; 
    
    private double positionX, maxXposition; 

    /**
     * Creates a paddle that can redirect the ball toward bricks
     * @param x1 top left x-coordinate of initial position
     * @param y1 top left y-coordinate of initial position
     * @param maxX the maximum x position for which the paddle will remain in bounds
     */
    public Paddle(double x1, double y1, double width, double height, double maxX) {
        super(x1, y1, width, height);
        maxXposition = maxX;
    }

     /**
     * tests to see if paddle is in bounds of canvas
     * @return true if paddle is in bound on canvas' left side
     */
    public boolean isInBoundsNear() {
        if (this.getCenter().getX() < 0) {
            return false;
        } 
        else {
            return true;
        }
    }

    /**
     * tests to see if paddle is in bounds of canvas
     * @return true if paddle is in bound on canvas' right side
     */
    public boolean isInBoundsFar() {
        if (this.getCenter().getX() > maxXposition) {
            return false;
        } 
        else {
            return true;
        }
    }

    /**
     * moves the paddle to the left
     * @return true if position can be updated left
     */
    public boolean updatePositionLeft() {
        double newPositionX = this.getCenter().getX() - SPEED;
        if (isInBoundsNear()) {
               
            positionX = newPositionX;
            this.setCenter(positionX, Y_POSITION);

            return true;
        }
        else {
            return false;
        }
    }

    /**
     * moves the paddle to the right
     * @return true if position can be updated right
     */
    public boolean updatePositionRight() {
        double newPositionX = this.getCenter().getX() + SPEED;
        if (isInBoundsFar()) {

            positionX = newPositionX;
            this.setCenter(positionX, Y_POSITION);

            return true;
        }
        else {
            return false;
        }
    }

    /**
     * @return paddle's x-position
     */
    public double getXPosition() {
        return getX();
    }

    
}

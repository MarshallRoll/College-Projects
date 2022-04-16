package breakout;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.GraphicsObject;

/**
 * Ball which can destroy bricks and be hit by paddle
 */
public class Ball extends Ellipse {
    public static final double BALL_RADIUS = 3;
    private double xVelocity;
    private double yVelocity; 
    
    private double positionX, positionY, maxXposition, maxYposition; 
        
    /**
     * Creates a ball with a given center, initial angle, and maximum position
     * @param centerX x-coordinate of the center of the ball's initial position
     * @param centerY y-coordinate of the center of the ball's initial position
     * @param angle the initial angle at which ball will go, negative toward paddle
     * @param maxX the maximum x position for which the ball will be in bounds
     * @param maxY the maximum y position for which the ball will be in bounds
     */
    public Ball(
        double centerX,
        double centerY,
        double angle,
        double maxX,
        double maxY) {
            
        super(centerX, centerY, BALL_RADIUS*2, BALL_RADIUS*2);
        this.setFilled(true);
        positionX = centerX;
        positionY = centerY;
        double angleRadians = Math.toRadians(angle);
        xVelocity = 3 * Math.cos(angleRadians);
        yVelocity = 3 * -Math.sin(angleRadians);

        maxXposition = maxX;
        maxYposition = maxY;
    }


    /**
     * Gets the center x position of the cannonball
     */
    public double getCenterX() {
        return positionX;
    }

    /**
     * Gets the center y position of the cannonball
     */
    public double getCenterY() {
        return positionY;
    }

    /**
     * Update the cannon ball's position if it is in bounds
     * @return true if the ball is in within the maxXBound and maxYBound
     */
    public void updatePosition() {
        double newPositionX = positionX + xVelocity;
        double newPositionY = positionY + yVelocity;
        if (!testHitXWall() && !testHitYWall()){
            positionX = newPositionX;
            positionY = newPositionY;
            this.setCenter(positionX, positionY);
        }
        else {
            redirectBallFromWall();
        }
    }
    
    /**
     * Checks to see if the ball hits the vertical walls
     *
     * @return true if ball intersects wall
     */
    public boolean testHitXWall() {
        if (getCenterX() < BALL_RADIUS || 
            getCenterX() > maxXposition - BALL_RADIUS) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Checks to see if the ball hits the upper horizontal wall
     *
     * @return true if ball intersects wall
     */
    public boolean testHitYWall() {
        if (getCenterY() < BALL_RADIUS) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Checks to see if the ball is out of bounds
     *
     * @return true if ball intersects wall
     */
    public boolean testOutOfBounds() {
        if (getCenterY() > maxYposition - BALL_RADIUS) {
            return true;
        }
        else {
            return false;
        }
    }


    /**
     * Checks to see if the ball hits the paddle
     *
     * @param paddle
     * @param canvas
     * @return true if ball intersects paddle
     */
    public boolean testHitPaddle(Paddle paddle, CanvasWindow canvas) {
        GraphicsObject midpointBottom = canvas.getElementAt(this.getCenterX(), this.getCenterY() - BALL_RADIUS - 1);
        GraphicsObject midpointRight = canvas.getElementAt(this.getCenterX() + BALL_RADIUS + 1, this.getCenterY());
        GraphicsObject midpointTop = canvas.getElementAt(this.getCenterX(), this.getCenterY() + BALL_RADIUS + 1);
        GraphicsObject midpointLeft = canvas.getElementAt(this.getCenterX() - BALL_RADIUS - 1, this.getCenterY());
    
        if (midpointLeft == paddle || midpointTop == paddle || midpointBottom == paddle || midpointRight == paddle) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Checks to see if the ball hits the brick
     *
     * @param brick
     * @param canvas
     * @return true if ball intersects brick
     */
    public boolean testHitBrick(Brick brick, CanvasWindow canvas) {
        GraphicsObject midpointBottom = canvas.getElementAt(this.getCenterX(), this.getCenterY() - BALL_RADIUS - 1);
        GraphicsObject midpointRight = canvas.getElementAt(this.getCenterX() + BALL_RADIUS + 1, this.getCenterY());
        GraphicsObject midpointTop = canvas.getElementAt(this.getCenterX(), this.getCenterY() + BALL_RADIUS + 1);
        GraphicsObject midpointLeft = canvas.getElementAt(this.getCenterX() - BALL_RADIUS - 1, this.getCenterY());
    
        if (midpointLeft == brick || midpointTop == brick || midpointBottom == brick || midpointRight == brick) {
            return true;
        }
        else {
            return false;
        }
    }

     /**
     * Redirects the ball
     */
    public void redirectBall() {
        double newPositionX = positionX + xVelocity;
        double newPositionY = positionY + yVelocity;

        positionX = newPositionX;
        positionY = newPositionY;
        this.setCenter(positionX, positionY);
    }

    /**
     * Redirects the ball when it hits a wall
     */
    public void redirectBallFromWall() {
        if (testHitXWall()) {
            xVelocity *= -1;
        } else if (testHitYWall()) {
            yVelocity *= -1;
        }
        
        redirectBall();
    }

    /**
     * Redirects the ball when it hits the paddle
     */
    public void redirectBallFromPaddle() {
        yVelocity *= -1;
        redirectBall();
    }

}

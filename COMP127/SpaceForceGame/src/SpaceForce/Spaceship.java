package SpaceForce;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Point;

/**
 * Authors: Curran Middleton, Ross Kogel, Marshall Roll
 * Macalester College
 * Professor Hillman
 * COMP-127
 */
public class Spaceship {
    private Image icon; 
    private double positionX, positionY, maxXposition, maxYposition; 
    private boolean onCanvas;

    /**
     * 
     * @param centerX 
     * @param centerY
     * @param maxX maximum x position to which spaceship can travel
     * @param maxY maximum y position to which spaceship can travel
     */
    public Spaceship(
        double centerX,
        double centerY,
        double maxX,
        double maxY) {
        
        icon = new Image(centerX, centerY);
        icon.setCenter(centerX, centerY); 
        icon.setMaxWidth(50);
        icon.setMaxHeight(50);

        icon.setImagePath(getSpaceshipIcon());
        positionX = centerX;
        positionY = centerY;
        this.maxXposition = maxX;
        this.maxYposition = maxY;

        onCanvas = false;
    }

    /**
     * Moves the spaceship on the canvas by a factor of 12-pixel increments, taking into account
     * given velocities (doubles)
     */
    public void updatePosition(double xVelocity, double yVelocity) {
        positionX += 6 * xVelocity;
        positionY += 6 * yVelocity;
               
        icon.setCenter(positionX, positionY);
    }

    /**
     * Moves the spaceship negative in the y-direction 
     */
    public void moveForward() {
        updatePosition(0, -1);
    }

     /**
     * Moves the spaceship positive in the y-direction 
     */
    public void moveBackward() {
        updatePosition(0, 1);
    }

     /**
     * Moves the spaceship negative in the x-direction 
     */
    public void moveLeft() {
        updatePosition(-1, 0);
    }

     /**
     * Moves the spaceship positive in the x-direction 
     */
    public void moveRight() {
        updatePosition(1, 0);
    }

    /**
     * Adds the spaceship icon to the given canvas
     */
    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(icon);
        onCanvas = true;
    }

    //checks whether the spaceship is on the canvas
    public boolean onCanvas() {
        return onCanvas;
    }

     /**
     * Tests to see if spaceship is in bounds of left side of canvas, and sets the position
     * to the opposite side of the canvas if it is not
     */
    private boolean isInBoundsNear() {
        if (this.getCenterX() < 0) {
            icon.setCenter(maxXposition, positionY);
            positionX = maxXposition;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Tests to see if spaceship is in bounds of right side of canvas, and sets the position
     * to the opposite side of the canvas if it is not
     */
    private boolean isInBoundsFar() {
        if (this.getCenterX() > maxXposition) {
            icon.setCenter(0, positionY);
            positionX = 0;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Tests to see if spaceship is in bounds of the upper side of canvas, and sets the position
     * to the opposite side of the canvas if it is not
     */
    private boolean isInBoundsTop() {
        if (this.getCenterY() < 0) {
            icon.setCenter(positionX, maxYposition);
            positionY = maxYposition;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Tests to see if spaceship is in bounds of the lower side of canvas, and sets the position
     * to the opposite side of the canvas if it is not
     */
    private boolean isInBoundsBottom() {
        if (this.getCenterY() > maxYposition) {
            icon.setCenter(positionX, 0);
            positionY = 0;
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return true if spaceship is in bounds of the canvas
     */
    public boolean isInBounds() {
        if (isInBoundsBottom() ||
            isInBoundsFar() ||
            isInBoundsNear() ||
            isInBoundsTop()) {
                return true;
            } else {
                return false;
            }
     }

    /**
     * Rotates the spaceship icon by a given angle in degrees (double)
     */
    public void rotateSpaceship(double angle) {
        icon.setRotation(angle);
    }

    /**
     * gets the icon of the spaceship from the project's icons folder
     */
    private String getSpaceshipIcon() {
        return "icons/pixel_spaceship.png";
    }

    /**
     * sets the spaceship's icon to an explosion image
     */
    public Image setExplosionIcon(CanvasWindow canvas, String imagePath) {
        icon.setImagePath(imagePath);
        return icon;
    }

    /** 
     * gets the height of the spaceship icon
     */
    public double getImageHeight() {
        return icon.getHeight();
    }

    /**
     * gets the width of the spaceship icon
     */
    public double getImageWidth() {
        return icon.getImageWidth();
    }
    
    /**
     * @return spaceship's center x-position
     */
    public double getCenterX() {
        return positionX;
    }

     /**
     * @return spaceship's center y-position
     */
    public double getCenterY() {
        return positionY;
    }

    /**
     * @return angle the spaceship is facing, in degrees
     */
    public double getSpaceshipAngle() {
        return icon.getRotation() - 90;
    }

    /**
     * sets the position of the spaceship
     * @param x center x-coordinate of the spaceship
     * @param y center y-coordinate of the spaceship
     */
    public void setPosition(double x, double y) {
        positionX = x;
        positionY = y;
    }

    /**
     * removes the spaceship from the canvas
     */
    public void removeFromCanvas(CanvasWindow canvas) {
        if (onCanvas)
            canvas.remove(icon);
            onCanvas = false;
    }

    /**
     * @return true if the spaceship has intersected an asteroid. 
     */
    public boolean intersects(CanvasWindow canvas, Asteroid asteroid) {
        if (canvas.getElementAt(getBottomRight()) == asteroid.getIcon(canvas) || 
            canvas.getElementAt(getCenter()) == asteroid.getIcon(canvas) ||
            canvas.getElementAt(getTop()) == asteroid.getIcon(canvas) || 
            canvas.getElementAt(getBottom()) == asteroid.getIcon(canvas) ||
            canvas.getElementAt(getBottomLeft()) == asteroid.getIcon(canvas)) {
            return true;
        } else { 
            return false;
        }
    }

    /**
     * Getters for crucial points on the spaceship including the top, bottom, left, right, bottomright, and the center point
     */
    public Point getTop() {
        Point top = new Point(icon.getX() + (icon.getWidth() / 2), icon.getY());
        return top;
    }

    public Point getBottomLeft() {
        Point bottomLeft = new Point(icon.getX(), icon.getY() + icon.getHeight() - 5);
        return bottomLeft;
    }

    public Point getBottom() {
        Point bottom = new Point(icon.getX() + (icon.getWidth() / 2), icon.getY() + icon.getHeight() - 5);
        return bottom;
    }

    public Point getBottomRight() {
        Point bottomRight = new Point(icon.getX() + icon.getWidth(), icon.getY() + icon.getHeight() - 5);
        return bottomRight;
    }

    public Point getCenter() {
        Point center = new Point(icon.getX() + (icon.getWidth() / 2), icon.getY() + (icon.getHeight() / 2));
        return center;
    }
}

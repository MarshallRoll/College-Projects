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
public class Asteroid {
    public Image icon;
    private double speedX;
    private double speedY;
    private boolean isInBounds;
    private int maxXPosition, maxYPosition;

    /**
     * creates an asteroid
     * @param x the x coordinate of the initial center position
     * @param y the y coordinate of the initial center position
     * @param diameter
     * @param maxX the maximum x-position to which the asteroid can move
     * @param maxY the maximum y-position to which the asteroid can move
     * @param directionInDegrees the initial direction the asteroid will move
     * @param speed
     * @param size a scaling factor to adjust the size of the asteroid
     */
    public Asteroid(double x, double y, double diameter, int maxX, int maxY, double directionInDegrees, double speed, double size) {
        icon = new Image(x, y);
        icon.setCenter(x, y); 
        icon.setMaxWidth(100 - size);
        icon.setMaxHeight(100 - size);
        icon.setImagePath(getAsteroidIcon());

        speedX = speed * (Math.cos(Math.toRadians(directionInDegrees)));
        speedY = speed * (Math.sin(Math.toRadians(directionInDegrees)));

        isInBounds = true;
        maxXPosition = maxX;
        maxYPosition = maxY;
    }

    /**
     * gets the icon for the asteroid in the projects icons folder
     */
    private String getAsteroidIcon() {
        return "icons/asteroidImagePixel.png";
    }
    
    /**
     * checks whether an asteroid's x coordinate is in bounds
     */
    private boolean isInBoundsX() {
        if (getLeft().getX() < 0 || getLeft().getX() > maxXPosition) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * checks whether an asteroid's y coordinate is in bounds
     */
    private boolean isInBoundsY() {
        if (getBottom().getY() < 0 || getBottom().getY() > maxYPosition) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * uses isInBoundsX() and isInBoundsY() to determine whether the asteroid is within the bounds of the canvas
     */
    public boolean isInBounds() {
        if (!isInBoundsX() || !isInBoundsY()) {
            isInBounds = false;
        } else {
            isInBounds = true;
        }
        return isInBounds;
    }
    
    /**
     * gets the Bottom point of the asteroid
     */
    private Point getBottom() {
        Point bottom = new Point(icon.getX() + (icon.getWidth() / 2), icon.getY() + icon.getHeight());
        return bottom;
    }

    /**
     * gets the left point of the asteroid
     */
    private Point getLeft() {
        Point left = new Point(icon.getX(), icon.getY() + (icon.getHeight() / 2));
        return left;
    }
    
    /**
     * gets the asteroid's speed in the x-direction
     */
    public double getSpeedX() {
        return speedX;
    }

    /**
     * gets the asteroid's speed in the y-direction
     */    
    public double getSpeedY() {
        return speedY;
    }

    /**
     * gets the center poiint of the asteroid using its coordinates, width, and height
     */
    public Point getCenter() {
        Point center = new Point(icon.getX() + (icon.getWidth() / 2), icon.getY() + icon.getHeight());
        return center;
    }
    
    /**
     * reflects the asteroids x coordinate when it goes out of bounds in the x direction so that the asteroid return to the other side of the canvas
     */
    private void reflectX() {
        if (icon.getX() > maxXPosition) {
            icon.setX(0);
        } else {
            icon.setX(maxXPosition);
        }
    }

    /**
     * reflects the asteroid's y coordinate when it goes out of bounds in the y direction so that the asteroid reutnrs to the other side of the canvas.
     */
    private void reflectY() {
        if (getBottom().getY() > maxYPosition) {
            icon.setY(0);
        } else {
            icon.setY(maxYPosition - icon.getHeight());
        }
    }

    /**
     * manages the movement of the asteroid, reflecting the asteroid if it is not in bounds
     */
    public void updatePosition() {
        icon.setX(icon.getX() + speedX);
        icon.setY(icon.getY() + speedY);
        if (!(isInBoundsX())) {
            reflectX();
        }
        if (!(isInBoundsY())) {
            reflectY();
        }
    }

    /**
     * Adds the asteroid icon to the given canvas
     */
    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(icon);
    }

    /**
     * Removes the asteroid icon from the canvas
     */
    public void removeFromCanvas(CanvasWindow canvas) {
        canvas.remove(icon);
    }

    /**
     * gets the icon of the asteroid on the canvas.
     */
    public Image getIcon(CanvasWindow canvas) {
        return icon;
    }

    /**
     * sets the asteroid's icon to an explosion image
     */
    public Image setExplosionIcon(CanvasWindow canvas) {
        icon.setImagePath("icons/AsteroidExplosion_1.png");
        return icon;
    }
}
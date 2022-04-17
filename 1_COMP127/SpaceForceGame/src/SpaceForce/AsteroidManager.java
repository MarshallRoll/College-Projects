package SpaceForce;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.macalester.graphics.CanvasWindow;

/**
 * Authors: Curran Middleton, Ross Kogel, Marshall Roll
 * Macalester College
 * Professor Hillman
 * COMP-127
 */
public class AsteroidManager {
    private List<Asteroid> enemyAsteroids;
    private Random rand;
    private int maxXPosition, maxYPosition;


    /**
     * @param maxX the maximum x-position to which asteroids can move on the canvas
     * @param maxY the maximum y-position to which asteroids can move on the canvas
     */
    public AsteroidManager(int maxX, int maxY) {
        enemyAsteroids = new ArrayList<>();
        rand = new Random();

        maxXPosition = maxX;
        maxYPosition = maxY;
    }

    /**
     * sets the initial X coordinate of each asteroid
     */
    private int setInitialX() {
        int initialX = rand.nextInt(maxXPosition);
        if (initialX >= 200 || initialX <= 600) {
            return initialX;
        } else {
            List<Integer> spawnList = new ArrayList<>();
            spawnList.add(0);
            spawnList.add(150);
            spawnList.add(750);
            spawnList.add(800);
            int position = rand.nextInt(3);
            return spawnList.get(position);
        }
    }

    /**
     * sets the initial Y coordinate of each asteroid
     */
    private int setInitialY() {
        int initialY = rand.nextInt(maxYPosition);
        if (initialY <= 200 || initialY >= 600) {
            return initialY;
        } else {
            List<Integer> spawnList = new ArrayList<>();
            spawnList.add(0);
            spawnList.add(150);
            spawnList.add(750);
            spawnList.add(800);
            int position = rand.nextInt(3);
            return spawnList.get(position);
        }
    }
    /**
     * generates a series of asteroids and adds them to a list
     * @return list of all asteroids
     */
    public List<Asteroid> generateAsteroids(CanvasWindow canvas, int numberOfAsteroids) {
        enemyAsteroids.clear();
        for (int i = 0; i < numberOfAsteroids; i++) {
    
        Asteroid asteroid = new Asteroid(setInitialX(), setInitialY(), 20, maxXPosition, maxYPosition, rand.nextInt(360), rand.nextInt(4) + 1, rand.nextInt(50));
            asteroid.addToCanvas(canvas);
            enemyAsteroids.add(asteroid);
        }         
        return enemyAsteroids;
    }


    /**
     * @return true if an asteroid has been hit by a lazer.
     */
    public boolean testHit(CanvasWindow canvas, SpaceLazer lazer) {
        for (Asteroid a : enemyAsteroids) {
            if(lazer.intersects(canvas, a)) {
                breakAsteroid(canvas, a);
                return true;
            }
        }
        return false;
    }

    /**
     * @return true if the spaceship has collided with one of the asteroids in the enemyAsteroids list
     * then runs the spaceship through it's death animation before reseting the spaceship.
     */
    public boolean testHitSpaceship(CanvasWindow canvas, Spaceship spaceship) {
        for (Asteroid a : enemyAsteroids) {
            if(spaceship != null) {
                if(spaceship.intersects(canvas, a)) {
                    //start of animation
                    canvas.pause(25);
                    spaceship.setExplosionIcon(canvas, "icons/SpaceshipEx1.jpg");
                    canvas.draw();
                    canvas.pause(25);
                    spaceship.setExplosionIcon(canvas, "icons/SpaceshipEx2.jpg");
                    canvas.draw();
                    canvas.pause(25);
                    spaceship.setExplosionIcon(canvas, "icons/SpaceshipEx3.jpg");
                    canvas.draw();
                    canvas.pause(25);
                    spaceship.setExplosionIcon(canvas, "icons/SpaceshipEx4.jpg");
                    canvas.draw();
                    canvas.pause(75);
                    spaceship.setExplosionIcon(canvas, "icons/SpaceshipEx5.png");
                    canvas.draw();
                    canvas.pause(200);
                    spaceship.setExplosionIcon(canvas, "icons/SpaceshipEx6.png");
                    canvas.draw();
                    canvas.pause(75);
                    spaceship.setExplosionIcon(canvas, "icons/SpaceshipEx7.png");
                    canvas.draw();
                    canvas.pause(100);
                    spaceship.setExplosionIcon(canvas, "icons/SpaceshipEx8.png");
                    canvas.draw();
                    canvas.pause(200);
                    //end of animation

                    spaceship.setPosition(0, 0);
                    spaceship.removeFromCanvas(canvas);
                    return true;
                }
            }
        }
        return false;
    }
    
    
    /**
     * breaks a given asteroid, displaying an explosion and removing it from the canvas and list of asteroids
     */
    private void breakAsteroid(CanvasWindow canvas, Asteroid a) {
        a.setExplosionIcon(canvas);
        canvas.draw();
        canvas.pause(100); 
        a.removeFromCanvas(canvas);
        enemyAsteroids.remove(a);
    }

    /**
     * removes all asteroids from the canvas and the list
     */
    public void removeAllAsteroids() {
        for (int i = 0; i < enemyAsteroids.size(); i++) {
            enemyAsteroids.remove(i);
        } 
    }

    /**
     * @return true if asteroids are still on canvas
     */
    public boolean asteroidsStillExist() {
        if (enemyAsteroids.size() == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * gets an asteroid at an index in the enemyAsteroids list
     */
    public Asteroid getAsteroid(int asteroidIndex) {
        Asteroid finessedAsteroid = enemyAsteroids.get(asteroidIndex);
        return finessedAsteroid;
    }
    
    /**
     * returns the length of the list of asteroids
     */
    public int getNumberofAsteroids() {
        return enemyAsteroids.size();
    }
}
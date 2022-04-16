package SpaceForce;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.events.Key;
import edu.macalester.graphics.ui.Button;

/**
 * Authors: Curran Middleton, Ross Kogel, Marshall Roll
 * Macalester College
 * Professor Hillman
 * COMP-127
 * 12/17/21 COMPLETED AND READY TO BE GRADED
 */
public class SpaceForceGame {
    private static final int CANVAS_WIDTH = 650;
    private static final int CANVAS_HEIGHT = 650;

    private CanvasWindow canvas;
    private Spaceship spaceship;
    private AsteroidManager asteroidManager;
    private SpaceLazer lazer;
    private List<SpaceLazer> lazerList;
    private Button playAgain;
    private Button exit;
    private boolean movingForward, movingLeft, movingRight, movingBackward;
    private int numberOfAsteroids;
    private int lives;
    private int level;
    private boolean animating;

    /**
     * Constructor for Space Force Game
     */
    public SpaceForceGame() {
        canvas = new CanvasWindow("Space Force Game", CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.setBackground(Color.BLACK);

        numberOfAsteroids = 2;
        asteroidManager = new AsteroidManager(CANVAS_WIDTH, CANVAS_HEIGHT);

        animating = true;
        lives = 3; 
        level = 0;

        movingForward = false;
        movingBackward = false;
        movingLeft = false;
        movingRight = false;

    }

    /**
     * method to remove objects from the canvas and update the canvas with no objects
     */
    private void removeObjects() {
        asteroidManager.removeAllAsteroids();
        canvas.removeAll();
        canvas.draw();
    }

    /**
     * method for repeating the previous level should the player die in that level.
     */
    private void repeatLevel() {
        lives--;
        GraphicsText livesLeft = new GraphicsText("You have " + lives + " lives left.");
        livesLeft.setFillColor(Color.WHITE);
        livesLeft.setFontSize(35);
        if (lives == 1) {
            livesLeft.setText("You have " + lives + " life left.");
        }
        livesLeft.setCenter(CANVAS_WIDTH * 0.5, CANVAS_HEIGHT * 0.6);

        canvas.add(livesLeft);
        canvas.draw();
        canvas.pause(3500);
        canvas.draw();
        canvas.remove(livesLeft);
    }

    /**
     * method for starting the game in a new level if the player destorys all of the asteroid in that level.
     */
    private void newLevel() {
        level++;
        canvas.draw();
        GraphicsText levelText = new GraphicsText("Level " + level);
        levelText.setFillColor(Color.WHITE);
        levelText.setFontSize(45);
        levelText.setCenter(CANVAS_WIDTH * 0.5, CANVAS_HEIGHT * 0.5);

        GraphicsText livesLeft = new GraphicsText("You have " + lives + " lives left.");
        livesLeft.setFillColor(Color.WHITE);
        livesLeft.setFontSize(35);
        if (lives == 1) {
            livesLeft.setText("You have " + lives + " life left.");
        }
        livesLeft.setCenter(CANVAS_WIDTH * 0.5, CANVAS_HEIGHT * 0.6);

        canvas.add(levelText);
        canvas.add(livesLeft);
        canvas.draw();
        canvas.pause(3500);
        canvas.draw();
        canvas.remove(levelText);
        canvas.remove(livesLeft);
        spaceship = new Spaceship(400, 400, CANVAS_WIDTH, CANVAS_HEIGHT);
        spaceship.moveBackward();
        spaceship.addToCanvas(canvas);
        asteroidManager.generateAsteroids(canvas, numberOfAsteroids + level * 2);
    }
    
    /** 
     * resets the game and clears the canvas
     */
    private void resetGame() {
        if (lives == 0) {
            animating = false;
            avengersEndGame();
        } else {
            spaceship = new Spaceship(400, 400, CANVAS_WIDTH, CANVAS_HEIGHT);
            spaceship.moveBackward();
            spaceship.addToCanvas(canvas);
            asteroidManager.generateAsteroids(canvas, numberOfAsteroids + level * 2);
        }        
    }

    /**
     * restarts the game after the player dies if they want to continue playing
     */
    private void restartGame() {
        animating = true;
        lives = 3;
        level = 1;
        canvas.remove(playAgain);
        canvas.remove(exit);
        canvas.removeAll();
        resetGame();
    }

    /**
     * ends the game once the player has lost all of their lives and dies.
     */
    private void avengersEndGame() {
        GraphicsText gameOverText = new GraphicsText("Game Over. You reached Level " + level );
        gameOverText.setFillColor(Color.WHITE);
        gameOverText.setFontSize(30);
        gameOverText.setCenter(CANVAS_WIDTH * 0.5, CANVAS_HEIGHT * 0.5);
        canvas.add(gameOverText);
        canvas.draw();

        playAgain = new Button("Play Again");
        canvas.add(playAgain);
        playAgain.setPosition(CANVAS_WIDTH * 0.5 - playAgain.getWidth(), CANVAS_HEIGHT * 0.6);
        playAgain.onClick(() -> restartGame());

        exit = new Button("Exit");
        canvas.add(exit);
        exit.setPosition(CANVAS_WIDTH * 0.5 + playAgain.getWidth(), CANVAS_HEIGHT * 0.6);
        exit.onClick(() -> endGame());
    }

    /**
     * ends the game once the "exit" button has been clicked.
     */
    private void endGame() {
        asteroidManager.removeAllAsteroids();
        canvas.removeAll();
        canvas.closeWindow();
        System.out.println("Thanks for Playing!");
    }

    /**
     * Moves the spaceship with W, A, S, and D keys.
     */
    private void moveSpaceship() {
        canvas.onKeyDown(event -> {
            if (event.getKey() == Key.W) {
                    movingForward = true;
                    spaceship.rotateSpaceship(0);
                    spaceship.moveForward();
                } 
            
            if (event.getKey() == Key.S) {
                movingBackward = true; 
                spaceship.rotateSpaceship(180);
                spaceship.moveBackward();
            }

            if (event.getKey() == Key.A) {
                movingLeft = true;
                spaceship.rotateSpaceship(270);
                spaceship.moveLeft();
            }

            if (event.getKey() == Key.D) {
                movingRight = true; 
                spaceship.rotateSpaceship(90);
                spaceship.moveRight();
            }
        }); 

        canvas.onKeyUp(event -> {
            if (event.getKey() == Key.W) {
                    movingForward = false;
                }
            
            if (event.getKey() == Key.S) {
                movingBackward = false;
            }

            if (event.getKey() == Key.A) {
                movingLeft = false;
            }

            if (event.getKey() == Key.D) {
                movingRight = false;
            }
        }); 
    }

    
    /**
     * Creates and moves a lazer when the spacebar is pressed.
     */
    private void lazerBlast() {
        lazerList = new ArrayList<>();
        canvas.onKeyDown(event -> {
            if (event.getKey() == Key.SPACE) {
                lazer = new SpaceLazer(spaceship.getCenterX(), spaceship.getCenterY(), CANVAS_WIDTH, CANVAS_HEIGHT, canvas, spaceship.getSpaceshipAngle());
                lazerList.add(lazer);
                canvas.add(lazer);
            } 
        });
    }

    /**
     * manages the lazers on the canvas, updates their positions, and checks whether they have collided with an asteroid.
     */
    private void lazerManager() {
        if (lazerList != null) {
            for (SpaceLazer lazer : lazerList) {
                asteroidManager.testHit(canvas, lazer);
                lazer.updatePosition(canvas);
            }
        }
    }
   
     /**
     * Animates objects on canvas
     */
    private void animate() {
        if (animating) {
            moveSpaceship();
            lazerBlast();
            newLevel();
        }

        canvas.animate( 
            () -> 
            {
                if (animating) {
                    for (int i = 0; i < asteroidManager.getNumberofAsteroids(); i++) {
                        asteroidManager.getAsteroid(i).updatePosition();
                    }
                    spaceship.isInBounds();
                    asteroidManager.testHitSpaceship(canvas, spaceship);
                    lazerManager();

                    if (movingForward) {
                        spaceship.updatePosition(0, -1);
                    }
                    if (movingBackward) {
                        spaceship.updatePosition(0, 1);
                    }
                    if (movingLeft) {
                        spaceship.updatePosition(-1, 0);
                    }
                    if (movingRight) {
                        spaceship.updatePosition(1, 0);
                    }
                    if (!asteroidManager.asteroidsStillExist()) {
                        removeObjects();
                        newLevel();
                        // resetGame();
                    } else if (!spaceship.onCanvas()) {
                        removeObjects();
                        repeatLevel();
                        resetGame();
                    }
                }
        });
        
    }

    /**
     * runs the game
     */
    private void run() {
        animate();
    }

    //Main method for game
    public static void main(String[] args) {
        SpaceForceGame game = new SpaceForceGame();
        game.run();
    }
    
}
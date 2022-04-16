package breakout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;

/**
 * Manages the game's mechanics
 */
public class GameManager {
    
    private CanvasWindow canvas;
    private double angle;
    private Brick brick;
    private List<Brick> bricks = new ArrayList<>();

    /**
     * Constructs a Breakout Game manager for the specified CanvasWindow object.
     */
    public GameManager(CanvasWindow canvas) {
        this.canvas = canvas;
    }

      /**
     * Sets the initial angle of the ball
     * @return inital angle between -60 and -120
     */
    public double initialAngle () {
        Random initialAngle = new Random();
        angle = -120 + (-60 - -120) * initialAngle.nextDouble();
        return angle;
    }

    /**
     * Creates a row of bricks at specified position, dimension, and color
     */
    public void rowOfBricks(int x, int y, int width, int height, Color color) {
        for (int i = 0; i < 17; i++) {
            brick = new Brick(x, y, width, height, color);
            bricks.add(brick);
            canvas.add(brick);
            x += 35;
        } 
    }

    /**
     * Generates bricks
     */
    public void generateBricks() {
        List<Color> listOfColors = Arrays.asList(Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN);
        int x = 5;
        int y = 200;
        int width = 30;
        int height = 8; 
        int spacing = 5;
        for (int rows = 0; rows < 10; rows++) {
            Color color = listOfColors.get(rows/2);
            rowOfBricks(x, y, width, height, color);
            y += height + spacing;
        }
    }

    /**
     * If ball intersects paddle, it will be redirected
     */
    public void ballHitsPaddle(Ball ball, Paddle paddle) {
        if (ball.testHitPaddle(paddle, canvas)) {
            ball.redirectBallFromPaddle();
        }
    }

    /**
     * If ball intersects brick, brick will be removed from canvas
     * @param ball
     */
    public void ballHitsBrick(Ball ball) {
        for (Brick brick: bricks) {
            if (ball.testHitBrick(brick, canvas)) {
                canvas.remove(brick);
                bricks.remove(brick);
                ball.redirectBallFromPaddle();
                return;
            }
        }
    }

    /**
     * Ends the game when no bricks remain on canvas
     */
    public void endGame() {
        if (bricks.size() == 0) {
            System.out.println("Congratulations, you win!");
            System.exit(0);
        }
    }
}

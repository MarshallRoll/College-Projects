package breakout;


import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.events.Key;

/**
 * The game of Breakout.
 * 
 * Author: Marshall Roll
 */
public class BreakoutGame {
    static final int CANVAS_WIDTH = 600;
    static final int CANVAS_HEIGHT = 650;

    private CanvasWindow canvas;
    private GameManager gameManager;
    private Ball ball;
    private Paddle paddle;
    private int lives;


    /**
     * Creates a new Breakout game on a CanvasWindow
     */
    public BreakoutGame() {
        canvas = new CanvasWindow("Breakout!", CANVAS_WIDTH, CANVAS_HEIGHT);

        gameManager = new GameManager(canvas);

        ball = new Ball(300, 400, gameManager.initialAngle(), CANVAS_WIDTH, CANVAS_HEIGHT + 10);
        canvas.add(ball);
        
        paddle = new Paddle(285, 640, 60, 5, CANVAS_WIDTH);
        canvas.add(paddle);

        lives = 3;            
    }

  

    /**
     * Animates objects on canvas
     */
    private void animate() {
        canvas.animate( 
            () -> 
            {
            ball.updatePosition();
            gameManager.ballHitsPaddle(ball, paddle);
            gameManager.ballHitsBrick(ball);
            ballOutOfBounds();
            gameManager.endGame();
            });
    }

    /**
     * Allows user to move paddle with arrow keys
     */
    private void movePaddle() {
        canvas.onKeyDown(event -> {
            if (event.getKey() == Key.LEFT_ARROW) {
                    paddle.updatePositionLeft();
                }
        }); 
                           

        canvas.onKeyDown(event -> {
            if (event.getKey() == Key.RIGHT_ARROW) {
                    paddle.updatePositionRight();
                }
        });   
    
    }

    /**
     * Sets initial conditions for a new instance of Breakout game
     */
    private void newGame() {
        lives = 3;
        gameManager.initialAngle();
        gameManager.generateBricks();
        canvas.draw();
        canvas.pause(2000);
    }

    /**
     * Sets the initial conditions for a new round of a Breakout game
     */
    private void startRound() {
        lives--;
        System.out.println("Lives left: " + lives);
        ball = new Ball(300, 400, gameManager.initialAngle(), CANVAS_WIDTH, CANVAS_HEIGHT + 10);
        canvas.add(ball);
        paddle = new Paddle(285, 640, 60, 5, CANVAS_WIDTH);
        canvas.add(paddle);
        canvas.draw();
        canvas.pause(2000);
        gameManager.initialAngle();
        if (lives == 0) {
            System.out.println("Game over!");
            System.exit(0);
        }
    }

    /**
     * Removes ball and paddle from canvas and freezes animation after the ball goes out of bounds
     */
    public void ballOutOfBounds() {
        if (ball.testOutOfBounds()) {
            canvas.remove(ball);
            canvas.remove(paddle);
            canvas.pause(2000);
            startRound();        
        }
    }

    

    /**
     * Method sequence that occurs in each instance of BreakoutGame
     */
    public void run() {
        newGame();
        animate();
        movePaddle();
   }

    public static void main(String[] args) {
        BreakoutGame breakoutGame = new BreakoutGame();
        breakoutGame.run();
    }

}

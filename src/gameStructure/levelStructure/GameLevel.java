import java.awt.Color;
import java.util.List;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * Initializes and runs the game.
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private AnimationRunner animationRunner;
    private KeyboardSensor keyboard;
    private LevelInformation levelInformation;
    private Counter scoreCounter;
    private ScoreTrackingListener scoreTrackingListener;

    private boolean running;
    private Counter breakableBlocksCounter = new Counter();
    private Counter availableBallsCounter = new Counter();
    private BlockRemover blockRemover = new BlockRemover(this, breakableBlocksCounter);

    // Game Constants
    public static final int WIDTH = 800, HEIGHT = 600;

    /**
     * Constructor.
     * @param levelInfo - Information about the level that will play
     * @param ar - AnimationRunner that will run the level animation
     * @param sc - Score counter
     */
    public GameLevel(LevelInformation levelInfo, AnimationRunner ar, Counter sc) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.animationRunner = ar;
        this.keyboard = ar.getGUI().getKeyboardSensor();
        this.levelInformation = levelInfo;
        this.scoreCounter = sc;
        this.scoreTrackingListener = new ScoreTrackingListener(scoreCounter);
    }

    /**
     * Gets the KeyboardSensor for the Game.
     * @return - The KeyboardSensor for the Game
     */
    public KeyboardSensor getSensor() {
        return this.keyboard;
    }

    /**
     * Adds a Collidable object to the Game.
     * @param c - The Collidable to add
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }

    /**
     * Adds a Sprite object to the Game.
     * @param s - The Sprite to add
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    /**
     * Gets the GameEnvironment of the Game.
     * @return - The GameEnvironment
     */
    public GameEnvironment getEnvironment() {
        return this.environment;
    }

    /**
     * Removes a Collidable object from the Game.
     * @param c - The Collidable to remove
     * @return - True if the game contained the specified Collidable
     */
    public boolean removeCollidable(Collidable c) {
        return this.environment.removeCollidable(c);
    }

    /**
     * Removes a Sprite object from the Game.
     * @param s - The Sprite to remove
     * @return - True if the Game contained the specified Sprite
     */
    public boolean removeSprite(Sprite s) {
        return this.sprites.removeSprite(s);
    }

    /**
     * Initiliazes the Game.
     * Creates the objects that will appear and run the game.
     */
    public void initialize() {
        // Add Background
        levelInformation.getBackground().addToGame(this);

        // Add Walls
        WallBlocks wallBlocks = new WallBlocks();
        wallBlocks.addToGame(this);

        // Add Death Zone Block
        Block ballDeathBlock = wallBlocks.getWall(WallBlocks.BOTTOM);
        BallRemover ballRemover = new BallRemover(this, availableBallsCounter);
        ballDeathBlock.addHitListener(ballRemover);

        // Add Blocks
        List<Block> blocks = levelInformation.blocks();
        for (Block block : blocks) {
            block.addHitListener(this.scoreTrackingListener);
            block.addHitListener(blockRemover);
            block.addToGame(this);
        }
        breakableBlocksCounter.increase(blocks.size());

        // Add Score Indicator
        ScoreIndicator scoreIndicator = new ScoreIndicator(scoreCounter, levelInformation.levelName());
        scoreIndicator.addToGame(this);

        // Add Paddle
        Paddle paddle = createPaddle();
        paddle.addToGame(this);

        // Add Balls
        Ball[] balls = createBalls();
        for (Ball ball : balls) {
            ball.addToGame(this);
        }
        availableBallsCounter.increase(levelInformation.numberOfBalls());
    }

    /**
     * Runs the animation loop and passes time of the game.
     * @return The score accumulated in the level
     */
    public int run() {
        animationRunner.run(new CountdownAnimation(3, 3, this.sprites));
        this.running = true;
        animationRunner.run(this);
        return scoreCounter.getValue();
    }

    @Override
    public void doOneFrame(DrawSurface d) {

        // Draw Sprites
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed(d);

        if (this.keyboard.isPressed("p")) {
            this.animationRunner.run(new PauseAnimation(this.keyboard));
        }

        // All blocks have been removed
        if (breakableBlocksCounter.getValue() == 0) {
            scoreCounter.increase(100);
            this.running = false;
        }

        // No balls available
        if (availableBallsCounter.getValue() == 0) {
            this.running = false;
        }
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * number of balls left in the game.
     * @return How many balls are in the game
     */
    public int numOfBallsLeft() {
        return this.availableBallsCounter.getValue();
    }

    private Paddle createPaddle() {
        int paddleWidth = levelInformation.paddleWidth();
        int paddleSpeed = levelInformation.paddleSpeed();
        Point paddleUpperLeft = new Point(WIDTH / 2 - paddleWidth / 2, HEIGHT -  2 * Paddle.HEIGHT);
        Rectangle paddleRect = new Rectangle(paddleUpperLeft, paddleWidth, Paddle.HEIGHT);

        return new Paddle(paddleRect, Color.YELLOW, paddleSpeed);
    }

    private Ball[] createBalls() {
        int numOfBalls = levelInformation.numberOfBalls();
        List<Velocity> vList = levelInformation.initialBallVelocity();
        Ball[] balls = new Ball[numOfBalls];

        for (int i = 0; i < numOfBalls; i++) {
            balls[i] = new Ball(WIDTH / 2, HEIGHT - Paddle.HEIGHT * 3, 6, Color.WHITE);
            balls[i].setVelocity(vList.get(i));
        }

        return balls;
    }

}

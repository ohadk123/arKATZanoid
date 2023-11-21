

import java.awt.Color;
import java.util.Random;

/**
 * Creates new balls in the game.
 */
public class BallGenerator implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBalls;

    /**
     * Constructor.
     * @param game - The Game to add the balls to
     * @param counter - The Game's balls counter
     */
    public BallGenerator(GameLevel game, Counter counter) {
        this.gameLevel = game;
        this.remainingBalls = counter;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        Random sizeRandomizer = new Random();
        int x = hitter.getX();
        int y = hitter.getY();
        int size = sizeRandomizer.nextInt(4, 10);
        Color color = Color.WHITE;
        int dx = hitter.getDX();
        int dy = hitter.getDY();
        Ball newBall = new Ball(x, y, size, color);
        newBall.setVelocity(-dx, dy);
        newBall.addToGame(this.gameLevel);
        remainingBalls.increase(1);
    }
}


/**
 * Removes a Ball from the gameLevel.
 */
public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBalls;

    /**
     * Constructor.
     * @param gameLevel - The GameLevel to remove the ball from
     * @param counter - The GameLevel's balls Counter
     */
    public BallRemover(GameLevel gameLevel, Counter counter) {
        this.gameLevel = gameLevel;
        this.remainingBalls = counter;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.gameLevel);
        remainingBalls.decrease(1);
    }
}

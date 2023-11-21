/**
 * Listens for score tracking events.
 */
public class ScoreTrackingListener implements HitListener {
private Counter currentScore;

    /**
     * Constructor.
     * @param scoreCounter - The Game's score Counter
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        currentScore.increase(5);
    }
}

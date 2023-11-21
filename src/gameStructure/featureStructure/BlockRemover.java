

/**
 * Removes a Block from the game.
 */
public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;

    /**
     * Constructor.
     * @param game - The Game to remove the Block from
     * @param counter - The Game's blocks Counter
     */
    public BlockRemover(GameLevel game, Counter counter) {
        this.gameLevel = game;
        this.remainingBlocks = counter;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(this.gameLevel);
        remainingBlocks.decrease(1);
    }
}

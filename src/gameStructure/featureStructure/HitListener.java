/**
 * Checks for hit collision with objects.
 */
public interface HitListener {

    /**
     * This method is called when beingHit is hit, ant does something accordingly.
     * @param beingHit - The object that was hit
     * @param hitter - The Ball the hit.
     */
    void hitEvent(Block beingHit, Ball hitter);
 }
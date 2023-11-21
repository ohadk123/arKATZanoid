/**
 * Notifies Hit Listeners when hit occured.
 */
public interface HitNotifier {

    /**
     * Add a Hit Listener to the list of listeners to notify.
     * @param hl - The Hit listener to add
     */
    void addHitListener(HitListener hl);

    /**
     * Remove a Hit Listener from the list of listeners to notify.
     * @param hl - The Hit listener to remove
     */
    void removeHitListener(HitListener hl);
 }
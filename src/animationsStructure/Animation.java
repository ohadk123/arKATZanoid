

import biuoop.DrawSurface;

/**
 * An Animation is an object which can run different frames on a DrawSurface.
 */
public interface Animation {

    /**
     * Progresses and shows a single frame of the animation on DrawSurface.
     * @param d - The DrawSurface to draw on
     */
    void doOneFrame(DrawSurface d);

    /**
     * Checks if an animation should stop or not.
     * @return True if animation should stop, False otherwise
     */
    boolean shouldStop();
}

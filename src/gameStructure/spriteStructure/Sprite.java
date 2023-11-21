import biuoop.DrawSurface;
/**
 * An object which is drawable on the screen.
 */
public interface Sprite {

    /**
     * Draw the Sprite on a DrawSurface.
     * @param d - The DrawSurface to draw on
     */
    void drawOn(DrawSurface d);

    /**
     * Notify the object that one time unit had passed.
     * @param d - The DrawSurface to update the sprite on
     */
    void timePassed(DrawSurface d);

    /**
     * Add the Sprite to the game.
     * @param g - The Game to add the Sprite to
     */
    void addToGame(GameLevel g);
}

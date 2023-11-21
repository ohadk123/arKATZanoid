

import java.util.ArrayList;
import biuoop.DrawSurface;

/**
 * Contains a list of all Sprite objects in the game.
 */
public class SpriteCollection {
    private ArrayList<Sprite> sprites;

    /**
     * Default Constructor.
     */
    public SpriteCollection() {
        sprites = new ArrayList<>();
    }

    /**
     * Adds a Sprite to list of Sprites.
     * @param s - The Sprite to add to the list
     */
    public void addSprite(Sprite s) {
        sprites.add(s);
    }

    /**
     * Removes a Sprite object from the SpriteCollection.
     * @param s - The Sprite to remove
     * @return - True if the SpriteCollection contained the specified Sprite
     */
    public boolean removeSprite(Sprite s) {
        return this.sprites.remove(s);
    }

    /**
     * Gets the Sprites in the game.
     * @return - The list of all Sprites in game
     */
    public ArrayList<Sprite> sprites() {
        return sprites;
    }

    /**
     * Update all the Sprites in game that one unit of time had passed.
     * @param d - The DrawSurface to update the Sprites on
     */
    public void notifyAllTimePassed(DrawSurface d) {
        ArrayList<Sprite> sprites = new ArrayList<>(this.sprites);
        for (Sprite sprite : sprites) {
            sprite.timePassed(d);
        }
    }

    /**
     * Draw all the Sprites on the DrawSurface.
     * @param d - The DrawSurface to draw on
     */
    public void drawAllOn(DrawSurface d) {
        ArrayList<Sprite> sprites = new ArrayList<>(this.sprites);
        for (Sprite sprite : sprites) {
            sprite.drawOn(d);
        }
    }
}

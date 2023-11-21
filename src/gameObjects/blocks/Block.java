import java.awt.Color;
import java.util.ArrayList;

import biuoop.DrawSurface;

/**
 * A block is a collidable object in the game in the shape of a rectangle.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle collisioRectangle;
    private Color color = Color.RED;
    private ArrayList<HitListener> hitListeners = new ArrayList<>();

    /**
     * Constructor.
     * @param rect - The Rectangle repreenting the Block
     */
    public Block(Rectangle rect) {
        this.collisioRectangle = rect;
    }

    /**
     * Constructor.
     * @param rect - The Rectangle representing the Block
     * @param color - The color of the Block on screen
     */
    public Block(Rectangle rect, Color color) {
        this.collisioRectangle = rect;
        this.color = color;
    }

    /**
     * Gets the Color of the Block.
     * @return - The Color of the Block
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Sets the Block's color.
     * @param c - A color
     */
    public void setColor(Color c) {
        this.color = c;
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return this.collisioRectangle;
    }

    @Override
    public void setCollisionRectangle(Rectangle rect) {
        this.collisioRectangle = rect;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        // Object hit on vertical edge
        if (Treshold.equals(collisionPoint.getX(), collisioRectangle.getUpperLeft().getX())
            || Treshold.equals(collisionPoint.getX(),
                                         collisioRectangle.getUpperLeft().getX() + collisioRectangle.getWidth())) {
            currentVelocity = new Velocity(-1 * currentVelocity.getDX(), currentVelocity.getDY());
        }

        // Object hit on horizontal edge
        if (Treshold.equals(collisionPoint.getY(), collisioRectangle.getUpperLeft().getY())
            || Treshold.equals(collisionPoint.getY(),
                                         collisioRectangle.getUpperLeft().getY() + collisioRectangle.getHeight())) {
            currentVelocity = new Velocity(currentVelocity.getDX(), -1 *  currentVelocity.getDY());
        }

        this.notifyHit(hitter);

        return currentVelocity;
    }

    @Override
    public void drawOn(DrawSurface d) {
        int upperLeftX = (int) this.collisioRectangle.getUpperLeft().getX();
        int upperLeftY = (int) this.collisioRectangle.getUpperLeft().getY();
        int width = (int) this.collisioRectangle.getWidth();
        int height = (int) this.collisioRectangle.getHeight();

        d.setColor(this.color);
        d.fillRectangle(upperLeftX, upperLeftY, width, height);
        d.setColor(Color.BLACK);
        d.drawRectangle(upperLeftX, upperLeftY, width, height);
    }

    @Override
    public void timePassed(DrawSurface d) {
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    /**
     * Removes the Block from a Game.
     * @param game - The Game to remove the Block from
     * @return - True if the Game contained the Block
     */
    public boolean removeFromGame(GameLevel game) {
        return game.removeCollidable(this)
               && game.removeSprite(this);
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    private void notifyHit(Ball hitter) {
        if (this.hitListeners != null) {
            ArrayList<HitListener> listeners = new ArrayList<>(this.hitListeners);
            for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
            }
        }
    }
}

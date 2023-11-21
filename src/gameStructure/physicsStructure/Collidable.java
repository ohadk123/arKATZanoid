/**
 * An object in-game which the Ball can interact with.
 */
public interface Collidable {

    /**
     * Gets the Collision Rectangle representing the Collidable.
     * @return - The Collision Rectangle
     */
    Rectangle getCollisionRectangle();

    void setCollisionRectangle(Rectangle rect);

    /**
     * When object collides with collidable check the return velocity of the object.
     * @param hitter - The Ball that hit the Collidable
     * @param collisionPoint - Where the collision happens
     * @param currentVelocity - The velocity of the colliding object
     * @return - The new Velocity after the collision
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}

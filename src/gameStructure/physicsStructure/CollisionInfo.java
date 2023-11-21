/**
 * Hold information about a collision.
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collisionObject;

    /**
     * Constructor.
     * @param point - Point of collision
     * @param object - Collidable object which collision occured with
     */
    public CollisionInfo(Point point, Collidable object) {
        this.collisionPoint = point;
        this.collisionObject = object;
    }

    /**
     * Gets the point of collision.
     * @return - The point of collision
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * Gets the Collidable object which collision occured with.
     * @return - The Collidable object which collision occured with
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }
}

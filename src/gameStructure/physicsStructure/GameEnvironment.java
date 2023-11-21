import java.util.ArrayList;

/**
 * Contains a list of all Collidable objects in the game.
 */
public class GameEnvironment {
    private ArrayList<Collidable> collidables;

    /**
     * Default Constructor.
     */
    public GameEnvironment() {
        collidables = new ArrayList<>();
    }

    /**
     * Adds a Collidable to the game.
     * @param c - The Collidable to add
     */
    public void addCollidable(Collidable c) {
        collidables.add(c);
    }

    /**
     * Removes a Collidable object from the GameEnvironment.
     * @param c - The Collidable to remove
     * @return - True if the Environment contained the specified Collidable
     */
    public boolean removeCollidable(Collidable c) {
        return this.collidables.remove(c);
    }

    /**
     * Gets the Collidables in the game.
     * @return - A list of the Collidables in the game.
     */
    public ArrayList<Collidable> collidables() {
        return collidables;
    }

    /**
     * Finds the info about the closest collision of an object.
     * @param trajectory - The path the object will take
     * @return - The info about the collision, null if no collisions occure
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        double minDistance = Integer.MAX_VALUE;
        Collidable closestCollidable = null;
        Point closestPoint = null;
        if (this.collidables.isEmpty()) {
            return null;
        }

        // For each collidable check it's closest intersection Point to trajectory's start Point (if exists)
        // save the object with the intersection with the lowest distance
        for (Collidable collidable : this.collidables) {
            Point tempPoint = trajectory.closestIntersectionToStartOfLine(collidable.getCollisionRectangle());
            if (tempPoint == null) {
                continue;
            }
            double tempDistance = tempPoint.distance(trajectory.start());
            if (tempDistance < minDistance) {
                minDistance = tempDistance;
                closestPoint = tempPoint;
                closestCollidable = collidable;
            }
        }
        if (closestPoint == null) {
            return null;
        }
        return new CollisionInfo(closestPoint, closestCollidable);
    }
}
import java.awt.Color;

import biuoop.DrawSurface;

/**
 * A ball represented by a center point and radius size.
 * A ball also has a color and velocity, and can access collidables with @param game
 */
public class Ball implements Sprite {
    private Point center;
    private int size;
    private Color color;
    private Velocity velocity = new Velocity(0, 0);
    private GameEnvironment game;

    /**
     * Constructor.
     * @param center - center Point
     * @param size - radius
     * @param color - fill color
     */
    public Ball(Point center, int size, Color color) {
        this.center = new Point(center.getX(), center.getY());
        this.size = size;
        this.color = color;
    }

    /**
     * Constructor.
     * @param x - center x value
     * @param y - center y value
     * @param size - radius
     * @param color - fill color
     */
    public Ball(int x, int y, int size, Color color) {
        this.center = new Point(x, y);
        this.size = size;
        this.color = color;
    }

    /**
     * Gets Ball's center point's x value.
     * @return x value
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * Gets Ball's center point's y value.
     * @return y value
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * Gets Ball's horizontal velocity.
     * @return - dx value
     */
    public int getDX() {
        return (int) this.velocity.getDX();
    }

    /**
     * Gets Ball's vertical velocity.
     * @return - dy value
     */
    public int getDY() {
        return (int) this.velocity.getDY();
    }

    /**
     * Sets the Ball's velocity.
     * @param dx - Horizontal velocity
     * @param dy - Vertical velocity
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * Set's the Ball's game environment.
     * @param game - Game Environmemnt
     */
    public void setGameEnvironment(GameEnvironment game) {
        this.game = game;
    }

    /**
     * Sets the Ball's velocity.
     * @param v Velocity to match
     */
    public void setVelocity(Velocity v) {
        this.velocity = new Velocity(v);
    }

    @Override
    /**
     * Draws the Ball on a DrawSurface.
     * @param surface - A DrawSurface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle(this.getX(), this.getY(), this.size);
        surface.drawCircle(this.getX(), this.getY(), this.size);
    }

    /**
     * Move's the ball a step with it's velocity,
     * if the ball reaches an edge of the panel, it changes directions.
     */
    public void moveOneStep() {
        // Find if the ball would intersect a collidable
        Point poc = findPointOnCircumference(); // poc = Point On Circumference
        double dx = this.velocity.getDX(), dy = this.velocity.getDY();
        Line trajectory = new Line(this.center, new Point(poc.getX() + dx, poc.getY() + dy));
        CollisionInfo info = game.getClosestCollision(trajectory);

        // Find a point that is close to the collision point
        if (info != null) {
            this.setVelocity(info.collisionObject().hit(this, info.collisionPoint(), this.velocity));
            return;
        }

        this.center = this.velocity.applyToPoint(center);
    }

    @Override
    public void timePassed(DrawSurface d) {
        this.moveOneStep();
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        this.setGameEnvironment(g.getEnvironment());
    }

    /**
     * Removes the Ball from a Game.
     * @param game - The Game to remove the Ball from
     * @return - True if the Game contained the Ball
     */
    public boolean removeFromGame(GameLevel game) {
        return game.removeSprite(this);
    }

    private Point findPointOnCircumference() {
        Velocity v = this.velocity;
        double speed = Math.sqrt(Math.pow(v.getDX(), 2.0) + Math.pow(v.getDY(), 2.0));
        double proportions = speed / this.size;
        double changeX = v.getDX() / proportions;
        double changeY = v.getDY() / proportions;
        double newX = this.getX() + changeX;
        double newY = this.getY() + changeY;
        return new Point(newX, newY);
    }
}

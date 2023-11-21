
/**
 * Represents velocity by horizontal and vertical value.
 */
public class Velocity {
    private double dx, dy;

    /**
     * Constructor.
     * @param dx - Horizontal velocity
     * @param dy - Vertical velocity
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Constructor.
     * @param velocity - Velocity
     */
    public Velocity(Velocity velocity) {
        this.dx = velocity.getDX();
        this.dy = velocity.getDY();
    }

    /**
     * Get's horizontal velocity.
     * @return Horizontal value
     */
    public double getDX() {
        return this.dx;
    }

    /**
     * Get's vertical velocity.
     * @return Vertical value
     */
    public double getDY() {
        return this.dy;
    }

    /**
     * Moves a Point by Velocity.
     * @param p - Point to move
     * @return - Point a new position
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
    }

    /**
     * Creates a Velocity object from angle and speed.
     * Where 0 degress is North/Up/y going down
     * @param angle - Velocity's angle
     * @param speed - Velocity's speed
     * @return Velocity object
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double rAngle = Math.toRadians(angle);
        double dx = Math.sin(rAngle) * speed;
        double dy = -Math.cos(rAngle) * speed;
        return new Velocity(dx, dy);
    }
}

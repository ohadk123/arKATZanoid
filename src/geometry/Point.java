
/**
 * Represets a point on the grid with x and y values.
 */
public class Point {
    private double x;
    private double y;

    /**
     *  Constructor.
     * @param x - x value
     * @param y - y value
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     *  Calculates the distance from a different Point.
     * @param other - Another point
     * @return Distance from other Point
     */
    public double distance(Point other) {
        double deltaX = this.x - other.x;
        double deltaY = this.y - other.y;

        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }

    /**
     * Checks if two points are equal.
     * @param other - Another point
     * @return True if both x value and y value are equal
     */
    public boolean equals(Point other) {
        return Treshold.equals(this.x, other.x)
                &&
               Treshold.equals(this.y, other.y);
    }

    /**
     * Get's Point's x value.
     * @return x value
     */
    public double getX() {
        return this.x;
    }

    /**
     * Get's Point's Y value.
     * @return Y value
     */
    public double getY() {
        return this.y;
    }

    /**
     * Changes Point position on the grid.
     * @param x - new x value
     * @param y - new y value
     */
    public void movePoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Changes Point position on grid.
     * @param other - new Point position
     */
    public void movePoint(Point other) {
        this.x = other.x;
        this.y = other.y;
    }
}
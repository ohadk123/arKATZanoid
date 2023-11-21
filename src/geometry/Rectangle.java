

import java.util.ArrayList;
import java.util.List;

/**
 * A rectangle represented by the upper-left point, height and width.
 */
public class Rectangle {
    private Point upperLeft;
    private double width, height;

    /**
     * Constructor.
     * @param upperLeft - The upper-left point of the rectangle
     * @param width - The rectangle's width
     * @param height - The rectangle's height
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = new Point(upperLeft.getX(), upperLeft.getY());
        this.width = width;
        this.height = height;
    }

    /**
     * Checks all intersections points between a line and the rectangle.
     * @param line - intersecting line
     * @return list of points of intersection, empty list if no such points exist
     */
    public List<Point> intersectionPoints(Line line) {
        // 4 lines that make the rectangle sides
        Line[] sides = new Line[4];
        sides[0] = new Line(upperLeft,
                            new Point(this.upperLeft.getX() + width, this.upperLeft.getY()));
        sides[1] = new Line(new Point(this.upperLeft.getX() + width, this.upperLeft.getY()),
                            new Point(this.upperLeft.getX() + width, this.upperLeft.getY() + this.height));
        sides[2] = new Line(new Point(this.upperLeft.getX() + width, this.upperLeft.getY() + this.height),
                            new Point(this.upperLeft.getX(), this.upperLeft.getY() + this.height));
        sides[3] = new Line(new Point(this.upperLeft.getX(), this.upperLeft.getY() + this.height),
                            upperLeft);

        List<Point> intersectionPoints = new ArrayList<Point>();
        // Search intersection points for each side of the rectangle with the line
        for (Line side : sides) {
            Point intersectionPoint = side.intersectionWith(line);
            boolean pointExist = false;
            // intersectionPoint is null if there is not intersection point
            if (intersectionPoint != null) {
                // Check if point isn't in the list already
                for (Point point : intersectionPoints) {
                    if (point.equals(intersectionPoint)) {
                        pointExist = true;
                        break;
                    }
                }
                if (!pointExist) {
                    intersectionPoints.add(intersectionPoint);
                }
            }
        }

        return intersectionPoints;
    }

    /**
     * Gets Rectangles' width.
     * @return - rectangle's width
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Gets Rectangles' height.
     * @return - rectangle's height
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Gets Rectangles' upper-left point.
     * @return - rectangle's upper-left Point
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }
}
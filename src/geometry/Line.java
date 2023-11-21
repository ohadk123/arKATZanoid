
import java.util.List;

/**
 * A line represented by two points on the grid.
 */
public class Line {
    private Point start, end;
    private Line normalizedLine;
    private static final int CLOCKWISE = 0, COUNTER_CLOCK = 1, COLLINEAR = 2;

    /**
     * Represents a Line on the grid with two Points.
     */
    public Line() {
        this.start = new Point(0, 0);
        this.end = new Point(0, 0);
        this.normalizedLine = this;
    }

    /**
     *
     * @param start
     * @param end
     */
    public Line(Point start, Point end) {
        this.start = new Point(start.getX(), start.getY());
        this.end = new Point(end.getX(), end.getY());
        this.normalizedLine = new Line();
        this.normalizeLine();
    }

    /**
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
        this.normalizedLine = new Line();
        this.normalizeLine();
    }

    /**
     *
     * @return Line's length
     */
    public double length() {
        return this.start.distance(end);
    }

    /**
     *
     * @return Line's Middle Point
     */
    public Point middle() {
        double midX = (this.start.getX() + this.end.getX()) / 2;
        double midY = (this.start.getY() + this.end.getY()) / 2;
        return new Point(midX, midY);
    }

    /**
     *
     * @return Line's Starting Point
     */
    public Point start() {
        return new Point(this.start.getX(), this.start.getY());
    }

    /**
     *
     * @return Line's Ending Point
     */
    public Point end() {
        return new Point(this.end.getX(), this.end.getY());
    }

    private int checkOrientation(Point p1, Point p2, Point p3) {
        // We can calculate the oriantation of three points on a triangle
        double orientation =
        ((p3.getY() - p1.getY()) * (p2.getX() - p1.getX()))
        -
        ((p2.getY() - p1.getY()) * (p3.getX() - p1.getX()));

        if (orientation > 0) {
            return COUNTER_CLOCK;
        } else if (orientation < 0) {
            return CLOCKWISE;
        } else {
            return COLLINEAR;
        }
    }

    /**
     *
     * @param other
     * @return True if both lines intersect, False otherwise.
     */
    public boolean isIntersecting(Line other) {
        Point p1 = this.start;
        Point p2 = this.end;
        Point p3 = other.start;
        Point p4 = other.end;

        int o1 = checkOrientation(p1, p3, p4);
        int o2 = checkOrientation(p2, p3, p4);
        int o3 = checkOrientation(p1, p2, p3);
        int o4 = checkOrientation(p1, p2, p4);

        /* If the two pairs of opposing triangles created by the points are of different orientation,
         * than there is an intersection between the lines */
        if (o1 != o2 && o3 != o4) {
            return true;

        /* Special case is if both lines are parallel to each other,
         * lines might overlap each other */
        } else if (o1 == o2 && o2 == o3 && o3 == o4 && o4 == COLLINEAR) {
            // whether end point of line other is on line this
            boolean p4Inp1p2 =
                (p4.getX() >= p1.getX()) && (p4.getX() <= p2.getX())
                &&
                (p4.getY() >= p1.getY()) && (p4.getY() <= p2.getY());

            // whether start point of line other is on line this
            boolean p3Inp1p2 =
                ((p3.getX() >= p1.getX()) && (p3.getX() <= p2.getX()))
                &&
                ((p3.getY() >= p1.getY()) && (p3.getY() <= p2.getY()));

            return p4Inp1p2 || p3Inp1p2;
        } else {
            return false;
        }
    }

    /**
     *
     * @param other
     * @return Returns intersection Point if both Lines intersect in one point
     * Null otherwise.
     */
    public Point intersectionWith(Line other) {
        double thisStartX = normalizedLine.start.getX();
        double thisStartY = normalizedLine.start.getY();
        double thisEndX = normalizedLine.end.getX();
        double thisEndY = normalizedLine.end.getY();
        double otherStartY = other.normalizedLine.start.getY();
        double otherStartX = other.normalizedLine.start.getX();
        double otherEndX = other.normalizedLine.end.getX();
        double otherEndY = other.normalizedLine.end.getY();

        // The two lines are not even intersecting
        if (!this.isIntersecting(other)) {
            return null;
        }

        /* x, y - general coordinates
         * a, b - linear equation coefficients of line this
         * m, n - linear equation coefficients of line other */
        double x, y, a, b, m, n;

        /* Lines might be vertical,
         * Later calculations will fail as division by zero might occur */
        boolean thisVertical = Treshold.equals(thisStartX, thisEndX);
        boolean otherVertical = Treshold.equals(otherStartX, otherEndX);

        /* Both lines are vertical, checking if overlapping in one point or infinite
         * We can do this because the lines are normalized so if one's end is another's
         * Then they meet only at that one point */
        if (thisVertical && otherVertical) {
            if (this.start.equals(other.end)) {
                return new Point(thisStartX, thisStartY);
            } else if (this.end.equals(other.start)) {
                return new Point(thisEndX, thisEndY);
            } else {
                return null;
            }
        } else
        // "this" line is vertical, calculate "other"s intersection with algebra
        if (thisVertical) {
            m = (otherEndY - otherStartY) / (otherEndX - otherStartX);
            n = otherStartY - (m * otherStartX);

            x = thisStartX;
            y = (m * x) + n;

            return new Point(x, y);

        } else
        // "other" line is vertical, calculate "this" intersection with algebra
        if (otherVertical) {
            a = (thisEndY - thisStartY) / (thisEndX - thisStartX);
            b = thisStartY - (a * thisStartX);

            x = otherStartX;
            y = (a * x) + b;

            return new Point(x, y);

        } else {
        // Neither lines are vertical
            a = (thisEndY - thisStartY) / (thisEndX - thisStartX);
            m = (otherEndY - otherStartY) / (otherEndX - otherStartX);
            /* Lines are parallel.
             * Same check as when both lines were vertical */
            if (Treshold.equals(a, m)) {
                if (this.start.equals(other.end)) {
                    return new Point(thisStartX, thisStartY);
                } else if (this.end.equals(other.start)) {
                    return new Point(thisEndX, thisEndY);
                } else {
                    return null;
                }
            }

            b = thisStartY - (a * thisStartX);
            n = otherStartY - (m * otherStartX);

            x = (n - b) / (a - m);
            y = (a * x) + b;

            return new Point(x, y);
        }
    }

    /**
     * Checks if two lines are the same.
     * @param other - line to check with.
     * @return True if both start points and end points are equal
     */
    public boolean equals(Line other) {
        return (this.start.equals(other.start))
                &&
               (this.end.equals(other.end));
    }

    private void normalizeLine() {
        Point nStart = new Point(this.start.getX(), this.start.getY());
        Point nEnd = new Point(this.end.getX(), this.end.getY());

        // If Point start is to the right of Point end, switch them
        if (this.start.getX() > this.end.getX()) {
            nStart.movePoint(this.end);
            nEnd.movePoint(this.start);
        } else
        // The line is vertical.
        // If Point start is above Point end, switch them
        if (this.start.getX() == this.end.getX()) {
            if (this.start.getY() > this.end.getY()) {
                nStart.movePoint(this.end);
                nEnd.movePoint(this.start);
            }
        }

        normalizedLine.start.movePoint(nStart);
        normalizedLine.end.movePoint(nEnd);
    }

    /**
     * Checks the closest intersection point with Rectangle rect to the start point of the line.
     * @param rect - possibly intersecting rectangle
     * @return - intersecting Point closest to Line's start,
     *           null if line is not intersecting
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> intersectionPoints = rect.intersectionPoints(this);
        // Line is not intersecting with the rectangle
        if (intersectionPoints.isEmpty()) {
            return null;
        }
        Point closestPoint = null;

        // Checks the intersection Point's distance from Line's start
        // saves corrently lowest distance and the Point
        double minDistance = Integer.MAX_VALUE;
        for (Point point : intersectionPoints) {
            double tempDistance = this.start.distance(point);
            if (tempDistance < minDistance) {
                minDistance = tempDistance;
                closestPoint = point;
            }
        }

        return new Point(closestPoint.getX(), closestPoint.getY());
    }
}

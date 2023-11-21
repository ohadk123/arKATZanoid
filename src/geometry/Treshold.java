

/**
 * A class containing constants and utility method.
 */
public final class Treshold {

    /**
     * Checks equality between two doubles with a treshold.
     * @param x - Double x
     * @param y - Double y
     * @return - If x and y are equal up to a treshold
     */
    public static boolean equals(double x, double y) {
        double treshold = 0.1;
        return (x <= (y + treshold)) && (x >= (y - treshold));
    }
}

/**
 * Counts stuff.
 */
public class Counter {
    private int count;

    /**
     * Constructor.
     */
    public Counter() {
        this.count = 0;
    }

    /**
     * Add to the Counter.
     * @param number - The amount to increase by
     */
    public void increase(int number) {
        this.count  += number;
    }

    /**
     * Remove from the Counter.
     * @param number - The amount to decrease by
     */
    public void decrease(int number) {
        this.count -= number;
    }

    /**
     * Get the amount the Counter counted.
     * @return - Counter's amount
     */
    public int getValue() {
        return this.count;
    }
}

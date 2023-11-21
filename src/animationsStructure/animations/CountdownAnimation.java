import java.awt.Color;

import biuoop.DrawSurface;

/**
 * An animation which countsdown untill a level starts.
 */
public class CountdownAnimation implements Animation {
    private double numOfMillisecondsPerCount;
    private Counter countdownCounter;
    private SpriteCollection gameScreen;
    private long startTime;

    /**
     * Constructor.
     * @param numOfSeconds - The number of seconds the countdown should last
     * @param countFrom - Number to count down from
     * @param gameScreen - The SpriteCollection of the level playing
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfMillisecondsPerCount = numOfSeconds / countFrom * 1000;
        this.countdownCounter = new Counter();
        this.countdownCounter.increase(countFrom);
        this.gameScreen = gameScreen;
        this.startTime = System.currentTimeMillis();
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.gameScreen.drawAllOn(d);
        int size = (int) checkTime();
        int countdownNumber = countdownCounter.getValue();
        d.setColor(Color.WHITE);
        d.drawText(GameLevel.WIDTH / 2, GameLevel.HEIGHT / 2, String.valueOf(countdownNumber), size);
    }

    @Override
    public boolean shouldStop() {
        return countdownCounter.getValue() == 0;
    }

    private double checkTime() {
        long deltaTime = System.currentTimeMillis() - startTime;
        if (deltaTime >= this.numOfMillisecondsPerCount) {
            countdownCounter.decrease(1);
            startTime = System.currentTimeMillis();
        }
        return (1 - deltaTime / numOfMillisecondsPerCount) * 64;
    }
}

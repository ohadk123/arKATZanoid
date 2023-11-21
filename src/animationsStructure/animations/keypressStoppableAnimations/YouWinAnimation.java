import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * Animation which plays when the player wins the game.
 */
public class YouWinAnimation extends KeyPressStoppableAnimation {
    private Counter score;

    /**
     * Constructor.
     * @param keyboardSensor - Keyboard Sensor
     * @param scoreCounter - The player's score
     */
    public YouWinAnimation(KeyboardSensor keyboardSensor, Counter scoreCounter) {
        super(keyboardSensor, KeyboardSensor.SPACE_KEY);
        this.score = scoreCounter;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        final String youWinString = "You Win! Your score is " + String.valueOf(score.getValue());
        d.drawText(10, d.getHeight() / 2, youWinString, 32);
        super.doOneFrame(d);
    }
}

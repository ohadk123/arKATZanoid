import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * An animation which plays when the player loses.
 */
public class GameOverAnimation extends KeyPressStoppableAnimation {
    private Counter score;

    /**
     * Constructor.
     * @param keyboardSensor - Keyboard Sensor
     * @param scoreCounter - The player's score
     */
    public GameOverAnimation(KeyboardSensor keyboardSensor, Counter scoreCounter) {
        super(keyboardSensor, KeyboardSensor.SPACE_KEY);
        this.score = scoreCounter;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        final String youWinString = "Game Over! Your score is " + String.valueOf(score.getValue());
        d.drawText(10, d.getHeight() / 2, youWinString, 32);
        super.doOneFrame(d);
    }
}

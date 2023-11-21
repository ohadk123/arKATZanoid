
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * An animation which plays when the player pauses the game.
 */
public class PauseAnimation extends KeyPressStoppableAnimation {

    /**
     * Constructor.
     * @param k - Key that starts the pause animation
     */
    public PauseAnimation(KeyboardSensor k) {
        super(k, KeyboardSensor.ENTER_KEY);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        final String pauseText = "PAUSED -- Press \'Enter\' to continue";
        d.drawText(10, d.getHeight() / 2, pauseText, 32);
        super.doOneFrame(d);
    }
}

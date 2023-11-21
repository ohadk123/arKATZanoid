

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * An Animation type which can be stopped by a button press on the keyboard.
 */
public abstract class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private String stoppingKey;
    private boolean isAlreadyPressed = true;

    /**
     * Constructor.
     * @param keyboardSensor - KeyboardSensor
     * @param stoppingKey - The key which stops the animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor keyboardSensor, String stoppingKey) {
        this.keyboard = keyboardSensor;
        this.stop = false;
        this.stoppingKey = stoppingKey;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        stopKeyPressed(stoppingKey);
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }

    private void stopKeyPressed(String key) {
        if (this.keyboard.isPressed(this.stoppingKey)) {
            if (isAlreadyPressed) {
                return;
            } else {
                this.stop = true;
            }
        } else {
            this.isAlreadyPressed = false;
        }
    }
}

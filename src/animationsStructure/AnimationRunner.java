

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * Runs an animation.
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private final Sleeper sleeper = new Sleeper();

    private static final int FPS = 60;

    /**
     * Constructor.
     * @param gui - The GUI to run Animation on
     */
    public AnimationRunner(GUI gui) {
        this.gui = gui;
        this.framesPerSecond = FPS;
    }

    /**
     * Get's the GUI this runs Animations on.
     * @return GUI
     */
    public GUI getGUI() {
        return this.gui;
    }

    /**
     * Runs an Animation frame by frame at a set FPS.
     * @param animation - The Animation to run
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis();
            DrawSurface d = gui.getDrawSurface();

            animation.doOneFrame(d);

            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long millisecondsLeftToSleep = millisecondsPerFrame - usedTime;
            if (millisecondsLeftToSleep > 0) {
                this.sleeper.sleepFor(millisecondsLeftToSleep);
            }
        }
    }
}

import java.util.List;
import biuoop.GUI;
import biuoop.KeyboardSensor;

/**
 * Flows through the animations of the game.
 */
public class GameFlow {
    private AnimationRunner animationRunner;
    private Counter scoreCounter = new Counter();
    private boolean lost = false;

    /**
     * Constructor.
     * @param ar - AnimationRunner that will run the game's animations
     */
    public GameFlow(AnimationRunner ar) {
        animationRunner = ar;
    }

    /**
     * Goes through the game's levels and runs them.
     * @param levels - The game's levels
     */
    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, this.animationRunner, this.scoreCounter);

            level.initialize();

            level.run();

            if (level.numOfBallsLeft() == 0) {
                lost = true;
                break;
            }
        }

        KeyboardSensor keyboard = animationRunner.getGUI().getKeyboardSensor();
        if (lost) {
            animationRunner.run(new GameOverAnimation(keyboard, scoreCounter));
        } else {
            animationRunner.run(new YouWinAnimation(keyboard, this.scoreCounter));
        }
    }

    /**
     * gets the GUI the game runs on.
     * @return - GUI
     */
    public GUI getGUI() {
        return animationRunner.getGUI();
    }
}

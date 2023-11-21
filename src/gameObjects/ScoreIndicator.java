import java.awt.Color;
import biuoop.DrawSurface;

/**
 * Shows the score on screen.
 */
public class ScoreIndicator implements Sprite {
    private Counter scoreCounter;
    private String levelName;

    /**
     * Consturctor.
     * @param counter - The score Counter of the game
     * @param levelName - The name of the current level playing
     */
    public ScoreIndicator(Counter counter, String levelName) {
        this.scoreCounter = counter;
        this.levelName = levelName;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 0, 800, 20);
        Integer score = scoreCounter.getValue();
        String text = "Score: " + score.toString();
        d.setColor(Color.BLACK);
        d.drawText(400 - text.length() / 2, 16, text, 16);

        String level = "Level Name: " + this.levelName;
        d.drawText(600, 16, level, 16);
    }

    @Override
    public void timePassed(DrawSurface d) {
        //
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}

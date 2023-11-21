import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import biuoop.DrawSurface;

/**
 * A level in the game.
 */
public class DirectHit implements LevelInformation {

    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocity() {
        return this.velocityDivider(this.numberOfBalls());
    }

    @Override
    public int paddleSpeed() {
        return 0;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        return new Sprite() {

            @Override
            public void drawOn(DrawSurface d) {
                // Background
                d.setColor(Color.BLACK);
                d.fillRectangle(0, 0, d.getWidth(), d.getHeight());

                int x = d.getWidth() / 2;
                int y = 200;

                d.setColor(Color.BLUE);
                // Circles
                d.drawCircle(x, y, 200);
                d.drawCircle(x, y, 150);
                d.drawCircle(x, y, 100);

                // Lines
                int length = 225;
                d.drawLine(x, y, x, y - length);
                d.drawLine(x, y, x + length, y);
                d.drawLine(x, y, x, y + length);
                d.drawLine(x, y, x - length, y);
            }

            @Override
            public void timePassed(DrawSurface d) { }

            @Override
            public void addToGame(GameLevel g) {
                g.addSprite(this);
            }
        };
    }

    @Override
    public List<Block> blocks() {
        ArrayList<Block> blocks = new ArrayList<>();

        int blockWidth = 30;
        Point upperLeft = new Point(GameLevel.WIDTH / 2 - blockWidth / 2, 200 - blockWidth / 2);
        Rectangle rect = new Rectangle(upperLeft, blockWidth, blockWidth);
        blocks.add(new Block(rect, Color.RED));

        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}

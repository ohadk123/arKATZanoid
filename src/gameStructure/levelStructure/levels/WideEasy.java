import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import biuoop.DrawSurface;

/**
 * A level in the game.
 */
public class WideEasy implements LevelInformation {

    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocity() {
        return this.velocityDivider(this.numberOfBalls());
    }

    @Override
    public int paddleSpeed() {
        return 10;
    }

    @Override
    public int paddleWidth() {
        return 600;
    }

    @Override
    public String levelName() {
        return "Wide Easy";
    }

    @Override
    public Sprite getBackground() {
        return new Sprite() {

            @Override
            public void drawOn(DrawSurface d) {
                // Bkacgournd
                d.setColor(Color.CYAN);
                d.fillRectangle(0, 0, GameLevel.WIDTH, GameLevel.HEIGHT);

                int radius = 90;
                int x = (GameLevel.WIDTH + radius) / 2, y = 200;

                // Sun Rays
                d.setColor(Color.ORANGE);
                int rayAngleDif = 10;
                for (int i = 0; i < 359; i += rayAngleDif) {
                    Velocity v = Velocity.fromAngleAndSpeed(i, 1000);
                    int endX = x + (int) v.getDX();
                    int endY = y + (int) v.getDY();
                    d.drawLine(x, y, endX, endY);
                }

                // Sun
                d.setColor(Color.YELLOW);
                d.fillCircle(x, y, radius);
                radius -= 20;
                d.setColor(Color.ORANGE);
                d.fillCircle(x, y, radius);
                radius -= 20;
                d.setColor(Color.RED);
                d.fillCircle(x, y, radius);

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
        int numberOfBlocks = 15;
        int width = (GameLevel.WIDTH - 2 * WallBlocks.getWidth()) / numberOfBlocks;
        int height = 25;
        List<Rectangle> rects = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            rects.add(new Rectangle(new Point(width * i + WallBlocks.getWidth(), 300), width, height));
        }
        List<Block> blocks = new ArrayList<>();
        for (Rectangle rect : rects) {
            int setColor = (int) rect.getUpperLeft().getX() / 126;
            Color color;
            switch (setColor) {
                case (0) :
                    color = Color.RED;
                    break;
                case (1) :
                    color = Color.ORANGE;
                    break;
                case (2) :
                    color = Color.YELLOW;
                    break;
                case (3) :
                    color = Color.GREEN;
                    break;
                case (4) :
                    color = Color.BLUE;
                    break;
                case (5) :
                    color = Color.PINK;
                    break;
                default :
                    color = Color.BLACK;
                    break;
            }
            blocks.add(new Block(rect, color));
        }

        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}

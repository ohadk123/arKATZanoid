

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import biuoop.DrawSurface;

/**
 * A level in the game.
 */
public class MidnightCity implements LevelInformation {

    @Override
    public int numberOfBalls() {
        return 2;
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
        return 100;
    }

    @Override
    public String levelName() {
        return "Midnight City";
    }

    @Override
    public Sprite getBackground() {
        return new Sprite() {

            @Override
            public void drawOn(DrawSurface d) {
                // Background
                d.setColor(new Color(12, 20, 69));
                d.fillRectangle(0, 0, 800, 600);

                // Stars
                Random rand = new Random(1);
                int numOfStars = 100;
                d.setColor(Color.WHITE);
                for (int i = 0; i < numOfStars; i++) {
                    int randX = rand.nextInt(0, 800);
                    int randY = rand.nextInt(0, 600);
                    int randRadius = rand.nextInt(1, 3);
                    d.fillCircle(randX, randY, randRadius);
                }

                int numOfBuildings = 50;
                Color[] buildingColors = {Color.GRAY, Color.DARK_GRAY, Color.LIGHT_GRAY};
                for (int i = 0; i < numOfBuildings; i++) {
                    int height = rand.nextInt(300, 600);
                    int width = rand.nextInt(50, 150);
                    int x = rand.nextInt(15) * 50;
                    Color color = buildingColors[rand.nextInt(buildingColors.length)];
                    Rectangle rect = new Rectangle(new Point(x, height), width, GameLevel.HEIGHT - height);
                    drawRectangle(d, rect, color);
                }
            }

            private void drawRectangle(DrawSurface d, Rectangle rect, Color color) {
                d.setColor(color);
                int rectX = (int) rect.getUpperLeft().getX();
                int rectY = (int) rect.getUpperLeft().getY();
                int rectWidth = (int) rect.getWidth();
                int rectHeight = (int) rect.getHeight();

                d.fillRectangle(rectX, rectY, rectWidth, rectHeight);
                d.setColor(Color.BLACK);
                d.drawRectangle(rectX, rectY, rectWidth, rectHeight);
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
        int startingRow = 3;
        int numOfRows = 5;
        int maxRows = 15, maxColumns = 20;

        int width = (GameLevel.WIDTH - 2 * WallBlocks.getWidth()) / maxRows;
        int height = (GameLevel.HEIGHT - 2 * WallBlocks.getWidth()) / maxColumns;

        Random rowColorRand = new Random(1);

        ArrayList<Block> blocks = new ArrayList<>();
        for (int i = startingRow; i < numOfRows + startingRow; i++) {
            // Each row gets a random color
            Color color = new Color(rowColorRand.nextInt());
            for (int j = i; j < maxRows; j++) {
                Point upperLeft = new Point(width * j + WallBlocks.getWidth(), height * i + WallBlocks.getWidth());
                Rectangle rect = new Rectangle(upperLeft, width, height);
                Block block = new Block(rect, color);
                blocks.add(block);
            }
        }

        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}

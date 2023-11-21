

import java.awt.Color;

/**
 * Contains an array of block which makes the game walls.
 */
public class WallBlocks {
    // Walls Settings
    private static final int WIDTH = 25;
    private static final Color COLOR = Color.GRAY;

    // Walls indices
    public static final int TOP = 0;
    public static final int LEFT = 1;
    public static final int BOTTOM = 2;
    public static final int RIGHT = 3;

    // Walls Upper-Left Points
    private static final Point TOP_POINT = new Point(0, 20);
    private static final Point LEFT_POINT = new Point(0, WIDTH + 20);
    private static final Point BOTTOM_POINT = new Point(0, GameLevel.HEIGHT);
    private static final Point RIGHT_POINT = new Point(GameLevel.WIDTH - WIDTH, WIDTH + 20);

    // Walls Rectangles
    private static final Rectangle TOP_RECT = new Rectangle(TOP_POINT, GameLevel.WIDTH, WIDTH);
    private static final Rectangle LEFT_RECT = new Rectangle(LEFT_POINT, WIDTH, GameLevel.HEIGHT - WIDTH);
    private static final Rectangle BOTTOM_RECT = new Rectangle(BOTTOM_POINT, GameLevel.WIDTH, WIDTH);
    private static final Rectangle RIGHT_RECT = new Rectangle(RIGHT_POINT, WIDTH, GameLevel.HEIGHT - WIDTH);

    // Wall Blocks
    private static final Block TOP_WALL = new Block(TOP_RECT, COLOR);
    private static final Block LEFT_WALL = new Block(LEFT_RECT, COLOR);
    private static final Block BOTTOM_WALL = new Block(BOTTOM_RECT, COLOR);
    private static final Block RIGHT_WALL = new Block(RIGHT_RECT, COLOR);

    private Block[] wallBlocks;

    /**
     * Default Constructor.
     */
    public WallBlocks() {
        wallBlocks = new Block[]{TOP_WALL, LEFT_WALL, BOTTOM_WALL, RIGHT_WALL};
    }

    /**
     * Adds all the Blocks to the game.
     * @param g - The game to add the blocks to
     */
    public void addToGame(GameLevel g) {
        for (Block block : wallBlocks) {
            block.addToGame(g);
        }
    }

    /**
     * Gets the width of a Wall Block.
     * @return - The width of a Wall Block
     */
    public static int getWidth() {
        return WIDTH;
    }

    /**
     * Gets a wall Block.
     * @param index - The index of the wall Block
     * @return - The wall Block
     */
    public Block getWall(int index) {
        return this.wallBlocks[index];
    }
}

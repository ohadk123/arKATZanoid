

import java.util.ArrayList;
import java.util.List;

/**
 * Holds information about a level.
 */
public interface LevelInformation {
    /**
     * How many balls does the level has.
     * @return Ball amount
     */
    int numberOfBalls();

    /**
     * List of the initial Velocity of each ball in the level.
     * @return - List of Ball's Velocity
     */
    List<Velocity> initialBallVelocity();

    /**
     * The horizontal velocity of the paddle in the level.
     * @return - Paddle speed
     */
    int paddleSpeed();

    /**
     * The width of the paddl in the level.
     * @return Paddle width
     */
    int paddleWidth();

    /**
     * The name of the level.
     * @return Level name
     */
    String levelName();

    /**
     * Creates the background of the level.
     * @return Sprite which is the level's background
     */
    Sprite getBackground();

    /**
     * Creates the block arrangment of the level.
     * @return - List of the blocks in the level
     */
    List<Block> blocks();

    /**
     * How many blocks do you need to remove to complete the level.
     * @return - Number of blocks in the level
     */
    int numberOfBlocksToRemove();

    /**
     * Creates a list of velocities, each at an equal angle to the other,
     * based on how many balls there are.
     * @param numOfBalls - The amount of ball in the level
     * @return - List of equally angled velocities in half circle
     */
    default List<Velocity> velocityDivider(int numOfBalls) {
        final int ballSpeed = 7;
        ArrayList<Velocity> velocityList = new ArrayList<>();
        for (int i = 0; i < numOfBalls; i++) {
            double angle = (180f / (numOfBalls + 1)) * (i + 1) - 90;
            Velocity ballVelocity = Velocity.fromAngleAndSpeed(angle, ballSpeed);

            velocityList.add(ballVelocity);
        }

        return velocityList;
    }
}

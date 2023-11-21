

import java.awt.Color;
import java.util.HashMap;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * A Paddle is a player-controlled Block.
 */
public class Paddle extends Block {
    private KeyboardSensor sensor;
    private int speed;
    private int width;

    public static final int HEIGHT = 20;

    /**
     * Constructor.
     * @param rect - The geometrical Rectangle of the paddle
     * @param color - The color of the paddle
     * @param speed - The horizontal velocity of the paddle
     */
    public Paddle(Rectangle rect, Color color, int speed) {
        super(rect, color);
        this.speed = speed;
        this.width = (int) rect.getWidth();
    }

    /**
     * Moves the Paddle a bit to the left.
     */
    public void moveLeft() {
        double newX = this.getCollisionRectangle().getUpperLeft().getX() - this.speed;
        Point currPoint = this.getCollisionRectangle().getUpperLeft();
        if (newX >= WallBlocks.getWidth()) {
            currPoint.movePoint(newX, currPoint.getY());
        } else {
            currPoint.movePoint(WallBlocks.getWidth(), currPoint.getY());
        }
    }

    /**
     * Moves the Paddle a bit to the right.
     */
    public void moveRight() {
        double newX = this.getCollisionRectangle().getUpperLeft().getX() + this.speed;
        Point currPoint = this.getCollisionRectangle().getUpperLeft();
        if (newX + this.getCollisionRectangle().getWidth() <= GameLevel.WIDTH - WallBlocks.getWidth()) {
            currPoint.movePoint(newX, currPoint.getY());
        } else {
            currPoint.movePoint(GameLevel.WIDTH - WallBlocks.getWidth() - this.width, currPoint.getY());
        }
    }

    @Override
    public void addToGame(GameLevel g) {
        super.addToGame(g);
        this.sensor = g.getSensor();
    }

    @Override
    public void timePassed(DrawSurface d) {
        if (this.sensor.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        }

        if (this.sensor.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        final int numOfRegions = 5;
        // Calculate the speed of the ball
        double dx = currentVelocity.getDX(), dy = currentVelocity.getDY();
        double currentSpeed = Math.sqrt(Math.pow(dx, 2.0) + Math.pow(dy, 2.0));
        double collisionX = collisionPoint.getX();          // The X coordinate of the collision
        double relativeX = this.getCollisionRectangle().getUpperLeft().getX();
        double[] regions = new double[numOfRegions + 1];    // X coordinates of dividers between regions

        for (int i = 0; i < regions.length; i++) {
            regions[i] = relativeX + ((double) i / (double) numOfRegions) * this.width;
        }

        HashMap<Integer, Float> angles = this.createRegionToAngleMap(numOfRegions);

        for (int i = 0; i < regions.length - 1; i++) {
            if (collisionX >= regions[i] && collisionX <= regions[i + 1]) {
                if (angles.get(i) == 0) {
                    return new Velocity(currentVelocity.getDX(), -1 * currentVelocity.getDY());
                }
                return Velocity.fromAngleAndSpeed(angles.get(i), currentSpeed);
            }
        }
        return currentVelocity;
    }

    private HashMap<Integer, Float> createRegionToAngleMap(int numOfRegions) {
        HashMap<Integer, Float> angles = new HashMap<Integer, Float>();

        // General forumla to calculate return angle
        for (int i = 0; i < numOfRegions; i++) {
            float x = 180 / (numOfRegions + 1);
            float y = i + (1 - numOfRegions) / 2;
            float z = x * y;
            angles.put(i, z);
        }

        return angles;
    }
}

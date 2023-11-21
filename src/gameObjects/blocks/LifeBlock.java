

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import biuoop.DrawSurface;

/**
 * A Block object that creates a Ball on collision.
 */
public class LifeBlock extends Block {

    /**
     * Constructor.
     * @param rect - Collision Renctangle
     */
    public LifeBlock(Rectangle rect) {
        super(rect);
        this.setColor(Color.GREEN);
    }

    @Override
    public void drawOn(DrawSurface d) {
        int upperLeftX = (int) this.getCollisionRectangle().getUpperLeft().getX();
        int upperLeftY = (int) this.getCollisionRectangle().getUpperLeft().getY();
        int width = (int) this.getCollisionRectangle().getWidth();
        int height = (int) this.getCollisionRectangle().getHeight();

        d.setColor(this.getColor());
        d.fillRectangle(upperLeftX, upperLeftY, width, height);
        d.setColor(Color.BLACK);
        d.drawRectangle(upperLeftX, upperLeftY, width, height);

        File imageFile = new File("src/gameObjects/blocks/blockArt", "plus.png");
        Image image = new BufferedImage(256, 16, BufferedImage.TYPE_4BYTE_ABGR);
        try {
            image = ImageIO.read(imageFile);
            d.drawImage(upperLeftX, upperLeftY, image);
        } catch (IOException e) {
            System.out.println(imageFile.getAbsolutePath());
            e.printStackTrace();
        }
    }
}

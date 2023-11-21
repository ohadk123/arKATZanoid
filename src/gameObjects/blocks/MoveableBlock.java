import java.awt.Color;

import biuoop.DrawSurface;

public class MoveableBlock extends Block {
    double dx, dy;

    public MoveableBlock(Rectangle rect, Color color) {
        super(rect, color);
        this.dx = 0;
        this.dy = 0;
    }

    protected void moveBy(double dx, double dy) {
        double x =  this.getCollisionRectangle().getUpperLeft().getX();
        double y = this.getCollisionRectangle().getUpperLeft().getY();
        double width = this.getCollisionRectangle().getWidth();
        double height = this.getCollisionRectangle().getHeight();
        
        x += dx;
        y += dy;

        Rectangle newRect = new Rectangle(new Point(x, y), width, height);
        
        //boolean collisionLeft = newRect.intersectionPoints(new Line(25, 0, 25, 600)) != null;
        //boolean collisionTop = newRect.intersectionPoints(new Line(0, 25, 800, 25)) != null;
        //boolean collisionRight = newRect.intersectionPoints(new Line(775, 0, 775, 600)) != null;

        //if (collisionLeft && collisionRight && collisionTop) {
            this.setCollisionRectangle(newRect);
        //}
    }
    
    @Override
    public void timePassed(DrawSurface d) {
        moveBy(this.dx, this.dy);
    }

    public void changeSpeed(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }
}

package pobj.pinboard.document;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class AbstractClip implements Clip {

    private double left, top, right, bottom;
    private Color  color;

    /*public AbstractClip(double left, double top, double right, double bottom, Color color) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.color = color;
    }*/

    @Override
    public abstract void draw(GraphicsContext ctx);

    @Override
    public double getTop() {
        // TODO Auto-generated method stub
        return top;
    }

    @Override
    public double getLeft() {
        // TODO Auto-generated method stub
        return left;
    }

    @Override
    public double getBottom() {
        // TODO Auto-generated method stub
        return bottom;
    }

    @Override
    public double getRight() {
        // TODO Auto-generated method stub
        return right;
    }

    public double getHeight() {
        return getBottom() - getTop();
    }

    public double getWidth() {
        return getRight() - getLeft();
    }

    @Override
    public void setGeometry(double left, double top, double right, double bottom) {
        // TODO Auto-generated method stub
        this.top = top;
        this.left = left;
        this.right = right;
        this.bottom = bottom;

    }

    @Override
    public void move(double x, double y) {
        // TODO Auto-generated method stub
        setGeometry(left + x, top + y, right + x, bottom + y);
        // this.right += x;
        // this.left += x;
        // this.top += y;
        // this.bottom +=y;

    }

    @Override
    public boolean isSelected(double x, double y) {
        // TODO Auto-generated method stub
        return (x <= this.right && x >= this.left && y >= this.top && y <= this.bottom);
    }

    @Override
    public void setColor(Color c) {
        // TODO Auto-generated method stub
        this.color = c;
    }

    @Override
    public Color getColor() {
        // TODO Auto-generated method stub
        return color;
    }

    @Override
    public abstract Clip copy();
}

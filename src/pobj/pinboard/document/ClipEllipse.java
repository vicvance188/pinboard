package pobj.pinboard.document;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class ClipEllipse extends AbstractClip implements Clip {
    
    

    public ClipEllipse(double left, double top, double right, double bottom, Color color) {
        super.setGeometry(left, top, right, bottom);
        super.setColor(color);
        // TODO Auto-generated constructor stub
    }
    
    double cx = (super.getLeft() + super.getRight())/2; // centre de l'éllipse
    double cy = (super.getTop() + super.getBottom())/2; // centre de l'éllipse 
    double rx = (super.getRight() - super.getLeft())/2; // rayon de l'éllipse
    double ry = (super.getBottom() - super.getTop())/2; // rayon de l'éllipse
    
    @Override
    public boolean isSelected(double x, double y) {
        // TODO Auto-generated method stub
        return ( ( Math.pow(((x-cx)/rx),2) + Math.pow(((y-cy)/ry),2) ) <= 1 );
    }
    
    @Override
    public void draw(GraphicsContext ctx) {
        // TODO Auto-generated method stub
        ctx.setFill(super.getColor());
        ctx.fillOval(getLeft(), getTop(), getWidth(), getHeight());

    }
    
    @Override
    public Clip copy() {
        // TODO Auto-generated method stub
        return new ClipEllipse(super.getLeft(), super.getTop(), super.getRight(), super.getBottom(), super.getColor());
    }

}

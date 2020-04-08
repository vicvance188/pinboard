package pobj.pinboard.document;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class ClipRect extends AbstractClip implements Clip {


    public ClipRect(double left, double top, double right, double bottom, Color color) {
        super.setGeometry(left, top, right, bottom);
        super.setColor(color);
    }

    @Override
    public void draw(GraphicsContext ctx) {
        // TODO Auto-generated method stub
        ctx.setFill(super.getColor());
        ctx.fillRect(getLeft(), getTop(), getWidth(), getHeight());
        

    }

    @Override
    public Clip copy() {
        // TODO Auto-generated method stub
        return new ClipRect(super.getLeft(), super.getTop(), super.getRight(), super.getBottom(), super.getColor());
    }

}

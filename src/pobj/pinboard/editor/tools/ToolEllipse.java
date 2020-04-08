package pobj.pinboard.editor.tools;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import pobj.pinboard.document.ClipEllipse;
import pobj.pinboard.editor.EditorInterface;

public class ToolEllipse implements Tool{

    private double x;
    private double y;
    private double nx;
    private double ny;

    @Override
    public void press(EditorInterface i, MouseEvent e) {
        // TODO Auto-generated method stub
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void drag(EditorInterface i, MouseEvent e) {
        // TODO Auto-generated method stub
        nx = e.getX();
        ny = e.getY();
    }

    @Override
    public void release(EditorInterface i, MouseEvent e) {
        // TODO Auto-generated method stub
        nx = e.getX();
        ny = e.getY();
        Color color = Color.rgb((int)Math.ceil(Math.random()*255),(int)Math.ceil(Math.random()*255),(int)Math.ceil(Math.random()*255));

        if (nx > x) {
            if (ny > y) {
                i.getBoard().addClip(new ClipEllipse(x, y, nx, ny, color));
            } else {
                i.getBoard().addClip(new ClipEllipse(x, ny, nx, y, color));
            }
        } else {
            if (ny > y) {
                i.getBoard().addClip(new ClipEllipse(nx, y, x, ny, color));
            } else {
                i.getBoard().addClip(new ClipEllipse(nx, ny, x, y, color));
            }
        }
    }

    @Override
    public void drawFeedback(EditorInterface i, GraphicsContext gc) {
        // TODO Auto-generated method stub
        if (nx > x) {   // deplace vers la droite   x < nx
            if (ny > y) {   // deplace vers le bas  y < ny
                gc.strokeOval(x, y, nx-x, ny-y);
            } else {    // deplace vers le haut     ny < y
                gc.strokeOval(x, ny, nx-x, y-ny);
            }
        } else {    // deplace vers la gauche       nx < x
            if (ny > y) {   // deplace vers le bas  y < ny
                gc.strokeOval(nx, y, x-nx, ny-y);
            } else {    // deplace vers le haut     ny < y
                gc.strokeOval(nx, ny, x-nx, y-ny);
            }
        }

    }

    @Override
    public String getName(EditorInterface editor) {
        // TODO Auto-generated method stub
        return null;
    }

}

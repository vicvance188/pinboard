package pobj.pinboard.editor.tools;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import pobj.pinboard.document.ClipRect;
import pobj.pinboard.editor.EditorInterface;

public class ToolRect implements Tool {

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
                i.getBoard().addClip(new ClipRect(x, y, nx, ny, color));
            } else {
                i.getBoard().addClip(new ClipRect(x, ny, nx, y, color));
            }
        } else {
            if (ny > y) {
                i.getBoard().addClip(new ClipRect(nx, y, x, ny, color));
            } else {
                i.getBoard().addClip(new ClipRect(nx, ny, x, y, color));
            }
        }
    }

    @Override
    public void drawFeedback(EditorInterface i, GraphicsContext gc) {
        
        // gc.strokeRect(x, y, nx - x, ny - y);

        
        if (nx > x) {   // deplace vers la droite   x < nx
            if (ny > y) {   // deplace vers le bas  y < ny
                gc.strokeRect(x, y, nx-x, ny-y);
            } else {    // deplace vers le haut     ny < y
                gc.strokeRect(x, ny, nx-x, y-ny);
            }
        } else {    // deplace vers la gauche       nx < x
            if (ny > y) {   // deplace vers le bas  y < ny
                gc.strokeRect(nx, y, x-nx, ny-y);
            } else {    // deplace vers le haut     ny < y
                gc.strokeRect(nx, ny, x-nx, y-ny);
            }
        }
    }

    @Override
    public String getName(EditorInterface editor) {
        // TODO Auto-generated method stub
        return null;
    }

}

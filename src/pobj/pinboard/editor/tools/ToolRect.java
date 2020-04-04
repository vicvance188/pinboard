package pobj.pinboard.editor.tools;

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

        if (nx > x) {
            if (ny > y) {
                i.getBoard().addClip(new ClipRect(x, y, nx, ny, Color.BLUE));
            } else {
                i.getBoard().addClip(new ClipRect(x, ny, nx, y, Color.BLUE));
            }
        } else {
            if (ny > y) {
                i.getBoard().addClip(new ClipRect(nx, y, x, ny, Color.BLUE));
            } else {
                i.getBoard().addClip(new ClipRect(nx, ny, x, y, Color.BLUE));
            }
        }
    }

    @Override
    public void drawFeedback(EditorInterface i, GraphicsContext gc) {
        // TODO Auto-generated method stub
        if (nx > x) {
            if (ny > y) {
                gc.strokeRect(x, y, nx - x, ny - y);
            } else {
                gc.strokeRect(x, y, nx - x, y - ny);
            }
        } else {
            if (ny > y) {
                gc.strokeRect(x, y, x - nx, ny - y);
            } else {
                gc.strokeRect(x, y, x - nx, y - ny);
            }
        }

    }

    @Override
    public String getName(EditorInterface editor) {
        // TODO Auto-generated method stub
        return null;
    }

}

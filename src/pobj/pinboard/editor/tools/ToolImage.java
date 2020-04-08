package pobj.pinboard.editor.tools;

import java.io.File;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import pobj.pinboard.document.ClipImage;
import pobj.pinboard.editor.EditorInterface;

public class ToolImage implements Tool {
    
    private ClipImage img;
    private File filename;
    private double x, y;
    
    public ToolImage(File filename) {
        this.filename = filename;
    }

    @Override
    public void press(EditorInterface i, MouseEvent e) {
        // TODO Auto-generated method stub
        img = new ClipImage(e.getX(), e.getY(), filename);
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void drag(EditorInterface i, MouseEvent e) {
        // TODO Auto-generated method stub
        img.move(e.getX()-x, e.getY()-y);
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void release(EditorInterface i, MouseEvent e) {
        // TODO Auto-generated method stub
        img.move(e.getX()-x, e.getY()-y);
        x = e.getX();
        y = e.getY();
        i.getBoard().addClip(img);
    }

    @Override
    public void drawFeedback(EditorInterface i, GraphicsContext gc) {
        // TODO Auto-generated method stub
        gc.strokeRect(img.getLeft(), img.getTop(), img.getRight()-img.getLeft(), img.getBottom()-img.getTop());
    }

    @Override
    public String getName(EditorInterface editor) {
        // TODO Auto-generated method stub
        return null;
    }

}

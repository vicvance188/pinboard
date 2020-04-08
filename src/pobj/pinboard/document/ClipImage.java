package pobj.pinboard.document;

import java.io.File;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class ClipImage extends AbstractClip implements Clip {
    
    private File filename;
    private Image img;
    
    
    public ClipImage(double left, double top, File filename) {
        img = new Image("File:" + filename.getAbsolutePath());
        super.setGeometry(left, top, left + img.getWidth(), top + img.getHeight());
        this.filename = filename;
    }

    @Override
    public void draw(GraphicsContext ctx) {
        // TODO Auto-generated method stub
       ctx.drawImage(img, super.getLeft(), super.getTop());
    }

    @Override
    public Clip copy() {
        // TODO Auto-generated method stub
        return new ClipImage(super.getLeft(), super.getTop(), filename);
    }
}

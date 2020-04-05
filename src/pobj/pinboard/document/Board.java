package pobj.pinboard.document;

import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;

public class Board {
    
    private List<Clip> plateau;
    
    public Board() {
        plateau = new ArrayList<Clip>();
    }
    
    public List<Clip> getContents() {
        return plateau;
    }
    
    public void addClip(Clip clip) {
        plateau.add(clip);
    }
    
    public void addClip(List<Clip> clips) {
        for(Clip clip : clips) {
            plateau.add(clip);
        }
    }
    
    public void removeClip(Clip clip) {
        plateau.remove(clip);
    }
    
    public void removeClip(List<Clip> clips) {
        for(Clip clip : clips) {
            plateau.remove(clip);
        }
    }
    
    public void draw(GraphicsContext gc) {
        // Dessine un carré blanc pour faire une 'page' vierge
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
        // Dessine le contenu de notre plateau
        for(Clip clip : this.getContents())
            clip.draw(gc);
    }


}

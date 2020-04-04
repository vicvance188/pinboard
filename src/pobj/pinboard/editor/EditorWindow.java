package pobj.pinboard.editor;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pobj.pinboard.document.Board;

public class EditorWindow {
    
    public EditorWindow(Stage stage) {

        VBox vbox = new VBox();

        MenuBar menubar = new MenuBar(); // Menu bar
        Menu file = new Menu("File");
        Menu edit = new Menu("Edit");
        Menu tools = new Menu("Tools");
        menubar.getMenus().addAll(file, edit, tools);

        MenuItem nouveau = new MenuItem("New"); // Menu Bar -> Menu File
        MenuItem close = new MenuItem("Close");

        file.getItems().addAll(nouveau, close);

        nouveau.setOnAction( (e) -> new EditorWindow(new Stage()) ); // Set action MenuBar -> MenuFile -> New with lambda
        
        close.setOnAction(new EventHandler<ActionEvent>() {   // Set action MenuBar -> MenuFile -> Close w/o lambda
            public void handle(ActionEvent e) {
                stage.close();
            }
        });
        

        ToolBar toolbar = new ToolBar(      // ToolBar
                new Button("Box"), new Button("Ellipse"), new Button("Img..."));

        Canvas canvas = new Canvas(800, 600);

        Separator separator = new Separator();

        Label label = new Label("Filled rectangle tool");

        vbox.getChildren().addAll(menubar, toolbar, canvas, separator, label);

        stage.setScene(new javafx.scene.Scene(vbox));
        Board board = new Board();

        // board.addClip(new ClipRect(350, 100, 450, 300, Color.BLACK));
        // board.addClip(new ClipEllipse(300, 350, 500, 500, Color.BLACK));

        board.draw(canvas.getGraphicsContext2D());

        stage.show();
    }
}

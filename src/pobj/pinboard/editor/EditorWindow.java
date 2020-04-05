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
import pobj.pinboard.editor.tools.Tool;
import pobj.pinboard.editor.tools.ToolEllipse;
import pobj.pinboard.editor.tools.ToolRect;

public class EditorWindow implements EditorInterface {

    private Tool  tool  = new ToolRect();
    private Board board = new Board();

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

        MenuItem toolRect = new MenuItem("Rectangle"); // menu tools -> choix de l'outils
        MenuItem toolEllipse = new MenuItem("Ellipse");

        tools.getItems().addAll(toolRect, toolEllipse);

        toolRect.setOnAction((e) -> tool = new ToolRect());
        toolEllipse.setOnAction((e) -> tool = new ToolEllipse());

        nouveau.setOnAction((e) -> new EditorWindow(new Stage())); // Set action MenuBar -> MenuFile -> New with lambda

        close.setOnAction(new EventHandler<ActionEvent>() { // Set action MenuBar -> MenuFile -> Close w/o lambda
            public void handle(ActionEvent e) {
                stage.close();
            }
        });

        Button b1 = new Button("Box");
        b1.setOnAction( (e)-> tool = new ToolRect());
        Button b2 = new Button("Ellipse");
        b2.setOnAction( (e)-> tool = new ToolEllipse());
        Button b3 = new Button("Img...");
        b3.setOnAction( (e)-> {
            //FileChooser fc = new FileChooser();
            //fc.setTitle("Open Resource File");
            //fc.getExtensionFilters().addAll(
            //         new ExtensionFilter("Image Files", ".png", ".jpg", ".gif"),
            //         new ExtensionFilter("All Files", ".*"));
            //File selectedFile = fc.showOpenDialog(stage);
            //tool = new ToolImg(selectedFile);
            });
        ToolBar toolbar = new ToolBar(b1,b2,b3);
        
        

        Canvas canvas = new Canvas(800, 600);

        Separator separator = new Separator();

        Label label = new Label("Filled rectangle tool");

        vbox.getChildren().addAll(menubar, toolbar, canvas, separator, label);

        stage.setScene(new javafx.scene.Scene(vbox));

        canvas.setOnMousePressed(e -> {
            board.draw(canvas.getGraphicsContext2D());
            tool.press(this, e);
        });
        canvas.setOnMouseReleased(e -> {
            tool.release(this, e);
            board.draw(canvas.getGraphicsContext2D());
        });
        canvas.setOnMouseDragged(e -> {
            tool.drag(this, e);
            board.draw(canvas.getGraphicsContext2D());
            tool.drawFeedback(this, canvas.getGraphicsContext2D());
        });

        // board.addClip(new ClipRect(350, 100, 450, 300, Color.BLACK));
        // board.addClip(new ClipEllipse(300, 350, 500, 500, Color.BLACK));

        board.draw(canvas.getGraphicsContext2D());

        stage.show();
    }

    @Override
    public Board getBoard() {
        // TODO Auto-generated method stub
        return board;
    }

    @Override
    public Selection getSelection() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommandStack getUndoStack() {
        // TODO Auto-generated method stub
        return null;
    }
}

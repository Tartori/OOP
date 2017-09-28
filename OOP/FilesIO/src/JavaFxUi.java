import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.List;

/**
 * Created by julia on 24-Feb-17.
 */
public class JavaFxUi extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox vbox = new VBox();

        List<String> args = this.getParameters().getRaw();
        String filename = args.get(0);


        vbox.getChildren().addAll(
                new Label("file: "+filename),
                new TextArea(FileToHex.toHex(filename)));

        // Link Stage, Scene and StackPane
        primaryStage.setScene(new Scene(vbox, 400, 400));

        // set properties title and resizeable
        primaryStage.setTitle("Label Demo");
        primaryStage.setResizable(true);

        // Position and show
        primaryStage.centerOnScreen();
        primaryStage.show();

    }


}

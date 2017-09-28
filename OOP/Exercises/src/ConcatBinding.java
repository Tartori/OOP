import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by julia on 13-Jan-17.
 */
public class ConcatBinding extends Application {
    TextField txtResult;
    TextField txt1;
    TextField txt2;

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox box = new VBox();
        txt1 = new TextField("aaa");
        txt2 = new TextField("bbb");
        txtResult = new TextField();
        txtResult.textProperty().bind(txt1.textProperty().concat(txt2.textProperty()));

        Label lbl1 = new Label(" Concat ");
        Label lbl2 = new Label(" = ");
        box.getChildren().addAll(txt1, lbl1, txt2, lbl2, txtResult);
        primaryStage.setScene(new Scene(box, 900, 400));

        // set properties title and resizeable
        primaryStage.setTitle("Label Demo");
        primaryStage.setResizable(true);

        // Position and show
        primaryStage.centerOnScreen();
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}


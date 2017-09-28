import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Created by julia on 10-Jan-17.
 */
public class PropertyExample extends Application {
    TextField txtResult;
    TextField txt1;
    TextField txt2;

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox box = new HBox();
        txt1 = new TextField("10");
        txt2 = new TextField("10");
        txtResult = new TextField("20");
        txt1.textProperty().addListener((o, oldValue, newValue) -> {
            CheckForNumber(txt1, oldValue);
        });
        txt2.textProperty().addListener((o, oldValue, newValue) -> {
            CheckForNumber(txt2, oldValue);
        });
        Label lbl1 = new Label(" + ");
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

    private void CheckForNumber(TextField txt, String oldValue) {
        try {
            Integer.parseInt(txt.getText());
            UpdateResult();
        } catch (Exception ex) {
            txt.setText(oldValue);
        }
    }

    private void UpdateResult() {
        txtResult.setText(new Integer(Integer.parseInt(txt1.getText()) + Integer.parseInt(txt2.getText())).toString());
    }


    public static void main(String[] args) {
        launch(args);
    }
}

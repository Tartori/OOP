import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by julia on 09.12.2016.
 */

public class TwoButtonExercise extends Application {
    int i1;
    int i2;
    final static String ATEXT="A=";
    final static String BTEXT="B=";
    @Override
    public void start(Stage primaryStage) throws Exception {
        i1=0;
        i2=0;
        VBox pane = new VBox(5);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10));
        HBox hBox = new HBox(15);
        hBox.setAlignment(Pos.CENTER);
        HBox hBox2=new HBox(15);
        hBox2.setAlignment(Pos.CENTER);
        pane.getChildren().add(hBox);
        pane.getChildren().add(hBox2);

        final Label lblA = new Label(ATEXT+i1);
        final Button buttonA = new Button("A");
        buttonA.setOnAction(event->{i1++; lblA.setText(ATEXT+i1); event.consume();});
        hBox.getChildren().add(buttonA);
        hBox2.getChildren().add(lblA);
        final Label lblB = new Label(BTEXT+i2);
        final Button buttonB = new Button("B");
        buttonB.setOnAction(event->{i2++; lblB.setText(BTEXT+i2); event.consume();});
        hBox.getChildren().add(buttonB);
        hBox2.getChildren().add(lblB);




        // Link Stage, Scene and StackPane
        primaryStage.setScene(new Scene(pane, 300, 200));

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

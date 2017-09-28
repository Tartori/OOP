import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.*;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

import java.applet.Applet;
import java.awt.*;
import java.awt.Color;
import java.util.Random;

import static java.awt.Color.PINK;

/**
 * Created by julia on 09.12.2016.
 */
public class CircleDrawer extends Application {
    int x=0;
    int y=0;
    public void start(Stage primaryStage) throws Exception {
        BorderPane pane = new BorderPane();
        VBox vBox = new VBox(5);
        HBox hBox1 = new HBox(15);
        hBox1.setAlignment(Pos.CENTER);
        HBox hBox2=new HBox(15);
        hBox2.setAlignment(Pos.CENTER);
        HBox hBox3=new HBox(15);
        hBox2.setAlignment(Pos.CENTER);
        vBox.getChildren().add(hBox1);
        vBox.getChildren().add(hBox2);
        vBox.getChildren().add(hBox3);
        Button btnDraw = new Button("Draw");
        vBox.getChildren().add(btnDraw);
        final Label lblMessage = new Label("");
        pane.setBottom(lblMessage);
        pane.setLeft(vBox);

        hBox1.getChildren().add(new Label("X:"));
        hBox2.getChildren().add(new Label("Y:"));
        hBox3.getChildren().add(new Label("R:"));

        final TextField txtX = new TextField("150");
        final TextField txtY = new TextField("150");
        final TextField txtR = new TextField("150");
        hBox1.getChildren().add(txtX);
        hBox2.getChildren().add(txtY);
        hBox3.getChildren().add(txtR);
        txtX.textProperty().addListener((o, oldValue, newValue)->{});

        final Canvas canvas = new Canvas(500,300);
        pane.setCenter(canvas);
        canvas.setOnMouseClicked(event->{
            try {
                int x = new Double(event.getX()).intValue();
                int y = new Double(event.getY()).intValue();
                int r = Integer.parseInt(txtR.getText());
                makeCircle(x, y, r, canvas, lblMessage);

            }
            catch (Exception ex){
                lblMessage.setText("Input Values were not valid. Please check them!");
            }
        });
        btnDraw.setOnAction(event->{
           try {
               int x = Integer.parseInt(txtX.getText());
               int y = Integer.parseInt(txtY.getText());
               int r = Integer.parseInt(txtR.getText());
               makeCircle(x, y, r, canvas, lblMessage);

           }
           catch (Exception ex){
               lblMessage.setText("Input Values were not valid. Please check them!");
           }

        });


        // Link Stage, Scene and StackPane
        primaryStage.setScene(new Scene(pane, 900, 400));

        // set properties title and resizeable
        primaryStage.setTitle("Label Demo");
        primaryStage.setResizable(true);

        // Position and show
        primaryStage.centerOnScreen();
        primaryStage.show();

    }

    private void makeCircle(int x, int y, int r, Canvas canvas, Label lblMessage )    {
        x-=r;
        y-=r;
        r*=2;
        if (x> canvas.getWidth() || y > canvas.getHeight())

        {
            lblMessage.setText("Circle2 out of range");
            return;
        }
        Random rnd = new Random();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setFill(javafx.scene.paint.Color.rgb(rnd.nextInt(255),rnd.nextInt(255),rnd.nextInt(255)));
        gc.fillOval(x, y, r, r);
        lblMessage.setText("Check out that awesome circle :O");
    }


    public static void main(String[] args) {
        launch(args);
    }
}

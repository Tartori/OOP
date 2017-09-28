import javafx.animation.Animation;
import javafx.animation.FillTransition;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Created by julia on 13-Jan-17.
 */
public class ThreeCircles extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 300, 250);
        DoubleBinding myBinding = new DoubleBinding() {

            {
                super.bind(scene.heightProperty(), scene.widthProperty());
            }

            @Override
            protected double computeValue() {
                return Math.min(scene.getHeight()/2, scene.getWidth()/4);
            }
        };
        Circle c1 = new Circle(100, Color.MEDIUMAQUAMARINE);

        c1.centerXProperty().bind(scene.widthProperty().divide(4));
        c1.centerYProperty().bind(scene.heightProperty().divide(2));
        c1.radiusProperty().bind(Bindings.min(scene.heightProperty().divide(2), scene.widthProperty().divide(4)));




        Circle c2 = new Circle(100, Color.MEDIUMSPRINGGREEN);

        c2.centerXProperty().bind(scene.widthProperty().divide( 2));
        c2.centerYProperty().bind(scene.heightProperty().divide(2));
        c2.radiusProperty().bind(Bindings.min(scene.heightProperty().divide(2), scene.widthProperty().divide(4)));

        Circle c3 = new Circle(100, Color.ANTIQUEWHITE);

        c3.centerXProperty().bind(scene.widthProperty().divide(4).multiply(3));
        c3.centerYProperty().bind(scene.heightProperty().divide(2));
        c3.radiusProperty().bind(Bindings.min(scene.heightProperty().divide(2), scene.widthProperty().divide(4)));

        root.getChildren().addAll(c1,c2,c3);

        primaryStage.setTitle("JavaFX Binding example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String... args){launch(args);}
}

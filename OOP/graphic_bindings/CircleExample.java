package graphic_bindings;

import javafx.animation.Animation;
import javafx.animation.FillTransition;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * The Circle Example with StackPane
 * 
 * @author lua1
 */
public class CircleExample extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		Group root = new Group();
		Scene scene = new Scene(root, 300, 250);

		Circle c1 = new Circle(100, Color.BLUEVIOLET);

		c1.centerXProperty().bind(Bindings.divide(scene.widthProperty(), 2));
		c1.centerYProperty().bind(scene.heightProperty().divide(2));

		FillTransition ft = new FillTransition(Duration.millis(3000), c1, Color.RED, Color.BLUE);
		ft.setCycleCount(Animation.INDEFINITE);
		ft.setAutoReverse(true);

		ft.play();

		root.getChildren().addAll(c1);

		primaryStage.setTitle("JavaFX Binding example");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}

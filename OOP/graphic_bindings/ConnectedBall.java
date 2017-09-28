package graphic_bindings;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ConnectedBall extends Application {
	   @Override
	   public void start(Stage stage) throws Exception {
	       Group root = new Group();

	       initShapes(root);

	       Scene scene = new Scene(root, 400, 400);
		   stage.setTitle("Connected Balls");
	       stage.setScene(scene);
	       stage.show();
	   }
	   
	   private void initShapes(Group root) {
	       Ball ball1 = new Ball(100, 200, 30);
	       ball1.setFill(Color.DARKTURQUOISE);
	       root.getChildren().add(ball1);
	       Ball ball2 = new Ball(300, 200, 30);
	       ball2.setFill(Color.DARKTURQUOISE);
	       root.getChildren().add(ball2);

	       Connection connection = new Connection(ball1, ball2);
	       connection.setStroke(Color.HOTPINK);
	       connection.setStrokeWidth(5);
	       root.getChildren().add(0, connection);
	   }

	   public static void main(String... args) {
	       launch(args);
	   }
	}

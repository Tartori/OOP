import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//often used as the basic Layout for a window

public class BorderPaneExample extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("BorderPane example");
		
		//generate label with or without text
		Label l1 = new Label("This is a horizontal Test!\n");
		Label l2 = new Label("This is a vertical Test!\n");
		
		//generate button with or without text
		Button b1 = new Button("Show");
		Button b2 = new Button("Hide");
		
		// generate a VBox and HBox with or without "Children" for the sides
		VBox vb1 = new VBox(l1, b1);
		vb1.setAlignment(Pos.CENTER);
		vb1.setSpacing(15.00);
		
		HBox hb1 = new HBox(l2, b2);
		hb1.setAlignment(Pos.CENTER);
		hb1.setSpacing(15.00);
		
		VBox vb2 = new VBox();
		HBox hb2 = new HBox();
		
		// generate a Circle, Rectangle and Line for the StackPane
		Circle circ1 = new Circle();
		circ1.setRadius(80);
		circ1.setFill(Color.AZURE);
		
		Circle circ2 = new Circle();
		circ2.setRadius(45);
		circ2.setFill(Color.FORESTGREEN);
		
		Rectangle rect1 = new Rectangle();
		rect1.setHeight(100);
		rect1.setWidth(100);
		rect1.setFill(Color.PALEVIOLETRED);
		
		Line line1 = new Line();
		line1.setStartX(circ1.getRadius()/2);
		line1.setStartY(circ1.getRadius()/2);
		line1.setEndX(circ1.getRadius());
		line1.setEndY(circ1.getRadius());
		line1.setFill(Color.CRIMSON);
		
		//generate a StackPane for the center
		StackPane sp1 = new StackPane(circ1, rect1, circ2, line1);
		
		// generate a BorderPane
		final BorderPane root = new BorderPane();
		
		// align the BorderPane and give it Lines at the edges
		BorderPane.setAlignment(root, Pos.CENTER);
		root.setPadding(new Insets(15));
		
		// set the different areas of the BorderPane
		root.setCenter(sp1);
		root.setLeft(vb1);
		root.setTop(hb1);
		root.setRight(vb2);
		root.setBottom(hb2);
		
		// generate action events for the buttons
		b1.setOnAction(event -> {
			sp1.setVisible(true);
		});
		
		b2.setOnAction(event -> {
			sp1.setVisible(false);
		});
		
		// generate the Scene which holds all the nodes
		Scene myScene = new Scene(root);
		
		// set Stage with the scene in it
		primaryStage.setScene(myScene);
		primaryStage.setHeight(400);
		primaryStage.setWidth(400);
		
		// show the stage!
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);

	}

}

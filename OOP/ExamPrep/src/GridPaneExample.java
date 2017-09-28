import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPaneExample extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Button b1 = new Button();
		Button b2 = new Button();
		
		b1.setPrefSize(15, 40);
		b2.setPrefSize(40, 15);
		
		// generate a GridPane
		GridPane grid1 = new GridPane();
		
		// set Spacing and Padding for the GridPane
		grid1.setPadding(new Insets(10, 10, 10, 10));
		grid1.setHgap(15);
		grid1.setVgap(15);
		
		// add nodes to the GridPane by using column and row numbers
		grid1.add(b1, 1, 1);
		grid1.add(b2, 1, 2);
		
		Scene myScene = new Scene(grid1);
		primaryStage.setScene(myScene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);

	}

}

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class FlowPaneExample extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Label labe1 = new Label("I am here!");
		Label labe2 = new Label("I am there!");
		Label labe3 = new Label("I am everywhere");
		Label labe4 = new Label("Here?");
		Label labe5 = new Label("There?");
		Label labe6 = new Label("Everywhere!");
		
		Button but1 = new Button("Get over here!");
		Button but2 = new Button("Get over there!");
		Button but3 = new Button("Get over everywhere!");
		Button but4 = new Button("Go over here?");
		Button but5 = new Button("Go over there?!");
		Button but6 = new Button("Go everywhere!");
		
		FlowPane fp1 = new FlowPane(labe1, labe2, labe3, labe4, labe5, labe6, but1, but2, but3, but4, but5, but6);
		
		// set the distance between FlowPane and window border
		fp1.setPadding(new Insets(20, 20, 20, 20));
		
		// set the distance between the elements in the FlowPane
		fp1.setHgap(15);
		fp1.setVgap(15);
		
		primaryStage.setTitle("FlowPane Example");
		
		Scene myScene = new Scene(fp1);
		primaryStage.setScene(myScene);
		primaryStage.show();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}

}

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AnchorPaneExample extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		AnchorPane anchor = new AnchorPane();
		
		Button sav1 = new Button("Save");
		Button lod2 = new Button("Load");
		Button exi3 = new Button("Exit");
		
		Label lab1 = new Label("This is my fucking Place!");
		lab1.setPrefSize(150, 50);
		
		Label lab2 = new Label("I am the Middle!");
		
		// anchor the label1 to the top and left of the window 
		AnchorPane.setTopAnchor(lab1, 15.0);
		AnchorPane.setLeftAnchor(lab1, 15.0);
		
		// anchor the label2 to the middle of the window 
		// does not yet work!
		AnchorPane.setRightAnchor(lab2, anchor.getHeight()/2);
		AnchorPane.setLeftAnchor(lab2, anchor.getWidth()/2);
		
		// anchor the save button to the bottom and right of the window 
		AnchorPane.setBottomAnchor(sav1, 15.0);
		AnchorPane.setRightAnchor(sav1, 15.0);
		
		// anchor the load button to the bottom and left of the window
		AnchorPane.setBottomAnchor(lod2, 15.0);
		AnchorPane.setLeftAnchor(lod2, 15.0);
		
		// anchor the exit button to the top and right of the window
		AnchorPane.setTopAnchor(exi3, 15.0);
		AnchorPane.setRightAnchor(exi3, 15.0);
		
		anchor.getChildren().addAll(sav1, lod2, exi3, lab1, lab2);
		
		Scene myScene = new Scene(anchor);
		primaryStage.setScene(myScene);
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);

	}

}

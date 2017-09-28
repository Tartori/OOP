package displayHex;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * The Display Hex App
 * @author lua1
 */

public class JavaFXDisplayHex extends Application {
	
	private TextArea ta = new TextArea();
	private Label l = new Label();

	@Override
	public void start(Stage primaryStage) throws Exception {

		VBox pane = new VBox(5);
				
		ta.setWrapText(true);
		ta.setEditable(false);
		// Font setzen
		ta.setFont(Font.font("Courier New", FontWeight.BOLD, 14));
		
		ta.minHeightProperty().bind(pane.heightProperty());

		pane.getChildren().addAll(l,ta);
		
		readBytes();
		
		// Link Stage, Scene and StackPane
		primaryStage.setScene(new Scene(pane,400,200));

		// set properties title and resizeable
		primaryStage.setTitle("Display Hex");
		primaryStage.setResizable(true);

		// Position and show
		primaryStage.centerOnScreen();
		primaryStage.show();

	}

	private void readBytes() throws IOException {
		
		List<String> args = this.getParameters().getRaw();
		
		String inputFileName = new String();
		CharArrayWriter buffer = new CharArrayWriter(); 
		PrintWriter writer = new PrintWriter(buffer);
		
		if (args.size() >= 1) {
			inputFileName = args.get(0);

			l.setText("File: " + inputFileName);
			Path file = Paths.get(inputFileName);

			byte[] bytes = Files.readAllBytes(file);

			
			for (byte theByte : bytes) {
				writer.printf("%02X ", theByte);
			}
			
			ta.setText(buffer.toString());

		} else {
			l.setText("Usage: java " + NIODisplayHex.class.getName()
					+ " filename");
		}

		
	}

	public static void main(String[] args) {
		launch(args);
   }
}

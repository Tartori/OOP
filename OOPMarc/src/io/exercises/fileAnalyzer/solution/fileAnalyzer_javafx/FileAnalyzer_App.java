package io.exercises.fileAnalyzer.solution.fileAnalyzer_javafx;

import java.io.File;
import java.io.IOException;

import io.exercises.fileAnalyzer.solution.nio_fileAnalyzer.NIOFileCounter;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * File Analyzer App
 * 
 * @author lua1
 *
 */
public class FileAnalyzer_App extends Application {

	private Label filename;
	private TextField t1, t2, t3;

	@Override
	public void start(final Stage primaryStage) {

		VBox vBox = new VBox(10);
		vBox.setPadding(new Insets(5));
		vBox.setAlignment(Pos.CENTER);

		Button button = new Button("Analyze");
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				FileChooser fileChooser = new FileChooser();
				FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
						"TXT files (*.txt)", "*.txt");
				fileChooser.getExtensionFilters().add(extFilter);
				File file = fileChooser.showOpenDialog(primaryStage);
				if (file != null) {
					filename.setText("Analyzing ... "
							+ file.getAbsolutePath().toString());
					filename.setVisible(true);

					NIOFileCounter counter = analyzeFile(file.getAbsolutePath()
							.toString());

					t1.setText("" + counter.getCharacterCount());
					t2.setText("" + counter.getWordCount());
					t3.setText("" + counter.getLineCount());
				} else {
					filename.setVisible(false);
					t1.setText("");
					t2.setText("");
					t3.setText("");
				}
			}
		});
		vBox.getChildren().add(button);

		filename = new Label(" ");
		filename.setVisible(false);
		filename.setWrapText(true);

		HBox hBox1 = new HBox(5);
		hBox1.setAlignment(Pos.CENTER_RIGHT);
		Label l1 = new Label("Characters:");
		t1 = new TextField();
		t1.setEditable(false);
		hBox1.getChildren().addAll(l1, t1);

		HBox hBox2 = new HBox(5);
		hBox2.setAlignment(Pos.CENTER_RIGHT);
		Label l2 = new Label("Words:");
		t2 = new TextField();
		t2.setEditable(false);
		hBox2.getChildren().addAll(l2, t2);

		HBox hBox3 = new HBox(5);
		hBox3.setAlignment(Pos.CENTER_RIGHT);
		Label l3 = new Label("Lines:");
		t3 = new TextField();
		t3.setEditable(false);
		hBox3.getChildren().addAll(l3, t3);

		vBox.getChildren().addAll(filename, hBox1, hBox2, hBox3);

		primaryStage.setScene(new Scene(vBox, 250, 250));
		primaryStage.setTitle("FileAnalyzer with JavaFX");
		primaryStage.show();

	}

	private NIOFileCounter analyzeFile(String fileName) {
		NIOFileCounter counter = new NIOFileCounter();
		try {
			counter.read(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return counter;
	}

	public static void main(String[] args) {
		launch(args);
	}
}

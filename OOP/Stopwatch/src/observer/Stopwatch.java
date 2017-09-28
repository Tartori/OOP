package observer;

import java.util.Observable;
import java.util.Observer;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Stopwatch extends Stage implements Observer {
	private final Timer timer;
	
	private final Label timeLabel;
	private final Button start;
	private final Button stop;
	private final Button reset;
	private final Label statusBar;
	
	public Stopwatch(Timer timer) {
		
		this.timer = timer;
		
		BorderPane pane = new BorderPane();
		
		this.statusBar = new Label("Stopped");
		BorderPane.setMargin(this.statusBar, new Insets(5));
		pane.setBottom(this.statusBar);
		
		
		final BorderPane center = new BorderPane();
		pane.setCenter(center);
		
		final HBox controls = new HBox(10);
		controls.setAlignment(Pos.CENTER);
		center.setBottom(controls);
		
		this.start = new Button("Start");
		this.start.setPrefWidth(80);
		this.start.setOnAction((event)->{
			this.timer.start();
		});
		this.stop = new Button("Stop");
		this.stop.setDisable(true);
		this.stop.setPrefWidth(80);
		this.stop.setOnAction((event)->{
			this.timer.stop();
		});
		this.reset = new Button("Reset");
		this.reset.setPrefWidth(80);
		this.reset.setOnAction((event)->{
			this.timer.reset();
		});
		
		controls.getChildren().addAll(this.start, this.stop, this.reset);
		
		final HBox display = new HBox(5);
		BorderPane.setMargin(display, new Insets(10, 10, 5, 10));
		display.setAlignment(Pos.CENTER);
		display.setStyle("-fx-border-width: 2px; -fx-border-color: #555; ");
		final Label display_left = new Label("Sekunden:");
		this.timeLabel = new Label("0:00");
		display.getChildren().addAll(display_left, this.timeLabel);
		
		center.setCenter(display);
		
		timer.addObserver(this);
		
		

		Scene scene = new Scene(pane, 350, 300);
		this.setTitle("Stopwatch");
		this.setScene(scene);
		this.show();
		
	}
	

	@Override
	public void update(Observable o, Object arg) {
		Platform.runLater(new Runnable(){
			@Override
			public void run() {
				timeLabel.setText(timer.getTimeString());
				start.setDisable(timer.isRunning());
				stop.setDisable(!timer.isRunning());
				reset.setDisable(timer.isRunning());
				statusBar.setText(timer.isRunning() ? "Running..." : "Stopped");
			}
		});
		
	}
}

package MyPackage;/**
 * Created by julia on 31-Mar-17.
 */

import javafx.application.Application;
import javafx.stage.Stage;

public class MyMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        new MyFx();
    }
}

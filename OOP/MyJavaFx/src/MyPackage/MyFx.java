package MyPackage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by julia on 31-Mar-17.
 */



public class MyFx  extends Stage {

    public MyFx() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("MyFxml.fxml"));
        Scene scene = new Scene(loader.load(), 350, 200);

        scene.getStylesheets().add(getClass().getResource("MyCSS.css").toExternalForm());

        this.setTitle("Stopwatch");
        this.setScene(scene);
        this.show();

    }

}

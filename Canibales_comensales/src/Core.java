/**
 * Created by carli on 10/10/2016.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Core extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Vista.fxml"));
        primaryStage.setTitle("Canibales comensales");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}

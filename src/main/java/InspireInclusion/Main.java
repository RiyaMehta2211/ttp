package InspireInclusion;

import InspireInclusion.ui.MainWindow;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * GUI using FXML.
 */
public class Main extends Application {

    private Platform platform = new Platform();

    /**
     * Initializes and starts the JavaFX application.
     * @param stage The primary stage for this application, representing the main window.
     */
    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setTitle("#InspireInclusion for Everyone");
            stage.setScene(scene);
            fxmlLoader.<MainWindow>getController().setPlatform(platform);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


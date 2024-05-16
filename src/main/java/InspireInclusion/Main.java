package InspireInclusion;

import InspireInclusion.ui.Authentication;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Authentication.start(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}



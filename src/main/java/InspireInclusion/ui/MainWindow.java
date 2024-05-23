package InspireInclusion.ui;
import InspireInclusion.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
/**
 * Controller for MainWindow. Provides the layout for the other controls.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Platform platform;
    private Image defaultImage = new Image(this.getClass().getResourceAsStream("/images/defaultImage.png"));


    //private Image userImage = new Image(this.getClass().getResourceAsStream("/images/profileImage.png"));
    /**
     * Initializes the JavaFX controller when the associated FXML file is loaded.
     * This method sets up the scroll pane and adds the initial dialog to the dialog container.
     */
    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        dialogContainer.getChildren().addAll(
                DialogBox.getPlatformDialog(Ui.printWelcome(), defaultImage)
        );
    }

    public void setPlatform(Platform p) {
        platform = p;
    }
    /**
     * Accepts user input and clears after processing
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        userInput.clear();
    }
}


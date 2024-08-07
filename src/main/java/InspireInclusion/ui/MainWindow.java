package InspireInclusion.ui;
import InspireInclusion.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.*;
import java.util.Objects;

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
    @FXML
    private Button streaks;
    @FXML
    private Button profile;
    @FXML
    private ImageView profileImageView;
    @FXML
    private ImageView streaksIconView;
    private File chosenFile;
    private final Image calendarIcon = new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/images/defaultImage.png")));

    private Platform platform;
    private final Image defaultImage = new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/images/defaultImage.png")));
    private final Image defaultUserImage = new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/images/userImage.png")));
    private final Image dailyStreaksIcon= new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/images/DailyStreaksIcon.png")));
    /**
     *
     * Initializes the JavaFX controller when the associated FXML file is loaded.
     * This method sets up the scroll pane and adds the initial dialog to the dialog container.
     */
    @FXML
    public void initialize() {
        String imagePath = readPath();
        if (imagePath != null) {
            File imageFile = new File(imagePath);
            if (imageFile.exists()) {
                Image image = new Image(imageFile.toURI().toString());
                profileImageView.setImage(image);
            }
            else {
                profileImageView.setImage(defaultUserImage);
            }
        } else {
            profileImageView.setImage(defaultUserImage);
        }
        streaksIconView.setImage(dailyStreaksIcon);
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        dialogContainer.getChildren().addAll(
                DialogBox.getPlatformDialog(Ui.printWelcome(), defaultImage)
        );
    }

    public String readPath() {
        String IMAGE_FILE = "path.txt";
        String path = "";
        try (ObjectInputStream file = new ObjectInputStream(new FileInputStream(IMAGE_FILE))) {
            path = (String) file.readObject();
        } catch (IOException|ClassNotFoundException e) {
            e.getMessage();
        } return path;
    }

    public void setPlatform(Platform p) {
        platform = p;
    }
    @FXML
    private void openDailyStreaksPage() {
        try {
            Stage dailyStreaksStage = new Stage();
            DailyStreak dailyStreakPage = new DailyStreak();
            dailyStreakPage.start(dailyStreaksStage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void openProfilePage() {
        try {
            Stage profileStage = new Stage();
            ProfilePage userProfilePage = new ProfilePage();
            userProfilePage.start(profileStage);
            profileStage.setOnHiding(event -> {
                if (ProfilePage.profilePictureUpdated) {
                    String imagePath = readPath();
                    if (imagePath != null) {
                        File imageFile = new File(imagePath);
                        if (imageFile.exists()) {
                            Image image = new Image(imageFile.toURI().toString());
                            profileImageView.setImage(image);
                        } else {
                            profileImageView.setImage(defaultUserImage);
                        }
                    } else {
                        profileImageView.setImage(defaultUserImage);
                    }
                    ProfilePage.profilePictureUpdated = false;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Accepts user input and clears after processing
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = platform.getResponse(input);
        String imagePath = readPath();
        Image userImage;
        if (imagePath != null) {
            File imageFile = new File(imagePath);
            if (imageFile.exists()) {
                userImage = new Image(imageFile.toURI().toString());
            }
            else {
                userImage = defaultUserImage;
            }
        } else {
            userImage = defaultUserImage;
        }
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getPlatformDialog(response,  defaultImage)
        );
        userInput.clear();
    }
}


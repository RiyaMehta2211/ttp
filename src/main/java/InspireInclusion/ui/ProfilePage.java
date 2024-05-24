package InspireInclusion.ui;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class ProfilePage {
    private ImageView profileImageView;
    private File chosenFile;
    Label profileSaved = new Label();

    public void start(Stage stage) {
        stage.setTitle("User Profile");

        profileImageView = new ImageView();
        profileImageView.setFitWidth(150);
        profileImageView.setFitHeight(150);
        profileImageView.setPreserveRatio(true);

        Button uploadButton = new Button("Upload Profile Picture");
        uploadButton.setOnAction(e -> chooseFile(stage));

        TextField nameField = new TextField();
        nameField.setPromptText("Enter your name");
        Label name = new Label("Name: ");
        Button saveButton = new Button("Save Profile");
        saveButton.setOnAction(e -> saveProfile(nameField.getText()));

        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(0, 10, 0, 10));

        gridPane.add(name, 0, 0);
        gridPane.add(nameField, 1, 0);
        gridPane.add(uploadButton, 0, 1);
        gridPane.add(profileImageView, 1, 1);
        gridPane.add(saveButton, 1, 2);
        gridPane.getChildren().addAll(profileSaved);
        Scene scene = new Scene(gridPane, 400, 300);
        stage.setScene(scene);
        stage.show();
    }

    private void chooseFile(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );
        chosenFile = fileChooser.showOpenDialog(stage);
        if (chosenFile != null) {
            try {
                Image image = new Image(new FileInputStream(chosenFile));
                profileImageView.setImage(image);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveProfile(String name) {
        if (chosenFile != null && !name.isEmpty()) {
            profileSaved.setText("Profile saved: " + name);
            System.out.println("Profile picture path: " + chosenFile.getAbsolutePath());
        } else {
            profileSaved.setText("Please complete all fields");
        }
    }

}

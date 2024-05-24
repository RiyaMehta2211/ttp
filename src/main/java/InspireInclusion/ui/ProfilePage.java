package InspireInclusion.ui;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Objects;


public class ProfilePage {
    private ImageView profileImageView;
    private File chosenFile;
    Label profileSaved = new Label();
    private final Image defaultImage = new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/images/defaultImage.png")));

    public void start(Stage stage) {
        stage.setTitle("User Profile");

        profileImageView = new ImageView();
        profileImageView.setFitWidth(150);
        profileImageView.setFitHeight(150);
        profileImageView.setPreserveRatio(true);
        profileImageView.setImage(defaultImage); //to handle the case of no profile image in the beginning

        Button uploadButton = new Button("Upload Profile Picture");
        uploadButton.setOnAction(e -> chooseFile(stage));

        TextField nameField = new TextField();
        nameField.setPromptText("Enter your name");
        Label name = new Label("Name: ");

        TextField emailField = new TextField();
        emailField.setPromptText("Enter your email");
        Label email = new Label("Email: ");

        Button saveButton = new Button("Save Profile");
        saveButton.setOnAction(e -> saveProfile(nameField.getText(), emailField.getText()));

        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        gridPane.add(name, 0, 0);
        gridPane.add(nameField, 1, 0);
        gridPane.add(email, 0, 1);
        gridPane.add(emailField, 1, 1);
        gridPane.add(uploadButton, 0, 2);
        gridPane.add(profileImageView, 1, 2);
        gridPane.add(saveButton, 1, 3);
        gridPane.add(profileSaved, 1, 4);

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

    private void saveProfile(String name, String email) {
        if (chosenFile != null && !name.isEmpty() && !email.isEmpty()) {
            //sufficient to ensure that the name field is not empty
            if (isValidEmail(email)) {
                profileSaved.setTextFill(Color.GREEN);
                profileSaved.setText("Profile saved: " + name);
                System.out.println("Profile picture path: " + chosenFile.getAbsolutePath());
            }
            if (!isValidEmail(email)) {
                profileSaved.setTextFill(Color.RED);
                profileSaved.setText("Please enter valid email");
            }
        } else {
            profileSaved.setTextFill(Color.RED);
            profileSaved.setText("Please complete all the fields");
        }
    }
    private boolean isValidEmail(String email) {
        return email.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");
    }

}
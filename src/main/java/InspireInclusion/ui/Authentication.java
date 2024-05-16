package InspireInclusion.ui;

import InspireInclusion.Platform;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for Authentication Window. Provides the layout for the other controls.
 */
public class Authentication {
    private static final Platform platform = new Platform();
    //Change default strings later to use a
    //hashmap data structure to map the usernames to passwords
    private static final String DEFAULT_USERNAME = "admin";
    private static final String DEFAULT_PASSWORD = "12345678";
    public static boolean authentication_status;

    public static void start(Stage stage) {
        stage.setTitle("Login Page");
        Label username = new Label("Username: ");
        Label password = new Label("Password: ");
        Label authentication = new Label();
        TextField usernameField = new TextField();
        PasswordField passwordField = new PasswordField();
        Button login = new Button("Login");
        login.setOnAction(event -> {
            String enteredUsername = usernameField.getText();
            String enteredPassword = passwordField.getText();

            if (enteredUsername.equals(DEFAULT_USERNAME) && enteredPassword.equals(DEFAULT_PASSWORD)) {
                authentication.setText("Login successful!");
                authentication_status = true;
                openMainWindow(stage);
            } else {
                authentication.setText("Login failed. Please check your credentials.");
                authentication_status = false;
            }
        });
        VBox root = new VBox(10);
        root.getChildren().addAll(username, usernameField, password, passwordField, login, authentication);

        // Create the scene and set it in the stage.
        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);

        // Show the window.
        stage.show();
    }
    private static void openMainWindow(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Authentication.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setTitle("#InspireInclusion for Everyone");
            stage.setScene(scene);
            fxmlLoader.<MainWindow>getController().setPlatform(platform); // Ensure to set the platform if needed
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



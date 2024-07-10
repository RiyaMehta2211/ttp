package InspireInclusion.ui;

import InspireInclusion.Platform;
import java.util.HashMap;

import InspireInclusion.Storage;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
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
    private static HashMap<String, String> userCredentials = new HashMap<>();
    public static boolean authentication_status;
    static {
        try {
            userCredentials = Storage.loadCredentials();
        } catch (IOException | ClassNotFoundException e) {
            e.getMessage();
        }
    }

    private static void addUserCredentials(String username, String password) {
        userCredentials.put(username, password);
        try {
            Storage.saveCredentials(userCredentials);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean authenticate(String username, String password) {
        return userCredentials.containsKey(username) && userCredentials.get(username).equals(password);
    }

    public static void start(Stage stage) {
        stage.setTitle("Login Page");
        Label username = new Label("Username: ");
        Label password = new Label("Password: ");
        Label authentication = new Label();
        Label registration = new Label();
        TextField usernameField = new TextField();
        PasswordField passwordField = new PasswordField();
        Button login = new Button("Login");
        Button signup = new Button("Signup");
        signup.setOnAction(event -> {
            String enteredUsername = usernameField.getText();
            String enteredPassword = passwordField.getText();
            if (userCredentials.containsKey(enteredUsername)) {
                registration.setText("Username already exists!");
            } else {
                addUserCredentials(enteredUsername, enteredPassword);
                registration.setText("Sign up successful! Proceed to log in!");
            }
        });
        login.setOnAction(event -> {
            String enteredUsername = usernameField.getText();
            String enteredPassword = passwordField.getText();
            if (authenticate(enteredUsername, enteredPassword)) {
                authentication.setText("Login successful!");
                authentication_status = true;
                openMainWindow(stage);
            } else if (userCredentials.containsKey(enteredUsername)) {
                authentication.setText("Login failed. Please check your credentials.");
                authentication_status = false;
            } else {
                authentication.setText("Username does not exist. Please sign up.");
                authentication_status = false;
            }
        });
        VBox root = new VBox(10);
        root.setPadding(new Insets(10, 10, 10, 10));
        root.getChildren().addAll(username, usernameField, password, passwordField, login, authentication,
                signup, registration);

        Scene scene = new Scene(root, 300, 250);
        stage.setScene(scene);
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



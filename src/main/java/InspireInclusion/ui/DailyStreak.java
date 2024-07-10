package InspireInclusion.ui;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;

public class DailyStreak extends AnchorPane{
    private Scene scene;
    private Label score;
    private StackPane stackPane;
    private ScrollPane scrollPane;
    private AnchorPane anchorPane;

    public static boolean quizAnsweredToday = false;
    public static boolean quizAlreadyDoneToday = false;
    public static int xpScore = 0;
    static String SCORE_FILE = "score.txt";
    static String DATE_FILE = "date.txt";
    private static LocalDate latestDate = LocalDate.now();

    public void updateScore() {
        score.setText("XP Score: " + xpScore);
    }

    public static void calculateScore() {
        if (quizAnsweredToday && !quizAlreadyDoneToday) {
            xpScore += 10;
        }
    }

    public void updateStreakStatus() {
        quizAnsweredToday = true;
        calculateScore();
        quizAlreadyDoneToday = true;
        saveToFiles();
    }

    private static void saveToFiles(){
        try (ObjectOutputStream scoreFile = new ObjectOutputStream(new FileOutputStream(SCORE_FILE));
             ObjectOutputStream accessDateFile = new ObjectOutputStream(new FileOutputStream(DATE_FILE))) {
            scoreFile.writeObject(xpScore);
            accessDateFile.writeObject(latestDate);
        } catch (IOException e) {
            e.getMessage();
        }
    }
    private void loadFromFiles(){
        LocalDate today = LocalDate.now();
        try (ObjectInputStream scoreFile = new ObjectInputStream(new FileInputStream(SCORE_FILE));
             ObjectInputStream accessDateFile = new ObjectInputStream(new FileInputStream(DATE_FILE))) {
            xpScore = (int) scoreFile.readObject();
            LocalDate lastAccessDate = (LocalDate) accessDateFile.readObject();
            if (lastAccessDate.isBefore(today.minusDays(1))) {
                quizAnsweredToday = false;
                xpScore = 0; //reset the streak
            } else if (lastAccessDate.equals(today.minusDays(1))) {
                quizAnsweredToday = false;
            } else if (lastAccessDate.equals(today)){
                quizAlreadyDoneToday = true;
                quizAnsweredToday = true;
            }
            if (score == null) {
                score = new Label();
            }
            score.setText("XP Score: " + xpScore);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void start(Stage stage) {
        loadFromFiles();
        anchorPane = new AnchorPane();
        anchorPane.setPrefWidth(400.0);
        anchorPane.setPrefHeight(600.0);
        anchorPane.setStyle("-fx-background-color: black;");

        scrollPane = new ScrollPane();
        scrollPane.setPrefWidth(400.0);
        scrollPane.setPrefHeight(600.0);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setStyle("-fx-background-color: black;");
        scrollPane.getStyleClass().add("scrollPane");
        //scrollPane.getStylesheets().add(getClass().getResource("DailyStreak.css").toExternalForm());

        stackPane = new StackPane();
        stackPane.setPrefWidth(400.0);
        stackPane.setPrefHeight(600.0);

        score = new Label();
        score.setId("score");
        score.setPrefWidth(150.0);
        score.setPrefHeight(150.0);
        score.setContentDisplay(ContentDisplay.CENTER);
        score.setStyle("-fx-background-radius: 150.0; -fx-background-color: #FFBF00; -fx-border-radius: 150.0; -fx-padding: 35px;");
        score.setTextFill(Color.BLACK);
        score.setFont(Font.font("Times New Roman Bold", 15));

        stackPane.getChildren().add(score);
        scrollPane.setContent(stackPane);
        anchorPane.getChildren().add(scrollPane);
        //FXMLLoader fxmlLoader = new FXMLLoader(DailyStreak.class.getResource("/view/DailyStreak.fxml"));
        score.setText("Score: " + xpScore + "XP");
        AnchorPane.setTopAnchor(scrollPane, 1.0);
        Scene scene = new Scene(anchorPane);
        scene.getStylesheets().add(getClass().getResource("/view/DailyStreak.css").toExternalForm());
        stage.setTitle("Daily Streaks");
        stage.setScene(scene);
        stage.setMinHeight(600.0);
        stage.setMinWidth(400.0);
        stage.show();


    }
}

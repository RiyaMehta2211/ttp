package InspireInclusion;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class Music {
    static MediaPlayer audio = new MediaPlayer(
            new Media(
                    new File(Music.class.getResource("/music/audio.mp3").getPath()).toURI().toString()));
    public static void playMusic() {
        audio.seek(audio.getStartTime());
        audio.play();
    }
    public static void stopMusic() {
        audio.stop();
    }
    public static void pauseMusic() {
        audio.pause();
    }
    public static void resumeMusic() {
        audio.play();
    }
}

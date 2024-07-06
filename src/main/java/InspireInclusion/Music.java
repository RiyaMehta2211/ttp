package InspireInclusion;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import java.io.InputStream;
import java.util.Objects;

public class Music {
    static String path = Music.class.getResource("/music/audio.mp3").toExternalForm();
    static MediaPlayer audio = new MediaPlayer(
            new Media(
                    new File(Music.class.getResource("/music/audio.mp3").getPath()).toURI().toString()));
                            //"C:\\Users\\User\\Pictures\\Java Projects\\FlappyBird\\sfx_wing.mp3").toURI().toString()));
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

package InspireInclusion;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class Music {
    private static final String[] AUDIO_PATHS = {
            "/music/audio.mp3",
            "/music/audio2.mp3",
            "/music/audio3.mp3"
    };
    static int i = 0;
    static MediaPlayer audio = new MediaPlayer(
            new Media(new File(Music.class.getResource(AUDIO_PATHS[0]).getPath()).toURI().toString()));
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
    public static void changeMusic() {
        if (i < 2) {
            i++;
        } else {
            i = 0;
        }
        if (audio.getStatus() == MediaPlayer.Status.PLAYING) {
            audio.pause();
        }
        audio = new MediaPlayer(
                new Media(new File(Music.class.getResource(AUDIO_PATHS[i]).getPath()).toURI().toString()));
        playMusic();
    }
}

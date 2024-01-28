import java.io.IOException;
import javax.sound.sampled.*;

public class SnakeMain {

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		new SplashScreen();
		new MenuFrame(); 
	}
}

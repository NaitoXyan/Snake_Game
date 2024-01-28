 import java.net.URL;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

public class Sound {

	Clip clip;
	float previousVolume = 0;
	float currentVolume = -17;
	FloatControl fc;
	boolean mute = true;

	public void setFile(URL  url) {

		try {
			AudioInputStream sound = AudioSystem.getAudioInputStream(url);
			clip = AudioSystem.getClip();
			clip.open(sound);
			fc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
		}catch(Exception e) {

		}
	}
	public void play() {
		fc.setValue(currentVolume);
		clip.setFramePosition(0);
		clip.start();
	
	}
	public void loop() {

		clip.loop(Clip.LOOP_CONTINUOUSLY);
		
	}
	public void stop() {	
		clip.stop();
	}
}

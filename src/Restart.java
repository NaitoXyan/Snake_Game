
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class Restart extends KeyAdapter {
	
	public static char restart = '0';
	
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_ENTER && SnakeJPanel.running == false) {
			restart = 'r';
			
		}
	}
}

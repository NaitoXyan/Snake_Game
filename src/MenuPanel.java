import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

public class MenuPanel extends JPanel  implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	final int PANEL_WIDTH = 750;
	final int PANEL_HEIGHT = 600;
	Image snakeLogo, bg;
	Timer timer1;
	int xVelocity = 1;
	int yVelocity = 1;
	int x  = 85;
	int y = 100;

	MenuPanel(){
		
		this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		this.setBackground(Color.decode("#A2D04A"));
		snakeLogo = new ImageIcon("C:\\Users\\chalb\\eclipse-workspace\\Snake_Game\\snake.png").getImage();
		timer1 = new Timer(105, this);
		timer1.start();
		
	}

	public void paint(Graphics g) {

		super.paint(g);
		Graphics2D g2D = (Graphics2D) g;
		g2D.drawImage(bg, x, y,  null);
		g2D.drawImage(snakeLogo, x, y, null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(y>=snakeLogo.getHeight(null) || y < 100) {
			yVelocity = yVelocity * -1;

		}

		y = y + yVelocity;
		repaint();

	}
}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

public class CreditPanel extends JPanel  implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	final int PANEL_WIDTH = 750;
	final int PANEL_HEIGHT = 600;
	Image  gameDesign, programming, music;
	Timer timer, timer1;
	int xVelocity = 1, xVelocity1 = 1, xVelocity2 = 1;
	int yVelocity = 1, yVelocity1 = 1, yVelocity2 = 1;
	int x  = 30,  x1 = 30, x2 = 30;
	int y = 150, y1 = 200, y2 = 250;


	CreditPanel(){

		gameDesign = new ImageIcon("C:\\Users\\chalb\\eclipse-workspace\\Snake_Game\\game_design.png").getImage();
		programming = new ImageIcon("C:\\Users\\chalb\\eclipse-workspace\\Snake_Game\\programming.png").getImage();
		music =  new ImageIcon("C:\\Users\\chalb\\eclipse-workspace\\Snake_Game\\music.png").getImage();
		timer = new Timer(60, this);
		timer.start();

		this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		this.setBackground(Color.decode("#A2D04A"));

	}

	public void paint(Graphics g) {

		super.paint(g);
		Graphics2D g2D = (Graphics2D) g;
		g2D.drawImage(gameDesign, x, y, null);
		g2D.drawImage(programming, x1, y1, null);
		g2D.drawImage(music, x2, y2, null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}

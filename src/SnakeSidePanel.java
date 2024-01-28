import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SnakeSidePanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	static int topScore = 0;
	static Timer timerSP;

	SnakeSidePanel () {
		this.setPreferredSize(new Dimension(SnakeJPanel.SCREEN_WIDTH/2,SnakeJPanel.SCREEN_HEIGHT));
		this.setBackground(Color.decode("#EEE6CE"));
		this.setFocusable(true);
		timerSP = new Timer(105,this);
		timerSP.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawSide(g);
	}
	
	public void drawSide (Graphics g) {
		
		g.setColor(Color.decode("#313552"));
		g.setFont( new Font("Helvetica",Font.BOLD, 40));
		FontMetrics metrics = getFontMetrics(g.getFont());
		
		g.drawString("TOP SCORE: " + topScore, 
				(SnakeJPanel.SCREEN_WIDTH/2 - metrics.stringWidth("TOP SCORE: " + topScore))/2,
				SnakeJPanel.SCREEN_HEIGHT/4);
		
		g.setFont( new Font("Helvetica",Font.BOLD, 25));
		g.drawString("SCORE: " + SnakeJPanel.food, 
				(SnakeJPanel.SCREEN_WIDTH - 350 - metrics.stringWidth("SCORE: " + SnakeJPanel.food))/2,
				SnakeJPanel.SCREEN_HEIGHT/3);
		
		g.setFont( new Font("Helvetica",Font.PLAIN, 25));
		g.drawString("Move Up: Up Arrowkey",(SnakeJPanel.SCREEN_WIDTH - metrics.stringWidth("Game Over"))/9, SnakeJPanel.SCREEN_HEIGHT/2);
		g.drawString("Move Left: Left Arrowkey",(SnakeJPanel.SCREEN_WIDTH - metrics.stringWidth("Game Over"))/9, SnakeJPanel.SCREEN_HEIGHT - 275);
		g.drawString("Move Down: Down Arrowkey",(SnakeJPanel.SCREEN_WIDTH - metrics.stringWidth("Game Over"))/9, SnakeJPanel.SCREEN_HEIGHT - 235);
		g.drawString("Move Right: Right Arrowkey",(SnakeJPanel.SCREEN_WIDTH - metrics.stringWidth("Game Over"))/9, SnakeJPanel.SCREEN_HEIGHT - 195);
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}
}


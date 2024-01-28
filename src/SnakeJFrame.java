import java.awt.BorderLayout;
import javax.swing.JFrame;

public class SnakeJFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	SnakeJFrame() {
	
		this.setLayout(new BorderLayout());
		
		this.add(new SnakeJPanel(), BorderLayout.CENTER);
		this.add(new SnakeSidePanel(), BorderLayout.EAST);
		
		this.setTitle("Snake!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);	
	}
}

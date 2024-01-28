import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class CreditFrame extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	CreditPanel panel = new CreditPanel();

	ImageIcon back = new ImageIcon("C:\\Users\\chalb\\eclipse-workspace\\Snake_Game\\back.png");
	JButton backButton = new JButton(back);

	CreditFrame(){

		panel = new CreditPanel();
		panel.setLayout(null);

		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
		backButton.addActionListener(this);
		backButton.setBounds(270, 450, 200, 75);

		panel.add(backButton);

		this.add(panel);
		this.setTitle("Snake Game!");
		this.pack();
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == backButton) {
			this.dispose();
			new MenuFrame();
		}
	}
}

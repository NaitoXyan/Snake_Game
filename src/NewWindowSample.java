import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class NewWindowSample implements ActionListener {
	
	JFrame frame = new JFrame();
	JLabel label = new JLabel("Snake Game!");

	NewWindowSample(){

		label.setBounds(0, 0, 100, 50);
		label.setFont(new Font(null, Font.BOLD, 25));
		
		frame.add(label);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

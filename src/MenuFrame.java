import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MenuFrame extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MenuPanel panel = new MenuPanel();

	ImageIcon play = new ImageIcon("C:\\Users\\chalb\\eclipse-workspace\\Snake_Game\\play.png");
	JButton playButton = new JButton(play);

	ImageIcon controls = new ImageIcon("C:\\Users\\chalb\\eclipse-workspace\\Snake_Game\\controls.png");
	JButton controlButton = new JButton(controls);

	ImageIcon credits = new ImageIcon("C:\\Users\\chalb\\eclipse-workspace\\Snake_Game\\Credits.png");
	JButton creditsButton = new JButton(credits);

	ImageIcon exit = new ImageIcon("C:\\Users\\chalb\\eclipse-workspace\\Snake_Game\\exit.png");
	JButton exitButton = new JButton(exit);

	Sound sound = new Sound();

	MenuFrame(){
		
		URL soundURL = getClass().getResource("/snakeThemeSound.wav");
		playMusic(soundURL);

		panel = new MenuPanel();
		panel.setLayout(null);

		playButton.setOpaque(false);
		playButton.setContentAreaFilled(false);
		playButton.setBorderPainted(true);
		playButton.addActionListener(this);
		playButton.setBounds(275, 300, 200, 75);

		creditsButton.setOpaque(false);
		creditsButton.setContentAreaFilled(false);
		creditsButton.setBorderPainted(false);
		creditsButton.addActionListener(this);
		creditsButton.setBounds(273, 390, 200, 80);

		exitButton.setOpaque(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setBorderPainted(false);
		exitButton.addActionListener(this);
		exitButton.setBounds(270, 460, 200, 75);

		panel.add(playButton);
		panel.add(controlButton);
		panel.add(creditsButton);
		panel.add(exitButton);
		sound.play();
		
		this.add(panel);
		this.setTitle("Snake Game!");
		this.pack();
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == playButton) {
			this.dispose();
			new SnakeJFrame();
		}

		if(e.getSource() == creditsButton) {
			this.dispose();
			new CreditFrame();
			sound.stop();
		}

		if(e.getSource() == exitButton) {
			int result = JOptionPane.showConfirmDialog(this,"Sure? You want to exit?", "Close Program",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			
			if(result == JOptionPane.YES_OPTION){
				System.exit(0);  
			}
			
			if (result == JOptionPane.NO_OPTION){
				System.out.println("Back to the game");
			}
		}
	}
	
	
	public void playMusic(URL url) {
		sound.setFile(url);
		sound.play();
	
	}
}
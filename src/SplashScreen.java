import javax.swing.*;
import java.awt.*;

public class SplashScreen {
	
	JFrame frame;
	JLabel image = new JLabel(new ImageIcon("C:\\Users\\chalb\\eclipse-workspace\\Snake_Game\\weirdSnake.png"));
	JLabel text = new JLabel("Did You Know?");
	JLabel text1 = new JLabel("Snakes use their tongues to navigate.");
	JProgressBar progressBar = new JProgressBar();
	JLabel message = new JLabel();
	
	SplashScreen()
	{
		createGUI();
		addImage();
		addText();
		addProgressBar();
		addMessage();
		runningPBar();
	}
	
	public void createGUI(){
		frame=new JFrame();
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		frame.setSize(600,400);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.decode("#A2D04A"));
		frame.setVisible(true);

	}
	
	public void addImage(){
		image.setSize(600,190);
		frame.add(image);
	}
	
	public void addText()
	{
		text.setFont(new Font("Calibri",Font.BOLD,20));
		text.setBounds(245,215,600,40);
		text1.setFont(new Font("Calibri",Font.PLAIN,18));
		text1.setBounds(170,240,600,40);
		text.setForeground(Color.BLACK);
		text1.setForeground(Color.BLACK);
		frame.add(text);
		frame.add(text1);
		
	}
	
	public void addMessage()
	{
		message.setBounds(250,320,200,40);
		message.setForeground(Color.black);
		message.setFont(new Font("arial",Font.BOLD,15));
		frame.add(message);
	}
	
	public void addProgressBar(){
		progressBar.setBounds(100,280,400,30);
		progressBar.setBorderPainted(true);
		progressBar.setStringPainted(true);
		progressBar.setBackground(Color.WHITE);
		progressBar.setForeground(Color.BLACK);
		progressBar.setValue(0);
		frame.add(progressBar);
	}
	
	public void runningPBar(){
		int i=0;

		while( i<=100)
		{
			try{
				Thread.sleep(100);
				progressBar.setValue(i);
				message.setText("LOADING "+Integer.toString(i)+"%");
				i++;
				if(i==100)
					frame.dispose();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}

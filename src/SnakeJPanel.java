import java.awt.event.*; 
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SnakeJPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static final int SCREEN_WIDTH = 900;
	static final int SCREEN_HEIGHT = 630;
	static final int UNIT_SIZE = 45;
	static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
	static final int DELAY = 75;
	static final int X_COORD[] = new int [GAME_UNITS];
	static final int Y_COORD[] = new int [GAME_UNITS];
	static int body = 3;
	static int food; static int foodX; static int foodY;
	static boolean running = false;
	Timer timer = new Timer(150,this);
	Random random;

	SnakeJPanel() {
		
		random = new Random();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		this.setBackground(Color.decode("#A2D04A"));
		this.setFocusable(true);
		this.addKeyListener(new SnakeKeyAdapter());
		this.addKeyListener(new Restart());
		startGame();
	}
	
	public void startGame() {
		food();
		running = true;
		timer.start();
	}
	
	public void restartGame() {
		
		if (Restart.restart == 'r') {
			
			food = 0;
			body = 3;
			running = true;
			X_COORD[0] = 0;
			Y_COORD[0] = 0;
			
			SnakeKeyAdapter.direction = 'R';
			Restart.restart = 'n';
		}
	}
		
	public void food() {
		
		foodX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
		foodY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		try 
		{
			draw(g);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void snakeMovement () {
		
		for(int i = body;i > 0; i--) {
			X_COORD[i] = X_COORD[i-1];
			Y_COORD[i] = Y_COORD[i-1];
		}
		
		switch(SnakeKeyAdapter.direction) {
		case 'U':
			Y_COORD[0] =Y_COORD[0] - UNIT_SIZE;
			break;
		case 'D':
			Y_COORD[0] = Y_COORD[0] + UNIT_SIZE;
			break;
		case 'L':
			X_COORD[0] = X_COORD[0] - UNIT_SIZE;
			break;
		case 'R':
			X_COORD[0] = X_COORD[0] + UNIT_SIZE;
			break;
		}
	}
	
	public void draw(Graphics g) throws IOException {
		
		if (running) {
		
			for (int i = 0; i < (SCREEN_WIDTH/UNIT_SIZE); i++) {
				g.setColor(Color.decode("#FFFFD0"));
				g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
				g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
			}
		
		
			final BufferedImage mouseImage = ImageIO.read(new File("C:\\Users\\chalb\\eclipse-workspace\\Snake_Game\\mouseSmall.png"));
			
			g.drawImage(mouseImage, foodX, foodY,  null);
		
			for(int i = 0; i< body;i++) {
				if(i == 0) {
					g.setColor(Color.decode("#FFFFD0"));
					g.fillRect(X_COORD[i], Y_COORD[i], UNIT_SIZE, UNIT_SIZE);
				}
				else {
					g.setColor(new Color(ThreadLocalRandom.current().nextInt(165, 207 + 1),
							ThreadLocalRandom.current().nextInt(85, 155 + 1),
							ThreadLocalRandom.current().nextInt(236, 249 + 1)));
					g.fillRect(X_COORD[i], Y_COORD[i], UNIT_SIZE, UNIT_SIZE);
				}			
			}
		}
		
		else {
			gameOver(g);
		}
	}
	
	private void gameOver(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.decode("#DC3535"));
		g.setFont( new Font("Helvetica",Font.BOLD, 75));
		FontMetrics metrics = getFontMetrics(g.getFont());
		g.drawString("Game Over", (SCREEN_WIDTH - metrics.stringWidth("Game Over"))/2, SCREEN_HEIGHT/3);
		
		g.setFont( new Font("Helvetica",Font.BOLD, 50));
		g.drawString("Press ENTER to Play Again",(SCREEN_WIDTH - metrics.stringWidth("Game Over"))/4, SCREEN_HEIGHT - SCREEN_HEIGHT/2);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(running) {
			snakeMovement();
			checkFood();
			checkCollisions();
		}
		
		else if (!running) {
			restartGame();
		}
		
		repaint();
	}

	public void checkCollisions() {
		
		for(int i = body;i>0;i--) {
			if((X_COORD[0] == X_COORD[i])&& (Y_COORD[0] == Y_COORD[i])) {
				running = false;
			}
			
			if(X_COORD[0] < 0) {
				running = false;
			}
		
			if(X_COORD[0] > SCREEN_WIDTH) {
				running = false;
			}
			
			if(Y_COORD[0] < 0) {
				running = false;
			}
			
			if(Y_COORD[0] > SCREEN_HEIGHT) {
				running = false;
			}
		}
	}

	public void checkFood() {
		
		if((X_COORD[0] == foodX) && (Y_COORD[0] == foodY)) {
			body++;
			food++;
			food();
		}
		
		if (SnakeSidePanel.topScore < food) {
			SnakeSidePanel.topScore = food;
		}
	}
}
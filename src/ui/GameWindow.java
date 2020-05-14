package ui;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameWindow extends JFrame {
	
	public static final int WIDTH = 600;
	public static final int HEIGHT = 230;
	
	private GameScreen gameScreen;
	public GameWindow()	{
		
		super("Dino");
		setSize(WIDTH,HEIGHT);
		setLocation(250, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		gameScreen = new GameScreen();
		add(gameScreen);
		addKeyListener(gameScreen);
	}
	
	public void startGame() {
		gameScreen.startGame();
	}

	public static void main(String[] args) {
		
		GameWindow gameWindow = new GameWindow();
		gameWindow.setVisible(true);
		gameWindow.startGame();
	}
}

package ui;

import static sprite.Dino.NORMAL_RUN;
import static sprite.Dino.JUMPING;
import static sprite.Dino.DOWN_RUN;
import static sprite.Dino.DEATH;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import sprite.Cloud;
import sprite.Dino;
import sprite.EnemyManager;
import sprite.Land;

@SuppressWarnings("serial")
public class GameScreen extends JPanel implements Runnable, KeyListener {
	
	public static final float GRAVITY = 0.1f;
	public static final int GROUND = 150;
	
	public static final int GAME_START_STATE = 0;
	public static final int GAME_PLAY_STATE = 1;
	public static final int GAME_OVER_STATE = 2;
	
	private Dino dino;
	private Land land;
	private Cloud cloud;
	private EnemyManager enemyManager;
	private Score score;
	
	private int gameState = GAME_START_STATE;
	private Thread thread;
	
	public GameScreen() {
		
		thread = new Thread(this);
		dino = new Dino();
		dino.setX(50);
		dino.setY(80);
		land = new Land();
		cloud = new Cloud();
		enemyManager = new EnemyManager(dino);
		score = new Score();
	}

	public void startGame() {
		
		thread.start();
	}
	
	@Override
	public void run() {
		
		while(true) {
			try {
				update();
				repaint();
				Thread.sleep(20);
			} 
			catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	public void update() {
		switch(gameState) {
			case GAME_PLAY_STATE:
				dino.update();
				land.update();
				cloud.update();
				enemyManager.update();
				score.update();
				if(!dino.getAlive()) {
					gameState = GAME_OVER_STATE;
					dino.setState(DEATH);
				}
				break;
		}
		
	}

	@Override
	public void paint(Graphics graphics) {
		
		graphics.setColor(Color.decode("#f7f7f7"));
		graphics.fillRect(0, 0, getWidth(), getHeight());
		switch(gameState) {
			case GAME_START_STATE:
				dino.draw(graphics);
				break;
			case GAME_PLAY_STATE:
				cloud.draw(graphics);
				land.draw(graphics);
				dino.draw(graphics);
				enemyManager.draw(graphics);
				score.draw(graphics);
				break;
			case GAME_OVER_STATE:
				cloud.draw(graphics);
				land.draw(graphics);
				dino.draw(graphics);
				enemyManager.draw(graphics);
				GameOver.draw(graphics);
				break;
		}
		
	}
	
	private void restartGame() {
		dino.setAlive(true);
		dino.setX(50);
		dino.setY(80);
		dino.setState(JUMPING);
		score.reset();
		enemyManager.reset();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
				
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(gameState == GAME_PLAY_STATE) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_UP:
				dino.jump();
				break;
			case KeyEvent.VK_DOWN:
				dino.bend();
				break;
			}
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_SPACE:
				if(gameState == GAME_START_STATE) {
					gameState = GAME_PLAY_STATE;
				}
				else if(gameState == GAME_OVER_STATE) {
					restartGame();
					gameState = GAME_PLAY_STATE;
				}
				break;
			case KeyEvent.VK_DOWN:
				if(dino.getState() == DOWN_RUN) {
					dino.setState(NORMAL_RUN);
					break;
				}
		}
		
	}
}

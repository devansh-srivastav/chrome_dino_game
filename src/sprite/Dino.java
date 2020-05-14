package sprite;

import static ui.GameScreen.GRAVITY;
import static ui.GameScreen.GROUND;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import res.Animation;
import res.Resource;

public class Dino {
	
	public static final int NORMAL_RUN = 0;
	public static final int JUMPING = 1;
	public static final int DOWN_RUN = 2;
	public static final int DEATH = 3;
	
	private int x = 0;
	private int y = 0;
	private int state;
	private float posY = 0;
	private Rectangle rectangle;
	private boolean isAlive = true;
	
	private BufferedImage jumpImage;
	private BufferedImage deadImage;
	private Animation normalRun;
	private Animation downRun;
	
	public Dino() {
		normalRun = new Animation(200);
		downRun = new Animation(200);
		rectangle = new Rectangle();
		state = JUMPING;
		normalRun.addFrame(Resource.getResourceimage("resources/dino1.png"));
		normalRun.addFrame(Resource.getResourceimage("resources/dino2.png"));
		jumpImage = Resource.getResourceimage("resources/dino3.png");
		deadImage = Resource.getResourceimage("resources/dino4.png");
		downRun.addFrame(Resource.getResourceimage("resources/dino5.png"));
		downRun.addFrame(Resource.getResourceimage("resources/dino6.png"));
	}
	
	public void update() {
		normalRun.update();
		downRun.update();
		if(state == JUMPING) {
			if(y>GROUND-normalRun.getFrame().getHeight()) {
				posY = 0;
				y = GROUND-normalRun.getFrame().getHeight();
				state = NORMAL_RUN;
			}
			else {
				y+=posY;
				posY+=GRAVITY;
			}
			rectangle.width = normalRun.getFrame().getWidth();
			rectangle.height = normalRun.getFrame().getHeight();
		}
		else {
			rectangle.width = downRun.getFrame().getWidth();
			rectangle.height = downRun.getFrame().getHeight();
		}
		rectangle.x = x;
		rectangle.y = y;
		
	}
	
	public Rectangle getBound() {
		return rectangle;
	}
	
	public void draw(Graphics graphics) {
		switch(state) {
			case NORMAL_RUN:
				graphics.drawImage(normalRun.getFrame(), (int) x, (int) y+10, null);
				break;
			case JUMPING:
				graphics.drawImage(jumpImage, (int) x, (int) y+10, null);
				break;
			case DOWN_RUN:
				graphics.drawImage(downRun.getFrame(), (int) x, (int) y+27, null);
				break;
			case DEATH:
				graphics.drawImage(deadImage, (int) x, (int) y+10, null);
				break;
		}
	}
	public void jump() {
		state = JUMPING;
		posY = -4;
		y+=posY;
	}
	public void bend() {
		if(state==JUMPING) {
			posY = 0;
			y = GROUND-normalRun.getFrame().getHeight();
			state = NORMAL_RUN;
		}
		else {
			state = DOWN_RUN;
		}
	}
	public float getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public float getPosY() {
		return posY;
	}
	public void setPosY(float posY) {
		this.posY = posY;
	}
	public void setAlive(boolean alive) {
		isAlive = alive;
	}
	public boolean getAlive() {
		return isAlive;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getState() {
		return state;
	}
}

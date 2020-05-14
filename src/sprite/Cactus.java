package sprite;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Cactus extends Enemy {
	
	private BufferedImage cactusImage;
	private int cactusHeight;
	private int cactusWidth;
	private int positionX;
	private int positionY;
	private Rectangle rectangle;
	
	public Cactus() {
		rectangle = new Rectangle();
	}
	
	@Override
	public void update() {
		positionX -= 3;
		rectangle.x = positionX;
		rectangle.y = positionY;
		rectangle.width = cactusWidth;
		rectangle.height = cactusHeight;
	}
	
	@Override
	public Rectangle getBound() {
		return rectangle;
	}
	
	@Override
	public void draw(Graphics graphics) {
		graphics.drawImage(cactusImage, positionX, positionY, null);
	}
	
	@Override
	public boolean isOutOfScreen() {
		return (positionX + cactusImage.getWidth() < 0 ); 
	}
	
	
	public void setImage(BufferedImage cactusImage) {
		
		this.cactusImage = cactusImage;
		cactusWidth = cactusImage.getWidth();
		cactusHeight = cactusImage.getHeight();
	}
	
	public void setX(int positionX) {
		this.positionX = positionX;
	}
	
	public void setY(int positionY) {
		this.positionY = positionY;
	}
	
}

package sprite;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Enemy {

	public abstract Rectangle getBound();
	public abstract void draw(Graphics graphics);
	public abstract void update();
	public abstract boolean isOutOfScreen();
	
}

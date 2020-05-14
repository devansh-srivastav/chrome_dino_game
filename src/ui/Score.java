package ui;

import static ui.GameScreen.GRAVITY;

import java.awt.Color;
import java.awt.Graphics;

public class Score {
	private float score;
		
	
	public Score() {
		score = 0;
	}
	
	public void update() {
		score += 3*GRAVITY/2;
	}
	
	public void draw(Graphics graphics) {
		graphics.setColor(Color.black);
		graphics.drawString("Score:"+String.valueOf((int)score), 500, 40);
	}
	
	public void reset() {
		score = 0;
	}
}
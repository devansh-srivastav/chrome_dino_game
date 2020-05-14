package ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import res.Resource;

public final class GameOver {
	private static final BufferedImage GAME_OVER = Resource.getResourceimage("resources/gameover_text.png");
	private static final BufferedImage REPLAY = Resource.getResourceimage("resources/replay_button.png");
	public static final void draw(Graphics graphics) {
		graphics.drawImage(GAME_OVER, 180, 60, null);
		graphics.drawImage(REPLAY, 260, 90, null);
	}
}

package sprite;

import static ui.GameScreen.GROUND;
import static ui.GameWindow.WIDTH;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import res.Resource;

public class Land {
	
	private List<ImageLand> lands;
	private BufferedImage land1, land2, land3;
	private int numberOfLands;
	private int imageWidth;
	private int imageHeight;
	private Random random;
	
	public Land() {
		land1 = Resource.getResourceimage("resources/land1.png");
		land2 = Resource.getResourceimage("resources/land2.png");
		land3 = Resource.getResourceimage("resources/land3.png");
		imageWidth = land1.getWidth();
		imageHeight = land1.getHeight();
		random = new Random();
		lands = new ArrayList<Land.ImageLand>();
		numberOfLands = WIDTH/imageWidth + 1;
		for(int i=0;i<=numberOfLands;i++) {
			ImageLand imageLand = new ImageLand();
			imageLand.position = i*imageWidth;
			imageLand.image = getLand();
			lands.add(imageLand);
		}
	}
	
	public void update() {
		for(ImageLand imageLand : lands) {
			imageLand.position -= 4;
		}
		ImageLand buffer = lands.get(0);
		if(buffer.position+imageWidth<0) {
			buffer.position = lands.get(lands.size()-1).position+imageWidth;
			lands.add(buffer);
			lands.remove(0);
		}
	}
	
	private BufferedImage getLand() {
		int buffer = random.nextInt(5);
		switch(buffer) {
			case 0: return land1;
			case 1: return land3;
			default: return land2;
		}
	}
	
	public void draw(Graphics graphics) {
		for(ImageLand imageLand : lands) {
			graphics.drawImage(imageLand.image, imageLand.position, GROUND - imageHeight/2, null);
		}
	}
	
	private class ImageLand {
		int position;
		BufferedImage image;
	}
}

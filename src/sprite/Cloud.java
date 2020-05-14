package sprite;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import res.Resource;

public class Cloud {

	private List<ImageCloud> clouds;
	private BufferedImage cloud;
	private int cloudWidth;
	
	public Cloud() {
		cloud = Resource.getResourceimage("resources/cloud.png");
		clouds = new ArrayList<Cloud.ImageCloud>();
		cloudWidth = cloud.getWidth();
		
		ImageCloud imageCloud = new ImageCloud();
		imageCloud.positionX = 100;
		imageCloud.positionY = 50;
		clouds.add(imageCloud);
		
		imageCloud = new ImageCloud();
		imageCloud.positionX = 250;
		imageCloud.positionY = 35;
		clouds.add(imageCloud);
		
		imageCloud = new ImageCloud();
		imageCloud.positionX = 400;
		imageCloud.positionY = 25;
		clouds.add(imageCloud);
		
		imageCloud = new ImageCloud();
		imageCloud.positionX = 600;
		imageCloud.positionY = 50;
		clouds.add(imageCloud);
		
		imageCloud = new ImageCloud();
		imageCloud.positionX = 900;
		imageCloud.positionY = 30;
		clouds.add(imageCloud);
		
	}
	
	public void update() {
		for(ImageCloud imageCloud : clouds) {
			imageCloud.positionX--;
		}
		ImageCloud buffer = clouds.get(0);
		if(buffer.positionX+cloudWidth<0) {
			buffer.positionX = 900;
			clouds.add(buffer);
			clouds.remove(0);
		}
	}
	
	public void draw(Graphics graphics) {
		for(ImageCloud imageCloud : clouds) {
			graphics.drawImage(cloud, imageCloud.positionX, imageCloud.positionY, null);
		}
	}
	
	private class ImageCloud {
		int positionX;
		int positionY;
	}
}

package res;

import java.util.List;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Animation {
	private List<BufferedImage> frames;
	private int index;
	private int deltaTime;
	private long previousTime;
	
	public Animation(int deltaTime) {
		this.deltaTime = deltaTime;
		frames = new ArrayList<BufferedImage>();
	}
	public void update() {
		if(System.currentTimeMillis()-previousTime>deltaTime) {
			index++;
			if(index>=frames.size()) {
				index = 0;
			}
			previousTime = System.currentTimeMillis();
		}
	}
	public void addFrame(BufferedImage frame) {
		frames.add(frame);
	}
	public BufferedImage getFrame() {
		if(frames.size()>0) {
			return frames.get(index);
		}
		return null;
	}
}

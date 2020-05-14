package sprite;

import static ui.GameScreen.GROUND;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import res.Resource;

public class EnemyManager {

	private List<Enemy> enemies;
	private Random random;
	private BufferedImage cactus1;
	private BufferedImage cactus2;
	private Dino dino;
	
	public EnemyManager(Dino dino) {
		this.dino = dino;
		enemies = new ArrayList<Enemy>();
		cactus1 = Resource.getResourceimage("resources/cactus1.png");
		cactus2 = Resource.getResourceimage("resources/cactus2.png");
		random = new Random();
		enemies.add(getCactus());
		
	}
	
	public void update() {
		for(Enemy enemy : enemies) {
			enemy.update();
			if(enemy.getBound().intersects(dino.getBound())) {
				dino.setAlive(false);
			}
		}
		Enemy buffer = enemies.get(0);
		if(buffer.isOutOfScreen()) {
			enemies.remove(buffer);
			enemies.add(getCactus());
		}
	}
	
	public void draw(Graphics graphics) {
		for(Enemy enemy : enemies) {
			enemy.draw(graphics);
		}
	}
	
	public void reset() {
		enemies.clear();
		enemies.add(getCactus());
	}
	
	private Cactus getCactus() {
		Cactus cactus = new Cactus();
		cactus.setX(600);
		if(random.nextBoolean()) {
			cactus.setImage(cactus1);
			cactus.setY(GROUND-cactus1.getHeight()+10);
		}
		else {
			cactus.setImage(cactus2);
			cactus.setY(GROUND-cactus2.getHeight()+10);
		}
		return cactus;
	}
	
}

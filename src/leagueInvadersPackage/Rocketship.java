package leagueInvadersPackage;

import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	int speed;
	boolean up = false;
	boolean down = false;
	boolean right = false;
	boolean left = false;
		
	
	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;	
	}
	
	void update() {
		super.update();
		if (up == true) {
			y = y - speed;
		}
		if (down == true) {
			y = y + speed;
		}
		if (right == true) {
			x = x + speed;
		}
		if (left == true) {
			x = x - speed;
		}

	}
	
	void draw(Graphics g) {
		g.drawImage(GamePanel.rocketImg, x, y, width, height, null);
	}

}

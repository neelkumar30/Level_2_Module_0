package leagueInvadersPackage;

import java.awt.Color;
import java.awt.Graphics;

public class Projectiles extends GameObject {
	int speed = 12;
	public Projectiles(int x, int y, int width, int height) {
		super(x, y, width, height);

	}
	void update() {
		super.update();
		y = y - speed;
		if(y<0) {
			isAlive = false;
		}
	}
	void draw(Graphics g) {
		g.drawImage(GamePanel.bulletImg, x, y, width, height, null);
	}
}
	
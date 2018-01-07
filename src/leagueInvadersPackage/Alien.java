package leagueInvadersPackage;

import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject{
	static boolean gameOver = false;
	public Alien(int x, int y, int width, int height){
		super(x, y, width, height);
	}
	
	void update() {
		super.update();
		y = y+4;
		if(y>800) {
			gameOver = true;
		}
	}
	void draw(Graphics g) {
		g.drawImage(GamePanel.alienImg, x, y, width, height, null);
	}
}

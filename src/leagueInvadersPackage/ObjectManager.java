package leagueInvadersPackage;

import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {

	Rocketship rocket2;
	ArrayList<Projectiles> projectiles = new ArrayList<Projectiles>();

	public ObjectManager(Rocketship rocket) {
		rocket2 = rocket;
	}

	void update() {
		rocket2.update();
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
		}
	}

	void draw(Graphics g) {
		rocket2.draw(g);
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
	}
	void addProjectile(Projectiles projectile) {
		projectiles.add(projectile);
	}
}

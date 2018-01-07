package leagueInvadersPackage;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {

	Rocketship rocket;
	long enemyTimer;
	ArrayList<Projectiles> projectiles = new ArrayList<Projectiles>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	long enemySpawnTime = 700;
	int score = 0;

	public ObjectManager(Rocketship rocket) {
		this.rocket = rocket;
	}

	void update() {
		rocket.update();
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
		}
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
			if(Alien.gameOver == true) {
				rocket.isAlive = false;
				aliens.get(i).isAlive = false;
			}
		}
	}

	void draw(Graphics g) {
		rocket.draw(g);
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}
	}

	void addProjectile(Projectiles projectile) {
		projectiles.add(projectile);
	}

	void addAlien(Alien alien) {
		aliens.add(alien);
	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Alien(new Random().nextInt(LeagueInvaders.width -45), 0, 50, 50));

			enemyTimer = System.currentTimeMillis();
		}
	}

	void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			if(aliens.get(i).isAlive == false) {
				aliens.remove(i);
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			if(projectiles.get(i).isAlive == false) {
				projectiles.remove(i);
			}
		}
	}

	void checkCollision() {
		for(Alien a : aliens){
	        if(rocket.collisionBox.intersects(a.collisionBox)){
	                rocket.isAlive = false;
	        }
	    for (Projectiles projectile : projectiles) {
			if(projectile.collisionBox.intersects(a.collisionBox)) {
					a.isAlive = false;
					projectile.isAlive=false;
					score = score+1;
			}
		}
	}
	}
	int getScore() {
		return score;
	}
	void reset() {
		projectiles.clear();
		aliens.clear();
		score = 0;
		Alien.gameOver = false;
	}
	void addRocket(Rocketship rocket) {
		this.rocket = rocket;
	}
}

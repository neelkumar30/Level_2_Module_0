package leagueInvadersPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer = new Timer(1000 / 60, this);
	final int MENU_STATE = 0;

	final int GAME_STATE = 1;

	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font font = new Font("Arial", Font.PLAIN, 48);
	Font font1 = new Font("Arial", Font.PLAIN, 30);
	Font font2 = new Font("Arial", Font.PLAIN, 30);
	Font font3 = new Font("Arial", Font.PLAIN, 48);
	Font font4 = new Font("Arial", Font.PLAIN, 30);
	Font font5 = new Font("Arial", Font.PLAIN, 30);

	Rocketship rocket = new Rocketship(250, 700, 50, 50);
	ObjectManager object = new ObjectManager(rocket);

	GamePanel() {

	}

	void updateMenuState() {

	}

	void updateGameState() {
		object.update();
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.length);
		g.setFont(font);
		g.setColor(Color.RED);
		g.drawString("League Invaders", 60, 100);
		g.setFont(font1);
		g.setColor(Color.RED);
		g.drawString("Press ENTER to Start", 100, 300);
		g.setFont(font2);
		g.setColor(Color.RED);
		g.drawString("Press SPACE for Instructions", 55, 450);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.length);
		object.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.length);
		g.setFont(font3);
		g.setColor(Color.BLACK);
		g.drawString("GAME OVER", 100, 100);
		g.setFont(font4);
		g.setColor(Color.BLACK);
		g.drawString("You killed X enemies", 100, 300);
		g.setFont(font5);
		g.setColor(Color.BLACK);
		g.drawString("Press ENTER to Restart", 75, 450);
	}

	public void paintComponent(Graphics g) {

		if (currentState == MENU_STATE) {

			drawMenuState(g);

		} else if (currentState == GAME_STATE) {

			drawGameState(g);

		} else if (currentState == END_STATE) {

			drawEndState(g);

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();

		if (currentState == MENU_STATE) {

			updateMenuState();

		} else if (currentState == GAME_STATE) {

			updateGameState();

		} else if (currentState == END_STATE) {

			updateEndState();

		}
	}

	void StartGame() {
		timer.start();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Hi");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Ozil");
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState = currentState + 1;
		}
		if (currentState > END_STATE) {

			currentState = MENU_STATE;

		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			rocket.up = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			rocket.down = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rocket.right = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			rocket.left = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			 object.addProjectile(new Projectiles(rocket.x+20, rocket.y, 10, 10));
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Chargers");
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			rocket.up = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			rocket.down = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rocket.right = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			rocket.left = false;
		}

	}
}

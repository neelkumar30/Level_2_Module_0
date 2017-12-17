package leagueInvadersPackage;

import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame = new JFrame();
	static final int width = 500;
	static final int length = 800;
	GamePanel panel = new GamePanel();
	LeagueInvaders(){
		
	}
	
	void setup() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.getContentPane().setPreferredSize(new Dimension(width, length));
        frame.pack();
        panel.StartGame();
        frame.addKeyListener(panel);
	}
	
	public static void main(String[] args) {
		LeagueInvaders league = new LeagueInvaders();
		league.setup();
	}
}

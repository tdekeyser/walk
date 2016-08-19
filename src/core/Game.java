package core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JPanel;

import gamestate.GameStateManager;
import player.PlayAdapter;

public class Game extends JPanel {
	
	public static boolean BOT_LEVEL = false;
	
	public static Game game;
	Graphics2D g2d;
	
	public static int GAME_WIDTH = Settings.DIMENSION_X;
	public static int GAME_HEIGHT = Settings.DIMENSION_Y;
	public static int offSetX;
	public static int offSetY;
	public static Rectangle windowBounds = new Rectangle(0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT);
	
	public boolean gameRunning = false;
	public static double deltaTime = (double) 1/65;
	public static int LOOP_KEEP = 60;
	
	public static GameStateManager gameStateManager = new GameStateManager();
	
	public PlayAdapter getKeyManager() {
		return gameStateManager.getKeyAdapter();
	}
	
	public void init() {
		gameStateManager.init();
	}
	
	public void update() {
		gameStateManager.update();
	}
	
	public void run(double delta) {
		// gameLoop
		gameRunning = true;
		
		double nextTime = (double) System.nanoTime() / 1000000000.0;
		
		while (true) {
			
			double currTime = (double) System.nanoTime() / 1000000000.0;
			
			if (currTime > nextTime) {
				// assign the time for next update
				nextTime += delta;
				update();
				repaint();
				
				Game.LOOP_KEEP--;
				if (Game.LOOP_KEEP == 0) Game.LOOP_KEEP = 60;
				
			} else {
				// calculate the time to sleep
				int sleepTime = (int) (1000.0 * (nextTime - currTime));
				
				// sanity check
				if (sleepTime > 0) {
					try {
						Thread.sleep(sleepTime);
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
				}
			}
		}
	}
	
	@Override
    public void paint(Graphics g) {
            super.paint(g);
            g2d = (Graphics2D) g;
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
            
            gameStateManager.render(g2d);
            
            setLocation(0, 0);
    }
	
	public static void main(String[] args) {
		GameWindow gameWindow = new GameWindow(GAME_WIDTH, GAME_HEIGHT, "Game");
		Game game = new Game();
		
		gameWindow.add(game);
		gameWindow.setupFrame();
		
		game.init();
		gameWindow.addKeyListener(game.getKeyManager());
		game.run(deltaTime);
		
	}

}

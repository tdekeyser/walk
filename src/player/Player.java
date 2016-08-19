package player;

import java.awt.Graphics2D;

import components.Tile;
import components.TileGrid;
import core.Settings;
import level.Level;
import sprite.MovingSprite;

public class Player extends MovingSprite {
	
	private static int playerX = (Settings.DIMENSION_X/2) / Settings.TILE_WIDTH; // set player to middle of frame
	private static int playerY = (Settings.DIMENSION_Y/2 - 32) / Settings.TILE_WIDTH;
	private static String[] animationImages = {"player-l1",	"player-l",	"player-r1", "player-r", "player-d", "player-d1", "player-d2", "player-u", "player-u1", "player-u2"};

	private Reader reader;
	private boolean isReading;
	
	public Player(TileGrid tileGrid) {
		super("player-d", playerX, playerY, tileGrid, animationImages);
		reader = new Reader(this);
	}
	
	public void update() {
		try {
			if (isReading && !isMoving()) {
				reader.read();
			} else {
				reader.update();
				super.move();
			} 
		} catch (ArrayIndexOutOfBoundsException ex) { // going off the map
			Level.toNextLevel = true;
		}
	}
	
	public void render(Graphics2D g) {
		g.drawImage(getImage(), getCX(), getCY(), null); // always keep player in the middle of the frame
		reader.render(g);
	}
	
	public Tile getTargetTile() {
		// determine target coordinates within grid
		int tileA = getCurrentTile().getA() + getStopDir()[0];
		int tileB = getCurrentTile().getB() + getStopDir()[1];
		Tile targetTile = getTileGrid().getMap()[tileA][tileB];
		
		System.out.println("Target: " + targetTile.getA() + ", " + targetTile.getB());
		return targetTile;
	}
	
	public int[] getStopDir() {
		int[] dirAB = new int[2];
		if (stoppedLeft()) {
			dirAB[0] = 0;
			dirAB[1] = -1;
		} else if (stoppedRight()) {
			dirAB[0] = 0;
			dirAB[1] = 1;
		} else if (stoppedDown()) {
			dirAB[0] = 1;
			dirAB[1] = 0;
		} else if (stoppedUp()) {
			dirAB[0] = -1;
			dirAB[1] = 0;
		}
		return dirAB;
	}
	
	public void isReading(boolean r) {
		isReading = r;
	}
	
}

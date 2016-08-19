package robot;

import java.awt.AWTException;

import components.Tile;
import components.TileGrid;
import core.Randomizer;
import level.Level;
import player.PlayAdapter;
import player.Player;

public class Bot extends Player {
	
	private static boolean aiIsImplemented = false;
	
	private BotKeyAdapter botKeyAdapter;
	
	private String moveDir;

	public Bot(TileGrid tileGrid) {
		super(tileGrid);		
		setRobotKeyAdapter("left");
		
		PlayAdapter.speed = 2;
	}
	
	public void setRobotKeyAdapter(String startDir) {
		try {
			this.botKeyAdapter = new BotKeyAdapter();
			this.setMoveDir(startDir);
		} catch (AWTException x) {
			x.printStackTrace();
		}
	}

	@Override
	public void move() {
		this.simulateMovement();
	}
	
	@Override
	public void update() {
		// press a movement button
		this.move();	
		// executes actual movement through superclass
		super.update();
	}
	
	public boolean isBlocked() {
		Tile target = this.getTargetTile();
		System.out.println(target.toString() + " walkable? "+ target.isWalkable());
		return (!target.isWalkable());
	}
	
	@Override
	public Tile getTargetTile() {
//		doesnt work!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		int x = 0;
		int y = 0;
		switch (moveDir) {
		case "left": x = -1;
		case "right": x = 1;
		case "up": y = -1;
		case "down": y = 1;
		}
		// determine target coordinates within grid
		int tileA = getCX() + Level.levelOffSetX + x;
		int tileB = getCY() + Level.levelOffSetY + y;
		
		Tile targetTile = getTileGrid().getMap()[Math.abs(tileA/64)][Math.abs(tileB/64)];
		
//		System.out.println("Target: " + targetTile.toString());
		return targetTile;
	}
	
	public void simulateMovement() {
		if (isBlocked()) {
			resetOptimalDir();
		} else {
			botKeyAdapter.moveInDirection(moveDir);
		}
	}
	
	public void resetOptimalDir() {
		if (aiIsImplemented) {
			performAI();
		} else {
			setMoveDir(getRandomDir());
			System.out.println(getMoveDir());
		}
	}
	
	public void performAI() {}
	
	public String getRandomDir() {
		// perform random movement switches
		int r = Randomizer.random(4);
		switch (r) {
			case 0: return "down";
			case 1: return "right";
			case 2: return "up";
			case 3: return "left";
			default: return "";
		}
	}
	
	public void interact() {
		botKeyAdapter.read();
	}
	
	public void setMoveDir(String dir) {
		this.moveDir = dir;
	}
	
	public String getMoveDir() {
		return moveDir;
	}

}

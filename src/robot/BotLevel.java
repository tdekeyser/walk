package robot;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import components.TileGrid;
import core.Game;
import level.Level;
import level.LevelMaker;
import player.PlayAdapter;
import sprite.Sprite;

public class BotLevel {
	/*
	 * Identical to Level class, but initialises the player as Bot (=TESTER)
	 */
	
	private LevelMaker levelMaker;
	
	public static int levelOffSetX = 0;
	public static int levelOffSetY = 0;
	
	private TileGrid tileGrid;
	
	private Bot robot;
	private PlayAdapter playAdapter;
	
	public static List<Sprite> opponents = new ArrayList<>();
	public static boolean toNextLevel = false;
	
	public BotLevel(int levelID) {
		loadLevel(levelID);
		
		// robot test init
		this.robot = new Bot(tileGrid);
		this.playAdapter = new PlayAdapter(robot);
		
	}
	
	public void loadLevel(int levelID) {
		// load content
		this.levelMaker = new LevelMaker(levelID);
		
		// set initial offsets
		Level.levelOffSetX = levelMaker.getLevelOffSetX();
		Level.levelOffSetY = levelMaker.getLevelOffSetY();
		
		// create tile grid based on level map
		this.tileGrid = new TileGrid(levelMaker.getLevelMap());
	
	}
	
	public void update() {
		if (!toNextLevel) {
			
			robot.update();
			
		} else {
			// moving off the map
			toNextLevel = false;
			
			/*
			 * Sth's not right here; it (correctly) opens a new window and everything works;
			 * but it should not open a new window without closing the previous.
			 */
			Game.gameStateManager.switchState(); // update the gamestate
			Game.main(null); // call main again to reimplement the key listener
		}
	}

    public void render(Graphics2D g) {       	
    	tileGrid.render(g);
    	
    	for (Sprite s : opponents) {
    		s.render(g);
    	}
    	
    	robot.render(g);
    	
    }
    
    public TileGrid getTileGrid() {
		return this.tileGrid;
	}
    
    public PlayAdapter getKeyAdapter() {
    	return playAdapter;
    }
	
}

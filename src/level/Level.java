package level;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import components.TileGrid;
import core.Game;
import player.PlayAdapter;
import player.Player;
import robot.DragonSlayer;
import sprite.Sprite;

public class Level {
	/*
	 * Creates new level based on a tile map, player and opponents
	 */
	
	private LevelMaker levelMaker;
	
	public static int levelOffSetX = 0;
	public static int levelOffSetY = 0;
	
	private TileGrid tileGrid;
	
	private Player player;
	private DragonSlayer dragonSlayer;
	public static List<Sprite> opponents = new ArrayList<>();
	
	private PlayAdapter playAdapter;

	public static boolean toNextLevel = false;
	
	public Level(int levelID) {
		loadLevel(levelID);
		
		// player test init
		this.player = new Player(tileGrid);
		this.dragonSlayer = new DragonSlayer(2, 14, tileGrid);
		Level.opponents.add(dragonSlayer);
		
		this.playAdapter = new PlayAdapter(player);
		
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
			player.update();
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
    	player.render(g);
    }
    
    public TileGrid getTileGrid() {
		return this.tileGrid;
	}
    
    public PlayAdapter getKeyAdapter() {
    	return playAdapter;
    }
	
}

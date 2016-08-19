package gamestate;

import java.awt.Graphics2D;

import core.Game;
import level.Level;
import player.PlayAdapter;
import robot.BotLevel;

public class GameState implements PlayState {
	
	Level level;
	BotLevel botLevel;
	private int GAME_LEVEL = 1;
	
	@Override
	public void init() {
		if (!Game.BOT_LEVEL) {
			level = new Level(GAME_LEVEL);
		} else {
			botLevel = new BotLevel(GAME_LEVEL);
		}
	}
	
	@Override
	public void update() {
		if (!Game.BOT_LEVEL) {
			level.update();
		} else {
			botLevel.update();
		}	
	}
	
	@Override
	public void render(Graphics2D g) {
		if (level != null && !Game.BOT_LEVEL) {
			level.render(g);;
		} else if (botLevel != null) {
			botLevel.render(g);
		}
	}
	
	public PlayAdapter getKeyAdapter() {
		if (!Game.BOT_LEVEL) {
			return level.getKeyAdapter();
		} else {
			return botLevel.getKeyAdapter();
		}
	}
	
	public void toNextLevel() {
		try {
			this.GAME_LEVEL++;
			init();
		} catch (ArrayIndexOutOfBoundsException ex) { // going to too high level
			this.GAME_LEVEL-=2;
			init();
		}
	}

}

package gamestate;

import java.awt.Graphics2D;

import player.PlayAdapter;

public class GameStateManager {
	
	public GameState gameState;
	
	public GameStateManager() {
		this.gameState = new GameState();
	}
	
	public void init() {
		gameState.init();
	}
	
	public void update() {
		gameState.update();
	}
	
	public void render(Graphics2D g) {
		gameState.render(g);
	}
	
	public PlayAdapter getKeyAdapter() {
		return gameState.getKeyAdapter();
	}
	
	public void switchState() {
		this.gameState.toNextLevel();
		
	}
	
}

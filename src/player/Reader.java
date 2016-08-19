package player;

import java.awt.Graphics2D;

import components.TextBox;
import components.Tile;

public class Reader implements Interacting {
	
	private Player player;
	private TextBox textBox = null;
	
	public Reader(Player player) {
		this.player = player;
	}
	
	public void update() {
		// remove textbox on movement
		if (player.isMoving()) textBox = null;
	}
	
	public void render(Graphics2D g) {
		if (textBox != null) textBox.render(g);
	}
	
	public void read() {
		// read from the tiles
		if (textBox != null && !textBox.isReady()) {
			textBox.update();
		} else if (textBox == null) {
			read(player.getTargetTile());
		} else {		
			player.isReading(false);
		}
	}
	
	@Override
	public void read(Tile target) {
		// creates textbox with tile content (if it has any)
		if (target.hasTreasure() || player.getCurrentTile().hasTreasure()) {
			textBox = new TextBox("There is treasure here!");
			getReward();
		} else if (target.tellStory() != null) {
			textBox = new TextBox(target.tellStory());
		} else {
			player.isReading(false);
		}
	}
	
	@Override
	public void getReward() {
		/* when treasure found, gets reward etc etc.
		 * Important for Robot to override; adds the supervised part of learning.
		 */
	}

}

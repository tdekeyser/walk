package gamestate;

import java.awt.Graphics2D;

public interface PlayState {
	
	public void init();
	public void update();
	public void render(Graphics2D g);

}

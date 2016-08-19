package player;

import components.Tile;

public interface Interacting {
	public void read(Tile targetTile);
	public void getReward();
}

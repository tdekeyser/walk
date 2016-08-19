package sprite;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import components.Tile;
import components.TileGrid;
import core.Loader;
import core.Settings;
import level.Level;

public abstract class Sprite {
	
	protected float x, y;
	protected float cx, cy; // coordinates in game
	private Rectangle rectPos; // rectangle position of sprite
	
	private BufferedImage img;
	private int tileWidth = Settings.TILE_WIDTH;
	
	private TileGrid tileGrid;
	private Tile currentTile;
	
	public Sprite(String img, int x, int y, TileGrid tileGrid) {
		this.x = x;
		this.y = y;
		this.cx = x*tileWidth;
		this.cy = y*tileWidth;
		this.tileGrid = tileGrid;
		
		setCurrentTile(tileGrid.getMap()[y][x]);
		setImage(img);
		setBounds();
	
	}
	
	public void render(Graphics g) {
		g.drawImage(getImage(), getCX() + Level.levelOffSetX, getCY() + Level.levelOffSetY, null);
	}
	
	public Rectangle getBounds() {
		setBounds();
		return rectPos;
	}
	
	public void setBounds() {
		this.rectPos = new Rectangle(getCX() + Level.levelOffSetX, getCY() + Level.levelOffSetY, tileWidth, getImage().getHeight());
	}

	public int getX() { return (int) this.x; }
	public int getY() { return (int) this.y; }
	public int getCX() { return (int) this.cx; }
	public int getCY() { return (int) this.cy; }
	public BufferedImage getImage() { return this.img; }
	public Tile getCurrentTile() { return this.currentTile; }
	public TileGrid getTileGrid() { return this.tileGrid; }

	public void setImage(String path) { this.img = new Loader().quickLoad(path); }
	public void setCurrentTile(Tile tile) { this.currentTile = tile; }
	
}

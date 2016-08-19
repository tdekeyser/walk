package components;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import core.Game;
import core.Loader;
import level.Level;

public class Tile {
	
	private int a, b; // coordinates within grid
	private int cX, cY; // coordinates
	private int width, height;
	private TileType type;
	private BufferedImage texture;
	
	private boolean inWindow; // tile appears in game window
	
	public Tile(int a, int b, int width, int height, TileType type) {
		this.a = a;
		this.b = b;
		this.width = width;
		this.height = height;
		this.type = type;
		this.texture = new Loader().quickLoad(type.textureName);
		
		this.cX = b*width;
		this.cY = a*height;
	}
	
	public void update() {
		Rectangle rect = getBounds();
		if (rect.intersects(Game.windowBounds)) {
			inWindow = true;
		} else {
			inWindow = false;
		}
	}
	
	public void render(Graphics2D g) {
		g.drawImage(getTexture(), getCoordX() + Level.levelOffSetX, getCoordY() + Level.levelOffSetY, null);
	}
	
	@Override
	public String toString() {
		return getA() + ", " + getB();
	}
	
	public Rectangle getBounds() {
		return new Rectangle(getCoordX() + Level.levelOffSetX, getCoordY() + Level.levelOffSetY, getWidth(), getHeight());
	}
	
	public BufferedImage getTexture() {
		return texture;
	}
	
	public TileType getType() {
		return type;
	}
	
	public boolean isWalkable() {
		return this.getType().isWalkable();
	}
	
	public boolean hasTreasure() {
		return this.getType().hasTreasure();
	}
	
	public String tellStory() {
		return this.getType().tellStory();
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getA() {
		return a;
	}
	
	public int getB() {
		return b;
	}
	
	public int getCoordX() {
		return cX;
	}
	
	public int getCoordY() {
		return cY;
	}

	public boolean isInWindow() {
		return inWindow;
	}
	
}

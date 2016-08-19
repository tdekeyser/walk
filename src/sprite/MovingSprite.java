package sprite;

import java.awt.Rectangle;

import components.Tile;
import components.TileGrid;
import core.Game;
import level.Level;

public abstract class MovingSprite extends Sprite {
	/*
	 * Class that defines sprite movement
	 */
	
	private int dirX; // moving direction x-axis
	private int dirY; // moving direction y-axis
	
	private boolean left, right, up, down = false;
	private boolean stopLeft, stopRight, stopDown, stopUp = false;
	private float moveDistance = 0;
	
	private int gridRows;
	private int gridColumns;
	
	private SpriteAnimation animation;
	
	public MovingSprite(String img, int x, int y, TileGrid tileGrid, String[] animationImages) {
		super(img, x, y, tileGrid);
		this.gridRows = tileGrid.getMap().length;
		this.gridColumns = tileGrid.getMap()[0].length;
		
		this.animation = new SpriteAnimation(this, animationImages);
	}
	
	public void move() {
		// if no collision detected, move and animate
		if (!tileCollision() && !spriteCollision()) {
			executeMovement();
			animateMovement();
		}
	}
	
	public Rectangle getPositionAfterMoving() {
		return new Rectangle((int) getCX() - getDirX(), (int) getCY() - getDirY(), getImage().getWidth()+1, getImage().getHeight());
	}
	
	public boolean collides(Tile t) {
		// returns possible intersection with tile
		Rectangle positionAfterMoving = getPositionAfterMoving();
		return t.getBounds().intersects(positionAfterMoving);
	}
	
	public boolean collides(Sprite s) {
		// returns possible intersection with sprite
		Rectangle positionAfterMoving = getPositionAfterMoving();
		return s.getBounds().intersects(positionAfterMoving);
	}
	
	public boolean spriteCollision() {
		// check sprite collision
		for (Sprite s : Level.opponents) {
			if (collides(s)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean tileCollision() {
		// collision detection against solid tiles
		for (int i=0; i < gridRows; i++) {
			for (int j=0; j < gridColumns; j++) {
				Tile t = getTileGrid().getMap()[i][j];
				if (t.isInWindow() && !t.isWalkable()) {
					if (collides(t)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public void executeMovement() {
		// update Level offset
		Level.levelOffSetX += getDirX();
		Level.levelOffSetY += getDirY();
		
		// update x and y within tileGrid and set new current tile
		x = (cx-Level.levelOffSetX)/64;
		y = (cy-Level.levelOffSetY)/64;
		setCurrentTile(getTileGrid().getMap()[(int) y][(int) x]);
	}
	
	public float distanceMoved() {
		// define distance traveled
		float newDistance = moveDistance + Math.abs(getDirX()+getDirY());
		return newDistance-moveDistance;
	}
	
	public void animateMovement() {
		float distMoved = distanceMoved();
		// if no movement has occurred, reset animation and left/right/down/up booleans
		if (distMoved == 0) {
			animation.resetAnimation();
		} else {
			// if there was movement, reset stops
			resetStopBooleans();
			moveDistance += distMoved;
			// update the animation according to the Game loop keeper
			if (Game.LOOP_KEEP % 10 == 0) {
				animation.animate();
			}
		}	
	}
	
	public void refuseMove() {
		resetMoveBooleans();
	}

	public void resetMoveBooleans() {
		left = false;
		right = false;
		up = false;
		down = false;
	}
	
	public boolean isMoving() {
		if (left || right || up || down) {
			return true;
		} else {
			return false;
		}
	}
	
	public void resetStopBooleans() {
		stopLeft = false;
		stopRight = false;
		stopDown = false;
		stopUp = false;
	}
	
	public void setMoveBoolean(String dir) {
		// first reset movement booleans
		resetMoveBooleans();
		// then assign new boolean acc to keyboard input
		switch (dir) {
			case "left": left = true; break;
			case "right": right = true; break;
			case "up": up = true; break;
			case "down": down = true; break;
		}
	}
	
	public void setStopBoolean(String dir) {
		// first reset movement booleans
		resetMoveBooleans();
		// then assign stop boolean acc to keyboard input
		switch (dir) {
			case "stopLeft": stopLeft = true; break;
			case "stopRight": stopRight = true; break;
			case "stopUp": stopUp = true; break;
			case "stopDown": stopDown = true; break;
		}
	}
	
	public boolean goLeft() { return this.left; }
	public boolean goRight() { return this.right; }
	public boolean goDown() { return this.down; }
	public boolean goUp() { return this.up; }
	
	public boolean stoppedLeft() { return this.stopLeft; }
	public boolean stoppedRight() { return this.stopRight; }
	public boolean stoppedDown() { return this.stopDown; }
	public boolean stoppedUp() { return this.stopUp; }
	
	public int getDirX() { return this.dirX; }
	public int getDirY() { return this.dirY; }
	public void setDirX(int dirX) {	this.dirX = dirX; }
	public void setDirY(int dirY) {	this.dirY = dirY; }

}

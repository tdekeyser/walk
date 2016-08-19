package components;

import java.awt.Graphics2D;

import core.Settings;

public class TileGrid  {

    private int[][] map;
    private int rows;
    private int columns;
    private Tile[][] tileMap;
    
    public TileGrid(int[][] map) {
    	this.map = map;
    	this.rows = map.length;
    	this.columns = map[0].length;
    	this.tileMap = new Tile[rows][columns];
    	
    	setupTiles();
    	
    }
    
    public void render(Graphics2D g) {
    	for (int i=0; i<rows; i++) {
        	for (int j=0; j<columns; j++) {
        		
        		Tile tile = tileMap[i][j];
        		tile.update();
        		if (tile.isInWindow()) {
        			tile.render(g);
        		}
        	}
        }
    }
    
    private void setupTiles() {
    	
        for (int i=0; i<rows; i++) {
        	for (int j=0; j<columns; j++) {
        		
        		Tile tile;
        		int defaultTileWidth = Settings.TILE_WIDTH;
        		
        		switch (map[i][j]) {
        			case 0: tile = new Tile(i, j, defaultTileWidth, defaultTileWidth, TileType.Road2); break;
        			case 1: tile = new Tile(i, j, defaultTileWidth, defaultTileWidth, TileType.Tree); break;
        			case 2: tile = new Tile(i, j, defaultTileWidth, defaultTileWidth, TileType.Road1); break;
        			case 3: tile = new Tile(i, j, defaultTileWidth, defaultTileWidth, TileType.TreasureRoad); break;
        			case 4: tile = new Tile(i, j, defaultTileWidth, defaultTileWidth, TileType.TreasureTree); break;
        			default: tile = new Tile(i, j, defaultTileWidth, defaultTileWidth, TileType.Road2); break;
        		}
        	
        		tileMap[i][j] = tile;
        		
        	}
        }

    }
    
    public Tile[][] getMap() {
    	return this.tileMap;
    }

}

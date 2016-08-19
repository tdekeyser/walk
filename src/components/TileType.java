package components;

public enum TileType {
	
	Road1("road1-64", true, false, "Where am I?"),
	Road2("road2-64", true, false, null),
	Tree("tree-64", false, false, "This is a strange tree..."),
	
	TreasureRoad("roadT-64", true, true, "How can mirrors be real / if our eyes aren't?"),
	TreasureTree("treeT-64", false, true, null);
	
	String textureName;
	boolean walkable;
	boolean hasTreasure;
	String story;
	
	TileType(String textureName, boolean walkable, boolean hasTreasure, String story) {
		this.textureName = textureName;
		this.walkable = walkable;
		this.hasTreasure = hasTreasure;
		this.story = story;
	}
	
	public boolean isWalkable() {
		return this.walkable;
	}
	
	public boolean hasTreasure() {
		return this.hasTreasure;
	}
	
	public String tellStory() {
		return this.story;
	}

}

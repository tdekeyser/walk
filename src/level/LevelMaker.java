package level;

public class LevelMaker {
	
	private int levelID;
	
	private int offSetX;
	private int offSetY;
	private int [][] map;
	
	public LevelMaker(int levelID) {
		this.levelID = levelID;
		load();
	}
	
	public int getLevelOffSetX() {
		return this.offSetX;
	}
	
	public int getLevelOffSetY() {
		return this.offSetY;
	}
	
	public int[][] getLevelMap() {
		return this.map;
	}
	
	private void load() {
		switch (levelID) {
			case 1:
				offSetX = -580;
				offSetY = 60;
				map = new int[][] {
					{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
					{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
					{1, 1, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
					{1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 2, 2, 2, 2, 2},
					{1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 1, 1, 1},
					{1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1, 1, 1, 1},
					{1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 2, 2, 1, 0, 1, 1},
					{1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 2, 2, 0, 0, 1, 1},
					{1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 1},
					{1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 1},
					{1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 1},
					{1, 1, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 3, 0, 0, 1, 1},
					{1, 1, 0, 0, 0, 0, 0, 2, 2, 2, 2, 0, 0, 0, 0, 1, 1},
					{1, 1, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 1, 1},
					{1, 1, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
					{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
					{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
				};
				break;
			case 2:
				offSetX = -140;
				offSetY = 200;
				map = new int[][] {
					{1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1},
					{1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1},
					{1, 1, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 1, 1},
					{1, 1, 1, 1, 0, 0, 0, 0, 2, 2, 0, 0, 2, 0, 0, 1, 1},
					{1, 1, 4, 1, 1, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 1, 1},
					{1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1},
					{1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 2, 0, 0, 0, 1, 1},
					{1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 2, 0, 0, 1, 1},
					{1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 2, 0, 0, 0, 1, 1},
					{1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 2, 1, 0, 0, 1, 1},
					{1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 2, 1, 0, 0, 1, 1},
					{1, 1, 0, 1, 0, 1, 0, 0, 2, 2, 2, 1, 1, 0, 0, 1, 1},
					{1, 1, 0, 0, 0, 1, 0, 2, 2, 2, 2, 1, 1, 1, 0, 1, 1},
					{1, 1, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1},
					{1, 1, 2, 2, 0, 2, 2, 2, 2, 0, 0, 0, 0, 1, 0, 1, 1},
					{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
					{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
				};
				break;
			default: map = new int[1][1]; 
		}
	}

}

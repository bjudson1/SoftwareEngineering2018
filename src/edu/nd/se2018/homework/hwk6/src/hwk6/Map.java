package hwk6;

public class Map {
	private int[][] grid = new int [25][25];
	final int dimension = 25;
	private LevelStrategy level1;
	private LevelStrategy level2;
	
	public Map(){
		level1 = new Level1();
		level1.buildLevel();
		
		level2 = new Level2();
		level2.buildLevel();
		
		for(int i=0;i<dimension;i++){
			for(int j=0;j<dimension;j++){
				grid[i][j] = 0;
			}
		}
	}
	
	public void drawMap(LevelStrategy level){
		for(int i=0;i<dimension;i++){
			for(int j=0;j<dimension;j++){
				grid[i][j] = level.getTile(i,j);
			}
		}
	}
	
	public int getDimension() {
		return dimension;
	}
	
	public int getValue(int i,int j) {
		return grid[i][j];
	}
	
	public void setValue(int i,int j,int value) {
		grid[i][j] = value;
	}
}

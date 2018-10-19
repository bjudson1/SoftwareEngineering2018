package hwk6;

import java.awt.Point;

public class Level2 implements LevelStrategy{
	private int[][] grid;
	private Point chipStart;
	private Point bugStart;
	private final int chips = 3;
	
	public Level2(){
		grid = new int [25][25];
	}
	
	public void buildLevel() {
		chipStart = new Point(14,7);
		bugStart = new Point(11,6);
		
		for(int i=0;i<25;i++){
			for(int j=0;j<25;j++){
				grid[i][j] = 0;
			}
		}
		
		//add walls
		for(int i=5;i<20;i++) {
			grid[i][5] = 1;
			grid[i][20] = 1;
			grid[i][10] = 1;
			grid[i][15] = 1;
		}
		
		for(int i=5;i<10;i++) {
			grid[5][i] = 1;
			grid[12][i] = 1;
			grid[12][i+10] = 1;
			grid[5][i+10] = 1;
		}
		
		for(int i=5;i<=20;i++) {
			grid[20][i] = 1;
		}
		
		for(int i=10;i<15;i++) {
			grid[15][i] = 1;
		}
		
		grid[17][8] = 4;
		grid[17][9] = 2;
		grid[17][10] = 3;
		grid[19][13] = 4;
		grid[19][14] = 2;
		grid[19][15] = 3;
		grid[12][7] = 3;
		grid[12][17] = 3;
		grid[7][7] = 2;
		grid[9][7] = 2;
		grid[9][18] = 4;
		
		
		//bugList.add(new Bug(chip,map,5,5));
	}

	public int getTile(int i, int j) {
		return grid[i][j];
	}
	
	public Point getChipStart(){
		return chipStart;
	}
	
	public Point getBugStart(){
		return bugStart;
	}
	
	public int getChipsCount() {
		return chips;
	}
}

package hwk6;

import java.awt.Point;

public class Level1 implements LevelStrategy{
	private int[][] grid;
	private Point chipStart;
	private Point bugStart;
	private final int chips = 3;
	
	public Level1(){
		grid = new int [25][25];
	}
	
	public void buildLevel() {		
		chipStart = new Point(12,7);
		bugStart = new Point(7,6);
		
		for(int i=0;i<25;i++){
			for(int j=0;j<25;j++){
				grid[i][j] = 0;
			}
		}
		
		//add walls
		for(int i=5;i<20;i++) {
			grid[i][5] = 1;
			grid[i][10] = 1;
			grid[i][15] = 1;
			grid[i][20] = 1;
			grid[5][i] = 1;
			grid[19][i] = 1;
		}
		
		grid[18][8] = 2;
		grid[18][7] = 4;
		grid[18][13] = 2;
		grid[18][12] = 4;
		grid[8][10] = 3;
		grid[8][15] = 3;
		grid[8][18] = 4;
		
		//bugList.add(new Bug(chip,map,5,5));
	}
	
	public int getTile(int i,int j){
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

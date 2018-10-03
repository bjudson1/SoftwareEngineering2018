package hwk6;

import javafx.collections.ObservableList;
import javafx.scene.Node;

public class Map {
	private int[][] grid = new int [25][25];
	final int dimension = 25;
	
	public Map(){
		for(int i=0;i<dimension;i++){
			for(int j=0;j<dimension;j++){
				grid[i][j] = 0;
			}
		}
	}
	
	public void drawMap(){
		//add walls
		for(int i=5;i<20;i++) {
			grid[i][5] = 1;
			grid[i][20] = 1;
			grid[5][i] = 1;
			grid[19][i] = 1;
		}
	}
	
	public int getDimension() {
		return dimension;
	}
	
	public int getValue(int i,int j) {
		return grid[i][j];
	}
}

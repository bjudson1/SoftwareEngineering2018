package hwk3;

import java.awt.Point;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class OceanMap {
	private boolean[][] grid = new boolean [25][25];
	final int dimensions = 25;
	
	
	public OceanMap(){
		for(int i=0;i<dimensions;i++){
			for(int j=0;j<dimensions;j++){
				grid[i][j] = false;
			}
		}
	}
	
	public void drawMap(ObservableList<Node> root,int scale){
		for(int i=0;i<dimensions;i++) {
			for(int j=0;j<dimensions;j++) {
				Rectangle rect = new Rectangle(i*scale,j*scale,scale,scale);
				rect.setStroke(Color.BLACK);
				if(grid[i][j])
					rect.setFill(Color.GREEN);
				else
					rect.setFill(Color.BLUE);
				root.add(rect);
			}
		}
	}
	
	//randomly add 10 islands
	public void addIslands(){
		for(int i=0;i<10;i++){
			int rand_x; 
			int rand_y;
			
			//find random location without island
			do{
				rand_x = (int)(Math.random() * 25);
				rand_y = (int)(Math.random() * 25);
			}while(grid[rand_x][rand_y]);
			
			grid[rand_x][rand_y] = true;
		}
	}
	
	public boolean getTileValue(int x,int y){
		return grid[x][y];
	}
}

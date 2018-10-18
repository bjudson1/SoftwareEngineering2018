package hwk6;

import java.awt.Point;

public class Chip{
	private Point location;
	private int keys;
	private int chips;
	Map map;
	

	public Chip(Map mapIn,Point start){
		location = new Point(start.x,start.y);
		map = mapIn;
		keys = 0;
	}
	
	public void goEast(){
		if(location.x < 24 && map.getValue(location.x+1, location.y) != 1 && map.getValue(location.x+1, location.y) != 3)
			location.x += 1;
		
		else if(map.getValue(location.x+1, location.y) == 3 && keys > 0){
			location.x += 1;
			keys -= 1;
		}
	}
	
	public void goWest() {
		if(location.x > 0 && map.getValue(location.x-1, location.y) != 1 && map.getValue(location.x-1, location.y) != 3)
			location.x -= 1;
		
		else if(map.getValue(location.x-1, location.y) == 3 && keys > 0){
			location.x -= 1;
			keys -= 1;
		}
	}
	
	public void goNorth(){
		if(location.y > 0 && map.getValue(location.x, location.y-1) != 1 && map.getValue(location.x, location.y-1) != 3)
			location.y -= 1;
		
		else if(map.getValue(location.x, location.y-1) == 3 && keys > 0){
			location.y -= 1;
			keys -= 1;
		}
	}
	
	public void goSouth(){
		if(location.y < 24 && map.getValue(location.x, location.y+1) != 1 && map.getValue(location.x, location.y+1) != 3)
			location.y += 1;
		
		else if(map.getValue(location.x, location.y+1) == 3 && keys > 0){
			location.y += 1;
			keys -= 1;
		}
	}
	
	public Point getLocation() {
		return location;
	}
	
	public void giveKey() {
		keys += 1;
	}
	
	public int getKeys() {
		return keys;
	}
	
	public void giveChip() {
		chips += 1;
	}
	
	public int getChips() {
		return chips;
	}
}

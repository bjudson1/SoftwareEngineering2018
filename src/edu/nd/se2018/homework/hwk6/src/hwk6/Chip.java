package hwk6;

import java.awt.Point;
import java.util.Observable;

public class Chip extends Observable {
	private Point location;
	Map map;

	public Chip(Map mapIn){
		location = new Point(13,13);
		map = mapIn;
	}
	
	public void goEast(){
		if(location.x < 24 && map.getValue(location.x+1, location.y) != 1)
			location.x += 1;
		
		setChanged();
		notifyObservers();
	}
	
	public void goWest() {
		if(location.x > 0 && map.getValue(location.x-1, location.y) != 1)
			location.x -= 1;
		
		setChanged();
		notifyObservers();
	}
	
	public void goNorth(){
		if(location.y > 0 && map.getValue(location.x, location.y-1) != 1)
			location.y -= 1;
		
		setChanged();
		notifyObservers();
	}
	
	public void goSouth(){
		if(location.y < 24 && map.getValue(location.x, location.y+1) != 1)
			location.y += 1;
		
		setChanged();
		notifyObservers();
	}
	
	public Point getLocation() {
		return location;
	}
}

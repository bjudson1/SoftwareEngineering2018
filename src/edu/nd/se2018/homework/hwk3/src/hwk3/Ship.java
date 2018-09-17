package hwk3;

import java.awt.Point;
import java.util.Observable;

public class Ship extends Observable {
	private Point location;
	private OceanMap map;
	
	public Ship(OceanMap oceanMap){
		location = new Point();
		map = oceanMap;
	}
	
	public Point getLocation() {
		return location;
	}
	
	public void setLocation(int x, int y){
		location.x = x;
		location.y = y;
	}
	
	public void goEast(){
		if(location.x < 24 && !map.getTileValue(location.x + 1,location.y))
			location.x += 1;
		
		setChanged();
		notifyObservers();
	}
	
	public void goWest() {
		if(location.x > 0 && !map.getTileValue(location.x - 1,location.y))
			location.x -= 1;
		
		setChanged();
		notifyObservers();
	}
	
	public void goNorth(){
		if(location.y > 0 && !map.getTileValue(location.x,location.y - 1))
			location.y -= 1;
		
		setChanged();
		notifyObservers();
	}
	
	public void goSouth(){
		if(location.y < 24 && !map.getTileValue(location.x,location.y + 1))
			location.y += 1;
		
		setChanged();
		notifyObservers();
	}
}

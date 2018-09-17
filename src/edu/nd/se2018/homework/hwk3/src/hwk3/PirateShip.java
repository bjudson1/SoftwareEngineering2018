package hwk3;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

public class PirateShip implements Observer{
	private Point location;
	private OceanMap map;
	public PirateShip(OceanMap oceanMap,Ship columbusShip){
		location = new Point();
		columbusShip.addObserver(this);
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
	}
	
	public void goWest() {
		if(location.x > 0 && !map.getTileValue(location.x - 1,location.y))
			location.x -= 1;
	}
	
	public void goNorth(){
		if(location.y > 0 && !map.getTileValue(location.x,location.y - 1))
			location.y -= 1;
	}
	
	public void goSouth(){
		if(location.y < 24 && !map.getTileValue(location.x,location.y + 1))
			location.y += 1;
	}
	
	public void update(Observable o, Object arg) {
		if(o instanceof Ship) {
			Point ccLocation = ((Ship) o).getLocation();
			
			if(ccLocation.y > location.y)
				goSouth();
			
			else if(ccLocation.y < location.y)
				goNorth();
			
			else if(ccLocation.x > location.x)
				goEast();
			
			else if(ccLocation.x < location.x)
				goWest();
		}	
	}

}

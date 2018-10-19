package hwk6;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

public class Bug implements Observer{
	private Point location;
	private Map map;
	private int waitCount;
	
	public Bug(Map mapIn,Point locationIn,Chip chip) {
		map = mapIn;
		location = locationIn;
		chip.addObserver(this);
		waitCount = 0;
	}
	
	public void goEast(){
		if(location.x < 24 && map.getValue(location.x+1, location.y) != 1 && map.getValue(location.x+1, location.y) != 3) {
			location.x += 1;
		}
	}
	public void goWest() {
		if(location.x > 0 && map.getValue(location.x-1, location.y) != 1 && map.getValue(location.x-1, location.y) != 3) {
			location.x -= 1;
		}
	}
		
	public void goNorth(){
		if(location.y > 0 && map.getValue(location.x, location.y-1) != 1 && map.getValue(location.x, location.y-1) != 3) {
			location.y -= 1;
		}
	}
		
	public void goSouth(){
		if(location.y < 24 && map.getValue(location.x, location.y+1) != 1 && map.getValue(location.x, location.y+1) != 3) {
			location.y += 1;
		}
	}

	public void update(Observable o, Object arg) {
		System.out.println("yo");
		if(o instanceof Chip) {
			Point chipLocation = ((Chip) o).getLocation();
			
			if(chipLocation.y > location.y) {
				if(waitCount == 1) {
					goSouth();
					waitCount = 0;
				}
				else
					waitCount += 1;
			}
			else if(chipLocation.y < location.y) {
				if(waitCount == 1) {
					goNorth();
					waitCount = 0;
				}
				else
					waitCount += 1;
			}
			
			else if(chipLocation.x > location.x) {
				if(waitCount == 1) {
					goEast();
					waitCount = 0;
				}
				else
					waitCount += 1;
			}
			
			else if(chipLocation.x < location.x) {
				if(waitCount == 1) {
					goWest();
					waitCount = 0;
				}
					
				else
					waitCount += 1;
			}
		}	
		
	}
	
	public Point getLocation(){
		return location;
	}

}

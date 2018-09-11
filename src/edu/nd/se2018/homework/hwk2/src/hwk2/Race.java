package hwk2;

import java.util.ArrayList;
import java.util.List;

public class Race{
	private double distance;
	private List<Horse> horses;
	
	
	public Race(double distance_in){
		horses = new ArrayList<Horse> ();
		distance = distance_in;
		
		horses.add(new Horse("Betsy",0.2,0));
		horses.add(new Horse("Ronald",0.25,1));
		horses.add(new Horse("Kevin",0.22,2));
	}
	
	public String run_the_race(){
		boolean won = false;
		List<Horse> finished_horses = new ArrayList<Horse> ();
		String winner = "";
		
		while(!won){
			for(Horse cur : horses) {
				cur.move();
				
				System.out.println(cur.get_name() + " has run " + cur.get_position() + " miles");
				
				//if horse has crossed finish line
				if(cur.get_position() > distance) {
					finished_horses.add(cur);
				}
			}
			
			if(!finished_horses.isEmpty()) {
				won = true;
				
				if(finished_horses.size() > 1) {
					double max = 0;
					
					for(Horse cur : finished_horses){
						if(cur.get_position() > max) {
							max = cur.get_position();
							winner = cur.get_name();
						}
					}
				}
				
				else {
					winner = finished_horses.get(0).get_name();
				}
			}
		}
		
		return winner;
	}
}

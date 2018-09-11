package hwk2;

public class SlowStartStrategy implements RaceStrategy{
	public double execute_strategy(double position, double max_speed){
		double new_position;
		
		if(position < 6) {
			new_position = position + .75 * max_speed;
		}
		
		else if(position < 9) {
			new_position = position + .9 * max_speed;
		}
		
		else {
			new_position = position + max_speed;
		}
		
		return(new_position);
	}
}

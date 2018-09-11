package hwk2;

public class EarlySprintStrategy implements RaceStrategy{
	public double execute_strategy(double postition, double max_speed){
		double new_position;
		
		if(postition < 2.0) {
			new_position = postition + max_speed;
		}
		
		else {
			new_position = postition + (.75 * max_speed);
		}
		
		return new_position;
	}
}

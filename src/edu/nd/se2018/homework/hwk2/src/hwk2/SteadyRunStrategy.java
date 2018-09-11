package hwk2;

public class SteadyRunStrategy implements RaceStrategy{
	public double execute_strategy(double postition, double max_speed){		
			return (postition + .8 * max_speed);
	}
}

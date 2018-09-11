package hwk2;

public class Horse {
	private String name;
	private double max_speed;
	private RaceStrategy strategy;
	private double position;
	
	public Horse(String name_in,double max_speed_in,int strategy_choice){
		name = name_in;
		max_speed = max_speed_in;
		position = 0;
		
		if(strategy_choice == 0){
			strategy = new EarlySprintStrategy();
		}
		
		else if(strategy_choice == 1){
			strategy = new SteadyRunStrategy();
		}
		
		else{
			strategy = new SlowStartStrategy();
		}
	}
	
	public void switch_strategy(int strategy_choice){
		if(strategy_choice == 0){
			strategy = new EarlySprintStrategy();
		}
		
		else if(strategy_choice == 1){
			strategy = new SteadyRunStrategy();
		}
		
		else{
			strategy = new SlowStartStrategy();
		}
	}
	
	public void move(){
		position = strategy.execute_strategy(position,max_speed);
	}
	
	public String get_name(){
		return name;
	}
	
	public double get_position() {
		return position;
	}
}

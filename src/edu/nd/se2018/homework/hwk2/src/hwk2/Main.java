package hwk2;

public class Main {
	public static void main(String[] args) {
		Race race = new Race(10);
		String winner = race.run_the_race();
		
		System.out.println(winner + " won the race!");
	}
}

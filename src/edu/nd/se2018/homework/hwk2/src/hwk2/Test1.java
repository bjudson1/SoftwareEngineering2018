package hwk2;

import org.junit.Test;

public class Test1 {
	@Test
	public void Test() {
		Race race1 = new Race(10);
		assert(race1.run_the_race()=="Ronald");
		Race race2 = new Race(5);
		assert(race2.run_the_race()=="Ronald");
		Race race3 = new Race(1);
		assert(race3.run_the_race()=="Betsy");
	}
}

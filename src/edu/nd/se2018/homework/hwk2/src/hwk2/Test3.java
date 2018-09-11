package hwk2;

import org.junit.Test;

public class Test3 {
	@Test
	public void Test(){
		Horse horse = new Horse("Brenden",1,0);
		horse.move();
		assert(horse.get_position() == 1.0);

		horse.switch_strategy(1);
		horse.move();
		assert(horse.get_position() == 1.8);

		horse.switch_strategy(2);
		horse.move();
		assert(horse.get_position() == 2.55);
	}
}

package hwk2;

import org.junit.Test;

public class Test2{
	@Test
	public void Test(){
		Horse horse1 = new Horse("Brenden",1,0);
		horse1.move();
		assert(horse1.get_position() == 1.0);
		
		Horse horse2 = new Horse("Brenden",1,1);
		horse2.move();
		assert(horse2.get_position() == .8);

		Horse horse3 = new Horse("Brenden",1,2);
		horse3.move();
		assert(horse3.get_position() == .75);
	}
}

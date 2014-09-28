package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import jeudeloie.Dice;

import org.junit.Test;


public class testDice {
	
	@Test 
	public void testThrowDice() {
		assertTrue(Dice.throwDice() > 1 && Dice.throwDice() <=12);
		assertFalse(Dice.throwDice() < 1 || Dice.throwDice() > 12);
	}
	


}

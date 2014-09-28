package jeudeloie;

import java.util.Random;

/**
 * Dice is a class which only statically throw dices.
 * 
 * 
 * @author Theo Plockyn & Remy Debue
 */
public class Dice {
	/**
	 * Throws the dice (2d6)
	 * @return The result of the throw
	 */
	public static int throwDice() {
		return new Random().nextInt(10) + 2;
		
	}

}

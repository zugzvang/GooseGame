package jeudeloie;

import java.util.Random;

/**
 * Dice is a class which only statically throw dices.
 * 
 * 
 * @author Theo Plockyn & Remy Debue
 */
public class Dice {
	public static int throwDice() {
		return new Random().nextInt(10) + 2;
		
	}

}

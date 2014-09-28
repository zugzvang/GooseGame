package jeudeloie;

/**
 * Cell is the interface representing a cell on the board of the game.
 * 
 * @author Theo Plockyn & Remy Debue
 * 
 */
public interface Cell {

	/**
	 * Checks if the cell can be left at this turn
	 * 
	 * @return true if it can be left, false else
	 */
	public boolean canBeLeftNow();

	/**
	 * Checks if the cell can be left at all.
	 * 
	 * @return true if it can't be left at all, false else.
	 */
	public boolean isRetaining();

	/**
	 * Gets the cell's index
	 */
	public int getIndex();

	/**
	 * Returns the index of the cell really reached, adding special effects if
	 * needed.
	 */
	public int handleMove(int diceThrow);

	/**
	 * Checks if the cell is currently occupied.
	 */
	public boolean isBusy();

	/**
	 * Sets the cell's new player
	 */
	public void welcome(Player player);

	/**
	 * Is called when the player leaves the cell, thus setting the occupying
	 * player to null.
	 */
	public void leave();

	/**
	 * Gets the occupying player.
	 */
	public Player getPlayer();
}

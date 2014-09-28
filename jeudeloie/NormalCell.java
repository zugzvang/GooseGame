package jeudeloie;

/**
 * <b>NormalCell implements the interface Cell, and is used as a regular cell and
 *  also as a base to modify for the special cells.</b>
 * <p>
 * It is a class containing :
 * <ul>
 * <li>Its index.</li>
 * <li>The player occupying it.</li>
 * </ul>
 * </p>
 * 
 * 
 * @author Theo Plockyn & Remy Debue
 */
public class NormalCell implements Cell {

	private int index;
	private Player player;
	
	/**
	 * The constructor only needs the index of the cell
	 * @param idx the case's index 
	 */
	public NormalCell(int idx) {
		this.index = idx;
		this.player = null;
	}

	/**
	 * Checks if the cell can be left this turn.
	 * @return true if it can be left, false else.
	 */
	@Override
	public boolean canBeLeftNow() {
		return !this.isRetaining();
	}
	

	/**
	 * Checks if the cell can be left at all.
	 * @return true if it can't be left at all, false else.
	 */
	@Override
	public boolean isRetaining() {
		return false;
	}

	/**
	 * Gets the cell's index
	 */
	@Override
	public int getIndex() {
		return this.index;
	}

	/**
	 * Returns the index of the cell, because there's no special effect on this cell.
	 */
	@Override
	public int handleMove(int diceThrow) {
		return this.getIndex();
	}

	/**
	 * Checks if the cell is currently occupied.
	 */
	@Override
	public boolean isBusy() {
		return (player!=null);
	}
	
	/**
	 * Sets the cell's new player
	 */
	@Override
	public void welcome(Player player) {
			this.player = player;

	}

	/**
	 * Is called when the player leaves the cell, thus setting the occupying player to null.
	 */
	@Override
	public void leave() {
		this.player=null;
	}

	/**
	 * Gets the occupying player.
	 */
	@Override
	public Player getPlayer() {
		return player;
	}

	

}

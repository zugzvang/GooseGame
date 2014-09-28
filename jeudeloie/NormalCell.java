package jeudeloie;

/**
 * <b>NormalCell implements the interface Cell, and is used as a regular cell
 * and also as a base to modify for the special cells.</b>
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
	 * 
	 * @param idx
	 *            the case's index
	 */
	public NormalCell(int idx) {
		this.index = idx;
		this.player = null;
	}

	@Override
	public boolean canBeLeftNow() {
		return !this.isRetaining();
	}

	@Override
	public boolean isRetaining() {
		return false;
	}

	@Override
	public int getIndex() {
		return this.index;
	}

	@Override
	public int handleMove(int diceThrow) {
		return this.getIndex();
	}

	@Override
	public boolean isBusy() {
		return (player != null);
	}

	@Override
	public void welcome(Player player) {
		this.player = player;

	}

	@Override
	public void leave() {
		this.player = null;
	}

	@Override
	public Player getPlayer() {
		return player;
	}

}

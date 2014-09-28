package jeudeloie;

/**
 * TeleportCell is a special cell teleporting to a specified cell.
 * @author Theo Plockyn & Remy Debue
 *
 */
public class TeleportCell extends NormalCell{

	private int teleIdx;
	/**
	 * Needs its index and the index of the cell where the player will be teleported
	 * @param idx its index
	 * @param teleIdx the index of the target cell
	 */
	public TeleportCell(int idx, int teleIdx) {
		super(idx);
		this.teleIdx=teleIdx;
	}
	
	/**
	 * Returns the index of the target cell
	 */
	@Override
	public int handleMove(int diceThrow) {
		System.out.println(" but it's a teleport cell !");
		return this.teleIdx;
	}

}

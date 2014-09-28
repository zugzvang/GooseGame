package jeudeloie;

/**
 * GooseCell is a special cell doubling the dice score.
 * @author Theo Plockyn & Remy Debue
 *
 */
public class GooseCell extends NormalCell {
	private int idx;
	public GooseCell(int idx) {
		super(idx);
		this.idx=idx;
	}
	
	/**
	 * Doubles the diceThrow, returning the index of the cell reached.
	 */
	@Override
	public int handleMove(int diceThrow) {
		System.out.println(" but it's a goose cell !");
		return this.idx + diceThrow;
	}

}

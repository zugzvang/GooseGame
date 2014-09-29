package jeudeloie;

/**
 * TrapCell is a special cell where you can't escape.
 * @author Theo Plockyn & Remy Debue
 *
 */
public class TrapCell extends NormalCell {

	public TrapCell(int idx) {
		super(idx);
	}

	/**
	 * Players can't escape this cell. Always returns true.
	 */
	@Override
	public boolean isRetaining() {
		return true;
	}
	
	
	@Override
	public int handleMove(int diceThrow) {
		System.out.print(" and reaches a trap cell !");
		return super.handleMove(diceThrow);
	}

}

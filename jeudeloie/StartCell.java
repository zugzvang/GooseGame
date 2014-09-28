/**
 * 
 */
package jeudeloie;

/**
 * @author Theo
 *
 */
public class StartCell implements Cell {

	/* (non-Javadoc)
	 * @see jeudeloie.Cell#canBeLeftNow()
	 */
	@Override
	public boolean canBeLeftNow() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see jeudeloie.Cell#isRetaining()
	 */
	@Override
	public boolean isRetaining() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see jeudeloie.Cell#getIndex()
	 */
	@Override
	public int getIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see jeudeloie.Cell#handleMove(int)
	 */
	@Override
	public int handleMove(int diceThrow) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see jeudeloie.Cell#isBusy()
	 */
	@Override
	public boolean isBusy() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see jeudeloie.Cell#welcome(jeudeloie.Player)
	 */
	@Override
	public void welcome(Player player) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see jeudeloie.Cell#leave()
	 */
	@Override
	public void leave() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see jeudeloie.Cell#getPlayer()
	 */
	@Override
	public Player getPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

}

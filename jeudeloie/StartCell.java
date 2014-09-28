/**
 * 
 */
package jeudeloie;

import java.util.*;

/**
 * Implements Cell, and holds multiple players.
 * @author Theo Plockyn & Remy Debue
 *
 */
public class StartCell implements Cell {

	private int idx=0;
	private List<Player> players;
	
	public StartCell(){
		this.players = new ArrayList<Player>();
	}
	
	/* (non-Javadoc)
	 * @see jeudeloie.Cell#canBeLeftNow()
	 */
	@Override
	public boolean canBeLeftNow() {
		return true;
	}

	/* (non-Javadoc)
	 * @see jeudeloie.Cell#isRetaining()
	 */
	@Override
	public boolean isRetaining() {
		return false;
	}

	/* (non-Javadoc)
	 * @see jeudeloie.Cell#getIndex()
	 */
	@Override
	public int getIndex() {
		return this.idx;
	}

	/* (non-Javadoc)
	 * @see jeudeloie.Cell#handleMove(int)
	 */
	@Override
	public int handleMove(int diceThrow) {
		return 0;
	}

	/* (non-Javadoc)
	 * @see jeudeloie.Cell#isBusy()
	 */
	@Override
	public boolean isBusy() {
		return false;
	}

	/* (non-Javadoc)
	 * @see jeudeloie.Cell#welcome(jeudeloie.Player)
	 */
	@Override
	public void welcome(Player player) {
		
	}

	/* (non-Javadoc)
	 * @see jeudeloie.Cell#leave()
	 */
	@Override
	public void leave() {
		
	}
	
	public void initPlayers(List<Player> players){
		this.players.addAll(players);
	}
	
	public void leaveStart(Player player){
		players.remove(player);
	}

	public List<Player> getPlayersAtStart() {
		return players;
	}

	@Override
	public Player getPlayer() {
		return null;
	}

}

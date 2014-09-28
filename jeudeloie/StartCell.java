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
	
	@Override
	public boolean canBeLeftNow() {
		return true;
	}

	@Override
	public boolean isRetaining() {
		return false;
	}

	@Override
	public int getIndex() {
		return this.idx;
	}

	@Override
	public int handleMove(int diceThrow) {
		return 0;
	}

	@Override
	public boolean isBusy() {
		return false;
	}

	/**
	 * Is never used, returns null.
	 */
	@Deprecated
	@Override
	public void welcome(Player player) {
		// Unused
	}

	/**
	 * Is never used, returns null.
	 */
	@Deprecated
	@Override
	public void leave() {
		// Unused
	}
	
	/**
	 * Initializes the players of the cell.
	 * @param players all the players in the game
	 */
	public void initPlayers(List<Player> players){
		this.players.addAll(players);
	}
	
	/**
	 * Removes the player from the list of occupying players.
	 * @param player the player leaving the cell
	 */
	public void leaveStart(Player player){
		players.remove(player);
	}

	/**
	 * Returns all the players in the starting cell.
	 * @return the list of players currently in the starting cell
	 */
	public List<Player> getPlayersAtStart() {
		return players;
	}

	/**
	 * Is never used, returns null.
	 */
	@Deprecated
	@Override
	public Player getPlayer() {
		return null;
	}

}

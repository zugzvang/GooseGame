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

	@Override
	public Player getPlayer() {
		return null;
	}

}

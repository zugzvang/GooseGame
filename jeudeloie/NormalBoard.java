package jeudeloie;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>NormalBoard implements the abstract class Board.</b>
 * 
 * @author Theo Plockyn & Remy Debue
 */
public class NormalBoard extends Board {
	
	/**
	 * The constructor needs the players, then initialize itself.
	 * @param players the players of the game
	 */
	public NormalBoard(List<Player> players) {
		super.players = players;
		this.init();
	}

	/**
	 * Initializes the board with the cells.
	 */
	@Override
	public void init() {
		List<Cell> cells = new ArrayList<Cell>();
		StartCell sc = new StartCell();
		sc.initPlayers(this.players);
		cells.add(sc);
		for(int i=1; i<64;i++){
			cells.add(new NormalCell(i));
		}
		super.cells=cells;

	}

}

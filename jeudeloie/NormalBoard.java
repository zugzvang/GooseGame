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

		/*
		 * Goose : 9 18 27 36 45 54
		 * Trap : 31 52
		 * Wait : 19 2tours
		 * Teleport : 6 vers 12  42 vers 30  58 vers 1
		 * 
		 */
		for(int i=1; i<64;i++){
			if(i%9==0){
				cells.add(new GooseCell(i));
			}else if(i==31||i==52){
				cells.add(new TrapCell(i));
			}else if(i==19){
				cells.add(new WaitCell(i, 2));
			}else if(i==6){
				cells.add(new TeleportCell(i, 12));
			}else if(i==42){
				cells.add(new TeleportCell(i, 30));
			}else if(i==58){
				cells.add(new TeleportCell(i, 1));
			}else{
				cells.add(new NormalCell(i));
			}
		}
		super.cells=cells;

	}

}

package jeudeloie;

import java.util.ArrayList;
import java.util.List;

public class NormalBoard extends Board {

	public NormalBoard(List<Player> players) {
		super.players = players;
		this.init();
	}

	@Override
	public void init() {
		List<Cell> cells = new ArrayList<Cell>();
		for(int i=0; i<64;i++){
			cells.add(new NormalCell(i));
		}
		super.cells=cells;

	}

}

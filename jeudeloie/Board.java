package jeudeloie;

import java.util.List;

public abstract class Board {
	protected List<Player> players;
	protected List<Cell> cells;
	
	public Board() {
	}
	
	private int normalize(int diceThrow) {
		return diceThrow;
		
		
	}
	
	private Cell getCell(int idx) {
		return cells.get(idx);
		
	}
	
	private int getNbCells() {
		return cells.size();
		
	}
	
	public void playTurn(Player p, int diceThrow) {
		Cell currCell = this.getCell(p.getCurrentCell());
		if(currCell.canBeLeftNow()){
			int idxNextCell = this.getCell(p.getCurrentCell()+diceThrow).handleMove(diceThrow);
			idxNextCell=this.normalize(idxNextCell);
			this.moveTo(p, idxNextCell);
		}
	}
	
	private void swap(Player p1, Player p2) {
		int tmpCell;
		tmpCell=p1.getCurrentCell();
		p1.setCell(p2.getCurrentCell());
		p2.setCell(tmpCell);
	}
	
	public abstract void init();
	
	public void moveTo(Player p, int cell) {
		if(cells.get(cell).isBusy()){
			swap(p, this.getPlayerFromCell(cell));
		}else{
			cells.get(p.getCurrentCell()).leave();
			p.setCell(cell);
			cells.get(cell).welcome(p);
		}
	}

	public Player getPlayerFromCell(int cell) {
		Player p;
		for(int i=0; i<players.size(); i++){
			p = players.get(i);
			if(p.getCurrentCell()==cell){
				return p;
			}
		}
		return null;
	}

	public Cell getEndCell() {
		return cells.get(cells.size()-1);
	}
	
	public int getEndCellIdx(){
		return cells.size()-1;
	}
	
	public boolean arePlayersTrapped(){
		int countPlayers=0;
		for(int i=0; i<this.getNbCells(); i++){
			if(cells.get(i) instanceof TrapCell){
				if(cells.get(i).isBusy())
					countPlayers++;
			}
		}
		if(countPlayers==players.size()){
			return true;
		}
		return false;
	}
	
	
}

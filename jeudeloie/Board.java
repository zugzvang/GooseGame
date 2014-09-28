package jeudeloie;

import java.util.List;

/**
 * <b>Board is the class which represents the game's board.</b>
 * <p>
 * It is an abstract class containing :
 * <ul>
 * <li>A list of players.</li>
 * <li>A list of cells.</li>
 * </ul>
 * </p>
 * <p>
 * It is an abstract class because we wanted to have multiple implementations
 * of the game itself ( Having special cells at random places, and so on).
 * </br>Most of the different implementation's code can lay here to minimize code redundancy.
 * </p>
 * 
 * 
 * @author Theo Plockyn & Remy Debue
 */
public abstract class Board {
	protected List<Player> players;
	protected List<Cell> cells;
	
	public Board() {
	}
	
	/**
	 * Makes the dice throw stay within the limits of the board.
	 * @param diceThrow the original result of the dice throw.
	 * @return the distance the player will actually do on the board.
	 */
	private int normalize(int idxNextCell) {
		// If the player throw a dice making it out of bounds, it goes back in cells as far as the excess goes beyond the limits.
		if(idxNextCell>cells.size()-1)
		 return ((cells.size()-1) - (idxNextCell-cells.size()-1));
		return idxNextCell;
	}
	
	/**
	 * A shortcut to access the cell at the specified index.
	 * @param idx the index of the wanted cell.
	 * @return the cell at the index idx.
	 */
	private Cell getCell(int idx) {
		return cells.get(idx);
		
	}
	
	/**
	 * Plays the turn with the specified player. Calculates the movement done by the player and actually moves it.
	 * @param p the current player.
	 * @param diceThrow the player dice's score.
	 */
	public void playTurn(Player p, int diceThrow) {
		Cell currCell = this.getCell(p.getCurrentCell());
		if(currCell.canBeLeftNow()){
			int idxNextCell;
			// Makes the score stay within the bounds
			System.out.print(p.getName()+" throws a "+diceThrow+"");
			idxNextCell = this.normalize(p.getCurrentCell()+diceThrow);
			// Then applies the optional special effect
			idxNextCell = this.getCell(idxNextCell).handleMove(diceThrow);
			// And makes it stay within the bounds again
			idxNextCell=this.normalize(idxNextCell);
			System.out.print(" cell "+idxNextCell+" is reached\n");
			// To finally make the player move to the actual cell
			this.moveTo(p, idxNextCell);
		}else{
			if(currCell.isRetaining()){
				System.out.print(p.getName()+" is trapped !");
			}else if(currCell instanceof WaitCell){
				System.out.println(p.getName()+" must wait "+((WaitCell) currCell).getWaitTime()+" turns to continue");
			}
		}
	}
	
	/**
	 * Swaps the two players on the board.
	 * @param p1 the first player.
	 * @param p2 the second player.
	 */
	private void swap(Player p1, Player p2) {
		int tmpCell;
		tmpCell=p1.getCurrentCell();
		p1.setCell(p2.getCurrentCell());
		p2.setCell(tmpCell);
		cells.get(p1.getCurrentCell()).welcome(p1);
		cells.get(p2.getCurrentCell()).welcome(p2);
	}
	
	public abstract void init();
	
	/**
	 * Moves the player to its new cell, swapping players if the new cell is already occupied.
	 * @param p this turn's player.
	 * @param cell the cell where the player is going to be.
	 */
	public void moveTo(Player p, int cell) {
		if(cells.get(cell).isBusy()){
			swap(p, this.getPlayerFromCell(cell));
		}else{
			// Leave the cell ( isBusy is now false ) then move to the new cell and turns it's isBusy to true.
			cells.get(p.getCurrentCell()).leave();
			p.setCell(cell);
			cells.get(cell).welcome(p);
		}
	}

	/**
	 * Searches within the players to find the player occupying the specified cell.
	 * @param cell the occupied cell.
	 * @return the player occupying it, null if the cell is empty.
	 */
	public Player getPlayerFromCell(int cell) {
		return cells.get(cell).getPlayer();
	}

	/**
	 * Returns the last cell of the board.
	 * @return the last cell.
	 */
	public Cell getEndCell() {
		return cells.get(this.getEndCellIdx());
	}
	
	/**
	 * Returns the last cell of the board's index.
	 * @return the last cell's index.
	 */
	public int getEndCellIdx(){
		return cells.size()-1;
	}
	
	/**
	 * Checks if all the players are trapped, thus ending the game if true.
	 * @return true if all the players are trapped, else false.
	 */
	public boolean arePlayersTrapped(){
		int countPlayers=0;
		for(int i=0; i<this.players.size(); i++){
			// Checks if the cell is a TrapCell, and only then if it is busy
			if(cells.get(players.get(i).getCurrentCell()) instanceof TrapCell){
				countPlayers++;
			}
		}
		// If all the players are counted, then they all are trapped.
		if(countPlayers==players.size()){
			return true;
		}
		return false;
	}
	
	
}

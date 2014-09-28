package jeudeloie;

/**
 * <b>Player represents the player of the game.</b>
 * <p>
 * It is a class containing :
 * <ul>
 * <li>The name  of player.</li>
 * <li>The index of its cell.</li>
 * </ul>
 * @author Theo Plockyn & Remy Debue
 */
public class Player {
	private String name;
	private int currentCell;
	
	/**
	 * The constructor initialize the name and puts the player in the first cell.
	 * @param name
	 */
	public Player(String name){
		this.name=name;
		this.currentCell=0;
	}
	
	/**
	 * Setter of the current cell
	 * @param cell the player's new cell
	 */
	public void setCell(int cell) {
		if(cell >= 0) {
			this.currentCell=cell;
		} else {
			this.currentCell=0;
		}
		
	}

	/**
	 * Getter of the player's name
	 * @return the player's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter of the player's cell
	 * @return the player's current cell
	 */
	public int getCurrentCell() {
		return currentCell;
	}

 
}

package jeudeloie;

/**
 * WaitCell is a special cell making the player wait for a determined amount of turns.
 * @author Theo Plockyn & Remy Debue
 *
 */
public class WaitCell extends NormalCell {
	private int waitTime;
	private int itWaitTime;
	/**
	 * Needs its index and the number of turns players will wait
	 * @param idx
	 * @param waitTime
	 */
	public WaitCell(int idx, int waitTime) {
		super(idx);
		this.waitTime = waitTime;
		this.itWaitTime = waitTime;
	}
	

	@Override
	public boolean canBeLeftNow() {
		if(this.itWaitTime>0){
			this.itWaitTime--;
			return false;
		}
		this.itWaitTime = this.waitTime;
		return true;
	}
	
	/**
	 * Getter of the waiting time
	 * @return the number of turns players will have to wait. 
	 */
	public int getWaitTime(){
		return this.waitTime;
	}
	public int getitWaitTime(){
		return this.itWaitTime;
	}
	
	
	@Override
	public int handleMove(int diceThrow) {
		System.out.print(" but it's a wait cell !");
		return super.handleMove(diceThrow);
	}

}

package jeudeloie;

public class WaitCell extends NormalCell {
	private int waitTime;
	public WaitCell(int idx, int waitTime) {
		super(idx);
		this.waitTime = waitTime;
	}
	

	@Override
	public boolean canBeLeftNow() {
		if(this.waitTime>0){
			this.waitTime--;
			return false;
		}
		return true;
	}
	
	public int getWaitTime(){
		return this.waitTime;
	}
	
	@Override
	public int handleMove(int diceThrow) {
		System.out.print(" but it's a wait cell !");
		return super.handleMove(diceThrow);
	}

}

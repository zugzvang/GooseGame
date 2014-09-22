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

}

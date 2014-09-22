package jeudeloie;

public class NormalCell implements Cell {

	private int index;
	private boolean busy;
	
	public NormalCell(int idx) {
		
		this.index = idx;
	}

	@Override
	public boolean canBeLeftNow() {
		if(this.isRetaining())
			return true;
		return false;
	}

	@Override
	public boolean isRetaining() {
		return false;
	}

	@Override
	public int getIndex() {
		return this.index;
	}

	@Override
	public int handleMove(int diceThrow) {
		return this.index;
	}

	@Override
	public boolean isBusy() {
		return this.busy;
	}
	
	@Override
	public void welcome(Player player) {
			this.busy=true;

	}

	@Override
	public void leave() {
		this.busy=false;
		
	}

	

}

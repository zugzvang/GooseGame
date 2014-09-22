package jeudeloie;

public class TeleportCell extends NormalCell{

	private int teleIdx;

	public TeleportCell(int idx, int teleIdx) {
		super(idx);
		this.teleIdx=teleIdx;
	}
	
	@Override
	public int handleMove(int diceThrow) {
		return this.teleIdx;
	}

}

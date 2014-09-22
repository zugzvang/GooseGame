package jeudeloie;

public class TeleportCell extends NormalCell{

	private int teleIdx;

	public TeleportCell(int idx, int teleIdx) {
		super(idx);
		this.teleIdx=teleIdx;
	}
	
	@Override
	public int handleMove(int diceThrow) {
		System.out.println(" but it's a teleport cell !");
		return this.teleIdx;
	}

}

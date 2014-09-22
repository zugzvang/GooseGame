package jeudeloie;

public class GooseCell extends NormalCell {
	private int idx;
	public GooseCell(int idx) {
		super(idx);
		this.idx=idx;
	}
	

	@Override
	public int handleMove(int diceThrow) {
		return this.idx + diceThrow;
	}

}

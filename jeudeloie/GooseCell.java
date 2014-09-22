package jeudeloie;

public class GooseCell extends NormalCell {
	private int idx;
	public GooseCell(int idx) {
		super(idx);
		this.idx=idx;
	}
	

	@Override
	public int handleMove(int diceThrow) {
		System.out.println(" but it's a goose cell !");
		return this.idx + diceThrow;
	}

}

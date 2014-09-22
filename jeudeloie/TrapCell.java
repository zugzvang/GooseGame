package jeudeloie;

public class TrapCell extends NormalCell {

	public TrapCell(int idx) {
		super(idx);
	}
	
	@Override
	public boolean isRetaining() {
		return true;
	}
	
	@Override
	public int handleMove(int diceThrow) {
		System.out.print(" but it's a trap cell !");
		return super.handleMove(diceThrow);
	}

}

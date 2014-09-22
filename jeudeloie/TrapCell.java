package jeudeloie;

public class TrapCell extends NormalCell {

	public TrapCell(int idx) {
		super(idx);
	}
	
	@Override
	public boolean isRetaining() {
		return true;
	}

}

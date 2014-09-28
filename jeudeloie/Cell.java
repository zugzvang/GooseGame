package jeudeloie;

public interface Cell {

	public boolean canBeLeftNow();
	
	public boolean isRetaining();
	
	public int getIndex();
	
	public int handleMove(int diceThrow);
	
	public boolean isBusy();
	
	public void welcome(Player player);

	public void leave();

	public Player getPlayer();
}

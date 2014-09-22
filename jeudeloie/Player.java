package jeudeloie;

public class Player {
	private String name;
	private int score;
	private int currentCell;
	
	public Player(String name){
		this.name=name;
		this.setScore(0);
		this.currentCell=0;
	}
	
	public void setCell(int cell) {
		this.currentCell=cell;
		
	}

	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getCurrentCell() {
		return currentCell;
	}

 
}

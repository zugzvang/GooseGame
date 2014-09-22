package jeudeloie;

import java.util.List;

public class Game {
	List<Player> players;
	Board board;
	int player=0;
	
	public Game(List<Player> players, Board board) {
		this.players=players;
		this.board=board;
	}
	
	public void play() {
		while(!isFinished()){
			board.playTurn(this.nextPlayer(), this.diceThrow());
		}
		System.out.println(this.getWinner().getName());
	}
	
	public Player nextPlayer() {
		Player nextPlayer = players.get(player);
		player=(player+1)%players.size();
		return nextPlayer;
	}
	
	public boolean isFinished() {
		if(board.getEndCell().isBusy()||board.arePlayersTrapped()){
			return true;
		}
		return false;
	}
	
	public int diceThrow() {
		return Dice.throwDice();
	}
	
	public Player getWinner() {
		return board.getPlayerFromCell(board.getEndCellIdx());
	}
	

}

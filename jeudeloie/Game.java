package jeudeloie;

import java.util.ArrayList;
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
			System.out.println();
			board.playTurn(this.nextPlayer(), this.diceThrow());
		}
		if(this.getWinner()!=null){
			System.out.println("The winner is "+this.getWinner().getName());
		}else{
			System.out.println("Everybody is trapped, the game is finished and nobody won !");
		}
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
	
	public static void main(String[] args){
		Player p1 = new Player("Jean carle");
		Player p2 = new Player("Mickael hauspie");
		Player p3 = new Player("Philippe matthieu");
		Player p4 = new Player("Yann secq");
		
		List<Player> players = new ArrayList<Player>();
		players.add(p1);
		players.add(p2);
		players.add(p3);
		players.add(p4);
		
		Board board = new NormalBoard(players);
		Game game = new Game(players, board);
		
		game.play();
	}
	

}

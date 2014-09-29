package jeudeloie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <b>Game is the class which contains all the core rules of the game.</b>
 * <p>
 * It is a class containing :
 * <ul>
 * <li>A list of players.</li>
 * <li>A board.</li>
 * <li>An index of the current player.</li>
 * </ul>
 * </p>
 * 
 * 
 * @author Theo Plockyn & Remy Debue
 */
public class Game {
	List<Player> players;
	Board board;
	int player=0;
	
	/**
	 * The constructor needs the players and an implementation of board.
	 * @param players The players
	 * @param board The board
	 */
	public Game(List<Player> players, Board board) {
		this.players=players;
		this.board=board;
	}
	
	/**
	 * The most important method of this class, which plays the game until there's a winner or everybody is trapped.
	 */
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
	
	/**
	 * Gets the next player in the list, for the next turn.
	 * @return the next player
	 */
	public Player nextPlayer() {
		Player nextPlayer = players.get(player);
		player=(player+1)%players.size();
		return nextPlayer;
	}
	
	/**
	 * Checks if the game is finished, that is to say somebody is on the last cell, or nobody can move due to traps.
	 * @return true if it is finished, else false
	 */
	public boolean isFinished() {
		if(board.getEndCell().isBusy()||board.arePlayersTrapped()){
			return true;
		}
		return false;
	}
	
	/**
	 * Throws the dice ( 2d6 )
	 * @return the value of the throw
	 */
	public int diceThrow() {
		return Dice.throwDice();
	}
	
	/**
	 * Gets the winner.
	 * @return the winning player, or null if there's no winner.
	 */
	public Player getWinner() {
		return board.getPlayerFromCell(board.getEndCellIdx());
	}
	
	public static void main(String[] args){
		String pName = "";
		List<Player> players = new ArrayList<Player>();
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("Entrez un nom pour ajouter un joueur à la partie de jeu de l'oie :");
			System.out.println("(Faites simplement entrée lorsque tous les joueurs ont été entrés)");
			pName = sc.nextLine();
			if(!pName.equals(""))
				players.add(new Player(pName));
		}while(!pName.equals(""));
		if(players.size()<=1){
			System.out.println("Il faut au moins deux joueur !");
			for(int i=players.size(); i<2;i++){
				players.add(new Player("Joueur "+(i+1)));
			}
		}
		Board board = new NormalBoard(players);
		Game game = new Game(players, board);
		sc.close();
		game.play();
	}
	

}

package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import jeudeloie.Board;
import jeudeloie.Game;
import jeudeloie.NormalBoard;
import jeudeloie.Player;

import org.junit.Before;
import org.junit.Test;

public class testGame {
	Board b ;
	Game g;
	List<Player> list_players ;
	@Before
	public void init() {
		list_players = new ArrayList<Player>();
		list_players.add(new Player("Toto"));
		list_players.add(new Player("Tata"));
		b  = new NormalBoard(list_players);
		g = new Game(list_players,b);
	}
	
	@Test
	public void testIsFinished() {
		assertFalse(g.isFinished());
		b.getEndCell().welcome(list_players.get(0));
		assertTrue(g.isFinished());
	}
	@Test
	public void testFinishedWhenTrapped() {
		assertFalse(g.isFinished());
		// 31 and 52 are the two trap cells
		b.moveTo(list_players.get(0),31);
		b.moveTo(list_players.get(1),52);
		assertTrue(g.isFinished());
	}
	
	@Test
	public void testNextPlayer() {
		assertEquals(list_players.get(0),g.nextPlayer());
	}
	@Test
	public void testDiceThrow() {
		assertTrue(g.diceThrow() > 1 && g.diceThrow()  <=12 && !(g.diceThrow()  < 1 || (g.diceThrow()  > 12)));
	}
	
	@Test
	public void testTheGame() {
		assertEquals(null,g.getWinner());
		assertFalse(g.isFinished());

	}
	
	@Test
	public void testGetWinner() {
		b.moveTo(list_players.get(0), 63);
		assertEquals(list_players.get(0),g.getWinner());
	}

}

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
import jeudeloie.TrapCell;

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
		TrapCell tc = new TrapCell(10);
		TrapCell tc2 = new TrapCell(12);
		tc.welcome(list_players.get(0));
		assertFalse(g.isFinished());
		tc2.welcome(list_players.get(1));
		assertTrue(g.isFinished());

	}
	
	@Test
	public void testNextPlayer() {
		assertEquals(list_players.get(0),g.nextPlayer());
	}
}

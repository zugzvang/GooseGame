package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import jeudeloie.Board;
import jeudeloie.GooseCell;
import jeudeloie.NormalBoard;
import jeudeloie.Player;
import jeudeloie.TeleportCell;
import jeudeloie.TrapCell;

import org.junit.Before;
import org.junit.Test;

public class testBoard {
	List<Player> list_player;
	Board b;
	Player p;

	@Before
	public void init() {
		list_player = new ArrayList<Player>();
		b = new NormalBoard(null);
		p = new Player("test");
	}
	
	@Test 
	public void testNamePlayer() {
		assertEquals("test",p.getName());
		
	}
	
	@Test
	public void testInitialScore() {
		assertEquals(0,p.getScore());
	}
	
	@Test
	public void testInitialIndex() {
		assertEquals(0,p.getCurrentCell());
	}

	@Test
	public void testNonTrappedPlayer() {
		list_player = new ArrayList<Player>();
		list_player.add(new Player("Robert"));
		b = new NormalBoard(list_player);
		assertFalse(b.arePlayersTrapped());
	}

	@Test
	public void testTrappedPlayer() {
		TrapCell tc = new TrapCell(5);
		tc.welcome(p);
		assertFalse(tc.canBeLeftNow());
		assertTrue(tc.isRetaining());
	}

	@Test
	public void testGooseCell() {
		GooseCell gc = new GooseCell(10);
		gc.welcome(p);
		gc.handleMove(5);
		assertEquals(15,gc.handleMove(5));
	}
	
	@Test
	public void testTeleportCell() {
		int destination = 10;
		TeleportCell tc = new TeleportCell(5, destination);
		tc.handleMove(5);
		assertEquals(10,tc.handleMove(5));
		
	}

	@Test
	public void testStartCell() {
		list_player = new ArrayList<Player>();
		list_player.add(new Player("Robert"));
		b = new NormalBoard(list_player);
		assertEquals(list_player.get(0), b.getPlayerFromCell(0));
	}

	@Test
	public void testMultiplePlayersStartCell() {
		list_player = new ArrayList<Player>();
		list_player.add(new Player("Robert"));
		list_player.add(new Player("Jean"));
		b = new NormalBoard(list_player);
		assertEquals(list_player.get(0), b.getPlayerFromCell(0));
	}

}

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
import jeudeloie.WaitCell;

import org.junit.Before;
import org.junit.Test;

public class testBoard {
	List<Player> list_player;
	Board b;
	Player p;

	@Before
	public void init() {
		list_player = new ArrayList<Player>();
		p = new Player("test");
		list_player.add(new Player("Michel"));
		list_player.add(new Player("Fabrice"));
		b = new NormalBoard(list_player);
	}

	@Test
	public void testNonTrappedPlayer() {
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
		assertEquals(15, gc.handleMove(5));
	}

	@Test
	public void testTeleportCell() {
		int destination = 10;
		TeleportCell tc = new TeleportCell(5, destination);
		tc.handleMove(5);
		assertEquals(10, tc.handleMove(5));

	}

	@Test
	public void testStartCell() {
		for(int i = 0 ; i < list_player.size();i++) {
			assertEquals(list_player.get(i), b.getPlayersAtStart().get(i));
		}
	}

	@Test
	public void testMultiplePlayersStartCell() {
		assertEquals(list_player.get(0), b.getPlayerFromCell(0));
	}

	@Test
	public void testNormalizeCell() {
		list_player.get(0).setCell(60);
		b.playTurn(list_player.get(0), 12);
		assertEquals(54, list_player.get(0).getCurrentCell());
	}
	
	@Test
	public void testWaitCell() {

		WaitCell wc = new WaitCell(10,3);
		wc.welcome(list_player.get(0));
		assertFalse(wc.canBeLeftNow());
		assertFalse(wc.canBeLeftNow());
		assertEquals(1,wc.getWaitTime());
		assertFalse(wc.canBeLeftNow());
		assertTrue(wc.canBeLeftNow());
		
	}
	@Test
	public void testWaitHandleMove() {
		WaitCell wc = new WaitCell(10,3);
		assertEquals(wc.getIndex(),wc.handleMove(10));
	}
	
	@Test
	public void testGetLastCell() {

		//assertEquals(,b.getEndCell());
	}


}

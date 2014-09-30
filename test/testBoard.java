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
	public void testStartIndex() {
		assertEquals(0,b.getCell(0).getIndex());
	}
	
	@Test
	public void testHandleMoveStartCell() {
		assertEquals(0,b.getCell(0).handleMove(10));
	}
	
	@Test
	public void testIsBusyStartCell() {
		assertEquals(false,b.getCell(0).isBusy());
	}

	@Test
	public void testMultiplePlayersStartCell() {
		assertEquals(list_player,b.getPlayersAtStart());
	}

	@Test
	public void testNormalizeCell() {
		list_player.get(0).setCell(55);
		b.playTurn(list_player.get(0), 8);
		System.out.println(""+list_player.get(0).getCurrentCell());
		assertEquals(63, list_player.get(0).getCurrentCell());
	}
	
	@Test
	public void testHandleMoveTrapCell() {
		assertEquals(52,b.getCell(52).handleMove(10));
	}
	
	@Test
	public void testCanBeLeftNowStartCell() {
		assertEquals(true,b.getCell(0).canBeLeftNow());
	}
	
	@Test
	public void testGetPlayerStartCell() {
		assertEquals(null,b.getCell(0).getPlayer());
	}
	@Test
	public void testitWaitCell() {

		WaitCell wc = new WaitCell(10,3);
		wc.welcome(list_player.get(0));
		assertFalse(wc.canBeLeftNow());
		assertFalse(wc.canBeLeftNow());
		assertEquals(1,wc.getitWaitTime());
		assertFalse(wc.canBeLeftNow());
		assertTrue(wc.canBeLeftNow());
		
	}
	
	@Test 
	public void testWaitCell() {
		WaitCell wc = new WaitCell(10,5);
		wc.welcome(list_player.get(0));
		assertEquals(5,wc.getWaitTime());
	}
	@Test
	public void testWaitHandleMove() {
		WaitCell wc = new WaitCell(10,3);
		assertEquals(wc.getIndex(),wc.handleMove(10));
	}
	
	@Test
	public void testGetLastCell() {

		assertEquals(b.getCell(b.getCells().size() - 1),b.getEndCell());
	}
	
	@Test
	public void testSwapPlayers() {
		list_player.get(0).setCell(2);
		list_player.get(1).setCell(3);
		b.swap(list_player.get(0), list_player.get(1));
		assertEquals(2,list_player.get(1).getCurrentCell());
		assertEquals(3,list_player.get(0).getCurrentCell());
	}


}

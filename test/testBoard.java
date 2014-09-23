package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import jeudeloie.Board;
import jeudeloie.NormalBoard;
import jeudeloie.Player;

import org.junit.Before;
import org.junit.Test;

public class testBoard {
	List<Player> list_player;
	Board b;
	
	@Before
	public void init() {

		list_player = new ArrayList<Player>();
		b = new NormalBoard(null);
	}
	
	@Test
	public void testTrappedPlayer() {
		list_player = new ArrayList<Player>();
		list_player.add(new Player("Robert"));
		b = new NormalBoard(list_player);
		assertFalse(b.arePlayersTrapped());
	}
	
	@Test
	public void testStartCell() {
		list_player = new ArrayList<Player>();
		list_player.add(new Player("Robert"));
		b = new NormalBoard(list_player);
		assertEquals(list_player.get(0),b.getPlayerFromCell(0));
	}
	
	@Test
	public void testMultiplePlayersStartCell() {
		list_player = new ArrayList<Player>();
		list_player.add(new Player("Robert"));
		list_player.add(new Player("Jean"));
		b = new NormalBoard(list_player);
		assertEquals(list_player.get(0),b.getPlayerFromCell(0));
	}

}

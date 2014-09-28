package test;

import static org.junit.Assert.*;
import jeudeloie.Player;

import org.junit.Before;
import org.junit.Test;

public class testPlayer {
	Player p;
	@Before
	public void init() {
		p = new Player("test");
	}
	@Test
	public void testName() {
		assertEquals("test",p.getName());
	}
	@Test
	public void testInitialCell() {
		assertEquals(0,p.getCurrentCell());
	}
	@Test
	public void testSetCell() {
		p.setCell(1);
		assertEquals(1,p.getCurrentCell());
		p.setCell(-1);
		assertEquals(0,p.getCurrentCell());
	}

}

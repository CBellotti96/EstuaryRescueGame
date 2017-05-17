package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ShoreTileTest {
	@Test
	public void testSetTileWidth(){
		ShoreTile test = new ShoreTile(20, 20, null);
        test.setTileWidth(40);
		int result = test.getTileWidth();
		int value  = 40;
		assertEquals(result,value);
}
	@Test
	public void testSetTileHeight(){
		ShoreTile test = new ShoreTile(20, 20, null);
        test.setTileHeight(40);
	    int result = test.getTileHeight();
	    int value  = 40;
		assertEquals(result,value);
}
	@Test
	public void testIsVacant(){
		ShoreTile test = new ShoreTile(20, 20, null);
        boolean result = test.isVacant();
        boolean value = false;
		assertEquals(result,value);
}
	@Test
	public void testSetTileErosion(){
		ShoreTile test = new ShoreTile(20, 20, null);
        test.setTileErosion(40);
	    int result = test.getTileErosion();
	    int value  = 40;
		assertEquals(result,value);
}
}

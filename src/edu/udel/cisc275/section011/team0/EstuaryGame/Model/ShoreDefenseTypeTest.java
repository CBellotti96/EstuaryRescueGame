package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ShoreDefenseTypeTest {
	@Test
	public void testSetShoreHealthEffect(){
		ShoreDefenseType example = new ShoreDefenseType("Sea Wall");
		example.setShoreHealthEffect(1.1);
		double result = example.getShoreHealthEffect();
		double value = 1.1;
		assertEquals(result, value,.001);
}
	@Test
	public void testSetDurability(){
		ShoreDefenseType example = new ShoreDefenseType("Sea Wall");
		example.setDurability(1.1);;
		double result = example.getDurability();
		double value = 1.1;
		assertEquals(result, value,.001);
}
	@Test
	public void testGetPlacementZoneStartY(){
		ShoreDefenseType example = new ShoreDefenseType("Sea Wall");
		double result = example.getPlacementZoneStartY();
		double value = 0;
		assertEquals(result, value,.001);
}
	@Test
	public void testGetPlacementZoneEndY(){
		ShoreDefenseType example = new ShoreDefenseType("Sea Wall");
		double result = example.getPlacementZoneEndY();
		double value = 0;
		assertEquals(result, value,.001);
}

}

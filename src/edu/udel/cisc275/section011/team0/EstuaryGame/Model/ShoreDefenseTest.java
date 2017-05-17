package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ShoreDefenseTest {
	@Test
	public void testSetContainedWithin(){
		ShoreModel test = new ShoreModel();
		ShoreDefense example = new ShoreDefense(test.getTiles().get(0).get(0)
				, test.getDefenseGabion());	
		example.setContainedWithin(test.getTiles().get(8).get(8));
		ShoreTile result = example.getContainedWithin();
		ShoreTile value =test.getTiles().get(8).get(8);
		assertEquals(result, value);
}
	@Test
	public void testGetType(){
		ShoreModel test = new ShoreModel();
		ShoreDefense example = new ShoreDefense(test.getTiles().get(0).get(0)
				, test.getDefenseGabion());	
		example.setContainedWithin(test.getTiles().get(8).get(8));
		ShoreDefenseType result = example.getType();
		ShoreDefenseType value =test.getDefenseGabion();
		assertEquals(result, value);
}
	@Test
	public void testSetDefenseDurability(){
		ShoreModel test = new ShoreModel();
		ShoreDefense example = new ShoreDefense(test.getTiles().get(0).get(0)
				, test.getDefenseGabion());	
		example.setDefenseDurability(3);
		double result = example.getDefenseDurability();
		double value =3;
		assertEquals(result, value,.001);
}
	@Test
	public void testSetIsGoodPlacement(){
		ShoreModel test = new ShoreModel();
		ShoreDefense example = new ShoreDefense(test.getTiles().get(0).get(0)
				, test.getDefenseGabion());	
		example.setIsGoodPlacement(false);
		boolean result = example.getIsGoodPlacement();
		boolean value =false;
		assertEquals(result, value);
}
}
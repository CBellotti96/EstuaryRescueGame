package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ShoreItemTest {
	@Test
	public void testGetType(){
		ShoreModel test = new ShoreModel();
		ShoreItem example = new ShoreItem(null, test.getItemOyster());
		ShoreItemType result = example.getType();
		ShoreItemType value = test.getItemOyster();
		assertEquals(result, value);
}
	@Test
	public void testSetContainedWithin(){
		ShoreModel test = new ShoreModel();
		ShoreItem example = new ShoreItem(null, test.getItemOyster());
		example.setContainedWithin(test.getTiles().get(1).get(1));
		ShoreTile result = example.getContainedWithin();
		ShoreTile value = test.getTiles().get(1).get(1);
		assertEquals(result, value);
}

}

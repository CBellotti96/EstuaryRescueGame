package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ShoreItemTypeTest {
	@Test
	public void testGetType(){
		ShoreModel test = new ShoreModel();
		ShoreItemType example = new ShoreItemType("Seed");
		ShoreTileType result = example.getSpawnArea();
		ShoreTileType value = ShoreTileType.BEACH;
		assertEquals(result, value);
}
	@Test
	public void testBuildsDefense(){
		ShoreModel test = new ShoreModel();
		ShoreItemType example = new ShoreItemType("Seed");
		ShoreDefenseType result = example.getBuildsDefense();
		ShoreDefenseType value = null;
		assertEquals(result, value);
}
}

package edu.udel.cisc275.section011.team0.EstuaryGame.Model;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;
public class ShoreModelTest {
@Test
public void testSetBuildDefense(){
	ShoreModel test = new ShoreModel();
    test.setBuildDefense(false);
    boolean result = test.isBuildDefense();
	boolean value = false;
	assertEquals(value,result);
}
@Test
public void testSetBoats(){
	ShoreModel test = new ShoreModel();
	ArrayList<ShoreBoat> sample =new ArrayList<ShoreBoat>();
	sample.add(new ShoreBoat(null,4,null));
	test.setBoats(sample);
	ArrayList<ShoreBoat> result =test.getBoats();
	ArrayList<ShoreBoat> value = sample;
	assertEquals(value,result);
}
@Test
public void testSetWaves(){
	ShoreModel test = new ShoreModel();
	ArrayList<ShoreWave> sample =new ArrayList<ShoreWave>();
	sample.add(new ShoreWave(null, 0, 0));
	test.setWaves(sample);
	ArrayList<ShoreWave> result =test.getWaves();
	ArrayList<ShoreWave> value = sample;
	assertEquals(value,result);
}
@Test
public void testSetItems(){ //fails
	ShoreModel test = new ShoreModel();
	ShoreItem subsample = new ShoreItem(null, null);
	ArrayList<ShoreItem> sample =new ArrayList<ShoreItem>();
	sample.add(subsample);
	test.setItems(sample);
	ArrayList<ShoreItem> result =test.getItems();
	ArrayList<ShoreItem> value = sample;
	assertEquals(value,result);
}
@Test
public void testSetItemRock(){
	ShoreModel test = new ShoreModel();
	ShoreItemType sample = new ShoreItemType("Rock");
	test.setItemRock(sample);
	ShoreItemType result = test.getItemRock();
	ShoreItemType value = sample;
}
@Test
public void testSetItemOyster(){
	ShoreModel test = new ShoreModel();
	ShoreItemType sample = new ShoreItemType("Oyster");
	test.setItemOyster(sample);
	ShoreItemType result = test.getItemOyster();
	ShoreItemType value = sample;
	assertEquals(value,result);
}
@Test
public void testSetItemSeed(){
	ShoreModel test = new ShoreModel();
	ShoreItemType sample = new ShoreItemType("Seed");
	test.setItemSeed(sample);
	ShoreItemType result = test.getItemSeed();
	ShoreItemType value = sample;
	assertEquals(value,result);
}
@Test
public void testSetInventoy(){
	ShoreModel test = new ShoreModel();
	HashMap<ShoreItemType,Integer> sample =new HashMap<ShoreItemType,Integer>();
	sample.put(null, 0);
	test.setInventory(sample);
	HashMap<ShoreItemType, Integer>result =test.getInventory();
	HashMap<ShoreItemType, Integer> value = sample;
	assertEquals(value,result);
}
@Test
public void testSetCountdown(){
	ShoreModel test = new ShoreModel();
	test.setCountdown(2);
	int result = test.getCountdown();
	int value = 2;
	assertEquals(value,result);
}
@Test
public void testSetShoreHealth(){
	ShoreModel test = new ShoreModel();
	test.setShoreHealth(2);
	Double result = test.getShoreHealth();
	Double value = 2.0;
	assertEquals(value,result);
}
@Test
public void testSetTilesInRow(){
	ShoreModel test = new ShoreModel();
	test.setTilesInRow(2);
	int result = test.getTilesInRow();
    int value = 2;
	assertEquals(value,result);
}
@Test
public void testSetTiles(){
	ShoreModel test = new ShoreModel();
	ArrayList<ShoreTile> subsample = new ArrayList<ShoreTile>();
	subsample.add(new ShoreTile(0, 0, null));
	ArrayList<ArrayList<ShoreTile>> sample =new ArrayList<ArrayList<ShoreTile>>();
	sample.add(subsample);
	test.setTiles(sample);
	ArrayList<ArrayList<ShoreTile>> result =test.getTiles();
	ArrayList<ArrayList<ShoreTile>> value = sample;
	assertEquals(value,result);
}
@Test
public void testSetTilesInColumn(){
	ShoreModel test = new ShoreModel();
	test.setTilesInColumn(2);
	int result = test.getTilesInColumn();
    int value = 2;
	assertEquals(value,result);
}
@Test
public void testSetTileHeight(){
	ShoreModel test = new ShoreModel();
	test.setTileHeight(2);
	int result = test.getTileHeight();
    int value = 2;
	assertEquals(value,result);
}
@Test
public void testSetTileWidth(){
	ShoreModel test = new ShoreModel();
	test.setTileWidth(2);
	int result = test.getTileWidth();
    int value = 2;
	assertEquals(value,result);
}
}

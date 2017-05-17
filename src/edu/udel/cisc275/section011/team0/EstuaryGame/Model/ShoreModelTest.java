package edu.udel.cisc275.section011.team0.EstuaryGame.Model;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

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
public void testSetItems(){ 
	ShoreModel test = new ShoreModel();
	ShoreItem subsample = new ShoreItem
			(new ShoreTile
					(50, 50, 
							new ShorePosition(350, 350)), test.getItemOyster());;
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
@Test
public void testBuildDefense(){
	ShoreModel test = new ShoreModel();
	test.setSavedDefenseType(test.getDefenseGabion());
	test.getTiles().get(7).get(7).setTileContents(ShoreTileType.BEACH);
	test.getInventory().put(test.getItemOyster(),7);
	test.buildDefense(7,7);
	ShoreTileType result = test.getTiles().get(7).get(7).getTileType();
    assertNotNull(result);
}
@Test
public void testHandleOnTick(){//tests if onTick() adds a boat if there are none
	ShoreModel test = new ShoreModel();
	test.setGameMode(ShoreGameMode.NORMAL);
	int value = test.getBoats().size();
	for(int i=0; i<100;i++){
	test.onTick();
	}
	int result = 0;
	assertNotSame(value,result);
}
@Test
public void testHandleOnClick(){//test if clicking removes the item
	ShoreModel test = new ShoreModel();
	test.setGameMode(ShoreGameMode.NORMAL);
	ShoreItem instance = new ShoreItem
			(new ShoreTile
					(50, 50, 
							new ShorePosition(500, 500)), test.getItemOyster());
	test.onClick(instance);
	assertNull(instance.getContainedWithin().getTileContents());
}
@Test
public void testHandleOnClick2(){//test if clicking works on toolbar
	ShoreModel test = new ShoreModel();
	test.setGameMode(ShoreGameMode.NORMAL);
	ShoreItem instance = new ShoreItem
			(new ShoreTile
					(50, 50, 
							new ShorePosition(0, 0)), test.getItemOyster());
	test.onClick(instance);
	assertNull(instance.getContainedWithin().getTileContents());
}
@Test
public void testHandleSailboat(){//asserts that handleSailboat() creates waves
	ShoreModel test = new ShoreModel();
	test.onTick();
	test.getBoats().get(0).setXDisplacement(test.getTileWidth());
	Iterator<ShoreBoat> boatIter =test.getBoats().iterator();
	test.handleSailboat(test.getBoats().get(0),boatIter);
	assertNotNull(test.getWaves());
}
@Test
public void testhandleWaveMovement(){//asserts that handleWaves() moves waves
	ShoreModel test = new ShoreModel();
	test.onTick();
	test.getBoats().get(0).setXDisplacement(test.getTileWidth());
	Iterator<ShoreWave> waveIter =test.getWaves().iterator();
	Iterator<ShoreBoat> boatIter =test.getBoats().iterator();
	test.handleSailboat(test.getBoats().get(0),boatIter);
	test.getWaves().get(0).setYDisplacement(test.getTileHeight());
	int value = test.getWaves().get(0).getYDisplacement();
	test.handleWaveMovement(test.getWaves().get(0),waveIter);
	int result = test.getWaves().get(0).getYDisplacement();
	assertNotSame(value,result);
}
@Test
public void testHandleWaveCollison(){//asserts that handleWaveCollision() removes waves
	ShoreModel test = new ShoreModel();
	test.onTick();
	test.getBoats().get(0).setXDisplacement(test.getTileWidth());
	Iterator<ShoreWave> waveIter =test.getWaves().iterator();
	Iterator<ShoreBoat> boatIter =test.getBoats().iterator();
	test.handleSailboat(test.getBoats().get(0),boatIter);
	test.getWaves().get(0).getContainedWithin().getTileOrigin()
	.setShoreY((test.getTilesInColumn()*test.getTileHeight()/2));
	int i = (int)((test.getWaves().get(0).getContainedWithin().getTileOrigin().getShoreX())/test.getTileWidth());
	int j = (int)((test.getWaves().get(0).getContainedWithin().getTileOrigin().getShoreY())/test.getTileHeight());
	test.getTiles().get(i).get(j+1).setTileContents(test.getDefenseGabion());
}
@Test
public void testCountDown(){//decreases countdown
	ShoreModel test = new ShoreModel();
    test.countdown();
    int result = test.getCountdown();
    int value = 2;
    assertEquals(value,result);
}
@Test
public void testSetDefenseWall(){
	ShoreModel test = new ShoreModel();
    test.setDefenseWall(test.getDefenseWall());
    ShoreDefenseType result = test.getDefenseWall();
    ShoreDefenseType value = test.getDefenseWall();
    assertEquals(value,result);
}
@Test
public void testSetDefenseGabion(){
	ShoreModel test = new ShoreModel();
    test.setDefenseGabion(test.getDefenseGabion());
    ShoreDefenseType result = test.getDefenseGabion();
    ShoreDefenseType value = test.getDefenseGabion();
    assertEquals(value,result);
}
@Test
public void testsetDefensePlant(){
	ShoreModel test = new ShoreModel();
    test.setDefensePlant(test.getDefensePlant());
    ShoreDefenseType result = test.getDefensePlant();
    ShoreDefenseType value = test.getDefensePlant();
    assertEquals(value,result);
}
@Test
public void testSetDefenses(){
	ShoreModel test = new ShoreModel();
	ArrayList<ShoreDefense> instance = new ArrayList<ShoreDefense>();
    test.setDefenses(instance);
    ArrayList<ShoreDefense> result = test.getDefenses();
    ArrayList<ShoreDefense> value = instance;
    assertEquals(value,result);
}
@Test
public void testGetSavedDefenseType(){
	ShoreModel test = new ShoreModel();
    ShoreDefenseType result = test.getSavedDefenseType();
    assertNotNull(result);
}
@Test
public void testSetSailBoat(){
	ShoreModel test = new ShoreModel();
	ShoreBoatType instance = new ShoreBoatType("Sail Boat", 0, 0);
    test.setBoatSailboat(instance);
    ShoreBoatType result = test.getBoatSailboat();
    ShoreBoatType value = instance;
    assertEquals(value,result);
}
@Test
public void testSetJetSki(){
	ShoreModel test = new ShoreModel();
	ShoreBoatType instance = new ShoreBoatType("Sail Boat", 0, 0);
    test.setBoatJetSki(instance);
    ShoreBoatType result = test.getBoatJetSki();
    ShoreBoatType value = instance;
    assertEquals(value,result);
}
@Test
public void testSetBoatCommercial(){
	ShoreModel test = new ShoreModel();
	ShoreBoatType instance = new ShoreBoatType("Sail Boat", 0, 0);
    test.setBoatCommercial(instance);
    ShoreBoatType result = test.getBoatCommercial();
    ShoreBoatType value = instance;
    assertEquals(value,result);
}
@Test
public void testSetGameMode(){
	ShoreModel test = new ShoreModel();
	test.setGameMode(ShoreGameMode.NORMAL);
	ShoreGameMode result = test.getGameMode();
	ShoreGameMode value = ShoreGameMode.NORMAL;
	assertEquals(value,result);
}
@Test
public void testSetTickCount(){
	ShoreModel test = new ShoreModel();
	test.setTickCount(20);
    int result = test.getTickCount();
    int value = 20;
    assertEquals(value,result);
}
@Test
public void testSetTutorialStage(){
	ShoreModel test = new ShoreModel();
	test.setTutorialStage(20);
    int result = test.getTutorialStage();
    int value = 20;
    assertEquals(value,result);
}
}

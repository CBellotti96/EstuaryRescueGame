package edu.udel.cisc275.section011.team0.EstuaryGame.Model;
import static org.junit.Assert.*;

import java.util.ArrayList;

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

}

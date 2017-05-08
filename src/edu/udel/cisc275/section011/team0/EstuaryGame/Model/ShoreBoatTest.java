package edu.udel.cisc275.section011.team0.EstuaryGame.Model;
import static org.junit.Assert.*;
import org.junit.Test;

public class ShoreBoatTest {
@Test
public void testShoreBoatConstructor() {
	ShoreBoat test = new ShoreBoat(null,0,null);
	int result = test.getXDisplacement();
	final int value = 0;
	assertEquals(value,result);
}
@Test
public void testShoreBoatConstructor2() { //fails
	ShoreBoat test = new ShoreBoat(null,3,null);
	int result = test.getXDisplacement();
	final int value = 0;
	assertEquals(value,result);
}
@Test
public void testSetCountNumWaves(){
	ShoreBoat test = new ShoreBoat(null,3,null);
	test.setCountNumWaves(3);
	int result =test.getCountNumWaves();
	int value = 3;
	assertEquals(value,result);
}
@Test
public void testSetCountNumWaves2(){//fails
	ShoreBoat test = new ShoreBoat(null,4,null);
	test.setCountNumWaves(4);
	int result =test.getCountNumWaves();
	int value = 3;
	assertEquals(value,result);
}
@Test
public void testSetXDisplacement(){
	ShoreBoat test = new ShoreBoat (null,0,null);
	test.setXDisplacement(3);
	int result =test.getXDisplacement();
	int value = 3;
	assertEquals(value ,result);
}
@Test
public void testSetXDisplacement2(){//fails
	ShoreBoat test = new ShoreBoat (null,0,null);
	test.setXDisplacement(3);
	int result =test.getXDisplacement();
	int value = 4;
	assertEquals(value ,result);
}

@Test
public void testSetWaveTile(){
	ShoreBoat test = new ShoreBoat (null,0,null);
	test.setWaveTile(3);
	int result =test.getWaveTile();
	int value = 3;
	assertEquals(value ,result);
}
@Test
public void testSetWaveTile2(){//fails
	ShoreBoat test = new ShoreBoat (null,0,null);
	test.setWaveTile(3);
	int result =test.getWaveTile();
	int value = 4;
	assertEquals(value ,result);
}
@Test
public void testSetContainedWithin(){
	ShoreBoat test = new ShoreBoat (null,0,null);
	ShoreTile testsample = new ShoreTile(0, 0, null);
	test.setContainedWithin(testsample);
	ShoreTile result =test.getContainedWithin();
	ShoreTile value = testsample;
	assertEquals(value ,result);
}
@Test
public void testSetContainedWithin2(){//fails
	ShoreBoat test = new ShoreBoat (null,0,null);
	ShoreTile testsample = new ShoreTile(0, 0, null);
	test.setContainedWithin(testsample);
	ShoreTile result =test.getContainedWithin();
	ShoreTile value = null;
	assertEquals(value ,result);
}
@Test
public void testgetType(){
	ShoreBoatType testsample = new ShoreBoatType("Sail Boat", 0, 0);
	ShoreBoat test = new ShoreBoat 
			(null,0,testsample);
	ShoreBoatType result =test.getType();
	ShoreBoatType value =testsample;
	assertEquals(value ,result);
}
@Test
public void testgetType2(){//fails
	ShoreBoatType testsample = new ShoreBoatType("Sail Boat", 0, 0);
	ShoreBoat test = new ShoreBoat 
			(null,0,testsample);
	ShoreBoatType result =test.getType();
	ShoreBoatType value =null;
	assertEquals(value ,result);
}
}
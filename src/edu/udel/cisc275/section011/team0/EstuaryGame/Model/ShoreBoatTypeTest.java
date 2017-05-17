package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ShoreBoatTypeTest {
	@Test
	public void testgetName(){
		ShoreBoatType testsample = new ShoreBoatType("Sail Boat", 0, 0);
		ShoreBoat test = new ShoreBoat 
				(null,0,testsample);
		String result =test.getType().getName();
		String value ="Sail Boat";
		assertEquals(value ,result);
	}
}

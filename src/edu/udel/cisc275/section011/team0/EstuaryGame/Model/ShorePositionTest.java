package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ShorePositionTest {
	@Test
	public void testSetShoreX(){
		ShorePosition test = new ShorePosition(20, 20);
        test.setShoreX(40);
		double value =test.getShoreX();
		double result = 40;
		assertEquals(result,value,.001);
}
	@Test
	public void testIncrY(){
		ShorePosition test = new ShorePosition(20, 20);
        test.incrY(20);
		double result = test.getShoreY();
		double value = 40;
		assertEquals(value,result,.001);
}
}

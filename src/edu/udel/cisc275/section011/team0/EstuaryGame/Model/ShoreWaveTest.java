package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ShoreWaveTest {
	@Test
	public void testgetWaveStrength(){
		ShoreWave test = new ShoreWave(null, 0, 2);
		double result = test.getWaveStrength();
		double value = 2;
		assertEquals(value,result,.001);
	}
}

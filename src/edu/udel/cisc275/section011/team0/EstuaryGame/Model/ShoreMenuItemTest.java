package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import static org.junit.Assert.assertEquals;

import java.awt.Rectangle;

import org.junit.Test;

import edu.udel.cisc275.section011.team0.EstuaryGame.Common.Main;
import edu.udel.cisc275.section011.team0.EstuaryGame.Controller.ShoreController;

public class ShoreMenuItemTest {
	@Test
	public void testGetName(){
		ShoreMenuItem test = new ShoreMenuItem();
		String result = test.getName();
		String value ="Shore Defense";
		assertEquals(result,value);
}
}

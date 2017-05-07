package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import static org.junit.Assert.*;

import java.awt.Rectangle;

import org.junit.Test;

public class StoryCubeTest {

	@Test
	public void testIncrementRoll() {
		StoryCube sc = new StoryCube(0);
		int n = 86;
		for (int i = 0; i < n; i++)
			sc.incrementRoll();
		assertEquals(n % 10, sc.getRollState());
	}

	@Test
	public void testGetRect() {
		StoryCube sc = new StoryCube(0);
		int x = 30;
		int y = 20;
		double scale = 1.0;
		int xMargin = 0;
		int scaledSize = (int) scale * StoryCube.size;
		double halfSize = scaledSize / 2;
		Rectangle expected = new Rectangle((int) (x * scale - halfSize) + xMargin, (int) (y * scale - halfSize), scaledSize, scaledSize);
		System.out.println(expected);
		sc.setX(30);
		sc.setY(20);
		Rectangle actual = sc.getRect(scale, xMargin);
		System.out.println(actual);
		assertEquals(expected, actual);
	}

	@Test
	public void testMove() {
		fail("Not yet implemented");
	}

}

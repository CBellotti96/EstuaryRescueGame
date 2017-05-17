package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import static org.junit.Assert.*;

import java.awt.Point;
import java.awt.Rectangle;

import org.junit.Test;

public class StoryCubePositionTest {
	
	@Test
	public void testGetAllPositions() {
		int n = 4;
		StoryCubePosition.initializePositions(n);
		for (StoryCubePosition scp : StoryCubePosition.getStartPositions())
			assertTrue(StoryCubePosition.getAllPositions().contains(scp));
		for (StoryCubePosition scp : StoryCubePosition.getEndPositions())
			assertTrue(StoryCubePosition.getAllPositions().contains(scp));
	}
	
	@Test
	public void testInitializePositions() {
		int n = 4;
		int startInterval = StoryModel.xCoordMax / 3;
		Point startIndexTwo = new Point(startInterval * 2, 30);
		double xOffset = StoryModel.xCoordMax / 2 - 2 * StoryCube.size + StoryCube.size / 2;
		Point endIndexTwo = new Point((int) (xOffset + StoryCube.size * 2), 60);
		
		StoryCubePosition.initializePositions(n);
		StoryCubePosition startTwo = StoryCubePosition.getStartPositions().get(2);
		Point startTwoPoint = new Point(startTwo.getX(), startTwo.getY());
		StoryCubePosition endTwo = StoryCubePosition.getEndPositions().get(2); 
		Point endTwoPoint = new Point(endTwo.getX(), endTwo.getY());
		assertEquals(startIndexTwo, startTwoPoint);
		assertEquals(endIndexTwo, endTwoPoint);
	}

	@Test
	public void testGetRect() {
		int size = StoryCubePosition.size;
		Rectangle expected = new Rectangle(80 - size / 2, 60 - size / 2, size, size);
		Rectangle actual = StoryCubePosition.center.getRect(1, 0);
		assertEquals(expected, actual);
	}

}

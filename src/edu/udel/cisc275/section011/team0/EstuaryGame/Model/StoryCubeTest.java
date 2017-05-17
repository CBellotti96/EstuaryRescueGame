package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import static org.junit.Assert.*;

import java.awt.Rectangle;

import org.junit.Test;

import edu.udel.cisc275.section011.team0.EstuaryGame.View.StoryView;

public class StoryCubeTest {
	
	@Test
	public void testGetCubeFace() {
		StoryCube sc = new StoryCube(0);
		assertTrue(sc.getCubeFace() < StoryView.numImages);
	}
	
	@Test
	public void testIsSelected() {
		StoryCube sc = new StoryCube(0);
		assertFalse(sc.isSelected());
		sc.setSelected(true);
		assertTrue(sc.isSelected());
	}
	
	@Test
	public void testIsRolling() {
		int n = 4;
		StoryModel sm = new StoryModel(n);
		StoryCube sc = new StoryCube(0);
		assertFalse(sc.isRolling());
		sc.setRolling(StoryCubePosition.getStartPositions().get(0));
		assertTrue(sc.isRolling());
	}

	@Test
	public void testIncrementRoll() {
		StoryCube sc = new StoryCube(0);
		int n = 86;
		for (int i = 0; i < n; i++)
			sc.incrementRoll();
		assertEquals(n, sc.getRollState());
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
		sc.setX(30);
		sc.setY(20);
		Rectangle actual = sc.getRect(scale, xMargin);
		assertEquals(expected, actual);
	}

	@Test
	public void testMoveSnapIntoPlace() {
		StoryCube sc = new StoryCube(0);
		int targetX = sc.getCubePos().getX();
		int targetY = sc.getCubePos().getY();
		int x = targetX - StoryCube.speed;
		int y = targetY - StoryCube.speed;
		sc.setX(x);
		sc.setY(y);
		sc.move();
		int newX = (int) sc.getRect(1, 0).getCenterX();
		int newY = (int) sc.getRect(1, 0).getCenterY();
		assertEquals(targetX, newX);
		assertEquals(targetY, newY);
	}
	
	@Test
	public void testMoveSnapXAbove() {
		StoryCube sc = new StoryCube(0);
		int targetX = sc.getCubePos().getX();
		int targetY = sc.getCubePos().getY();
		int x = targetX - StoryCube.speed;
		int y = targetY - 3 * StoryCube.speed;
		sc.setX(x);
		sc.setY(y);
		sc.move();
		int newX = (int) sc.getRect(1, 0).getCenterX();
		int newY = (int) sc.getRect(1, 0).getCenterY();
		assertEquals(targetX, newX);
		assertEquals(y + StoryCube.speed, newY);
	}
	
	@Test
	public void testMoveSnapXBelow() {
		StoryCube sc = new StoryCube(0);
		int targetX = sc.getCubePos().getX();
		int targetY = sc.getCubePos().getY();
		int x = targetX - StoryCube.speed;
		int y = targetY + 3 * StoryCube.speed;
		sc.setX(x);
		sc.setY(y);
		sc.move();
		int newX = (int) sc.getRect(1, 0).getCenterX();
		int newY = (int) sc.getRect(1, 0).getCenterY();
		assertEquals(targetX, newX);
		assertEquals(y - StoryCube.speed, newY);
	}
	
	@Test
	public void testMoveSnapYLeft() {
		StoryCube sc = new StoryCube(0);
		int targetX = sc.getCubePos().getX();
		int targetY = sc.getCubePos().getY();
		int x = targetX - 3 * StoryCube.speed;
		int y = targetY - StoryCube.speed;
		sc.setX(x);
		sc.setY(y);
		sc.move();
		int newX = (int) sc.getRect(1, 0).getCenterX();
		int newY = (int) sc.getRect(1, 0).getCenterY();
		assertEquals(x + StoryCube.speed, newX);
		assertEquals(targetY, newY);
	}
	
	@Test
	public void testMoveSnapYRight() {
		StoryCube sc = new StoryCube(0);
		int targetX = sc.getCubePos().getX();
		int targetY = sc.getCubePos().getY();
		int x = targetX + 3 * StoryCube.speed;
		int y = targetY - StoryCube.speed;
		sc.setX(x);
		sc.setY(y);
		sc.move();
		int newX = (int) sc.getRect(1, 0).getCenterX();
		int newY = (int) sc.getRect(1, 0).getCenterY();
		assertEquals(x - StoryCube.speed, newX);
		assertEquals(targetY, newY);
	}
	
	@Test
	public void testMoveSE() {
		StoryCube sc = new StoryCube(0);
		int targetX = sc.getCubePos().getX();
		int targetY = sc.getCubePos().getY();
		int x = targetX - 3 * StoryCube.speed;
		int y = targetY - 3 * StoryCube.speed;
		sc.setX(x);
		sc.setY(y);
		sc.move();
		int newX = (int) sc.getRect(1, 0).getCenterX();
		int newY = (int) sc.getRect(1, 0).getCenterY();
		assertEquals(x + StoryCube.speed, newX);
		assertEquals(y + StoryCube.speed, newY);
	}
	
	@Test
	public void testMoveSW() {
		StoryCube sc = new StoryCube(0);
		int targetX = sc.getCubePos().getX();
		int targetY = sc.getCubePos().getY();
		int x = targetX + 3 * StoryCube.speed;
		int y = targetY - 3 * StoryCube.speed;
		sc.setX(x);
		sc.setY(y);
		sc.move();
		int newX = (int) sc.getRect(1, 0).getCenterX();
		int newY = (int) sc.getRect(1, 0).getCenterY();
		assertEquals(x - StoryCube.speed, newX);
		assertEquals(y + StoryCube.speed, newY);
	}
	
	@Test
	public void testMoveNE() {
		StoryCube sc = new StoryCube(0);
		int targetX = sc.getCubePos().getX();
		int targetY = sc.getCubePos().getY();
		int x = targetX - 3 * StoryCube.speed;
		int y = targetY + 3 * StoryCube.speed;
		sc.setX(x);
		sc.setY(y);
		sc.move();
		int newX = (int) sc.getRect(1, 0).getCenterX();
		int newY = (int) sc.getRect(1, 0).getCenterY();
		assertEquals(x + StoryCube.speed, newX);
		assertEquals(y - StoryCube.speed, newY);
	}
	
	@Test
	public void testMoveNW() {
		StoryCube sc = new StoryCube(0);
		int targetX = sc.getCubePos().getX();
		int targetY = sc.getCubePos().getY();
		int x = targetX + 3 * StoryCube.speed;
		int y = targetY + 3 * StoryCube.speed;
		sc.setX(x);
		sc.setY(y);
		sc.move();
		int newX = (int) sc.getRect(1, 0).getCenterX();
		int newY = (int) sc.getRect(1, 0).getCenterY();
		assertEquals(x - StoryCube.speed, newX);
		assertEquals(y - StoryCube.speed, newY);
	}
	
	@Test
	public void testMoveSelected() {
		StoryCube sc = new StoryCube(0);
		int x = sc.getCubePos().getX();
		int y = sc.getCubePos().getY();
		sc.setSelected(true);
		sc.move();
		int newX = (int) sc.getRect(1, 0).getCenterX();
		int newY = (int) sc.getRect(1, 0).getCenterY();
		assertEquals(x, newX);
		assertEquals(y, newY);
	}

}

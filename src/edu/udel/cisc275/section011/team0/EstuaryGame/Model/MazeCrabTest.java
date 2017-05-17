package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class MazeCrabTest {

	MazeCrab test = new MazeCrab(0,0);
	
	@Test
	public void MazeCrabConstructorTest(){
		String result = test.toString();
		final String expectedValue = "crab";
		assertEquals(expectedValue, result);
	}
	
	@Test
	public void moveTest(){
		double initXPos = test.getXPos();
		double initYPos = test.getYPos();
		test.move(Direction.SOUTH);
		test.move(Direction.EAST);
		double currXPos = test.getXPos();
		double currYPos = test.getYPos();
		
		assertNotEquals(initXPos, currXPos);
		assertNotEquals(initYPos, currYPos);
	}
	
	@Test
	public void resetSpeedTest(){
		test.setSpeed(4.0);
		double initSpeed = test.getSpeed();
		test.resetSpeed();
		double currSpeed = test.getSpeed();
		
		assertNotEquals(initSpeed, currSpeed);
		assertEquals(currSpeed, test.getDefaultSpeed(), initSpeed-currSpeed);
	}
	
	@Test
	public void markCheckpointTest(){
		MazeCrab checkpointTestCrab = new MazeCrab(5.0, 7.0);
		checkpointTestCrab.markCheckpoint();
		
		assertEquals(5.0, checkpointTestCrab.getXCheckpointPos(), 0);
		assertEquals(7.0, checkpointTestCrab.getYCheckpointPos(), 0);
	}
	
	@Test
	public void resetToCheckpointTest(){
		MazeCrab checkpointTestCrab = new MazeCrab(5.0, 7.0);
		checkpointTestCrab.markCheckpoint();
		checkpointTestCrab.move(Direction.SOUTH);
		checkpointTestCrab.move(Direction.WEST);
		double initXPos = checkpointTestCrab.getXPos();
		double initYPos = checkpointTestCrab.getYPos();
		checkpointTestCrab.resetToCheckpoint();
		
		assertNotEquals(initXPos, checkpointTestCrab.getXPos());
		assertEquals(checkpointTestCrab.getXCheckpointPos(), checkpointTestCrab.getXPos(), 0);
		assertNotEquals(initYPos, checkpointTestCrab.getYPos());
		assertEquals(checkpointTestCrab.getYCheckpointPos(), checkpointTestCrab.getYPos(), 0);
	}
	
	@Test
	public void getXCheckpointPosTest(){
		MazeCrab checkpointTestCrab = new MazeCrab(5.0, 7.0);
		checkpointTestCrab.markCheckpoint();
		
		assertEquals(5.0, checkpointTestCrab.getXCheckpointPos(),0);
	}
	
	@Test
	public void getYCheckpointPosTest(){
		MazeCrab checkpointTestCrab = new MazeCrab(5.0, 7.0);
		checkpointTestCrab.markCheckpoint();
		
		assertEquals(7.0, checkpointTestCrab.getYCheckpointPos(),0);
	
	}
	
	@Test
	public void detectCollisionTest(){
		MazeEntity obstacle1 = new MazeObstacle(0.4, 1.0, 0.0, MazeObstacleType.SEAWEED);
		boolean collidedObstacle1 = test.detectCollision(obstacle1);
		assertEquals(false, collidedObstacle1);
		
		MazeEntity obstacle2 = new MazeObstacle(1.0, 0.4, 0.0, MazeObstacleType.SEAWEED);
		boolean collidedObstacle2 = test.detectCollision(obstacle2);
		assertEquals(false, collidedObstacle2);
		
		MazeEntity predator = new MazePredator(0.0, 0.0, 1, 1);
		boolean collidedPredator = test.detectCollision(predator);
		assertEquals(true, collidedPredator);
		
	}
	
	@Test
	public void handleCollisionTest(){
		MazeEntity predator = new MazePredator(0.0, 0.0, 1, 1);
		test.markCheckpoint();
		test.move(Direction.SOUTH);
		test.move(Direction.EAST);

		test.setIsColliding(false);
		test.handleCollision(predator);
		assertNotEquals(test.getXCheckpointPos(), test.getXPos(), 0);
		assertNotEquals(test.getYCheckpointPos(), test.getYPos(), 0);
	
		test.setIsColliding(true);
		test.handleCollision(predator);
		assertEquals(test.getXCheckpointPos(), test.getXPos(), 0);
		assertEquals(test.getYCheckpointPos(), test.getYPos(), 0);
	
		
		MazeEntity trash = new MazeObstacle(0.0, 0.0, 0.0, MazeObstacleType.TRASH);

		test.setIsColliding(false);
		test.handleCollision(trash);
		assertEquals(test.getDefaultSpeed(), test.getSpeed(), 0);
	
		test.setIsColliding(true);
		test.handleCollision(trash);
		assertNotEquals(test.getDefaultSpeed(), test.getSpeed(), 0);
	
		test.resetSpeed();
		MazeEntity seaweed = new MazeObstacle(0.0, 0.0, 0.0, MazeObstacleType.SEAWEED);
		test.setIsColliding(false);
		test.handleCollision(seaweed);
		assertEquals(test.getDefaultSpeed(), test.getSpeed(), 0);
	
		test.setIsColliding(true);
		test.handleCollision(seaweed);
		assertNotEquals(test.getDefaultSpeed(), test.getSpeed(), 0);
	
	}
	
	@Test
	public void testGetDefaultWidth(){
		assertEquals(0.5, test.getDefaultWidth(), 0);
	}
	
	@Test
	public void testGetDefaultHeight(){
		assertEquals(0.5, test.getDefaultHeight(), 0);
	}
	
}

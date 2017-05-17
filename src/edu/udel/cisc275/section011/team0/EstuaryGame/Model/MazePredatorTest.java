package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import org.junit.Test;
import static org.junit.Assert.*;

public class MazePredatorTest {
	
	MazePredator test = new MazePredator(0,0,1,1);
	
	@Test
	public void moveTest(){
		double initXPos = test.getXPos();
		double initYPos = test.getYPos();
		test.move();
		
		assertNotEquals(initXPos, test.getXPos(), 0);
		assertNotEquals(initYPos, test.getYPos(), 0);
		
		test.setXPos(test.getXPos()+test.getMaxDistanceFromSpawn()+1);
		test.setYPos(test.getYPos()+test.getMaxDistanceFromSpawn()+1);
		test.move();
		assertNotEquals(initXPos, test.getXPos(), 0);
		assertNotEquals(initYPos, test.getYPos(), 0);
	
		test.setXPos(test.getXPos()+test.getSpawnX()+1);
		test.setYPos(test.getYPos()+test.getSpawnY()+1);
		test.move();
		assertNotEquals(initXPos, test.getXPos(), 0);
		assertNotEquals(initYPos, test.getYPos(), 0);
	
		test.setSpeed(0);
		test.setXPos(test.getSpawnX() - test.getMaxDistanceFromSpawn() - 1);
		test.setYPos(test.getSpawnX() - test.getMaxDistanceFromSpawn() - 1);
		test.move();
		assertNotEquals(initXPos, test.getXPos(), 0);
		assertNotEquals(initYPos, test.getYPos(), 0);
		
	}
	
}

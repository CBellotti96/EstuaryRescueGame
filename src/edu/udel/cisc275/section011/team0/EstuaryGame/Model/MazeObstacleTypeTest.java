package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import org.junit.Test;
import static org.junit.Assert.*;

public class MazeObstacleTypeTest {
		
	@Test
	public void MazeObstacleTypeValuesTest(){
		assertNotNull(MazeObstacleType.valueOf("TRASH"));
		assertNotNull(MazeObstacleType.valueOf("SEAWEED"));
	}
	
	@Test
	public void MazeObstacleTypeToString(){
		assertEquals("seaweed", MazeObstacleType.SEAWEED.toString());
		assertEquals("trash", MazeObstacleType.TRASH.toString());
	}
	
	@Test
	public void randomMazeObstacleTest(){
		MazeObstacleType obstacle = MazeObstacleType.randomMazeObstacleType();
		boolean obstacleIsInstance = false;
		
		if (MazeObstacleType.SEAWEED == obstacle 
				|| MazeObstacleType.TRASH == obstacle){
			obstacleIsInstance = true;
		}
		
		assertTrue(obstacleIsInstance);
	}
	
	@Test
	public void getDefaultSpeedTest(){
		MazeObstacleType trash = MazeObstacleType.TRASH;
		MazeObstacleType seaweed = MazeObstacleType.SEAWEED;
		
		assertEquals(0.07, trash.getDefaultSpeed(), 0);
		assertEquals(0.0, seaweed.getDefaultSpeed(), 0);
	}
	
	@Test
	public void getInterferenceFactorTest(){
		MazeObstacleType trash = MazeObstacleType.TRASH;
		MazeObstacleType seaweed = MazeObstacleType.SEAWEED;
		
		assertEquals(0.009, trash.getInterferenceFactor(), 0);
		assertEquals(0.013, seaweed.getInterferenceFactor(), 0);
	}
}

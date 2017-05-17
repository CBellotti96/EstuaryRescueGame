package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import static org.junit.Assert.*;
import org.junit.Test;

public class MazeObstacleTest {

	//All other methods covered through MazeCrabTest tests.
	
	@Test
	public void getTypeTest(){
		MazeObstacle trash = new MazeObstacle(0.0, 0.0, 0.0, MazeObstacleType.TRASH);
		MazeObstacle seaweed = new MazeObstacle(0.0, 0.0, 0.0, MazeObstacleType.SEAWEED);
		
		assertEquals(MazeObstacleType.TRASH, trash.getType());
		assertEquals(MazeObstacleType.SEAWEED, seaweed.getType());
	}
}

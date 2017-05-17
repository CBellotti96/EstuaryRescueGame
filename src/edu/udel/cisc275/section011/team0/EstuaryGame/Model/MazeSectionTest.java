package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class MazeSectionTest {
	
	@Test
	public void testHandleCollision() {
		MazeCrab crab = new MazeCrab(0, 0);
		
		MazeSection s0 = MazeSection.generateMazeSection(30, 30, 
				Direction.SOUTH, Direction.EAST, MazeDifficulty.HARD);
		crab.setXPos(-0.5);
		crab.setYPos(-0.5);
		s0.handleCollision(crab);
	}

}

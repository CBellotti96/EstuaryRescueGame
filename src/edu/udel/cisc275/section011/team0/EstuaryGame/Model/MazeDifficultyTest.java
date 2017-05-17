package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import static org.junit.Assert.*;
import org.junit.Test;

public class MazeDifficultyTest {

	@Test
	public void MazeDifficultyValuesTest(){
		assertNotNull(MazeDifficulty.valueOf("EASY"));
		assertNotNull(MazeDifficulty.valueOf("NORMAL"));
		assertNotNull(MazeDifficulty.valueOf("HARD"));
	}
	
	@Test
	public void getPredatorNumTest(){
		assertEquals(5, MazeDifficulty.EASY.getPredatorNum());
		assertEquals(10, MazeDifficulty.NORMAL.getPredatorNum());
		assertEquals(15, MazeDifficulty.HARD.getPredatorNum());
	}

	@Test
	public void getObstacleNumTest(){
		assertEquals(10, MazeDifficulty.EASY.getObstacleNum());
		assertEquals(15, MazeDifficulty.NORMAL.getObstacleNum());
		assertEquals(20, MazeDifficulty.HARD.getObstacleNum());
	}

	@Test
	public void getPowerupNumTest(){
		assertEquals(3, MazeDifficulty.EASY.getPowerupNum());
		assertEquals(4, MazeDifficulty.NORMAL.getPowerupNum());
		assertEquals(5, MazeDifficulty.HARD.getPowerupNum());
	}

}

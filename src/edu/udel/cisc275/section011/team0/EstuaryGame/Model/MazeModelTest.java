package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class MazeModelTest {
	
	MazeModel test = new MazeModel();
	
	@Test
	public void MazeModelConstructorTest(){
		MazeModel mazeModelEasy = new MazeModel(MazeDifficulty.EASY);
		MazeModel mazeModelNormal = new MazeModel(MazeDifficulty.NORMAL);
		MazeModel mazeModelHard = new MazeModel(MazeDifficulty.HARD);
	}
	
	@Test
	public void getMinSalinityTest(){
		assertEquals(4, test.getMinSalinity(),0);
	}
	
	@Test
	public void getMaxSalinityTest(){
		assertEquals(30, test.getMaxSalinity(),0);
	}
	
	@Test
	public void setGetWeatherTest(){
		test.setWeather(MazeWeather.SUN);
		assertEquals(MazeWeather.SUN, test.getWeather());
		test.setWeather(MazeWeather.RAIN);
		assertNotEquals(MazeWeather.SUN, test.getWeather());
	}
	
	@Test
	public void setGetTimeRemainingTest(){
		test.setTimeRemaining(0);
		assertEquals(0, test.getTimeRemaining(),0);
	}
	
	@Test
	public void getCurrentSectionTest(){
		MazeSection[] testSections = test.getSections();
		MazeSection currSection = testSections[0];
		
		assertEquals(currSection, test.getCurrentSection());
	}
	
	@Test
	public void getDifficultyTest(){
		MazeModel mazeModelEasy = new MazeModel(MazeDifficulty.EASY);
		assertEquals(MazeDifficulty.EASY, mazeModelEasy.getDifficulty());
	}
	
	@Test
	public void getCurrentSectionIndexTest(){
		assertEquals(0, test.getCurrentSectionIndex());
	}
	
	@Test
	public void tickTest(){
		test.setMode(MazeGameMode.PLAYING);
		test.getPlayer().setIsColliding(false);
		test.tick();
		test.getPlayer().setIsColliding(true);
		test.tick();
		
		test.setMode(MazeGameMode.RESET_CRAB);
		test.tick();
		
		test.setMode(MazeGameMode.WIN_SCREEN);
		test.tick();
		
	}
	
}

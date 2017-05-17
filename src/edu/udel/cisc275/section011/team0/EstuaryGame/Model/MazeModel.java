package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import java.nio.charset.MalformedInputException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import edu.udel.cisc275.section011.team0.EstuaryGame.Common.Main;
import edu.udel.cisc275.section011.team0.EstuaryGame.Controller.MazeController;
import edu.udel.cisc275.section011.team0.EstuaryGame.Controller.MenuController;

public class MazeModel {

	private final double maxSalinity = 30; // TODO change value based on  
	private final double minSalinity = 4;  // specific estuary, these are tesing
	private MazeWeather weather;
	private final MazeCrab player;
	
	private long timeRemaining;
	private static final int NUM_SECTIONS = 3;
	private static final int SECTION_WIDTH = 30;
	private static final int SECTION_HEIGHT = SECTION_WIDTH;
	private MazeSection sections[] = new MazeSection[NUM_SECTIONS];
	private int currentSection = 0;
	private MenuReturnItem exitButton;
	private MazeDifficulty mazeDifficulty;
	private List<Direction> directions = new ArrayList<>();
	private MazeGameMode mode;
	
	private double collisionX = 0;
	private double collisionY = 0;
	private double percentageReset = 0;
	
	public MazeModel() {
		this.mode = MazeGameMode.TUTORIAL;
		this.mazeDifficulty = MazeDifficulty.NORMAL;
		
		// create maze sections
		directions.add(Direction.NORTH);
		directions.add(Direction.EAST);
		directions.add(Direction.SOUTH);
		directions.add(Direction.WEST);

		for (int i = 0;  i < sections.length; i++) {
			MazeSection section = this.generateSection(i);
			sections[i] = section;
		}

		this.weather = sections[currentSection].getWeather();
		
		player = new MazeCrab(sections[currentSection].getStartTileX() + (1.0 - MazeCrab.getDefaultWidth()) / 2, 
				sections[currentSection].getStartTileY() + (1.0 - MazeCrab.getDefaultHeight()) / 2);
		player.markCheckpoint();
		
		exitButton = new MenuReturnItem();
		
	}
	
	public MazeModel(MazeDifficulty mazeDifficulty){
		this();
		
		this.mazeDifficulty = mazeDifficulty;
	}
	
	public double getSalinity() {
		double sectionSalinityDiff = (maxSalinity - minSalinity) / sections.length;
		return ((getCurrentSection().getProgression(player) + currentSection) * sectionSalinityDiff)
				* weather.getSalinitySensitivity()
				+ minSalinity;
	}
	
	public double getMinSalinity() {
		return minSalinity;
	}
	
	public double getMaxSalinity() {
		return maxSalinity;
	}
	
	public double getSalinityPercent() {
		return (getSalinity() - getMinSalinity()) / (getMaxSalinity() - getMinSalinity());
	}

	public MazeWeather getWeather() {
		return weather;
	}
	
	public void setWeather(MazeWeather weather) {
		this.weather = weather;
	}

	public MazeCrab getPlayer() {
		return player;
	}
	
	public long getTimeRemaining() {
		return timeRemaining;
	}
	public void setTimeRemaining(long timeRemaining) {
		this.timeRemaining = timeRemaining;
	}
	
	private MazeSection generateSection(int i){
		Random rand = new Random();
		MazeSection section = MazeSection.generateMazeSection(
				SECTION_HEIGHT, SECTION_WIDTH, 
				i > 0 ? sections[i - 1].getExitSide() : null, 
				directions.remove(rand.nextInt(directions.size())), 
				this.mazeDifficulty);
		return section;
	}
	
	public MazeSection getCurrentSection () {
		return sections[currentSection];
	}
	
	public MazeDifficulty getDifficulty(){
		return this.mazeDifficulty;
	}
	
	public MazeGameMode getMode(){
		return this.mode;
	}
	
	public void setMode(MazeGameMode mode){
		this.mode = mode;
	}
	
	public void tick () {
		if (getMode() == MazeGameMode.PLAYING) {
			getCurrentSection().handleCollision(player);
			
			for (MazePredator predator : getCurrentSection().getPredators()) {
				predator.move();
				if (true == player.detectCollision(predator)){
					setMode(MazeGameMode.RESET_CRAB);
					collisionX = player.getXPos();
					collisionY = player.getYPos();
					percentageReset = 0;
				}
			}
			
			for (MazeObstacle obstacle : getCurrentSection().getObstacles()){
				if (true == player.detectCollision(obstacle)){
					player.handleCollision(obstacle);
				}
			}
			
			if (false == player.getIsColliding()){
				player.resetSpeed();
			}
		
			player.setIsColliding(false);
			
			int currentTileX = (int) (player.getXPos() + player.getWidth() / 2);
			int currentTileY = (int) (player.getYPos() + player.getHeight() / 2);
			if((getCurrentSection().getCell(currentTileY, currentTileX) & MazeSection.EXIT) != 0) {
				if (currentSection < sections.length - 1) {
					currentSection++;
					player.setXPos(sections[currentSection].getStartTileX() + (1.0 - MazeCrab.getDefaultWidth()) / 2);
					player.setYPos(sections[currentSection].getStartTileY() + (1.0 - MazeCrab.getDefaultHeight()) / 2);
					setWeather(sections[currentSection].getWeather());
					player.markCheckpoint();
					System.out.println(currentSection);
				} else {
					// TODO victory screen
					this.setMode(MazeGameMode.WIN_SCREEN);
					Main.getInstance().setController(new MenuController());
				}
			}
		} else if (getMode() == MazeGameMode.RESET_CRAB) {
			if (percentageReset >= 1) {
				setMode(MazeGameMode.PLAYING);
			}
			
			System.out.println(percentageReset);
			player.setXPos(collisionX + ((player.getXCheckpointPos() - collisionX) * percentageReset));
			player.setYPos(collisionY + ((player.getYCheckpointPos() - collisionY) * percentageReset));
			percentageReset += 0.01;
		}
	}
	
}

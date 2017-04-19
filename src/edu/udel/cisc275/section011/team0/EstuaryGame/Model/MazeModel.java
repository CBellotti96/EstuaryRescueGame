package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MazeModel {

	private final double maxSalinity = 30; // TODO change value based on  
	private final double minSalinity = 4;  // specific estuary, these are tesing
	private double salinity = 4;          // values based on horsehoe crab
	private MazeWeather weather = MazeWeather.RAIN;
	private final MazeCrab player;
	private long timeRemaining;
	private static final int NUM_SECTIONS = 3;
	private static final int SECTION_WIDTH = 20;
	private static final int SECTION_HEIGHT = SECTION_WIDTH;
	private MazeSection sections[] = new MazeSection[NUM_SECTIONS];
	private int currentSection = 0;
	
	public MazeModel() {
		player = new MazeCrab(0,0);
		
		// create maze sections
		List<Direction> directions = new ArrayList<>();
		for (Direction d : Direction.values()) {
			directions.add(d);
		}
		Random rand = new Random();
		for (int i = 0;  i < sections.length; i++) {
			MazeSection section = MazeSection.generateMazeSection(SECTION_WIDTH, 
					SECTION_HEIGHT, 
					i > 0 ? sections[i - 1].getExitSide() : null, 
					directions.remove(rand.nextInt(directions.size())));
			sections[i] = section;
		}
	}

	public double getSalinity() {
		return salinity;
	}
	
	public void setSalinity(double salinity) {
		this.salinity = salinity;
	}
	
	public double getMinSalinity() {
		return minSalinity;
	}
	
	public double getMaxSalinity() {
		return maxSalinity;
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
	
	public MazeSection getCurrentSection () {
		return sections[currentSection];
	}
	
}

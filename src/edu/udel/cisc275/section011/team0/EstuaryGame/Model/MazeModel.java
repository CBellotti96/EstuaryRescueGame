package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import java.util.ArrayList;
import java.util.List;

public class MazeModel {

	private final double maxSalinity = 30; // TODO change value based on  
	private final double minSalinity = 4;  // specific estuary, these are tesing
	private double salinity = 4;          // values based on horsehoe crab
	private MazeWeather weather = MazeWeather.RAIN;
	private final MazeCrab player;
	private long timeRemaining;
	private List<MazeSection> sections = new ArrayList<>();
	
	public MazeModel() {
		player = new MazeCrab();
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
	
}

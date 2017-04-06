package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import java.util.ArrayList;
import java.util.List;

public class MazeModel {

	private double salinity;
	private MazeWeather weather;
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

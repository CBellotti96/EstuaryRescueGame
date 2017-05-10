package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum MazeObstacleType {
	TRASH(0.07, 0.009, "trash"),
	SEAWEED(0.0, 0.013, "seaweed");

	private final double defaultSpeed;
	private final double interferenceFactor;
	private final String obstacleType;

	//Reference: http://stackoverflow.com/a/1972399
	private static final List<MazeObstacleType> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();
	
	MazeObstacleType(double defaultSpeed, double interferenceFactor, String obstacleType){
		this.defaultSpeed = defaultSpeed;
		this.interferenceFactor = interferenceFactor;
		this.obstacleType = obstacleType;
	}
	
	public String toString(){
		return this.obstacleType;
	}
	
	/* Generating random selection from enum values
	Solution Referenced: http://stackoverflow.com/a/1972399
	*/
	public static MazeObstacleType randomMazeObstacleType()  {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}
	
	public double getDefaultSpeed(){
		return this.defaultSpeed;
	}
	
	public double getInterferenceFactor(){
		return this.interferenceFactor;
	}
	
}

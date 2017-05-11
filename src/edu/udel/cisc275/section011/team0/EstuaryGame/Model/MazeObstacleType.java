package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * MazeObstacleType is an enum containing the specifications of non-predator hindrances contained in the maze.
 * 
 * @author Emily
 *
 */
public enum MazeObstacleType {
	TRASH(0.07, 0.009, "trash"),
	SEAWEED(0.0, 0.013, "seaweed");

	/**
	 * Default incremental speed of the obstacle type.
	 */
	private final double defaultSpeed;
	/**
	 * The speed at which the victim entity will travel when collision is happening.
	 */
	private final double interferenceFactor;
	/**
	 * Name of the enum type.
	 */
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
	
	/**
	 * Generates a random selection from the enum values.
	 * <p>
	 * Solution referenced from: <a href="http://stackoverflow.com/a/1972399">StackOverflow</a> 
	 * @return	a single randomized selection from the values contained within MazeObstacleType
	 */
	public static MazeObstacleType randomMazeObstacleType()  {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}
	
	/**
	 * Getter for {@link #defaultSpeed}
	 * @return {@link #defaultSpeed}
	 */
	public double getDefaultSpeed(){
		return this.defaultSpeed;
	}
	
	/**
	 * Getter for {@link #interferenceFactor}
	 * @return {@link #interferenceFactor}
	 */
	public double getInterferenceFactor(){
		return this.interferenceFactor;
	}
	
}

package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

/**
 * MazePredator class contains all members and functions relevant to moving predator entities.
 * 
 * @author Emily McNeil
 * @author Alexandra Hurst
 * 
 */
public class MazePredator extends MazeEntity {

	/**
	 * Standard incremental movement speed.
	 */
	private static double defaultSpeed = 0.02;
	/**
	 * Initial horizontal position.
	 */
	private double spawnX;
	/**
	 * Initial vertical position.
	 */
	private double spawnY;
	/**
	 * Default horizontal direction of travel.
	 */
	private int xDirection;
	/**
	 * Default vertical direction of travel.
	 */
	private int yDirection;
	/**
	 * Defines the area within which the predator will swim.
	 */
	private double maxDistanceFromSpawn = 4;
	
	/**
	 * Constructor for MazePredator. 
	 * <p>
	 * Invokes {@linkplain MazeEntity} superconstructor.
	 * @param xPos			initial horizontal position
	 * @param yPos			initial vertical position
	 * @param xDirection	default horizontal direction of travel
	 * @param yDirection	default vertical direction of travel
	 */
	public MazePredator(double xPos, double yPos, int xDirection, int yDirection) {
		super(xPos, yPos, defaultSpeed);
		spawnX = xPos;
		spawnY = yPos;
		this.xDirection = xDirection;
		this.yDirection = yDirection;
	}

	/**
	 * Handles movement of MazePredator.
	 * <p>
	 * Continually sets new x and y positions based off of current speed and position.
	 * Direction is adjusted based off of current position relative to the spawn coordinates.
	 */
	public void move(){
		this.setXPos(this.getXPos() + xDirection * this.getSpeed());
		if (getXPos() - spawnX > maxDistanceFromSpawn) {
			xDirection = -xDirection;
			setXPos(spawnX + maxDistanceFromSpawn);
		} else if (spawnX - getXPos() > maxDistanceFromSpawn) {
			xDirection = -xDirection;
			setXPos(spawnX - maxDistanceFromSpawn);
		}
		this.setYPos(this.getYPos() + yDirection * this.getSpeed());
		if (getYPos() - spawnY > maxDistanceFromSpawn) {
			yDirection = -yDirection;
			setYPos(spawnY + maxDistanceFromSpawn);
		} else if (spawnY - getYPos() > maxDistanceFromSpawn) {
			yDirection = -yDirection;
			setYPos(spawnY - maxDistanceFromSpawn);
		}
	}
	
	@Override
	/**
	 * Resets the position of {@link MazeCrab} instance to 
	 * @param crab	instance of MazeCrab with which this is colliding
	 */
	public void interfereCrab(MazeCrab crab){
		if (true == crab.getIsColliding()){
			crab.resetToCheckpoint();
		}
	}
	
	public double getMaxDistanceFromSpawn(){
		return this.maxDistanceFromSpawn;
	}
	
	public double getSpawnX(){
		return this.spawnX;
	}
	
	public double getSpawnY(){
		return this.spawnY;
	}
	
}

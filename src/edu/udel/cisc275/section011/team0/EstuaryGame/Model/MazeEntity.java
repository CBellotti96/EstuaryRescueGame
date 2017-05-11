package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

/**
 * @author Emily McNeil
 * @author Alexandra Hurst
 * 
 * MazeEntity class is an abstract class representing all 
 * moving pieces that exist within the maze and interact
 * with each other.
 */
public abstract class MazeEntity {

	/**
	 * Horizontal position of the entity.
	 */
	private double xPos;
	/**
	 * Vertical position of the entity.
	 */
	private double yPos;
	/**
	 * Incremental movement speed of the entity.
	 */
	private double speed;
	
	/**
	 * Constructor.
	 * @param xPos	double denoting initial horizontal position of entity
	 * @param yPos	double denoting initial vertical position of entity
	 * @param speed	double denoting the incremental movement speed of entity
	 */
	public MazeEntity(double xPos, double yPos, double speed){
		this.xPos = xPos;
		this.yPos = yPos;
		this.speed = speed;
	}
	
	/**
	 * Getter for {@link #xPos}.
	 * @return {@link #xPos}
	 */
	public double getXPos() {
		return xPos;
	}
	
	/**
	 * Setter for {@link #xPos}.
	 * @param xPos	double specifying new horizontal position
	 */
	public void setXPos(double xPos) {
		this.xPos = xPos;
	}
	
	/**
	 * Getter for {@link #yPos}.
	 * @return {@link #yPos}
	 */
	public double getYPos() {
		return yPos;
	}
	
	/**
	 * Setter for {@link #yPos}.
	 * @param yPos	double specifying new vertical position
	 */
	public void setYPos(double yPos) {
		this.yPos = yPos;
	}
	
	/**
	 * Getter for {@link #speed}.
	 * @return {@link #speed}
	 */
	public double getSpeed() {
		return speed;
	}
	
	/**
	 * Setter for {@link #speed}.
	 * @param speed		double specifying new incremental speed
	 */
	public void setSpeed(double speed){
		this.speed = speed;
	}
	
	/**
	 * Abstract method. Implementation found in subclasses.
	 * @param crab	{@link <MazeCrab> [MazeCrab]} instance that is the victim of the interference 
	 */
	public void interfereCrab(MazeCrab crab){
	}
	
}

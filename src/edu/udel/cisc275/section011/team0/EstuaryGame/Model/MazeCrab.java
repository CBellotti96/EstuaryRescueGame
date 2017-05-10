package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import java.awt.Rectangle;

/**
 * @author Emily McNeil
 * @author Alexandra Hurst
 * 
 * The MazeCrab class contains all members and functions relevant to the player-character.
 */

public class MazeCrab extends MazeEntity {
	
	/**
	 * Default movement speed for the crab.
	 */
	private final static double defaultSpeed = 0.04;
	/** 
	 * Horizontal location of saved checkpoint. Overwritten by new checkpoints.
	 */
	private double xCheckpointPos;
	/** 
	 * Vertical location of saved checkpoint. Overwritten by new checkpoints.
	 */
	private double yCheckpointPos;
	/**
	 * Standard width of the crab, relative to the maze tile size.
	 */
	private final static double defaultWidth = 0.5;
	/** 
	 * Standard height of the crab, relative to maze tile size.
	 */
	private final static double defaultHeight = defaultWidth;
	/**
	 * Boolean stating whether the crab is currently in collision with another MazeEntity.
	 */
	private boolean isColliding = false;
	
	/**
	 * Default constructor for MazeCrab. 
	 * <p>
	 * Invokes superconstructor, {@link <MazeEntity> [MazeEntity]}, using horizontal and vertical coordinates along with defaultSpeed.
	 * @param xPos	horizontal position of MazeCrab instance
	 * @param yPos	vertical position of MazeCrab instance
	 */
	public MazeCrab (double xPos, double yPos){
		super(xPos, yPos, defaultSpeed);
	}
	
	/**
	 * Handles movement of MazeCrab.
	 * <p>
	 * Continually sets new x and y positions based off of current speed and position.
	 * @param direction		Enum signifying movement relative to current position.
	 * @see		{@link <Direction> [Direction (enum)]}
	 */
	public void move(Direction direction){
		this.setXPos(this.getXPos() + direction.getXDir() * this.getSpeed());
		this.setYPos(this.getYPos() + direction.getYDir() * this.getSpeed());
	}
	
	/**
	 * Resets speed to initial default value. To be used after collision is finished.
	 */
	public void resetSpeed(){
		this.setSpeed(defaultSpeed);
	}
	
	/**
	 * Sets values for xCheckpointPos and yCheckpointPos.
	 * <p>
	 * Invoked when entering a new section of the maze.
	 */
	public void markCheckpoint(){
		this.xCheckpointPos = this.getXPos();
		this.yCheckpointPos = this.getYPos();
	}
	
	/**
	 * Moves crab back to checkpointed positions.
	 * <p>
	 * Invoked when MazeCrab collides with {@link <MazePredator> [MazePredator]}.  
	 */
	public void resetToCheckpoint(){
		this.setXPos(this.xCheckpointPos);
		this.setYPos(this.yCheckpointPos);
	}
	
	/**
	 * Returns a boolean telling whether MazeCrab instance is in collision with a MazeEntity instance.
	 * 
	 * @param entity	{@link <MazeEntity> [MazeEntity]} currently being testing for collision
	 */
	public boolean detectCollision(MazeEntity entity){
		if ((Math.abs((this.getXPos() - entity.getXPos())) < 0.5) && 
				(Math.abs((this.getYPos() - entity.getYPos())) < 0.5)){
			this.setIsColliding(true);
		}		
		return this.getIsColliding();
	}
	
	/**
	 * Invokes an entity's interference method.
	 * <p>
	 * This is called when {@link #detectCollision(MazeEntity)} returns true.
	 * @param entity	entity with which the crab is colliding.
	 */
	public void handleCollision(MazeEntity entity){
		entity.interfereCrab(this);
	}
	
	/**
	 * Getter for {@link #defaultWidth}
	 * @return defaultWidth	of MazeCrab
	 */
	public static double getDefaultWidth() {
		return defaultWidth;
	}
	
	/**
	 * Getter for {@link #defaultHeight}
	 * @return defaultHeight of MazeCrab
	 */
	public static double getDefaultHeight() {
		return defaultHeight;
	}
	
	/**
	 * Used to grow/shrink crab's width.
	 * @return defaultWidth
	 */
	public static double getWidth() {
		return defaultWidth; // TODO make crab grow and shrink in size
	}
	
	/**
	 * Used to grow/shrink crab's height.
	 * @return defaultHeight
	 */
	public static double getHeight() {
		return defaultHeight;
	}
	
	/**
	 * Getter for {@link #isColliding}
	 * @return isColliding 	boolean value which is true if collision is happening
	 */
	public boolean getIsColliding(){
		return this.isColliding;
	}
	
	/**
	 * Setter for {@link #isColliding}
	 * <p>
	 * Set to protected. Called in {@link <MazeModel> [MazeModel]}'s {@link MazeModel#tick} method.
	 * @param collision		boolean value
	 */
	protected void setIsColliding(boolean collision){
		this.isColliding = collision;
	}
}

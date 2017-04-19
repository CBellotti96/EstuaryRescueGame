package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

public class MazeCrab extends MazeEntity {
	
	private final static double defaultSpeed = 0.04;
	private double xCheckpointPos;
	private double yCheckpointPos;
	private final static double width = 0.5; // relative to maze tile size
	private final static double height = width;
	
	
	public MazeCrab (double xTile, double yTile){
		super(xTile + (1.0 - width) / 2, yTile + (1.0 - height) / 2, defaultSpeed);
	}
	
	// getters/setters for xPos, yPos, and speed are already present in superclass
	
	public void move(Direction direction){
		this.setXPos(this.getXPos() + direction.getXDir() * this.getSpeed());
		this.setYPos(this.getYPos() + direction.getYDir() * this.getSpeed());
	}
	
	public void changeSpeed(double proportion){
		//for walking through seaweed, powerup
		//proportion > 1 increases; <1 decreases 
		this.setSpeed(this.getSpeed()*proportion); 
	}
	
	public void resetSpeed(){
		//call after obstacle/powerup to reset 
		this.setSpeed(defaultSpeed);
	}
	
	public void markCheckpoint(){
		this.xCheckpointPos = this.getXPos();
		this.yCheckpointPos = this.getYPos();
	}
	
	public void resetToCheckpoint(){
		this.setXPos(this.xCheckpointPos);
		this.setYPos(this.yCheckpointPos);
	}
	
	public static double getWidth() {
		return width;
	}
	public static double getHeight() {
		return height;
	}
	
}

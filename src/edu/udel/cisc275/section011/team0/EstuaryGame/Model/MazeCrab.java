package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

public class MazeCrab extends MazeEntity {
	
	private final double defaultSpeed = 1.0;
	
	public MazeCrab(){
		super();
	}
	
	public MazeCrab (double xPos, double yPos, double speed){
		super(xPos, yPos, speed);
	}
	
	// getters/setters for xPos, yPos, and speed are already present in superclass
	
	public double changeSpeed(int proportion){
		//for walking through seaweed, powerup
		//proportion > 1 increases; <1 decreases 
		return this.getSpeed()*proportion;
	}
	
	public void resetSpeed(){
		//call after obstacle/powerup to reset 
		this.setSpeed(defaultSpeed);
	}
	
}

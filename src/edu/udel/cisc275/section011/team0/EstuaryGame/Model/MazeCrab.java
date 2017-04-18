package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

public class MazeCrab extends MazeEntity {
	
	private final static double defaultSpeed = 1.0;
	
	public MazeCrab (double xPos, double yPos){
		super(xPos, yPos, defaultSpeed);
	}
	
	// getters/setters for xPos, yPos, and speed are already present in superclass
	
	public void changeSpeed(int proportion){
		//for walking through seaweed, powerup
		//proportion > 1 increases; <1 decreases 
		this.setSpeed(this.getSpeed()*proportion); 
	}
	
	public void resetSpeed(){
		//call after obstacle/powerup to reset 
		this.setSpeed(defaultSpeed);
	}
	
}

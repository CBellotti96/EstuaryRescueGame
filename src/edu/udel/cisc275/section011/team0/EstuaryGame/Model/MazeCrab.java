package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

public class MazeCrab extends MazeEntity {
	
	private final static double defaultSpeed = 0.04;
	private double xCheckpointPos;
	private double yCheckpointPos;
	private final static double defaultWidth = 0.5; // relative to maze tile size
	private final static double defaultHeight = defaultWidth;
	
	
	public MazeCrab (double xPos, double yPos){
		super(xPos, yPos, defaultSpeed);
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
	
	public void handleCollision(MazeEntity entity){
		//error must be something with the xvalues
		/*if(((this.getXPos() - entity.getXPos()) < 0.5) && 
			((this.getYPos() - entity.getYPos()) < 0.5)){
			entity.interfereCrab(this);
			System.out.println("handled");
		}
		*/
	}
	
	public static double getDefaultWidth() {
		return defaultWidth;
	}
	public static double getDefaultHeight() {
		return defaultHeight;
	}
	
	public static double getWidth() {
		return defaultWidth; // TODO make crab grow and shrink in size
	}
	public static double getHeight() {
		return defaultHeight;
	}
	
}

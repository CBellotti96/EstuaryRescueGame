package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

public enum MazeObstacleType {
	TRASH(0.07, 0.6, "trash"),
	SEAWEED(0.0, 0.3, "seaweed");

	private final double defaultSpeed;
	private final double interferenceFactor;
	private final String obstacleType;
	
	MazeObstacleType(double defaultSpeed, double interferenceFactor, String obstacleType){
		this.defaultSpeed = defaultSpeed;
		this.interferenceFactor = interferenceFactor;
		this.obstacleType = obstacleType;
	}
	
	public String toString(){
		return this.obstacleType;
	}
	
	public double getDefaultSpeed(){
		return this.defaultSpeed;
	}
	
	public double getInterferenceFactor(){
		return this.interferenceFactor;
	}
	
}

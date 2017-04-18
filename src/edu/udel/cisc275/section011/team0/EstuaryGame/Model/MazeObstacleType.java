package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

public enum MazeObstacleType {
	TRASH(0.07,0.6),
	SEAWEED(0.0,0.3);

	private final double defaultSpeed;
	private final double interferenceFactor;
	
	MazeObstacleType(double defaultSpeed, double interferenceFactor){
		this.defaultSpeed = defaultSpeed;
		this.interferenceFactor = interferenceFactor;
	}
	
}

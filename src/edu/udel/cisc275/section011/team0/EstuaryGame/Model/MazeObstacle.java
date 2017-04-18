package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

public class MazeObstacle extends MazeEntity {
	
	private final static double defaultSpeed = 0.0;
	
	public MazeObstacle(double xPos, double yPos, double speed) {
		super(xPos, yPos, defaultSpeed);
	}

	public void interfereCrab(MazeCrab crab){
		crab.changeSpeed(0.3);
	}
	
}

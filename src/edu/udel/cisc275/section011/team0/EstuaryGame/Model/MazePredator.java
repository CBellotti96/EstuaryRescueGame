package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

public class MazePredator extends MazeEntity {

	private static double defaultSpeed = 0.3;
	
	public MazePredator(double xPos, double yPos, double speed) {
		super(xPos, yPos, defaultSpeed);
	}

	public void move(Direction direction){
		this.setXPos(this.getXPos() + direction.getXDir() * this.getSpeed());
		this.setYPos(this.getYPos() + direction.getYDir() * this.getSpeed());
	}
	
	public void interfereCrab(MazeCrab crab){
		crab.resetToCheckpoint();
	}
}

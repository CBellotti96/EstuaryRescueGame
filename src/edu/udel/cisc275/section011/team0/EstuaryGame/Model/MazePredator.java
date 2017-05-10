package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

public class MazePredator extends MazeEntity {

	private static double defaultSpeed = 0.02;
	private double spawnX;
	private double spawnY;
	private int xDirection;
	private int yDirection;
	private double maxDistanceFromSpawn = 4;
	
	public MazePredator(double xPos, double yPos, int xDirection,int yDirection) {
		super(xPos, yPos, defaultSpeed);
		spawnX = xPos;
		spawnY = yPos;
		this.xDirection = xDirection;
		this.yDirection = yDirection;
	}

	public void move(){
		this.setXPos(this.getXPos() + xDirection * this.getSpeed());
		if (getXPos() - spawnX > maxDistanceFromSpawn) {
			xDirection = -xDirection;
			setXPos(spawnX + maxDistanceFromSpawn);
		} else if (spawnX - getXPos() > maxDistanceFromSpawn) {
			xDirection = -xDirection;
			setXPos(spawnX - maxDistanceFromSpawn);
		}
		this.setYPos(this.getYPos() + yDirection * this.getSpeed());
		if (getYPos() - spawnY > maxDistanceFromSpawn) {
			yDirection = -yDirection;
			setYPos(spawnY + maxDistanceFromSpawn);
		} else if (spawnY - getYPos() > maxDistanceFromSpawn) {
			yDirection = -yDirection;
			setYPos(spawnY - maxDistanceFromSpawn);
		}
	}
	
	@Override
	public void interfereCrab(MazeCrab crab){
		if (true == crab.getIsColliding()){
			crab.resetToCheckpoint();
		}
	}
	
	
}

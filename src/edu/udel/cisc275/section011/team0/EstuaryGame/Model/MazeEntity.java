package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

public abstract class MazeEntity {

	private double xPos;
	private double yPos;
	private double speed;
	
	public MazeEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public MazeEntity(double xPos, double yPos, double speed){
		this.xPos = xPos;
		this.yPos = yPos;
		this.speed = speed;
	}

	public double getXPos() {
		return xPos;
	}
	public void setXPos(double xPos) {
		this.xPos = xPos;
	}
	
	public double getYPos() {
		return yPos;
	}
	
	public void setYPos(double yPos) {
		this.yPos = yPos;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	public void setSpeed(double speed){
		this.speed = speed;
	}
	
}

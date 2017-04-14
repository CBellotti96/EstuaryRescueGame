package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

public abstract class MazeEntity {

	private double xPos;
	private double yPos;
	private final double speed = 0.1;
	
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

		System.out.println(yPos);
	}
	
	public double getSpeed() {
		return speed;
	}
	
}

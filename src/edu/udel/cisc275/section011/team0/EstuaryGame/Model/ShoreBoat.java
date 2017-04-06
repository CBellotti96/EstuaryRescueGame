package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

public class ShoreBoat {

	private double xPos;
	private double yPos;
	private final ShoreBoatType type;
	
	public double getXPos () {
		return this.xPos;
	}
	
	public double getYPos () {
		return this.yPos;
	}
	
	public ShoreBoatType getType () {
		return this.type;
	}
	
	public void setXPos (double xPos) {
		this.xPos = xPos;
	}
	
	public void setYPos (double yPos) {
		this.yPos = yPos;
	}
	
	public ShoreBoat (double xPos, double yPos, ShoreBoatType type) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.type = type;
	}
	
}

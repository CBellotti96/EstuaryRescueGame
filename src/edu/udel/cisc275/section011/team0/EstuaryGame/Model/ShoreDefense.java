package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

public class ShoreDefense {
	
	private double xPos;
	private double yPos;
	private final ShoreDefenseType type;
	
	public double getXPos () {
		return this.xPos;
	}
	
	public double getYPos () {
		return this.yPos;
	}
	
	public ShoreDefenseType getType () {
		return this.type;
	}
	
	public void setXPos (double xPos) {
		this.xPos = xPos;
	}
	
	public void setYPos (double yPos) {
		this.yPos = yPos;
	}
	
	public ShoreDefense (double xPos, double yPos, ShoreDefenseType type) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.type = type;
	}

}

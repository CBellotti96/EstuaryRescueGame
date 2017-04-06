package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

public class ShoreItem {
	
	private double xPos;
	private double yPos;
	private final ShoreItemType type;
	
	public double getXPos () {
		return this.xPos;
	}
	
	public double getYPos () {
		return this.yPos;
	}
	
	public ShoreItemType getType () {
		return this.type;
	}
	
	public void setXPos (double xPos) {
		this.xPos = xPos;
	}
	
	public void setYPos (double yPos) {
		this.yPos = yPos;
	}
	
	public ShoreItem (double xPos, double yPos, ShoreItemType type) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.type = type;
	}

}

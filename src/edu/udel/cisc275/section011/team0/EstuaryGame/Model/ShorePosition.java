package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

public class ShorePosition {
	
	private double shoreX;
	private double shoreY;
	
	public ShorePosition(double x, double y){
		this.shoreX = x;
		this.shoreY = y;
	}

	public double getShoreX() {
		return shoreX;
	}

	public void setShoreX(double shoreX) {
		this.shoreX = shoreX;
	}

	public double getShoreY() {
		return shoreY;
	}

	public void setShoreY(double shoreY) {
		this.shoreY = shoreY;
	}
	public void incrY(double incr) {
		this.shoreY+=incr;
	}
}

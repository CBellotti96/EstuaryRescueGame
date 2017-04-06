package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

public class ShoreBoatType {
	
	private final double speed;
	private final double shoreHealthEffect;
	
	public double getSpeed () {
		return this.speed;
	}
	
	public double getShoreHealthEffect () {
		return this.shoreHealthEffect;
	}
	
	public ShoreBoatType (double speed, double shoreHealthEffect) {
		this.speed = speed;
		this.shoreHealthEffect = shoreHealthEffect;
	}

}

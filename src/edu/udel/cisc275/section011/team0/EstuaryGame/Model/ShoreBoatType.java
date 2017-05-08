package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

public class ShoreBoatType{
	
	private final String name;
	private final double speed;
	private final double shoreHealthEffect;
	
	
	public double getSpeed () {
		return this.speed;
	}
	
	public double getShoreHealthEffect () {
		return this.shoreHealthEffect;
	}
	
	public String getName(){
		return this.name;
	}
	
	public ShoreBoatType (String name, double speed, double shoreHealthEffect) {
		this.name = name;
		this.speed = speed;
		this.shoreHealthEffect = shoreHealthEffect;
	}
	
}

package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

public class ShoreBoatType{
	
	private final String name;
	private final double speed;
	private final double shoreHealthEffect;
	private final int numWaves;
	
	
	public double getSpeed () {
		return this.speed;
	}
	
	public double getShoreHealthEffect () {
		return this.shoreHealthEffect;
	}
	
	public double getNumWaves(){
		return this.numWaves;
	}
	
	public String getName(){
		return this.name;
	}
	
	public ShoreBoatType (String name, double speed, double shoreHealthEffect, int numWaves) {
		this.name = name;
		this.speed = speed;
		this.shoreHealthEffect = shoreHealthEffect;
		this.numWaves = numWaves;
	}
	
}

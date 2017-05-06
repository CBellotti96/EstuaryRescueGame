package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

public class ShoreWave {
	
	private ShoreTile containedWithin;
	private int yDisplacement;
	private final int waveStrength;
	
	public ShoreWave(ShoreTile containedWithin,int yDisplacement, int waveStrength){
		this.containedWithin = containedWithin;
		this.yDisplacement = yDisplacement;
		this.waveStrength = waveStrength;
	}

	public ShoreTile getContainedWithin() {
		return containedWithin;
	}
	
	public void setContainedWithin(ShoreTile containedWithin){
		this.containedWithin = containedWithin;
	}
	
	public int getYDisplacement() {
		return yDisplacement;
	}

	public void setYDisplacement(int yDisplacement) {
		this.yDisplacement = yDisplacement;
	}

	public int getWaveStrength() {
		return waveStrength;
	}
	
}

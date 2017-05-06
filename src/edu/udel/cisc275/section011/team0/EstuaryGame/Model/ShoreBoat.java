package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

public class ShoreBoat{

	private int xDisplacement;
	private ShoreTile containedWithin;
	private final ShoreBoatType type;
	private int countNumWaves;
	private int waveTile;
	
	public int getCountNumWaves() {
		return countNumWaves;
	}
	
	public int getWaveTile() {
		return waveTile;
	}
	
	public ShoreTile getContainedWithin() {
		return containedWithin;
	}
	
	public void setCountNumWaves(int countNumWaves) {
		this.countNumWaves = countNumWaves;
	}
	
	public void setWaveTile(int waveTile) {
		this.waveTile = waveTile;
	}
	
	public void setContainedWithin(ShoreTile containedWithin){
		this.containedWithin = containedWithin;
	}

	public int getXDisplacement () {
		return this.xDisplacement;
	}
	
	public ShoreBoatType getType () {
		return this.type;
	}
	
	public void setXDisplacement (int xDisplacement) {
		this.xDisplacement = xDisplacement;
	}
	
	public ShoreBoat (ShoreTile containedWithin, int xDisplacement, ShoreBoatType type) {
		this.containedWithin = containedWithin;
		this.xDisplacement = xDisplacement;
		this.type = type;
		this.waveTile = -1;
	}
	
}

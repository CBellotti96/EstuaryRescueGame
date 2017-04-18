package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

public class ShoreBoat{

	private ShorePosition boatPos;
	private final ShoreBoatType type;
	private int countNumWaves;
	private int waveTile;
	
	public int getCountNumWaves() {
		return countNumWaves;
	}
	
	public int getWaveTile() {
		return waveTile;
	}
	
	public void setCountNumWaves(int countNumWaves) {
		this.countNumWaves = countNumWaves;
	}
	
	public void setWaveTile(int waveTile) {
		this.waveTile = waveTile;
	}

	public ShorePosition getboatPos () {
		return this.boatPos;
	}
	
	public ShoreBoatType getType () {
		return this.type;
	}
	
	public void setBoatPos (ShorePosition boatPos) {
		this.boatPos = boatPos;
	}
	
	public ShoreBoat (ShorePosition boatPos, ShoreBoatType type, int waveTile) {
		this.boatPos = boatPos;
		this.type = type;
		this.waveTile = -1;
	}
	
}

package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

public class ShoreWave {
	
	private ShorePosition wavePos;
	private final int waveStrength;
	
	public ShoreWave(ShorePosition wavePos, int waveStrength){
		this.wavePos = wavePos;
		this.waveStrength = waveStrength;
	}

	public ShorePosition getWavePos() {
		return wavePos;
	}

	public void setWavePos(ShorePosition wavePos) {
		this.wavePos = wavePos;
	}

	public int getWaveStrength() {
		return waveStrength;
	}
	
}

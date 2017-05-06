package edu.udel.cisc275.section011.team0.EstuaryGame.Model;
/**
 * 
 * A ShoreWave is generated from the ShoreBoat and travels down until it collides with the shore
 * @see ShoreBoat
 * @author Chris Bellotti and Alvin Tang
 
 */
public class ShoreWave {
	
	private ShorePosition wavePos;
	private final int waveStrength;
	/**
	 * @author Chris Bellotti and Alvin Tang
	 * This methods generates a wave at wavePos
	 * @param wavePos   position of the wave
	 * @param waveStrength how much damage the wave does
	 */
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

package edu.udel.cisc275.section011.team0.EstuaryGame.Model;
/**
 * 
 * A ShoreWave is generated from the ShoreBoat and travels down until it collides with the shore
 * @see ShoreBoat
 * @author Chris Bellotti and Alvin Tang
 
 */
public class ShoreWave {
	
	private ShoreTile containedWithin;
	private int yDisplacement;
	private final int waveStrength;

	/**
	 * @author Chris Bellotti and Alvin Tang
	 * This methods generates a wave at wavePos
	 * @param containedWithin   tile the wave is in
	 * @param yDisplacement		distance from shore
	 * @param waveStrength		damage the wave will do if it makes contact with the shore
	 */
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

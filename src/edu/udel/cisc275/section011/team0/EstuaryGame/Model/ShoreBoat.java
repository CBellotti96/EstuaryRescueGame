package edu.udel.cisc275.section011.team0.EstuaryGame.Model;
/**
 * 
 * A ShoreBoat travels across the model and generates a wake
 * @author Chris Bellotti 
 * @author Alvin Tang
 *
 */
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
	/**
	 * 
	 * Defines a Shore Boat Constructor  
	 * @param containedWithin the tile the boat is in
	 * @param xDisplacement   the distance across the screen
	 * @param type    		  defines what kind of boat it is (i.e. sail boat,commercial boat,etc)
	 * 
	 */
	public ShoreBoat (ShoreTile containedWithin, int xDisplacement, ShoreBoatType type) {
		this.containedWithin = containedWithin;
		this.xDisplacement = xDisplacement;
		this.type = type;
		this.waveTile = -1;
	}
	
}

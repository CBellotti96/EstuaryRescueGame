package edu.udel.cisc275.section011.team0.EstuaryGame.Model;
/**
 * 
 * A ShoreBoat travels across the model and generates a wake
 * @author Chris Bellotti and Alvin Tang
 
 */
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
	/**
	 * 
	 * @author Chris Bellotti and Alvin Tang
	 * Defines a Shore Boat Constructor and 
	 * @param boatPos the location of the boat within a 2d array(its x and y position)
	 * @param type    defines what kind of boat it is (i.e. sail boat,commercial boat,etc)
	 */
	public ShoreBoat (ShorePosition boatPos, ShoreBoatType type) {
		this.boatPos = boatPos;
		this.type = type;
		this.waveTile = -1;
	}
	
}

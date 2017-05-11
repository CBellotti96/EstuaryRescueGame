package edu.udel.cisc275.section011.team0.EstuaryGame.Model;
/**
 * 
 *  ShoreBoatType defines the characteristics of a ShoreBoat
 * @author Chris Bellotti and Alvin Tang
 * @see ShoreBoat
 
 */
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
	/**
	 * 
	 * Defines a ShoreBoatType Constructor 
	 * @param name 			     what type of boat it is
	 * @param speed              how fast the boat is going
	 * @param ShoreHealthEffect  how much damage the boats wake will do if it reaches the shore
	 */
	public ShoreBoatType (String name, double speed, double shoreHealthEffect) {
		this.name = name;
		this.speed = speed;
		this.shoreHealthEffect = shoreHealthEffect;
	}
	
}

package edu.udel.cisc275.section011.team0.EstuaryGame.Model;
/**
 * 
 * A ShorePosition is the location of the object within the model(defined by x and y location)
 * @author Chris Bellotti and Alvin Tang
 
 */
public class ShorePosition {
	
	private double shoreX;
	private double shoreY;
	/**
	 * @author Chris Bellotti and Alvin Tang
	 * This methods creates a Shore position at shoreX and ShoreY
	 * @param x   position along the x-axis
	 * @param y   position along the y-axis
	 */
	public ShorePosition(double x, double y){
		this.shoreX = x;
		this.shoreY = y;
	}
	public double getShoreX() {
		return shoreX;
	}
	public void setShoreX(double shoreX) {
		this.shoreX = shoreX;
	}
	public double getShoreY() {
		return shoreY;
	}

	public void setShoreY(double shoreY) {
		this.shoreY = shoreY;
	}
	public void incrY(double incr) {
		this.shoreY+=incr;
	}
}

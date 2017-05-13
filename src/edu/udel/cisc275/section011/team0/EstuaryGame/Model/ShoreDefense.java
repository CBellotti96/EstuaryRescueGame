package edu.udel.cisc275.section011.team0.EstuaryGame.Model;
/**
 * 
 *  ShoreDefense defines tiles that blocks waves
 * @author Chris Bellotti 
 * @author Alvin Tang
 * 
 */
public class ShoreDefense extends ShoreDefenseType{
	
	private ShoreTile containedWithin;
	private double defenseDurability;
	private boolean isGoodPlacement;
	private final ShoreDefenseType type;
	
	public ShoreTile getContainedWithin () {
		return this.containedWithin;
	}
	
	public ShoreDefenseType getType () {
		return this.type;
	}
	
	public double getDefenseDurability() {
		return this.defenseDurability;
	}
	
	public boolean getIsGoodPlacement() {
		return this.isGoodPlacement;
	}
	
	public void setIsGoodPlacement(boolean isGoodPlacement){
		this.isGoodPlacement = isGoodPlacement;
	}
	
	public void setDefenseDurability(double d) {
		this.defenseDurability = d;
	}
	
	public void setContainedWithin (ShoreTile containedWithin) {
		this.containedWithin = containedWithin;
	}
	/**
	 * 
	 * Defines a ShoreBoatType Constructor 
	 * @param containedWithin	defines which tile the defense is in
	 * @param type				defines what kind of defense it is
	 * @see ShoreTile
	 * @see ShoreDefenseType
	 *             
	 */
	public ShoreDefense (ShoreTile containedWithin, ShoreDefenseType type) {
		super(type.getName());
		this.containedWithin = containedWithin;
		this.type = type;
		this.defenseDurability = type.getDurability();
	}

}

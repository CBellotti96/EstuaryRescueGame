package edu.udel.cisc275.section011.team0.EstuaryGame.Model;
/**
 * 
 *  ShoreItem defines tiles that contain objects that can be picked up 
 * @author Chris Bellotti 
 * @author Alvin Tang
 * 
 */
public class ShoreItem extends ShoreItemType{
	
	private ShoreTile containedWithin;
	private final ShoreItemType type;
	
	public ShoreTile getContainedWithin () {
		return this.containedWithin;
	}
	
	public ShoreItemType getType () {
		return this.type;
	}
	
	public void setContainedWithin (ShoreTile containedWithin) {
		this.containedWithin = containedWithin;
	}
	/**
	 * 
	 * Defines a ShoreItemType Constructor 
	 * @param containedWithin	defines which tile the ShoreItem is in
	 * @param type				defines what kind of ShoreItem it is
	 * @see ShoreTile
	 * @see ShoreItemType      
	 *       
	 */
	public ShoreItem (ShoreTile containedWithin, ShoreItemType type) {
		super(type.getName());
		this.containedWithin = containedWithin;
		this.type = type;
	}

}

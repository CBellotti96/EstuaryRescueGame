package edu.udel.cisc275.section011.team0.EstuaryGame.Model;
/**
 * 
 *  ShoreBoatType defines the characteristics of a ShoreDefense
 * @author Chris Bellotti 
 * @author Alvin Tang
 * @see ShoreDefense
 *
 */
public class ShoreDefenseType {
	
	private String name;
	private double placementZoneStartY;
	private double placementZoneEndY;
	private double shoreHealthEffect;
	private int numItemsRequired;
	private double durability;
	
	public void setPlacementZoneStartY(double placementZoneStartY) {
		this.placementZoneStartY = placementZoneStartY;
	}

	public void setPlacementZoneEndY(double placementZoneEndY) {
		this.placementZoneEndY = placementZoneEndY;
	}
	
	public void setShoreHealthEffect(double shoreHealthEffect){
		this.shoreHealthEffect = shoreHealthEffect;
	}
	public String getName () {
		return this.name;
	}
	
	public double getPlacementZoneStartY () {
		return this.placementZoneStartY;
	}
	
	public double getPlacementZoneEndY () {
		return this.placementZoneEndY;
	}
	
	public double getShoreHealthEffect () {
		return this.shoreHealthEffect;
	}
	
	public int getNumItemsRequired(){
		return this.numItemsRequired;
	}
	
	public double getDurability(){
		return this.durability;
	}
	
	public void setDurability(double durability){
		this.durability = durability;
	}
	/**
	 * 
	 * Defines the three possible types of Shore Defense("Sea Wall", "Gabion", and "Plant")
	 * @param name	what type of defense it is
	 * 
	 */
	public ShoreDefenseType (String name) {
		this.name = name;
		if (name == "Sea Wall"){
			this.placementZoneEndY = 0;
			this.placementZoneStartY = 0;
			this.shoreHealthEffect = -.1;
			this.numItemsRequired = 3;
			this.durability = .7;
		}
		else if (name == "Gabion"){
			this.placementZoneEndY = 0;
			this.placementZoneStartY = 0;
			this.shoreHealthEffect = .2;
			this.numItemsRequired = 3;
			this.durability = 9999;
		}
		else{
			this.placementZoneEndY = 0;
			this.placementZoneStartY = 0;
			this.shoreHealthEffect = .1;
			this.numItemsRequired = 1;
			this.durability = 0;
		}
		//this.placementZoneStartY = placementZoneStartY;
		//this.placementZoneEndY = placementZoneEndY;
		//this.shoreHealthEffect = shoreHealthEffect;
		//this.numItemsRequired = numItemsRequired;
		//this.durability = durability;
	}

}

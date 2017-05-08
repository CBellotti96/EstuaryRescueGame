package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

public class ShoreDefense extends ShoreDefenseType{
	
	private ShoreTile containedWithin;
	private double defenseDurability;
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
	
	public void setDefenseDurability(double d) {
		this.defenseDurability = d;
	}
	
	public void setContainedWithin (ShoreTile containedWithin) {
		this.containedWithin = containedWithin;
	}
	
	public ShoreDefense (ShoreTile containedWithin, ShoreDefenseType type) {
		super(type.getName());
		this.containedWithin = containedWithin;
		this.type = type;
		this.defenseDurability = type.getDurability();
	}

}

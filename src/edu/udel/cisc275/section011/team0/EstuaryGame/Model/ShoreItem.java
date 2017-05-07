package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

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
	
	public ShoreItem (ShoreTile containedWithin, ShoreItemType type) {
		super(type.getName());
		this.containedWithin = containedWithin;
		this.type = type;
	}

}

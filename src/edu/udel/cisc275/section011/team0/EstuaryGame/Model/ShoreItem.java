package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

public class ShoreItem extends ShoreItemType{
	
	private ShorePosition itemPos;
	private final ShoreItemType type;
	
	public ShorePosition getItemPos () {
		return this.itemPos;
	}
	
	public ShoreItemType getType () {
		return this.type;
	}
	
	public void setItemPos (ShorePosition itemPos) {
		this.itemPos = itemPos;
	}
	
	public ShoreItem (ShorePosition itemPos, ShoreItemType type) {
		super(type.getName());
		this.itemPos = itemPos;
		this.type = type;
	}

}

package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

public class ShoreDefense extends ShoreDefenseType{
	
	private ShorePosition defensePos;
	private final ShoreDefenseType type;
	
	public ShorePosition getDefensePos () {
		return this.defensePos;
	}
	
	public ShoreDefenseType getType () {
		return this.type;
	}
	
	public void setDefensePos (ShorePosition defensePos) {
		this.defensePos = defensePos;
	}
	
	public ShoreDefense (ShorePosition defensePos, ShoreDefenseType type) {
		super(type.getName());
		this.defensePos = defensePos;
		this.type = type;
	}

}

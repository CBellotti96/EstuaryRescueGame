package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

public class ShoreDefenseType {
	
	private final String name;
	private final double placementZoneStartY;
	private final double placementZoneEndY;
	private final double shoreHealthEffect;
	
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
	
	public ShoreDefenseType (String name, double placementZoneStartY, double placementZoneEndY, double shoreHealthEffect) {
		this.name = name;
		this.placementZoneStartY = placementZoneStartY;
		this.placementZoneEndY = placementZoneEndY;
		this.shoreHealthEffect = shoreHealthEffect;
	}

}

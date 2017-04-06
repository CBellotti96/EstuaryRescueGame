package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

public class ShoreItemType {
	
	private final String name;
	private final double spawnZoneStartY;
	private final double spawnZoneEndY;
	private final ShoreDefenseType buildsDefense;
	
	public String getName () {
		return this.name;
	}

	public double getSpawnZoneStartY () {
		return this.spawnZoneStartY;
	}
	
	public double getSpawnZoneEndY () {
		return this.spawnZoneEndY;
	}
	
	public ShoreDefenseType getBuildsDefense () {
		return this.buildsDefense;
	}
	
	public ShoreItemType (String name, double spawnZoneStartY, double spawnZoneEndY, ShoreDefenseType buildsDefense) {
		this.name = name;
		this.spawnZoneStartY = spawnZoneStartY;
		this.spawnZoneEndY = spawnZoneEndY;
		this.buildsDefense = buildsDefense;
	}
	
}

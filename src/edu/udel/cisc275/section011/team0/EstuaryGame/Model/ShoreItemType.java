package edu.udel.cisc275.section011.team0.EstuaryGame.Model;
/**
 * 
 *  ShoreBoatType defines the characteristics of a ShoreItem
 * @author Chris Bellotti and Alvin Tang
 * @see ShoreItem
 *
 */
public class ShoreItemType {
	
	private String name;
	private ShoreTileType spawnArea;
	private ShoreDefenseType buildsDefense;
	
	public String getName () {
		return this.name;
	}

	public ShoreTileType getSpawnArea () {
		return this.spawnArea;
	}
	
	public ShoreDefenseType getBuildsDefense () {
		return this.buildsDefense;
	}
	
	public void setBuildsDefense(ShoreDefenseType buildsDefense) {
		this.buildsDefense = buildsDefense;
	}
	/**
	 * 
	 * Defines a ShoreItemType Constructor 
	 * @param name 	 what type of boat it is
	 * 
	 */
	public ShoreItemType (String name) {
		this.name = name;
		this.spawnArea = ShoreTileType.BEACH;
	}
	
}

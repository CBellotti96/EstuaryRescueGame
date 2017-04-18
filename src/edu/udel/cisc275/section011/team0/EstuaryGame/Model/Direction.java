package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

public enum Direction {
	NORTH(0,1),
	NORTHEAST(1,1),
	EAST(1,0),
	SOUTHEAST(1,-1),
	SOUTH(0,-1),
	SOUTHWEST(-1,-1),
	WEST(-1,0),
	NORTHWEST(-1,1);
	
	private final int xDir;
	private final int yDir;
	
	Direction(int xDir, int yDir){
		this.xDir = xDir;
		this.yDir = yDir;
	}
	
	
	
}

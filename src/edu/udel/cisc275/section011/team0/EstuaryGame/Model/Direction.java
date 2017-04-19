package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

public enum Direction {
	NORTH(0,1,1),
	EAST(1,0, 2),
	SOUTH(0,-1, 4),
	WEST(-1,0, 8),
	NORTHEAST(1,1, NORTH.getFlag() | EAST.getFlag()),
	SOUTHEAST(1,-1, SOUTH.getFlag() | EAST.getFlag()),
	SOUTHWEST(-1,-1, SOUTH.getFlag() | WEST.getFlag()),
	NORTHWEST(-1,1, NORTH.getFlag() | WEST.getFlag());
	
	private final int xDir;
	private final int yDir;
	private final int flag;
	
	Direction(int xDir, int yDir, int flag){
		this.xDir = xDir;
		this.yDir = yDir;
		this.flag = flag;
	}
	
	public int getXDir(){
		return xDir;
	}
	
	public int getYDir(){
		return yDir;
	}
	
	public int getFlag(){
		return flag;
	}
	
}

package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

public enum StoryCubePosition {
	S_ONE (1, 0, 0), S_TWO (5, 0, 0), S_THREE (9, 0, 0), S_FOUR (13, 0, 0), S_FIVE (1, 10, 0), S_SIX (5, 10, 0), S_SEVEN (9, 10, 0), S_EIGHT (13, 10, 0),
	E_ONE (0, 5, 0), E_TWO (2, 5, 0), E_THREE (4, 5, 0), E_FOUR (6, 5, 0), E_FIVE (8, 5, 0), E_SIX (10, 5, 0), E_SEVEN (12, 5, 0), E_EIGHT (14, 5, 0);
	
	public static final StoryCubePosition[] cubeStartPositions = {S_ONE, S_TWO, S_THREE, S_FOUR, S_FIVE, S_SIX, S_SEVEN, S_EIGHT};
	public static final StoryCubePosition[] cubeEndPositions = {E_ONE, E_TWO, E_THREE, E_FOUR, E_FIVE, E_SIX, E_SEVEN, E_EIGHT};
	
	private int x;
	private int y;
	private int size;
	
	public int getX () {
		return this.x;
	}
	
	public int getY () {
		return this.y;
	}
	
	public int getSize () {
		return this.size;
	}
	
	public void setX (int x) {
		this.x = x;
	}
	
	public void setY (int y) {
		this.y = y;
	}
	
	public void setSize (int size) {
		this.size = size;
	}
	
	private StoryCubePosition (int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
	}
}
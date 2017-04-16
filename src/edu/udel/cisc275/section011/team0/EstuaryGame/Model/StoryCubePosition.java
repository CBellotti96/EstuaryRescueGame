package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

public enum StoryCubePosition {
	S_ONE (1, 0, 2), S_TWO (5, 0, 2), S_THREE (9, 0, 2), S_FOUR (13, 0, 2), S_FIVE (1, 10, 2), S_SIX (5, 10, 2), S_SEVEN (9, 10, 2), S_EIGHT (13, 10, 2),
	E_ONE (0, 5, 2), E_TWO (2, 5, 2), E_THREE (4, 5, 2), E_FOUR (6, 5, 2), E_FIVE (8, 5, 2), E_SIX (10, 5, 2), E_SEVEN (12, 5, 2), E_EIGHT (14, 5, 2);
	
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
	
	private StoryCubePosition (int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
	}
}
package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import java.awt.Rectangle;

public enum StoryCubePosition {
	S_ONE (1, 0), S_TWO (5, 0), S_THREE (9, 0), S_FOUR (13, 0), S_FIVE (1, 10), S_SIX (5, 10), S_SEVEN (9, 10), S_EIGHT (13, 10),
	E_ONE (0, 5), E_TWO (2, 5), E_THREE (4, 5), E_FOUR (6, 5), E_FIVE (8, 5), E_SIX (10, 5), E_SEVEN (12, 5), E_EIGHT (14, 5);
	
	public static final StoryCubePosition[] cubeStartPositions = {S_ONE, S_TWO, S_THREE, S_FOUR, S_FIVE, S_SIX, S_SEVEN, S_EIGHT};
	public static final StoryCubePosition[] cubeEndPositions = {E_ONE, E_TWO, E_THREE, E_FOUR, E_FIVE, E_SIX, E_SEVEN, E_EIGHT};
	
	private int x;
	private int y;
	private int size;
	private int margin = 0;
	
	public int getX () {
		return x * size + margin;
	}
	
	public int getY () {
		return y * size;
	}
	
	public void setSize (int size) {
		this.size = size;
	}
	
	public void setMargin (int margin) {
		this.margin = margin;
	}
	
	private StoryCubePosition (int x, int y) {
		this.x = x;
		this.y = y;
		this.size = 0;
	}
	
	public Rectangle getRect () {
		return new Rectangle(x * size + margin, y * size, size * 2, size * 2);
	}
}
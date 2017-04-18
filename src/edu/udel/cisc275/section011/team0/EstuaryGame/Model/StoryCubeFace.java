package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import java.awt.Color;
import java.util.Random;

public enum StoryCubeFace {

	A (0, Color.BLUE), B (1, Color.CYAN), C (2, Color.DARK_GRAY), D (3, Color.GRAY), E (4, Color.LIGHT_GRAY), F (5, Color.GREEN);
	
	private int id;
	private Color color;
	
	public int getID () {
		return this.id;
	}
	
	public Color getColor () {
		return this.color;
	}
	
	public static final StoryCubeFace[] faces = {A, B, C, D, E, F};
	
	private StoryCubeFace (int id, Color color) {
		this.id = id;
		this.color = color;
	}
	
	public static StoryCubeFace random () {
		Random r = new Random();
		int x = r.nextInt(6);
		return faces[x];
	}
}

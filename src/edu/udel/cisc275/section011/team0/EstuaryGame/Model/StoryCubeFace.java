package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import java.awt.Color;
import java.util.Random;

public enum StoryCubeFace {

	CRAB (0, Color.RED), BIRD (1, Color.WHITE), SEA (2, Color.BLUE), SEAWEED (3, Color.RED), OYSTER (4, Color.BLACK);
	
	private int id;
	private Color color;
	
	public int getID () {
		return this.id;
	}
	
	public Color getColor () {
		return this.color;
	}
	
	public static final StoryCubeFace[] faces = {CRAB, BIRD, SEA, SEAWEED, OYSTER};
	
	private StoryCubeFace (int id, Color color) {
		this.id = id;
		this.color = color;
	}
	
	public static StoryCubeFace random () {
		Random r = new Random();
		int x = r.nextInt(5);
		return faces[x];
	}
}

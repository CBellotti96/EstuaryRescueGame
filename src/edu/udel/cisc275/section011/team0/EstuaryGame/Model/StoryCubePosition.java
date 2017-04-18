package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import java.awt.Rectangle;
import java.util.ArrayList;

public class StoryCubePosition {
	
	private static ArrayList<StoryCubePosition> allPositions = new ArrayList<StoryCubePosition>();
	private static ArrayList<StoryCubePosition> startPositions = new ArrayList<StoryCubePosition>();
	private static ArrayList<StoryCubePosition> endPositions = new ArrayList<StoryCubePosition>();
	
	private int x;
	private int y;
	private int size;
	private int margin;
	
	public static ArrayList<StoryCubePosition> getAllPositions () {return allPositions;}
	public static ArrayList<StoryCubePosition> getStartPositions () {return startPositions;}
	public static ArrayList<StoryCubePosition> getEndPositions () {return endPositions;}
	
	public int getX () {
		return x * size + margin;
	}
	
	public int getY () {
		return y * size;
	}
	
	private StoryCubePosition (int x, int y) {
		this.x = x;
		this.y = y;
		this.size = 0;
		this.margin = 0;
	}
	
	public static void initializePositions (int n) {
		for (int i = 0; i < n; i++) {
			int startX = i % 2 == 0 ? i * 2 + 1 : i * 2 - 1;
			int startY = i % 2 == 0 ? 0 : 10;
			System.out.println(startX + ", " + startY);
			StoryCubePosition iStart = new StoryCubePosition(startX, startY);
			startPositions.add(iStart);
			StoryCubePosition iEnd = new StoryCubePosition(i * 2, 5);
			endPositions.add(iEnd);
			allPositions.add(iStart);
			allPositions.add(iEnd);
		}
	}
	
	public static void updateSizeAndMargin (int size, int margin) {
		for (StoryCubePosition scp : allPositions) {
			scp.size = size;
			scp.margin = margin;
		}
	}
	
	public Rectangle getRect () {
		return new Rectangle(x * size + margin, y * size, size * 2, size * 2);
	}
}
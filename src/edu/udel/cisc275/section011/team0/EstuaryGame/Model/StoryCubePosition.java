package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import java.awt.Rectangle;
import java.util.ArrayList;

public class StoryCubePosition {
	
	public final static StoryCubePosition center = new StoryCubePosition(80, 60);
	private static ArrayList<StoryCubePosition> allPositions = new ArrayList<StoryCubePosition>();
	private static ArrayList<StoryCubePosition> startPositions = new ArrayList<StoryCubePosition>();
	private static ArrayList<StoryCubePosition> endPositions = new ArrayList<StoryCubePosition>();
	
	private final static int size = 15;
	
	private int x;
	private int y;
	
	public static ArrayList<StoryCubePosition> getAllPositions () {return allPositions;}
	public static ArrayList<StoryCubePosition> getStartPositions () {return startPositions;}
	public static ArrayList<StoryCubePosition> getEndPositions () {return endPositions;}
	
	public int getX () {
		return this.x;
	}
	
	public int getY () {
		return this.y;
	}
	
	private StoryCubePosition (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public static void initializePositions (int n) {
		int startInterval = StoryModel.xCoordMax / (n / 2 + 1);
		int startX = 0;
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0)
				startX += startInterval;
			int startY = i % 2 == 0 ? 30 : 90;
			StoryCubePosition iStart = new StoryCubePosition(startX, startY);
			startPositions.add(iStart);
			double xOffset = StoryModel.xCoordMax / 2 - (n / 2) * StoryCube.size + StoryCube.size / 2;
			int endX = (int) (xOffset + StoryCube.size * i);
			StoryCubePosition iEnd = new StoryCubePosition(endX, 60);
			endPositions.add(iEnd);
			allPositions.add(iStart);
			allPositions.add(iEnd);
		}
	}
	
	public Rectangle getRect (double scale, int xMargin) {
		int scaledX = (int) (x * scale);
		int scaledY = (int) (y * scale);
		int scaledSize = (int) (size * scale);
		return new Rectangle(scaledX - scaledSize / 2 + xMargin, scaledY - scaledSize / 2, scaledSize, scaledSize);
	}
}
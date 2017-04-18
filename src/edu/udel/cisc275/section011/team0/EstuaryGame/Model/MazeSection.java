package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import java.util.Random;

public class MazeSection {

	public static final byte N = 1, S = 2, E = 4, W = 8;
	
	private final int width;
	private final int height;
	private final byte wall[][];
	private final Direction entranceSide;
	private final Direction exitSide;
	
	static MazeSection generateMazeSection(int width, int height, 
			Direction entranceSide, Direction exitSide) {
		byte[][] maze = new byte[width][height];
		
		// Generate maze using Sidewinder algorithm from 
		// (http://weblog.jamisbuck.org/2011/2/3/maze-generation-sidewinder-algorithm.html).
		// The Sidewinder algorithm was chosen for the relatively-trivial, 
		// direction-biased mazes it generates because the game is less about 
		// solving complex mazes and more about moving around minor obstacles 
		// towards a defined salinity goal
		Random rand = new Random();
		final int weight = 2;
		for (int y = 0; y < height; y++) {
			int runStart = 0;
			for (int x = 0; x < width; x++) {
				if (y > 0 && (x + 1 == width || rand.nextInt(weight) == 0)) {
					int cell = runStart + rand.nextInt(x - runStart + 1);
					maze[y][cell] |= N;
					maze[y - 1][cell] |= S;
					runStart = x + 1;
				} else if (x + 1 < width) {
					maze[y][x] |= E;
					maze[y][x + 1] |= W;
				}
			}
		}
		
		return new MazeSection(width, height, maze, entranceSide, exitSide);
	}
	
	private MazeSection(int width, int height, byte wall[][], 
			Direction entranceSide, Direction exitSide) {
		this.width = width;
		this.height = height;
		this.wall = wall;
		this.entranceSide = entranceSide;
		this.exitSide = exitSide;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public byte isWall(int x, int y) {
		return wall[x][y];
	}
	public int getWallGridWidth() {
		return wall.length;
	}
	public int getWallGridHeight() {
		if(wall.length == 0) {
			return 0;
		}
		return wall[0].length;
	}
	
	public Direction getEntranceSide() {
		return entranceSide;
	}
	public Direction getExitSide() {
		return exitSide;
	}
	
}

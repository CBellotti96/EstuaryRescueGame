package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import java.util.Random;

public class MazeSection {

	public static final byte N = 1, S = 2, E = 4, W = 8;
	
	private final byte grid[][];
	private final Direction entranceSide;
	private final Direction exitSide;
	
	static MazeSection generateMazeSection(int width, int height, 
			Direction entranceSide, Direction exitSide) {
		byte[][] maze = new byte[width][height];
		
		// Generate maze using Sidewinder algorithm adapted from 
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
		
		MazeSection section = new MazeSection(maze, entranceSide, exitSide);
		section.printMaze();
		System.out.println("-----");
		return section;
	}
	
	private void printMaze () {
		for (int y = 0; y < grid.length; y++) {
			byte row[] = grid[y];
			System.out.print("|"); // leftmost wall
			for (int x = 0; x < row.length; x++) {
				byte cell = row[x];
				if (cell == 0 && y + 1 < grid.length && grid[y + 1][x] == 0) { // cell is empty, next cell down is within grid and empty
					System.out.print(" ");
				} else { //
					System.out.print(((cell & S) != 0) ? " " : "_");
				}

				if (cell == 0 && x + 1 < row.length && row[x + 1] == 0) {
					System.out.print((y + 1 < grid.length && (grid[y + 1][x] == 0 
							|| grid[y + 1][x + 1] == 0)) ? " " : "_");
				} else if ((cell & E) != 0) {
					System.out.print((((cell | row[x + 1]) & S) != 0) ? " " : "_");
				} else {
					System.out.print("|");
				}
			}
		    System.out.println();
		}
	}
	
	private MazeSection(byte grid[][], Direction entranceSide, 
			Direction exitSide) {
		this.grid = grid;
		this.entranceSide = entranceSide;
		this.exitSide = exitSide;
	}
	
	public byte getCell(int y, int x) {
		return grid[y][x];
	}
	public int getWidth() {
		if(grid.length == 0) {
			return 0;
		}
		return grid[0].length;
	}
	public int getHeight() {
		return grid.length;
	}
	
	public Direction getEntranceSide() {
		return entranceSide;
	}
	public Direction getExitSide() {
		return exitSide;
	}
	
}

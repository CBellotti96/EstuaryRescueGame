package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.lang.Long;

public class MazeSection {

	public static final int N = Direction.NORTH.getFlag();
	public static final int E = Direction.EAST.getFlag();
	public static final int S = Direction.SOUTH.getFlag();
	public static final int W = Direction.WEST.getFlag();
	public static final int ENTRANCE = 16;
	public static final int EXIT = 32;
	
	private final int grid[][];
	private final Direction entranceSide;
	private final Direction exitSide;
	
	private final int startTileX;
	private final int startTileY;

	private List<MazeObstacle> obstacles = new ArrayList<>();
	private List<MazePredator> predators = new ArrayList<>();
	
	static MazeSection generateMazeSection(int height, int width, 
			Direction entranceSide, Direction exitSide, MazeDifficulty mazeDifficulty) {
		int[][] maze = new int[height][width];
		
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
		// carve and mark exit along top row
		for (int x = 0; x < maze[0].length; x++) {
			maze[0][x] = (maze[0][x]) | N | EXIT;
		}
		
		// rotate maze so exit side is facing in correct direction
		//TODO: Delete print statement
		System.out.println(exitSide);
		switch (exitSide) {
		case EAST: maze = rotateMazeLeft(maze);
		case SOUTH: maze = rotateMazeLeft(maze);
		case WEST: maze = rotateMazeLeft(maze);
		case NORTH:;
		default:;
		}
		
		// pick appropriate starting position
		int startX = 0, startY = 0; 
		if (entranceSide == Direction.NORTH) {
			if (exitSide == Direction.EAST) {
				startX = rand.nextInt(maze[0].length / 2);
			} else if (exitSide == Direction.SOUTH) {
				startX = rand.nextInt(maze[0].length);
			} else if (exitSide == Direction.WEST) {
				startX = rand.nextInt(maze[0].length / 2) + maze[0].length / 2;
			}
			startY = 0;
			maze[startY][startX] = (maze[startY][startX]) | N | ENTRANCE;
		} else if (entranceSide == Direction.EAST) {
			if (exitSide == Direction.NORTH) {
				startY = rand.nextInt(maze.length / 2) + maze.length / 2;
			} else if (exitSide == Direction.SOUTH) {
				startY = rand.nextInt(maze.length / 2);
			} else if (exitSide == Direction.WEST) {
				startY = rand.nextInt(maze.length);
			}
			startX = maze[0].length - 1;
			maze[startY][startX] = (maze[startY][startX]) | E | ENTRANCE;
		} else if (entranceSide == Direction.SOUTH) {
			if (exitSide == Direction.NORTH) {
				startX = rand.nextInt(maze[0].length);
			} else if (exitSide == Direction.EAST) {
				startX = rand.nextInt(maze[0].length / 2);
			} else if (exitSide == Direction.WEST) {
				startX = rand.nextInt(maze[0].length / 2) + maze[0].length / 2;
			}
			startY = maze.length - 1;
			maze[startY][startX] = (maze[startY][startX]) | S | ENTRANCE;
		} else if (entranceSide == Direction.WEST) {
			if (exitSide == Direction.NORTH) {
				startY = rand.nextInt(maze.length / 2) + maze.length / 2;
			} else if (exitSide == Direction.EAST) {
				startY = rand.nextInt(maze.length);
			} else if (exitSide == Direction.SOUTH) {
				startY = rand.nextInt(maze.length / 2);
			}
			startX = 0;
			maze[startY][startX] = (maze[startY][startX]) | W | ENTRANCE;
		} else if (entranceSide == null) {
			if (exitSide == Direction.NORTH) {
				startX = rand.nextInt(maze[0].length);
				startY = rand.nextInt(maze.length / 2) + maze.length / 2;
			} else if (exitSide == Direction.EAST) {
				startX = rand.nextInt(maze[0].length / 2);
				startY = rand.nextInt(maze.length);
			} else if (exitSide == Direction.SOUTH) {
				startX = rand.nextInt(maze[0].length);
				startY = rand.nextInt(maze.length / 2);
			} else if (exitSide == Direction.WEST) {
				startX = rand.nextInt(maze[0].length / 2) + maze[0].length / 2;
				startY = rand.nextInt(maze.length);
			}
		}
		
		ArrayList<MazeObstacle> obstacles = genObstacles(mazeDifficulty, maze[0].length, maze.length);
		ArrayList<MazePredator> predators = genPredators(mazeDifficulty, maze[0].length, maze.length);
		
		MazeSection section = new MazeSection(maze, entranceSide, exitSide, 
				startX, startY, obstacles, predators);
		//section.printMaze();
		//System.out.println("-----");
		return section;
	}
	
	private static int[][] rotateMazeLeft(int original[][]) {
		int [][] transposed = new int[original[0].length][original.length];
		for (int y = 0; y < original.length; y++) {
			for (int x = 0; x < original[0].length; x++) {
				if ((original[y][x] & N) != 0) {
					transposed[x][y] |= W;
				};
				if ((original[y][x] & W) != 0) {
					transposed[x][y] |= S;
				};
				if ((original[y][x] & S) != 0) {
					transposed[x][y] |= E;
				};
				if ((original[y][x] & E) != 0) {
					transposed[x][y] |= N;
				};
				if ((original[y][x] & ENTRANCE) != 0) {
					transposed[x][y] |= ENTRANCE;
				};
				if ((original[y][x] & EXIT) != 0) {
					transposed[x][y] |= EXIT;
				};
			}
		}
		int rotated[][] = new int[transposed.length][transposed[0].length];
		for (int y = 0; y < rotated.length; y++) {
			rotated[rotated.length - y - 1] = transposed[y];
		}
		return rotated;
	}
	
	private void printMaze () {
		for (int y = 0; y < grid.length; y++) {
			int row[] = grid[y];
			System.out.print("|"); // leftmost wall
			for (int x = 0; x < row.length; x++) {
				int cell = row[x];
				if (cell == 0 && y + 1 < grid.length && grid[y + 1][x] == 0) { // cell is empty, next cell down is within grid and empty
					System.out.print(" ");
				} else {
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
	
	private MazeSection(int grid[][], Direction entranceSide, 
			Direction exitSide, int startTileX, int startTileY,
			ArrayList<MazeObstacle> obstacles, ArrayList<MazePredator> predators) {
		this.grid = grid;
		this.entranceSide = entranceSide;
		this.exitSide = exitSide;
		this.startTileX = startTileX;
		this.startTileY = startTileY;
		this.obstacles = obstacles;
		this.predators = predators;
	}
	
	public int getCell(int y, int x) {
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
	
	public int getStartTileX() {
		return startTileX;
	}
	public int getStartTileY() {
		return startTileY;
	}
	
	public void handleCollision(MazeCrab crab) {
		int currentTileX = (int) (crab.getXPos() + crab.getWidth() / 2);
		int currentTileY = (int) (crab.getYPos() + crab.getHeight() / 2);
		if(crab.getXPos() < currentTileX 
				&& (grid[currentTileY][currentTileX] & W) == 0)  {
			crab.setXPos(currentTileX);
		}
		if(crab.getXPos() + crab.getWidth() > currentTileX + 1
				&& (grid[currentTileY][currentTileX] & E) == 0)  {
			crab.setXPos(currentTileX + 1 - crab.getWidth());
		}
		if(crab.getYPos() < currentTileY
				&& (grid[currentTileY][currentTileX] & N) == 0)  {
			crab.setYPos(currentTileY);
		}
		if(crab.getYPos() + crab.getHeight() > currentTileY + 1
				&& (grid[currentTileY][currentTileX] & S) == 0)  {
			crab.setYPos(currentTileY + 1 - crab.getHeight());
		}
		
		
		
	}
	
	public double getProgression(MazeCrab crab) {
		switch(exitSide) {
		case NORTH: return 1.0 - crab.getYPos() / (double) getHeight();
		case EAST: return crab.getXPos() / (double) getWidth();
		case SOUTH: return crab.getYPos() / (double) getHeight();
		case WEST: return 1.0 - crab.getXPos() / (double) getWidth();
		default: return 0.0;
		}
	}
	
	private static ArrayList<MazeObstacle> genObstacles(MazeDifficulty mazeDifficulty, int mazeWidth, int mazeHeight){
		ArrayList<MazeObstacle> obstacles = new ArrayList<>();
		for(int i=0; i < mazeDifficulty.getObstacleNum(); i++){
			double xPos = Math.round(Math.random() * mazeWidth) + 0.25;
			double yPos = Math.round(Math.random() * mazeHeight) + 0.25;
			MazeObstacleType type = MazeObstacleType.randomMazeObstacleType();
			obstacles.add(new MazeObstacle(xPos, yPos, type.getDefaultSpeed(), type));
		}
		return obstacles;
	}
	
	private static ArrayList<MazePredator> genPredators(MazeDifficulty mazeDifficulty, int mazeWidth, int mazeHeight){
		ArrayList<MazePredator> predators = new ArrayList<>();
		for(int i = 0; i < mazeDifficulty.getPredatorNum(); i++){
			double xPos = Math.round(Math.random() * mazeWidth) + 0.25;
			double yPos = Math.round(Math.random() * mazeHeight) + 0.25;
			int xDirection = (int) (Math.random() * 3) - 1;
			int yDirection = (int) (Math.random() * 3) - 1;
			predators.add(new MazePredator(xPos, yPos, xDirection, yDirection));
		}
		return predators;
	}
	
	public List<MazeObstacle> getObstacles() {
		return obstacles;
	}

	public List<MazePredator> getPredators() {
		return predators;
	}
}

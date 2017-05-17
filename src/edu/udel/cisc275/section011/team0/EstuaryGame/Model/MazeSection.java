package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.lang.Long;

/**
 * MazeSection class contains methods which generate a random maze,
 * as well as predators and obstacles contained within that maze.
 * 
 * @author Alexandra Hurst
 * @author Emily McNeil
 *
 */
public class MazeSection {

	/**
	 * For ease of use. Contains the flag value for NORTH.
	 * @see		{@link Direction} 
	 */
	public static final int N = Direction.NORTH.getFlag();
	/**
	 * For ease of use. Contains the flag value for EAST.
	 * @see		{@link Direction} 
	 */
	public static final int E = Direction.EAST.getFlag();
	/**
	 * For ease of use. Contains the flag value for SOUTH.
	 * @see		{@link Direction} 
	 */
	public static final int S = Direction.SOUTH.getFlag();
	/**
	 * For ease of use. Contains the flag value for WEST.
	 * @see		{@link Direction} 
	 */
	public static final int W = Direction.WEST.getFlag();
	public static final int ENTRANCE = 16;
	public static final int EXIT = 32;
	
	/**
	 * The maze represented as a 2D array.
	 */
	private final int grid[][];
	/**
	 * Side of the Maze at which the salinity is highest.
	 * Also where the {@link MazeCrab} enters the section.
	 * @see {@link Direction}
	 */
	private final Direction entranceSide;
	/**
	 * Side of the Maze at which the salinity is lowest.
	 * Also the correct location for the {@link MazeCrab} 
	 * to leave the section.
	 * @see {@link Direction}
	 */
	private final Direction exitSide;
	
	/**
	 * Horizontal position within the grid.
	 * @see	#grid
	 */
	private final int startTileX;
	/**
	 * Vertical position within the grid.
	 * @see	#grid
	 */
	private final int startTileY;

	/**
	 * Array containing all {@link MazeObstacle} objects generated for the section.
	 */
	private List<MazeObstacle> obstacles = new ArrayList<>();
	/**
	 * Array containing all {@link MazePredator} objects generated for the section.
	 */
	private List<MazePredator> predators = new ArrayList<>();
	
	private MazeWeather weather;
	
	/**
	 * Generates a single section of the maze, including its predators and obstacles.
	 * <p>
	 * The maze is generated using an adaptation of the Sidewinder algorithm from:
	 * http://weblog.jamisbuck.org/2011/2/3/maze-generation-sidewinder-algorithm.html .
	 * The Sidewinder algorithm was chosen for the relatively-trivial, 
	 * direction-biased mazes it generates because the game is less about 
 	 * solving complex mazes and more about moving around minor obstacles 
	 * towards a defined salinity goal.
	 * <p>
	 * First, the maze is built inside a 2D array. Then an exit point is chosen.
	 * After the exit point is chosen, the maze is rotated to align the exit side
	 * with its proper cardinal direction. The player's starting position is chosen
	 * based off of the exit.
	 * <p>
	 * After the maze, entrance, and exit are defined, the predators and obstacles are 
	 * generated. With all the components defined, the MazeSection constructor is called.
	 * @param height			height of the maze
	 * @param width				width of the maze
	 * @param entranceSide		side of the maze with the highest salinity
	 * @param exitSide			side of the maze with the lowest salinity
	 * @param mazeDifficulty	difficulty level of the maze; determines numbers of predators, etc.
	 * @return					a single maze section
	 */
	static MazeSection generateMazeSection(int height, int width, 
			Direction entranceSide, Direction exitSide, MazeDifficulty mazeDifficulty) {
		int[][] maze = new int[height][width];

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
			maze[startY][startX] = (maze[startY][startX]) /*| N*/ | ENTRANCE;
		} else if (entranceSide == Direction.EAST) {
			if (exitSide == Direction.NORTH) {
				startY = rand.nextInt(maze.length / 2) + maze.length / 2;
			} else if (exitSide == Direction.SOUTH) {
				startY = rand.nextInt(maze.length / 2);
			} else if (exitSide == Direction.WEST) {
				startY = rand.nextInt(maze.length);
			}
			startX = maze[0].length - 1;
			maze[startY][startX] = (maze[startY][startX]) /*| E*/ | ENTRANCE;
		} else if (entranceSide == Direction.SOUTH) {
			if (exitSide == Direction.NORTH) {
				startX = rand.nextInt(maze[0].length);
			} else if (exitSide == Direction.EAST) {
				startX = rand.nextInt(maze[0].length / 2);
			} else if (exitSide == Direction.WEST) {
				startX = rand.nextInt(maze[0].length / 2) + maze[0].length / 2;
			}
			startY = maze.length - 1;
			maze[startY][startX] = (maze[startY][startX]) /*| S*/ | ENTRANCE;
		} else if (entranceSide == Direction.WEST) {
			if (exitSide == Direction.NORTH) {
				startY = rand.nextInt(maze.length / 2) + maze.length / 2;
			} else if (exitSide == Direction.EAST) {
				startY = rand.nextInt(maze.length);
			} else if (exitSide == Direction.SOUTH) {
				startY = rand.nextInt(maze.length / 2);
			}
			startX = 0;
			maze[startY][startX] = (maze[startY][startX]) /*| W*/ | ENTRANCE;
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
		
		MazeWeather sectionWeather = MazeWeather.randomMazeWeather();
		
		MazeSection section = new MazeSection(maze, entranceSide, exitSide, 
				startX, startY, obstacles, predators, sectionWeather);

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
	
	private MazeSection(int grid[][], Direction entranceSide, 
			Direction exitSide, int startTileX, int startTileY,
			ArrayList<MazeObstacle> obstacles, ArrayList<MazePredator> predators,
			MazeWeather weather) {
		this.grid = grid;
		this.entranceSide = entranceSide;
		this.exitSide = exitSide;
		this.startTileX = startTileX;
		this.startTileY = startTileY;
		this.obstacles = obstacles;
		this.predators = predators;
		this.weather = weather;
	}
	
	/**
	 * Getter for the data in a given grid cell.
	 * @param y		vertical position in the grid
	 * @param x		horizontal position in the grid
	 * @return		integer data held in the grid
	 */
	public int getCell(int y, int x) {
		return grid[y][x];
	}
	
	/**
	 * Getter for width of the maze.
	 * @return	width of a single row
	 */
	public int getWidth() {
		return grid[0].length;
	}
	
	/**
	 * Getter for height of the maze.
	 * @return	height of a single row
	 */
	public int getHeight() {
		return grid.length;
	}
	
	/**
	 * Getter for exit side.
	 * @return	{@link Direction} in which exit exists
	 */
	public Direction getExitSide() {
		return exitSide;
	}
	
	/**
	 * Getter for horizontal starting position of player.
	 * @return	integer marking player's initial horizontal position in the maze
	 */
	public int getStartTileX() {
		return startTileX;
	}
	/**
	 * Getter for vertical starting position of player.
	 * @return	integer marking player's initial vertical position in the maze
	 */
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
	
	public MazeWeather getWeather(){
		return this.weather;
	}
}

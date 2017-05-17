package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

/**
 * MazeObstacle class is used to instantiate non-predator hindrances within the maze.
 * 
 * @author Emily McNeil
 */
public class MazeObstacle extends MazeEntity {
	
	/**
	 * The default incremental speed of all MazeObstacles. Initialized to 0.0.
	 */
	private final static double defaultSpeed = 0.0;
	/**
	 * The enumerated type of the obstacle.
	 */
	private MazeObstacleType type;
	
	/**
	 * Constructor for MazeObstacles.
	 * 
	 * @param xPos	double specifying initial horizontal position
	 * @param yPos	double specifying initial vertical position
	 * @param speed double specifying speed - used for moving obstacles
	 * @param type	{@link <MazeObstacleType> [MazeObstacleType]}, supplemental and specifies other values/behaviors
	 */
	public MazeObstacle(double xPos, double yPos, double speed, MazeObstacleType type) {
		super(xPos, yPos, defaultSpeed);
		this.type = type;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void interfereCrab(MazeCrab crab){
		if (this.type == MazeObstacleType.TRASH && true == crab.getIsColliding()){
			crab.setSpeed(MazeObstacleType.TRASH.getInterferenceFactor());
		}
		if (this.type == MazeObstacleType.SEAWEED && true == crab.getIsColliding()){
			crab.setSpeed(MazeObstacleType.SEAWEED.getInterferenceFactor());
		}
		
	}
	
	/**
	 * Getter for {@link #type}.
	 * @return	the enumerated type of the obstacle
	 * @see		{@link <MazeObstacleType> [MazeObstacleType (enum)]}
	 */
	public MazeObstacleType getType() {
		return type;
	}
	
}

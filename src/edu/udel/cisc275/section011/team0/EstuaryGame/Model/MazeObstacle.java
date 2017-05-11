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
	 * Changes horizontal/vertical position of an obstacle.
	 * <p>
	 * Tests type of obstacle and increments its horizontal and vertical position accordingly.
	 * @param direction		enum signifying movement relative to current position
	 * @see					{@link <Direction> [Direction (enum)]}
	 */
	public void move(Direction direction){
		if (this.type == MazeObstacleType.TRASH){
			this.setXPos(this.getXPos() + direction.getXDir() * MazeObstacleType.TRASH.getDefaultSpeed());
			this.setYPos(this.getYPos() + direction.getYDir() * MazeObstacleType.TRASH.getDefaultSpeed());
		}
		else if (this.type == MazeObstacleType.SEAWEED){
			return;
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void interfereCrab(MazeCrab crab){
		if (this.type == MazeObstacleType.TRASH){
			crab.setSpeed(MazeObstacleType.TRASH.getInterferenceFactor());
		}
		if (this.type == MazeObstacleType.SEAWEED){
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

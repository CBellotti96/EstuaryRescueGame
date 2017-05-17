package edu.udel.cisc275.section011.team0.EstuaryGame.Model;


/**
 * The MazeDifficulty enum provides values for the number of predators, 
 * obstacles, powerups, and effect durations for each level of difficulty.
 * A fresh round of each will be generated per section.
 * 
 * @author Emily
 */
public enum MazeDifficulty {
	
	EASY(5, 10, 3),
	NORMAL(10, 15, 4),
	HARD(15, 20, 5);
	
	/**
	 * Number of predators.
	 */
	private final int predatorNum;
	/**
	 * Number of obstacles.
	 */
	private final int obstacleNum;
	/**
	 * Number of powerups.
	 */
	private final int powerupNum;
	
	/**
	 * Class constructor.
	 * 
	 * @param predatorNum	number of predators
	 * @param obstacleNum	number of obstacles
	 * @param powerupNum	number of powerups
	 */
	MazeDifficulty(int predatorNum, int obstacleNum, int powerupNum){
		this.predatorNum = predatorNum;
		this.obstacleNum = obstacleNum;
		this.powerupNum = powerupNum;
	}
	
	/**
	 * Getter for {@link #predatorNum}.
	 * @return {@link #predatorNum}
	 */
	public int getPredatorNum(){
		return this.predatorNum;
	}
	
	/**
	 * Getter for {@link #obstacleNum}.
	 * @return {@link #obstacleNum}
	 */
	public int getObstacleNum(){
		return this.obstacleNum;
	}
	
	/**
	 * Getter for {@link #powerupNum}.
	 * @return	{@link #powerupNum}
	 */
	public int getPowerupNum(){
		return this.powerupNum;
	}
	

	
}

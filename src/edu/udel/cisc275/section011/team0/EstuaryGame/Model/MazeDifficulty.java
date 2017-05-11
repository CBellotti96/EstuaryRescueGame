package edu.udel.cisc275.section011.team0.EstuaryGame.Model;


/**
 * The MazeDifficulty enum provides values for the number of predators, 
 * obstacles, powerups, and effect durations for each level of difficulty.
 * A fresh round of each will be generated per section.
 * 
 * @author Emily
 */
public enum MazeDifficulty {
	
	EASY(5, 10, 3, 10.0, 3.0),
	NORMAL(10, 15, 4, 7.5, 4.5),
	HARD(15, 20, 5, 6.0, 5.0);
	
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
	 * Length of duration for positive effects.
	 */
	private final double posEffectDur;
	/**
	 * Length of duration for negative effects
	 */
	private final double negEffectDur;
	
	/**
	 * Class constructor.
	 * 
	 * @param predatorNum	number of predators
	 * @param obstacleNum	number of obstacles
	 * @param powerupNum	number of powerups
	 * @param posEffectDur	double denoting duration of positive effects 
	 * @param negEffectDur	double denoting duration of positive effects
	 */
	MazeDifficulty(int predatorNum, int obstacleNum, int powerupNum, double posEffectDur, double negEffectDur){
		this.predatorNum = predatorNum;
		this.obstacleNum = obstacleNum;
		this.powerupNum = powerupNum;
		this.posEffectDur = posEffectDur;
		this.negEffectDur = negEffectDur;
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
	
	/** 
	 * Getter for {@link #posEffectDur}.
	 * @return	
	 */
	public double getPosEffectDur(){
		return this.posEffectDur;
	}
	
	/**
	 * Getter for {@link #negEffectDur}.
	 * @return {@link #negEffectDur}
	 */
	public double getNegEffectDur(){
		return this.negEffectDur;
	}
	
}

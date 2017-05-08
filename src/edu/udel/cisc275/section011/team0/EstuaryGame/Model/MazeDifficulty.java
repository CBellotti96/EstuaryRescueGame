package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

public enum MazeDifficulty {

	//figuring a new round of predators/powerups will be generated per section
	
	EASY(4, 4, 3, 10.0, 3.0),
	NORMAL(7, 3, 4, 7.5, 4.5),
	HARD(10, 2, 5, 6.0, 5.0);
	
	private final int predatorNum;
	private final int obstacleNum;
	private final int powerupNum;
	//durations are supposed to represent # seconds
	private final double posEffectDur;
	private final double negEffectDur;
	
	MazeDifficulty(int predatorNum, int obstacleNum, int powerupNum, double posEffectDur, double negEffectDur){
		this.predatorNum = predatorNum;
		this.obstacleNum = obstacleNum;
		this.powerupNum = powerupNum;
		this.posEffectDur = posEffectDur;
		this.negEffectDur = negEffectDur;
	}
	
	public int getPredatorNum(){
		return this.predatorNum;
	}
	
	public int getObstacleNum(){
		return this.obstacleNum;
	}
	
	public int getPowerupNum(){
		return this.powerupNum;
	}
	
	public double getPosEffectDur(){
		return this.posEffectDur;
	}
	
	public double getNegEffectDur(){
		return this.negEffectDur;
	}
	
}

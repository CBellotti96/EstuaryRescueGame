package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

public class MazeObstacle extends MazeEntity {
	
	private final static double defaultSpeed = 0.0;
	private MazeObstacleType type;
	
	public MazeObstacle(double xPos, double yPos, double speed, MazeObstacleType type) {
		super(xPos, yPos, defaultSpeed);
		this.type = type;
	}

	public void move(Direction direction){
		if (this.type == MazeObstacleType.TRASH){
			this.setXPos(this.getXPos() + direction.getXDir() * MazeObstacleType.TRASH.getDefaultSpeed());
			this.setYPos(this.getYPos() + direction.getYDir() * MazeObstacleType.TRASH.getDefaultSpeed());
		}
		else if (this.type == MazeObstacleType.SEAWEED){
			return;
		}
	}
	
	public void interfereCrab(MazeCrab crab){
		if (this.type == MazeObstacleType.TRASH){
			crab.changeSpeed(MazeObstacleType.TRASH.getInterferenceFactor());
		}
		else if (this.type == MazeObstacleType.SEAWEED){
			crab.changeSpeed(MazeObstacleType.SEAWEED.getInterferenceFactor());
		}
	}
	
	public MazeObstacleType getType() {
		return type;
	}
	
}

package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

/**
 * The StoryCube is the main interactive object in the game. The cube knows where it is
 * in the StoryModel, where its target StoryCubePosition is, whether or not it is selected,
 * and whether it is currently rolling.
 * @see StoryCubePosition
 * @author Ben Wiswell
 */

import java.awt.Rectangle;
import java.util.Random;

import edu.udel.cisc275.section011.team0.EstuaryGame.View.StoryView;

public class StoryCube {
	
	private final static int speed = 1;
	public final static int size = 15;
	
	private int id;
	private int x;
	private int y;
	private StoryCubePosition cubePos;
	private int cubeFace;
	private boolean selected;
	private boolean rolling;
	private int rollState;
	
	public int getID () {return this.id;}	
	public StoryCubePosition getCubePos () {return this.cubePos;}
	public int getCubeFace () {return this.cubeFace;}
	public boolean isSelected () {return this.selected;}
	public boolean isRolling () {return this.rolling;}
	public int getRollState () {return this.rollState;}
	
	public void setX (int x) {this.x = x;}
	public void setY (int y) {this.y = y;}
	public void setCubePos (StoryCubePosition cubePos) {
		this.cubePos = cubePos;
		this.x = cubePos.getX();
		this.y = cubePos.getY();
	}
	public void setSelected (boolean selected) {this.selected = selected;}
	public void setRolling (StoryCubePosition cubePos) {
		this.cubePos = cubePos;
		this.rolling = true;
	}
	
	/**
	 * @author Ben Wiswell
	 * StoryCube constructor that sets the center StoryCubePosition as the StoryCube's initial
	 * position and assigns a random face to the cube.
	 * @param id	The id assigned to the cube, running between 0 and the number of cubes, non-inclusive
	 */
	public StoryCube (int id) {
		this.id = id;
		setCubePos(StoryCubePosition.center);
		Random r = new Random();
		this.cubeFace = r.nextInt(StoryView.numImages);
		this.rolling = false;
		this.rollState = 0;
	}
	
	public void incrementRoll () {
		this.rollState = rollState + 1;
		if (rollState % 10 == 0) {
			Random r = new Random();
			this.cubeFace = r.nextInt(StoryView.numImages);
		}
	}
	
	public Rectangle getRect (double scale, int xMargin) {
		int scaledSize = (int) (size * scale);
		int scaledX = (int) (x * scale);
		int scaledY = (int) (y * scale);
		return new Rectangle(scaledX - scaledSize / 2 + xMargin, scaledY - scaledSize / 2, scaledSize, scaledSize);
	}
	
	public void move () {
		if (!selected) {
			int targetX = cubePos.getX();
			int targetY = cubePos.getY();
			if (Math.abs(x - targetX) < 2 * speed && Math.abs(y - targetY) < 2 * speed) {
				this.x = targetX;
				this.y = targetY;
				this.rolling = false;
			} else if (Math.abs(x - targetX) <= speed) {
				this.x = targetX;
				this.y = y < targetY ? y + speed : y - speed;
			} else if (Math.abs(y - targetY) <= speed) {
				this.x = x < targetX ? x + speed : x - speed;
				this.y = targetY;
			} else {
				this.x = x < targetX ? x + speed : x - speed;
				this.y = y < targetY ? y + speed : y - speed;
			}
		}
	}

}

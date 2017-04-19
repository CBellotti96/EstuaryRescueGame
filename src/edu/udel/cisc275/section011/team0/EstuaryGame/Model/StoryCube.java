package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;

public class StoryCube {
	
	private static int speed = 5;
	
	private int id;
	private int x;
	private int y;
	private int size;
	private StoryCubeFace cubeFace;
	private StoryCubePosition home;
	private boolean selected;
	private boolean rolling;
	private int rollState;
	
	public int getID () {return this.id;}	
	public int getX () {return this.x;}	
	public int getY () {return this.y;}	
	public int getSize () {return this.size * 2;}	
	public StoryCubeFace getCubeFace () {return this.cubeFace;}
	public StoryCubePosition getHome () {return this.home;}
	public boolean isRolling () {return this.rolling;}
	
	public void setX (int x) {this.x = x;}	
	public void setY (int y) {this.y = y;}
	public void setHome (StoryCubePosition home) {this.home = home;}
	public void setSize (int size) {this.size = size;}	
	public void setSelected (boolean selected) {this.selected = selected;}
	public void setRolling (boolean rolling) {this.rolling = rolling;}
	
	public StoryCube (int id, StoryCubePosition home) {
		this.id = id;
		this.cubeFace = StoryCubeFace.random();
		this.home = home;
		this.rolling = false;
		this.rollState = 0;
	}
	
	public void incrementRoll () {
		this.rollState = (rollState + 1) % 5;
		if (rollState == 0)
			this.cubeFace = StoryCubeFace.random();
	}
	
	public Rectangle getRect () {
		return new Rectangle(x, y, size * 2, size * 2);
	}
	
	public void move (Point mousePos) {
		if (selected) {
			this.x = mousePos.x - size;
			this.y = mousePos.y - size;
		} else {
			int homeX = home.getX();
			int homeY = home.getY();
			if (Math.abs(x - homeX) < 2 * speed && Math.abs(y - homeY) < 2 * speed) {
				this.x = homeX;
				this.y = homeY;
				this.rolling = false;
			} else if (Math.abs(x - homeX) <= speed) {
				this.x = homeX;
				this.y = y < homeY ? y + speed : y - speed;
			} else if (Math.abs(y - homeY) <= speed) {
				this.x = x < homeX ? x + speed : x - speed;
				this.y = homeY;
			} else {
				this.x = x < homeX ? x + speed : x - speed;
				this.y = y < homeY ? y + speed : y - speed;
			}
		}
	}

}
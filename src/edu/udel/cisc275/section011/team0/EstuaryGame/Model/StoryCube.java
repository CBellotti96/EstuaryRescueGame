package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import java.awt.MouseInfo;
import java.awt.Rectangle;

public class StoryCube {
	
	private static int speed = 5;
	
	private int id;
	private int x;
	private int y;
	private int size;
	private StoryCubeFace cubeFace;
	
	private StoryCubePosition home;
	private int homeX;
	private int homeY;
	
	private int xOffset;
	private int yOffset;
	
	private boolean selected;
	private boolean rolling;
	
	public int getID () {return this.id;}	
	public int getX () {return this.x;}	
	public int getY () {return this.y;}	
	public int getSize () {return this.size;}	
	public StoryCubeFace getCubeFace () {return rolling ? StoryCubeFace.random() : this.cubeFace;}
	public StoryCubePosition getHome () {return this.home;}
	
	public void setX (int x) {this.x = x;}	
	public void setY (int y) {this.y = y;}
	public void setHome (StoryCubePosition home) {this.home = home;}
	public void setOffsets (int xOff, int yOff) {
		this.xOffset = xOff;
		this.yOffset = yOff;
	}	
	public void setSize (int size) {this.size = size;}	
	public void setSelected (boolean selected) {this.selected = selected;}
	public void setRolling (boolean rolling) {this.rolling = rolling;}
	
	public StoryCube (int id) {
		this.id = id;
		this.cubeFace = StoryCubeFace.random();
		this.rolling = false;
	}
	
	public Rectangle getRect () {
		return new Rectangle(x, y, size, size);
	}
	
	public void updateHome (int size) {
		this.homeX = home.getX() * size;
		this.homeY = home.getY() * size;
	}
	
	public void move () {
		if (selected) {
			this.x = MouseInfo.getPointerInfo().getLocation().x - xOffset;
			this.y = MouseInfo.getPointerInfo().getLocation().y - yOffset;
		} else {
			if (Math.abs(x - homeX) < 2 * speed && Math.abs(y - homeY) < 2 * speed) {
				this.x = homeX;
				this.y = homeY;
				this.rolling = false;
			} else if (Math.abs(x - homeX) <= speed) {
				this.x = homeX;
			} else if (Math.abs(y - homeY) <= speed) {
				this.y = homeY;
			} else {
				this.x = x < homeX ? x + speed : x - speed;
				this.y = y < homeY ? y + speed : y - speed;
			}
		}
	}

}

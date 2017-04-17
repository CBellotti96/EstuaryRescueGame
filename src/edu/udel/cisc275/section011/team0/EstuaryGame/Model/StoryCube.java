package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

public class StoryCube {
	
	private int x;
	private int y;
	private int size;
	private StoryCubePosition cubePosition;
	private StoryCubeFace cubeFace;
	private boolean selected;
	private boolean rolling;
	private boolean rolled;
	
	public int getX () {
		return this.x;
	}
	
	public int getY () {
		return this.y;
	}
	
	public int getSize () {
		return this.size;
	}
	
	public StoryCubePosition getCubePosition () {
		return this.cubePosition;
	}
	
	public StoryCubeFace getCubeFace () {
		return this.cubeFace;
	}
	
	public void randomFace () {
		this.cubeFace = StoryCubeFace.random();
	}
	
	public boolean isSelected () {
		return this.selected;
	}
	
	public boolean isRolling () {
		return this.rolling;
	}
	
	public boolean isRolled () {
		return this.rolled;
	}
	
	public void setX (int x) {
		this.x = x;
	}
	
	public void setY (int y) {
		this.y = y;
	}
	
	public void vX (int n) {
		this.x = x + n;
	}
	
	public void vY (int n) {
		this.y = y + n;
	}
	
	public void setSize (int size) {
		this.size = size;
	}
	
	public void setCubePosition (StoryCubePosition cubePosition) {
		this.cubePosition = cubePosition;
	}
	
	public void setSelected (boolean selected) {
		this.selected = selected;
	}
	
	public void setRolling (boolean rolling) {
		this.rolling = rolling;
	}
	
	public void setRolled (boolean rolled) {
		this.rolled = rolled;
	}
	
	public StoryCube () {
		this.cubeFace = StoryCubeFace.random();
		this.rolling = false;
		this.rolled = false;
	}

}

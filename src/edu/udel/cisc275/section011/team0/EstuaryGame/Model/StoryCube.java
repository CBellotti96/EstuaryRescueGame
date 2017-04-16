package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

public class StoryCube {
	
	private StoryCubePosition cubePosition;
	private StoryCubeFace cubeFace;
	private boolean selected;
	
	public int getX () {
		return this.cubePosition.getX();
	}
	
	public int getY () {
		return this.cubePosition.getY();
	}
	
	public int getSize () {
		return this.cubePosition.getSize();
	}
	
	public StoryCubePosition getCubePosition () {
		return this.cubePosition;
	}
	
	public StoryCubeFace getCubeFace () {
		return this.cubeFace;
	}
	
	public boolean isSelected () {
		return this.selected;
	}
	
	public void setCubePosition (StoryCubePosition cubePosition) {
		this.cubePosition = cubePosition;
	}
	
	public void setSelected (boolean selected) {
		this.selected = selected;
	}
	
	public StoryCube () {
		this.cubeFace = StoryCubeFace.random();
	}

}

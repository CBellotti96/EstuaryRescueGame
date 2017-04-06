package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

public class MazeSection {

	private final int width;
	private final int height;
	private final boolean wall[][];
	
	public MazeSection(int width, int height, boolean wall[][]) {
		this.width = width;
		this.height = height;
		this.wall = wall;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public boolean isWall(int x, int y) {
		return wall[x][y];
	}
	public int getWallGridWidth() {
		return wall.length;
	}
	public int getWallGridHeight() {
		if(wall.length == 0) {
			return 0;
		}
		return wall[0].length;
	}
	
}

package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

public class ShoreTile {
	private int tileWidth;
	private int tileHeight;
	private ShorePosition tileOrigin;
	private boolean vacant;
	private Object tileContents;
	private ShoreTileType tileType;
	
	public ShoreTile(int width, int height, ShorePosition origin){
		this.tileWidth = width;
		this.tileHeight = height;
		this.tileOrigin = origin;
		this.tileContents = null;
	}

	public int getTileWidth() {
		return tileWidth;
	}

	public void setTileWidth(int tileWidth) {
		this.tileWidth = tileWidth;
	}

	public int getTileHeight() {
		return tileHeight;
	}

	public void setTileHeight(int tileHeight) {
		this.tileHeight = tileHeight;
	}

	public ShorePosition getTileOrigin() {
		return tileOrigin;
	}

	public void setTileOrigin(ShorePosition tileOrigin) {
		this.tileOrigin = tileOrigin;
	}

	public boolean isVacant() {
		return vacant;
	}

	public void setVacant(boolean vacant) {
		this.vacant = vacant;
	}

	public Object getTileContents() {
		return tileContents;
	}

	public void setTileContents(Object tileContents) {
		this.tileContents = tileContents;
	}

	public ShoreTileType getTileType() {
		return tileType;
	}

	public void setTileType(ShoreTileType tileType) {
		this.tileType = tileType;
	}
	
}

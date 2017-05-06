package edu.udel.cisc275.section011.team0.EstuaryGame.Model;
/**
 * 
 * A ShoreTile is a square in the grid that divides up the model.
 * @author Chris Bellotti and Alvin Tang
 
 */
public class ShoreTile {
	private int tileWidth;
	private int tileHeight;
	private ShorePosition tileOrigin;
	private boolean vacant;
	private Object tileContents;
	private ShoreTileType tileType;
	/**
	 * @author Chris Bellotti and Alvin Tang
	 * This methods constructs a ShoreTile
	 * @param width   defines the width of a ShoreTile
	 * @param height defines the height of a ShoreTile
	 * @param origin defines the position of a ShoreTile
	 */
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

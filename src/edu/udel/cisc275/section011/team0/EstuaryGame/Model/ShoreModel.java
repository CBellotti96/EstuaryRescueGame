package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import java.util.HashMap;

public class ShoreModel {
	
	private double cursorXPos;
	private double cursorYPos;
	private double shoreHealth;
	private HashMap<ShoreItemType, Integer> inventory;
	private ShoreGameMode gameMode;
	
	public double getCursorXPos () {
		return this.cursorXPos;
	}
	
	public double getCursorYPos () {
		return this.cursorYPos;
	}
	
	public double getShoreHealth () {
		return this.shoreHealth;
	}
	
	public HashMap<ShoreItemType, Integer> getInventory () {
		return this.inventory;
	}
	
	public ShoreGameMode getGameMode () {
		return this.gameMode;
	}
	
	public void setCursorXPos (double cursorXPos) {
		this.cursorXPos = cursorXPos;
	}
	
	public void setCursorYPos (double cursorYPos) {
		this.cursorYPos = cursorYPos;
	}
	
	public void setShoreHealth (double shoreHealth) {
		this.shoreHealth = shoreHealth;
	}
	
	public void setGameMode (ShoreGameMode gameMode) {
		this.gameMode = gameMode;
	}

}

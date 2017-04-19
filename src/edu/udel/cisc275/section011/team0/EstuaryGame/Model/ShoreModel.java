package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JFrame;

public class ShoreModel {
	
	private ShorePosition cursorPos;
	private ShoreDefenseType defenseWall,defenseGabion,defensePlant;
	private ShoreItemType itemRock,itemOyster,itemSeed;
	private double itemSpawnStartY;
	private double itemSpawnEndY;
	private ArrayList<ShoreDefense> defenses;
	private ArrayList<ShoreItem> items;
	private double shoreHealth;			
	private HashMap<ShoreItemType, Integer> inventory;
	private ShoreGameMode gameMode;
	private int gameWidth;
	private int gameHeight;
	private int countdown;
	protected int tilesInRow;
	private ArrayList<ArrayList<ShoreTile>> tiles;
	protected int tilesInColumn;
	private int tileSize;
	
	
	public ShoreModel(int width, int height){
		this.gameWidth = width;
		this.gameHeight = height;
		this.countdown = 5;
		this.gameMode = ShoreGameMode.TUTORIAL;
		this.shoreHealth = 50;
		this.tileSize = 50;
		this.cursorPos = new ShorePosition(gameWidth/2, gameHeight/2);
		this.tilesInRow = gameWidth/tileSize;
		this.tilesInColumn = gameHeight/tileSize;
		this.inventory = new HashMap<ShoreItemType, Integer>();
		defenseWall = new ShoreDefenseType("Sea Wall");
		defensePlacementArea(defenseWall);
		defenseGabion = new ShoreDefenseType("Gabion");
		defensePlacementArea(defenseGabion);
		defensePlant = new ShoreDefenseType("Plant");
		defensePlacementArea(defensePlant);
		itemRock = new ShoreItemType("Rock");
		itemRock.setBuildsDefense(defenseWall);
		itemOyster = new ShoreItemType("Oyster");
		itemOyster.setBuildsDefense(defenseGabion);
		itemSeed = new ShoreItemType("Seed");
		itemSeed.setBuildsDefense(defensePlant);
		inventory.put(itemRock, 0);
		inventory.put(itemOyster, 0);
		inventory.put(itemSeed, 0);
		tiles = new ArrayList<ArrayList<ShoreTile>>();
		for (int i = 0; i < tilesInRow; i++){
			tiles.add(new ArrayList<ShoreTile>());
			for (int j = 0; j < tilesInColumn; j++){
				tiles.get(i).add(new ShoreTile(tileSize, tileSize, new ShorePosition(i*tileSize,j*tileSize)));
				//tiles[i][j] = new ShoreTile(tileSize, tileSize, new ShorePosition(i*tileSize,j*tileSize));
				if(tiles.get(i).get(j).getTileOrigin().getShoreY() < gameHeight/2){
					tiles.get(i).get(j).setTileType(ShoreTileType.OCEAN);
					tiles.get(i).get(j).setVacant(false);
				} 
				else { 
					tiles.get(i).get(j).setTileType(ShoreTileType.BEACH);
					tiles.get(i).get(j).setVacant(true);
				}
					
			}
		}
	}
	
	public int getGameWidth() {
		return gameWidth;
	}

	public void setGameWidth(int gameWidth) {
		this.gameWidth = gameWidth;
	}

	public int getGameHeight() {
		return gameHeight;
	}

	public void setGameHeight(int gameHeight) {
		this.gameHeight = gameHeight;
	}

	public int getCountdown() {
		return countdown;
	}

	public double getShoreHealth() {
		return shoreHealth;
	}

	public void setShoreHealth(double shoreHealth) {
		this.shoreHealth = shoreHealth;
	}

	public void setCountdown(int countdown) {
		this.countdown = countdown;
	}

	public ArrayList<ArrayList<ShoreTile>> getTiles() {
		return tiles;
	}

	public void setTiles(ArrayList<ArrayList<ShoreTile>> tiles) {
		this.tiles = tiles;
	}

	public int getTilesInRow() {
		return tilesInRow;
	}

	public void setTilesInRow(int tilesInRow) {
		this.tilesInRow = tilesInRow;
	}

	public int getTilesInColumn() {
		return tilesInColumn;
	}

	public void setTilesInColumn(int tilesInColumn) {
		this.tilesInColumn = tilesInColumn;
	}

	public int getTileSize() {
		return tileSize;
	}

	public void setTileSize(int tileSize) {
		this.tileSize = tileSize;
	}

	public void onTick(){ //updates position of moving objects
		for (int i = 0; i < tilesInRow; i++){
			for (int j = 0; j < tilesInColumn; j++){
				if(!tiles.get(i).get(j).isVacant() && tiles.get(i).get(j).getTileContents() != null){
					
					if(tiles.get(i).get(j).getTileContents() instanceof ShoreWave){
						Object  o = tiles.get(i).get(j).getTileContents();
						handleWaveMovement((ShoreWave)o);
					}
					else if(tiles.get(i).get(j).getTileContents() instanceof ShoreBoat){
						Object o = tiles.get(i).get(j).getTileContents();
						if(((ShoreBoat)o).getType().getName() == "Jet Ski"){
							handleJetSki((ShoreBoat)o);
						}
						else if(((ShoreBoat)o).getType().getName() == "Sailboat"){
							handleSailboat((ShoreBoat)o);
						}
						else if(((ShoreBoat)o).getType().getName() == "Commercial"){
							handleCommercial((ShoreBoat)o);
						}
					}
					else if(tiles.get(i).get(j).getTileContents() instanceof ShoreDefense){
						Object o = tiles.get(i).get(j).getTileContents();
						if(((ShoreDefense)o).getType().getName() == "Sea Wall"){
							shoreHealth -= .1;
						}
					}
				}
			}
		}
	}
	
	public void defensePlacementArea(ShoreDefenseType d){
		if(d.getName() == "Gabion") { //gabions go in two tiles nearest to ocean
			d.setPlacementZoneStartY(gameHeight/2);
			d.setPlacementZoneEndY((gameHeight/2)+(2*tileSize));
		}
		else if (d.getName() == "Plant"){ //plants go in lowest 2 tiles
			d.setPlacementZoneStartY((gameHeight)- (2*tileSize)); 
			d.setPlacementZoneEndY(gameHeight);
		}
	}
	
	public void handleJetSki(ShoreBoat b){ 
		int waveStrength = 1;
		if(b.getWaveTile() == -1){
			genWaveTile(b);
		}
		b.getboatPos().setShoreX(b.getboatPos().getShoreX() + tileSize);
		int i = (int)((b.getboatPos().getShoreX())/gameWidth);
		int j = (int)((b.getboatPos().getShoreY())/gameHeight);
		tiles.get(i).get(j).setTileContents(b);
		tiles.get(i).get(j).setVacant(false);
		tiles.get(i-1).get(j).setTileContents(null);
		tiles.get(i-1).get(j).setVacant(true);
		
		if (i == b.getWaveTile()){
			ShorePosition p1 = new ShorePosition(0,0);
			p1.setShoreX(b.getboatPos().getShoreX());
			p1.setShoreY(b.getboatPos().getShoreY() + tileSize);
			ShorePosition p2 = new ShorePosition(p1.getShoreX() + tileSize,p1.getShoreY());
			ShorePosition p3 = new ShorePosition(p1.getShoreX() - tileSize,p1.getShoreY());
			if(i+1 < tilesInRow){
				ShoreWave w2 = new ShoreWave(p2, waveStrength);
				tiles.get(i+1).get(j+1).setTileContents(w2);
				tiles.get(i+1).get(j+1).setVacant(false);
			}
			if(i-1 >= 0){
				ShoreWave w3 = new ShoreWave(p3, waveStrength);
				tiles.get(i-1).get(j-1).setTileContents(w3);
				tiles.get(i-1).get(j-1).setVacant(false);
			}
		}
		
	}
	
	public void handleSailboat(ShoreBoat b){
		int waveStrength = 2;
		if(b.getWaveTile() == -1){
			genWaveTile(b);
		}
		b.getboatPos().setShoreX(b.getboatPos().getShoreX() + tileSize);
		int i = (int)((b.getboatPos().getShoreX())/gameWidth);
		int j = (int)((b.getboatPos().getShoreY())/gameHeight);
		tiles.get(i).get(j).setTileContents(b);
		tiles.get(i).get(j).setVacant(false);
		tiles.get(i-1).get(j).setTileContents(null);
		tiles.get(i-1).get(j).setVacant(true);
		
		if(i == b.getWaveTile()){
			ShorePosition p = new ShorePosition(0,0);
			p.setShoreX(b.getboatPos().getShoreX());
			p.setShoreY(b.getboatPos().getShoreY() + tileSize);
			ShoreWave wave = new ShoreWave(p,waveStrength);
			tiles.get(i).get(j+1).setTileContents(wave);
			tiles.get(i).get(j+1).setVacant(false);	
		}
	}
	
	public void handleCommercial(ShoreBoat b){
		int waveStrength = 3;
		if(b.getWaveTile() == -1){
			genWaveTile(b);
		}
		b.getboatPos().setShoreX(b.getboatPos().getShoreX() + tileSize);
		int i = (int)((b.getboatPos().getShoreX())/gameWidth);
		int j = (int)((b.getboatPos().getShoreY())/gameHeight);
		tiles.get(i).get(j).setTileContents(b);
		tiles.get(i).get(j).setVacant(false);
		tiles.get(i-1).get(j).setTileContents(null);
		tiles.get(i-1).get(j).setVacant(true);
		
		if (i == b.getWaveTile()){
			ShorePosition p1 = new ShorePosition(0,0);
			p1.setShoreX(b.getboatPos().getShoreX());
			p1.setShoreY(b.getboatPos().getShoreY() + tileSize);
			ShorePosition p2 = new ShorePosition(p1.getShoreX() + tileSize,p1.getShoreY());
			ShorePosition p3 = new ShorePosition(p1.getShoreX() - tileSize,p1.getShoreY());
			ShoreWave w1 = new ShoreWave(p1, waveStrength);
			tiles.get(i).get(j+1).setTileContents(w1);
			tiles.get(i).get(j+1).setVacant(false);
			if(i+1 < tilesInRow){
				ShoreWave w2 = new ShoreWave(p2, waveStrength);
				tiles.get(i+1).get(j+1).setTileContents(w2);
				tiles.get(i+1).get(j+1).setVacant(false);
			}
			if(i-1 >= 0){
				ShoreWave w3 = new ShoreWave(p3, waveStrength);
				tiles.get(i-1).get(j-1).setTileContents(w3);
				tiles.get(i-1).get(j-1).setVacant(false);
			}
		}
		
	}
	
	public void genWaveTile(ShoreBoat b){
		Random rand = new Random();
		int randTile = rand.nextInt(tilesInRow - 1);
		b.setWaveTile(randTile);
	}
	
	public void handleWaveMovement(ShoreWave w){
		w.getWavePos().setShoreY(w.getWavePos().getShoreY() + tileSize);
		int i = (int)((w.getWavePos().getShoreX())/gameWidth);
		int j = (int)((w.getWavePos().getShoreY())/gameHeight);
		tiles.get(i).get(j-1).setTileContents(null);
		tiles.get(i).get(j-1).setVacant(true);
		if(tiles.get(i).get(j).getTileType() != ShoreTileType.BEACH && tiles.get(i).get(j).getTileType() != ShoreTileType.DAMAGED){
			tiles.get(i).get(j).setTileContents(w);
			tiles.get(i).get(j).setVacant(false);
		}
		else if(tiles.get(i).get(j).getTileType() == ShoreTileType.BEACH || tiles.get(i).get(j).getTileType() == ShoreTileType.DAMAGED){
			handleWaveCollision(w);
		}
	}
	
	public void handleWaveCollision(ShoreWave w){
		int i = (int)((w.getWavePos().getShoreX())/gameWidth);
		int j = (int)((w.getWavePos().getShoreY())/gameHeight);
		if(!tiles.get(i).get(j).isVacant() && tiles.get(i).get(j).getTileContents() instanceof ShoreDefense){
			Object o = tiles.get(i).get(j).getTileContents();
			int d = ((ShoreDefense)o).getType().getDurability();
			if(d - w.getWaveStrength() > 0){
				((ShoreDefense)o).getType().setDurability(d - w.getWaveStrength());
			}
			else{
				tiles.get(i).get(j).setTileContents(null);
				tiles.get(i).get(j).setVacant(true);
			}
		}
		else{
			tiles.get(i).get(j).setTileContents(null);
			tiles.get(i).get(j).setVacant(true);
			if(tiles.get(i).get(j).getTileType() == ShoreTileType.BEACH){
				shoreHealth -= w.getWaveStrength();
				tiles.get(i).get(j).setTileType(ShoreTileType.DAMAGED);
			}
			else if(tiles.get(i).get(j).getTileType() == ShoreTileType.DAMAGED){
				shoreHealth -= (w.getWaveStrength() + 1);
			}
		}
		w = null;
	}
	
	public void countdown(){
		this.countdown -= 1;
	}
	
}

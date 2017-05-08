package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

import edu.udel.cisc275.section011.team0.EstuaryGame.Common.Main;
import edu.udel.cisc275.section011.team0.EstuaryGame.Controller.MenuController;

public class ShoreModel {
	
	private ShorePosition cursorPos;
	public ShoreDefenseType defenseWall;
	public ShoreDefenseType defenseGabion;
	public ShoreDefenseType defensePlant;
	public ShoreItemType itemRock,itemOyster,itemSeed;
	public ShoreBoatType boatSailboat,boatJetSki,boatCommercial;
	private ShoreDefenseType savedDefenseType;
	private double itemSpawnStartY;
	private double itemSpawnEndY;
	private ArrayList<ShoreDefense> defenses;
	private ArrayList<ShoreItem> items;
	private ArrayList<ShoreBoat> boats;
	private ArrayList<ShoreWave> waves;
	private ArrayList<ShoreWave> wavesToRemove;
	private double shoreHealth = 50;			
	private HashMap<ShoreItemType, Integer> inventory;
	private ShoreGameMode gameMode = ShoreGameMode.TUTORIAL;
	private int countdown = 5;
	private int tickCount = 0;
	protected int tilesInRow = 16;
	private ArrayList<ArrayList<ShoreTile>> tiles;
	protected int tilesInColumn = 12;
	private int tileHeight = 50;
	private int tileWidth = 50;
	private boolean buildDefense;
	
	
	public ShoreModel(){
		this.gameMode = ShoreGameMode.TUTORIAL;
		this.items = new ArrayList<ShoreItem>();
		this.defenses = new ArrayList<ShoreDefense>();
		this.boats = new ArrayList<ShoreBoat>();
		this.waves = new ArrayList<ShoreWave>();
		this.wavesToRemove = new ArrayList<ShoreWave>();
		this.inventory = new HashMap<ShoreItemType, Integer>();
		this.buildDefense = false;
		defenseWall = new ShoreDefenseType("Sea Wall");
		defensePlacementArea(defenseWall);
		defenseGabion = new ShoreDefenseType("Gabion");
		defensePlacementArea(defenseGabion);
		defensePlant = new ShoreDefenseType("Plant");
		defensePlacementArea(defensePlant);
		boatSailboat = new ShoreBoatType("Sailboat", 1, .3);
		boatJetSki = new ShoreBoatType("Jet Ski", 3, .2);
		boatCommercial = new ShoreBoatType("Commercial", 1, .5);
		itemRock = new ShoreItemType("Rock");
		itemRock.setBuildsDefense(defenseWall);
		itemOyster = new ShoreItemType("Oyster");
		itemOyster.setBuildsDefense(defenseGabion);
		itemSeed = new ShoreItemType("Seed");
		itemSeed.setBuildsDefense(defensePlant);
		inventory.put(itemRock, 0);
		inventory.put(itemOyster, 0);
		inventory.put(itemSeed, 0);
		savedDefenseType = new ShoreDefenseType("Sea Wall");
		tiles = new ArrayList<ArrayList<ShoreTile>>();
		for (int i = 0; i < tilesInRow; i++){
			tiles.add(new ArrayList<ShoreTile>());
			for (int j = 0; j < tilesInColumn; j++){
				tiles.get(i).add(new ShoreTile(tileWidth, tileHeight, new ShorePosition(i*tileWidth,j*tileHeight)));
				//tiles[i][j] = new ShoreTile(tileSize, tileSize, new ShorePosition(i*tileSize,j*tileSize));
				if(j <= tilesInColumn/2){
					tiles.get(i).get(j).setTileType(ShoreTileType.OCEAN);
					tiles.get(i).get(j).setVacant(false);
				} 
				else { 
					tiles.get(i).get(j).setTileType(ShoreTileType.BEACH);
					tiles.get(i).get(j).setVacant(true);
				}
					
			}
		}
		ShoreDefense startDefense1 = new ShoreDefense(tiles.get(2).get((tilesInColumn/2)+1),defenseWall);
		ShoreDefense startDefense2 = new ShoreDefense(tiles.get(7).get((tilesInColumn/2)+1),defenseWall);
		ShoreDefense startDefense3 = new ShoreDefense(tiles.get(12).get((tilesInColumn/2)+1),defenseWall);
		tiles.get(2).get((tilesInColumn/2)+1).setTileContents(startDefense1);
		tiles.get(7).get((tilesInColumn/2)+1).setTileContents(startDefense2);
		tiles.get(12).get((tilesInColumn/2)+1).setTileContents(startDefense3);
		defenses.add(startDefense1);
		defenses.add(startDefense2);
		defenses.add(startDefense3);
		ShoreItem toolbar1 = new ShoreItem(tiles.get(0).get(0), itemRock);
		ShoreItem toolbar2 = new ShoreItem(tiles.get(2).get(0), itemOyster);
		ShoreItem toolbar3 = new ShoreItem(tiles.get(4).get(0), itemSeed);
		items.add(toolbar1);
		items.add(toolbar2);
		items.add(toolbar3);
		ShoreItem startItem1 = new ShoreItem(tiles.get(4).get(8),itemOyster);
		ShoreItem startItem2 = new ShoreItem(tiles.get(9).get(9),itemSeed);
		tiles.get(4).get(8).setTileContents(startItem1);
		tiles.get(9).get(9).setTileContents(startItem2);
		items.add(startItem1);
		items.add(startItem2);
		ShoreBoat startBoat = new ShoreBoat(tiles.get(0).get(1), 0, boatSailboat);
		boats.add(startBoat);
	}
	
	public ShoreBoatType getBoatSailboat() {
		return boatSailboat;
	}

	public void setBoatSailboat(ShoreBoatType boatSailboat) {
		this.boatSailboat = boatSailboat;
	}

	public ShoreBoatType getBoatJetSki() {
		return boatJetSki;
	}

	public void setBoatJetSki(ShoreBoatType boatJetSki) {
		this.boatJetSki = boatJetSki;
	}

	public ShoreBoatType getBoatCommercial() {
		return boatCommercial;
	}

	public void setBoatCommercial(ShoreBoatType boatCommercial) {
		this.boatCommercial = boatCommercial;
	}

	public boolean isBuildDefense() {
		return buildDefense;
	}

	public void setBuildDefense(boolean buildDefense) {
		this.buildDefense = buildDefense;
	}

	public ArrayList<ShoreBoat> getBoats() {
		return boats;
	}

	public void setBoats(ArrayList<ShoreBoat> boats) {
		this.boats = boats;
	}

	public ArrayList<ShoreWave> getWaves() {
		return waves;
	}

	public void setWaves(ArrayList<ShoreWave> waves) {
		this.waves = waves;
	}

	
	public ArrayList<ShoreItem> getItems() {
		return items;
	}

	public void setItems(ArrayList<ShoreItem> items) {
		this.items = items;
	}
	
	public ShoreItemType getItemRock() {
		return itemRock;
	}

	public void setItemRock(ShoreItemType itemRock) {
		this.itemRock = itemRock;
	}

	public ShoreItemType getItemOyster() {
		return itemOyster;
	}

	public void setItemOyster(ShoreItemType itemOyster) {
		this.itemOyster = itemOyster;
	}

	public ShoreItemType getItemSeed() {
		return itemSeed;
	}

	public void setItemSeed(ShoreItemType itemSeed) {
		this.itemSeed = itemSeed;
	}

	public HashMap<ShoreItemType, Integer> getInventory() {
		return inventory;
	}

	public void setInventory(HashMap<ShoreItemType, Integer> inventory) {
		this.inventory = inventory;
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

	public int getTileHeight() {
		return tileHeight;
	}

	public void setTileHeight(int tileHeight) {
		this.tileHeight = tileHeight;
	}
	
	public int getTileWidth() {
		return tileWidth;
	}
	
	public void setTileWidth(int tileWidth) {
		this.tileWidth = tileWidth;
	}

	public void onTick(){ //updates position of moving objects
		for (int i = 0; i < tilesInRow; i++){
			for (int j = 0; j < tilesInColumn; j++){
				ShorePosition p = tiles.get(i).get(j).getTileOrigin();
				tiles.get(i).get(j).setTileOrigin(new ShorePosition(i*tileWidth,j*tileHeight));
				p = null;
			}
		}
		tickCount+=1;
			
		for(ShoreItem it: items){
			tiles.get((int) (it.getContainedWithin().getTileOrigin().getShoreX()/tileWidth)).
			get((int) (it.getContainedWithin().getTileOrigin().getShoreY()/tileHeight)).setTileContents(it);
			}
		//for (int j = 0; j < tilesInColumn; j++){
			//if(!tiles.get(i).get(j).isVacant() && tiles.get(i).get(j).getTileContents() != null){
		Random randItem = new Random();	
		ShoreItemType newItemType = null;
		if(tickCount % 100 == 0 && items.size() <= 8){
			int randItemX = randItem.nextInt(tilesInRow-1);
			int randItemY = randItem.nextInt((int)(tilesInColumn/6));
			switch(randItem.nextInt(3)){
				case 0:  newItemType = itemRock;
					break;
				case 1:  newItemType = itemOyster;
					break;
				case 2:	 newItemType = itemSeed;
					break;
			}
			if(tiles.get(randItemX).get((tilesInColumn-1)-randItemY).getTileContents() == null){
				ShoreItem newItem = new ShoreItem(tiles.get(randItemX).get((tilesInColumn-1) - randItemY), newItemType);
				items.add(newItem);
			}
		}
		ShoreBoatType newBoatType = null;
		int randBoatLoc = randItem.nextInt((int)((tilesInColumn*tileWidth)/2));
		if(boats.size() <= 1 && boats.get(0).getContainedWithin().getTileOrigin().getShoreX() >= ((tileWidth*tilesInRow*3)/4) + randBoatLoc){
			switch(randItem.nextInt(3)){
				case 0: newBoatType = boatSailboat;
					break;
				case 1: newBoatType = boatJetSki;
					break;
				case 2: newBoatType = boatCommercial;
					break;
			}
			//System.out.println(newBoatType.getName());
			ShoreBoat newBoat = new ShoreBoat(tiles.get(0).get(1),0, newBoatType);
			boats.add(newBoat);
		}
		Iterator<ShoreWave> waveIter = waves.iterator();
		while(waveIter.hasNext()){
			ShoreWave w = waveIter.next();
			handleWaveMovement(w, waveIter);
		}
		Iterator<ShoreBoat> boatIter = boats.iterator();
		while(boatIter.hasNext()){
			ShoreBoat b = boatIter.next();
			handleSailboat(b,boatIter);
//					if(b.getType() == boatSailboat){
//						handleSailboat(b, boatIter);
//					}
//					else if(b.getType() == boatJetSki){
//						handleJetSki(b, boatIter);
//					}
//					else if(b.getType() == boatCommercial){
//						handleCommercial(b, boatIter);
//					}
			}
		if(tickCount % 25 == 0){
			for(ShoreDefense d: defenses){
				if(d.getType() == defenseWall){
					shoreHealth -= .1;
				}
				else if(d.getType() == defenseGabion){
					shoreHealth += .2;
				}
				else if(d.getType() == defensePlant){
					shoreHealth += .05;
				}
			}
		}
		if(shoreHealth >= 100 || shoreHealth <= 0){
			Main.getInstance().setController(new MenuController());
		}
	}
	public void onClick(ShoreItem click){
		if(click.getContainedWithin().getTileOrigin().getShoreY() != 0){
			tiles.get((int) (click.getContainedWithin().getTileOrigin().getShoreX()/tileWidth))
			.get((int) (click.getContainedWithin().getTileOrigin().getShoreY()/tileHeight)).setTileContents(null);
			tiles.get((int) (click.getContainedWithin().getTileOrigin().getShoreX()/tileWidth))
			.get((int) (click.getContainedWithin().getTileOrigin().getShoreY()/tileHeight)).setVacant(true);
			items.remove(click);	
			inventory.put(click.getType(), inventory.get(click.getType())+1);
			click = null;
		}
		else if(click.getContainedWithin().getTileOrigin().getShoreY() == 0){ //toolbar click
			if(click.getType() == itemRock){
				savedDefenseType = defenseWall;
			}
			else if(click.getType() == itemOyster){
				savedDefenseType = defenseGabion;
			}
			else if(click.getType() == itemSeed){
				savedDefenseType = defensePlant;
			}
			setBuildDefense(true);
		}
		click = null;
	}
	
	public void buildDefense(int tileRow, int tileCol){
		ShoreItemType itemType;
		if (savedDefenseType == defenseWall){
			itemType = itemRock;
		}
		else if (savedDefenseType == defenseGabion){
			itemType = itemOyster;
		}
		else {
			itemType = itemSeed;
		}
		if (inventory.get(itemType) >= savedDefenseType.getNumItemsRequired()){
			Object o = tiles.get(tileRow).get(tileCol).getTileContents();
			if(o instanceof ShoreDefense){
				defenses.remove(o);
			}
			else if(o instanceof ShoreItem){
				items.remove(o);
			}
			o = null;
			ShoreDefense d = new ShoreDefense(tiles.get(tileRow).get(tileCol), savedDefenseType);
			tiles.get(tileRow).get(tileCol).setTileContents(d);
			defenses.add(d);
			setBuildDefense(false);
			inventory.put(itemType, inventory.get(itemType)-savedDefenseType.getNumItemsRequired());
			//savedDefenseType = null;
		}
	}
	public void defensePlacementArea(ShoreDefenseType d){
		if(d.getName() == "Gabion") { //gabions go in two tiles nearest to ocean
			d.setPlacementZoneStartY(((tilesInColumn*tileHeight)/2)+1);
			d.setPlacementZoneEndY(((tilesInColumn*tileHeight)/2)+1);
		}
		else if (d.getName() == "Plant"){ //plants go in lowest 2 tiles
			d.setPlacementZoneStartY((tilesInColumn*tileHeight)- (2*tileHeight)); 
			d.setPlacementZoneEndY(tilesInColumn*tileHeight);
		}
	}
	public void handleJetSki(ShoreBoat b, Iterator boatIter){ 
		/*
		int waveStrength = 1;
		if(b.getWaveTile() == -1){
			genWaveTile(b);
		}
		b.getboatPos().setShoreX(b.getboatPos().getShoreX() + tileWidth);
		int i = (int)((b.getboatPos().getShoreX())/tileWidth);
		int j = (int)((b.getboatPos().getShoreY())/tileHeight);
		tiles.get(i).get(j).setTileContents(b);
		tiles.get(i).get(j).setVacant(false);
		if(i>0){
		tiles.get(i-1).get(j).setTileContents(null);
		tiles.get(i-1).get(j).setVacant(true);
		}
		if (i == b.getWaveTile()){
			ShorePosition p1 = new ShorePosition(0,0);
			p1.setShoreX(b.getboatPos().getShoreX());
			p1.setShoreY(b.getboatPos().getShoreY() + tileHeight);
			ShorePosition p2 = new ShorePosition(p1.getShoreX() + tileWidth,p1.getShoreY());
			ShorePosition p3 = new ShorePosition(p1.getShoreX() - tileWidth,p1.getShoreY());
			if(i+1 < tilesInRow){
				ShoreWave w2 = new ShoreWave(p2, waveStrength);
				tiles.get(i+1).get(j+1).setTileContents(w2);
				tiles.get(i+1).get(j+1).setVacant(false);
			}
			if(i-1 >= 0){
				ShoreWave w3 = new ShoreWave(p3, waveStrength);
				tiles.get(i-1).get(j+1).setTileContents(w3);
				tiles.get(i-1).get(j+1).setVacant(false);
			}
		}
		if(i >= tilesInRow-1){
			boatIter.remove();
			b = null;
		}*/
	}
	public void handleSailboat(ShoreBoat b, Iterator boatIter){
		double wakeStrength = .1;
		b.setXDisplacement((int)(b.getXDisplacement()+(b.getType().getSpeed()*(tileWidth/30))));
		if(b.getXDisplacement() >= tileWidth){
			int i = (int)((b.getContainedWithin().getTileOrigin().getShoreX()+tileWidth)/tileWidth);
			b.setXDisplacement(0);
			b.setContainedWithin(tiles.get(i).get(1));
			tiles.get(i).get(1).setTileContents(b);
			tiles.get(i).get(1).setVacant(false);
			if(i>0){
				tiles.get(i-1).get(1).setTileContents(null);
				tiles.get(i-1).get(1).setVacant(true);
				ShoreWave wave = new ShoreWave(tiles.get(i-1).get(2),0,b.getType().getShoreHealthEffect());
				waves.add(wave);
				tiles.get(i).get(2).setTileContents(wave);
				tiles.get(i).get(2).setVacant(false);
			}
			if(i >= tilesInRow-1){
				boatIter.remove();
				b = null;
			}
		}
	}
	public void handleCommercial(ShoreBoat b, Iterator boatIter){
		/*
		int waveStrength = 3;
		if(b.getWaveTile() == -1){
			genWaveTile(b);
		}
		b.getboatPos().setShoreX(b.getboatPos().getShoreX() + tileWidth);
		int i = (int)((b.getboatPos().getShoreX())/tileWidth);
		int j = (int)((b.getboatPos().getShoreY())/tileHeight);
		tiles.get(i).get(j).setTileContents(b);
		tiles.get(i).get(j).setVacant(false);
		if(i>0){
		tiles.get(i-1).get(j).setTileContents(null);
		tiles.get(i-1).get(j).setVacant(true);
		}
		if (i == b.getWaveTile()){
			ShorePosition p1 = new ShorePosition(0,0);
			p1.setShoreX(b.getboatPos().getShoreX());
			p1.setShoreY(b.getboatPos().getShoreY() + tileHeight);
			ShorePosition p2 = new ShorePosition(p1.getShoreX() + tileWidth,p1.getShoreY());
			ShorePosition p3 = new ShorePosition(p1.getShoreX() - tileWidth,p1.getShoreY());
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
		if(i >= tilesInRow-1){
			boatIter.remove();
			b = null;
		}
		*/
	}
	/**
	 * @author Chris Bellotti and Alvin Tang
	 * This method will create the wave tile when the boat reaches a random position
	 * @param b   the ShoreBoat that the method is using
	 * @see ShoreWave
	 * @see ShoreBoat
	 * @see ShoreTile
	 */
	public void handleWaveMovement(ShoreWave w, Iterator waveIter){
		w.setYDisplacement((int) (w.getYDisplacement()+(tileWidth/30)));
		int i = (int)(w.getContainedWithin().getTileOrigin().getShoreX()/tileWidth);
		int j = (int)(w.getContainedWithin().getTileOrigin().getShoreY()/tileHeight);
		if(w.getYDisplacement() >= tileHeight){
			w.setYDisplacement(0);
			w.setContainedWithin(tiles.get(i).get(j+1));
			tiles.get(i).get(j).setTileContents(null);
			tiles.get(i).get(j).setVacant(true);
			if(w.getContainedWithin().getTileOrigin().getShoreY() < (tilesInColumn*tileHeight)/2){ //&& tiles.get(i).get(j).getTileType() != ShoreTileType.DAMAGED){
				tiles.get(i).get(j+1).setTileContents(w);
				tiles.get(i).get(j+1).setVacant(false);
			}
			else if(w.getContainedWithin().getTileOrigin().getShoreY() >= (tilesInColumn*tileHeight)/2){
				//== ShoreTileType.BEACH || tiles.get(i).get(j).getTileType() == ShoreTileType.DAMAGED){
				handleWaveCollision(w, waveIter);
			}
		}
	}
	public void handleWaveCollision(ShoreWave w, Iterator waveIter){
		int i = (int)((w.getContainedWithin().getTileOrigin().getShoreX())/tileWidth);
		int j = (int)((w.getContainedWithin().getTileOrigin().getShoreY())/tileHeight);
		if(tiles.get(i).get(j+1).getTileContents() instanceof ShoreDefense){
			Object o = tiles.get(i).get(j+1).getTileContents();
			double d = ((ShoreDefense)o).getDefenseDurability();
			if(d - w.getWaveStrength() > 0){
				((ShoreDefense)o).setDefenseDurability(d - w.getWaveStrength());
			}
			else{
				defenses.remove(o);
				o = null;
				tiles.get(i).get(j+1).setTileContents(null);
				tiles.get(i).get(j+1).setVacant(true);
			}
		}
		else{
			tiles.get(i).get(j+1).setTileContents(null);
			tiles.get(i).get(j+1).setVacant(true);
			if(tiles.get(i).get(j+1).getTileType() == ShoreTileType.BEACH){
				shoreHealth -= w.getWaveStrength();
				//tiles.get(i).get(j+1).setTileType(ShoreTileType.DAMAGED);
			}
			//else if(tiles.get(i).get(j+1).getTileType() == ShoreTileType.DAMAGED){
				//shoreHealth -= (w.getWaveStrength() + 5);
			//}
		}
		waveIter.remove();
		w = null;
	}
	
	public void countdown(){
		this.countdown -= 1;
	}
   
	public ShoreDefenseType getDefenseWall() {
		return defenseWall;
	}

	public void setDefenseWall(ShoreDefenseType defenseWall) {
		this.defenseWall = defenseWall;
	}

	public ShoreDefenseType getDefenseGabion() {
		return defenseGabion;
	}

	public void setDefenseGabion(ShoreDefenseType defenseGabion) {
		this.defenseGabion = defenseGabion;
	}

	public ShoreDefenseType getDefensePlant() {
		return defensePlant;
	}

	public void setDefensePlant(ShoreDefenseType defensePlant) {
		this.defensePlant = defensePlant;
	}

	public ArrayList<ShoreDefense> getDefenses() {
		return defenses;
	}

	public void setDefenses(ArrayList<ShoreDefense> defenses) {
		this.defenses = defenses;
	}
	
}

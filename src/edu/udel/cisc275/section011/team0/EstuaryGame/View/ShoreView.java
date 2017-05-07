package edu.udel.cisc275.section011.team0.EstuaryGame.View;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.udel.cisc275.section011.team0.EstuaryGame.Model.ShoreBoat;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.ShoreDefense;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.ShoreItem;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.ShoreModel;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.ShorePosition;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.ShoreTile;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.ShoreTileType;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.ShoreWave;

public class ShoreView extends JComponent {

	private ShoreModel model;
	private ArrayList<ArrayList<ShoreTile>> modelTiles;
	
	private BufferedImage healthGaugeImg;
	
	private BufferedImage rockItemImg;
	private BufferedImage oysterItemImg;
	private BufferedImage seedItemImg;
	private BufferedImage wallDefenseImg;
	private BufferedImage gabionDefenseImg;
	private BufferedImage plantDefenseImg;
	private BufferedImage waveImg;
	private BufferedImage jetSkiImg;
	private BufferedImage sailboatImg;
	private BufferedImage commercialBoatImg;
	
	
	
	private BufferedImage beachTileImg;
	private BufferedImage damagedTileImg;
	private BufferedImage oceanTileImg;
	
	private BufferedImage toolbarImg;
	
	private Rectangle timerRect;
		
	
	public ShoreView(ShoreModel model){
		this.model = model;
		this.modelTiles = model.getTiles();
		//ShoreItem r1 = new ShoreItem(new ShorePosition(10,10), model.getItemRock());
		try {
			beachTileImg = ImageIO.read(new File("Final Images/Backgrounds/tile_sand_center.png"));
			damagedTileImg = ImageIO.read(new File("Final Images/Backgrounds/tile_dirt_north.png"));
			oceanTileImg = ImageIO.read(new File("Final Images/Backgrounds/tile_water_C.png"));
			rockItemImg = ImageIO.read(new File("Final Images/Animals/food_pellet.png"));
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//toolbarImg = new BufferedImage(model.getGameWidth(),model.getGameHeight()/20,BufferedImage.TYPE_INT_RGB);
	}
	
	private Color redYellowGreenGradient(double percent) {
		float hue = (float) (percent * (1.0 / 3.0));
	    return Color.getHSBColor(hue, 1.0f, 1.0f);
	}
	
	public void renderShore(Graphics g, int screen_width, int screen_height){
		int TILE_WIDTH = (int) (screen_width/model.getTilesInRow());
		int TILE_HEIGHT = (int) (screen_height/model.getTilesInColumn());
		BufferedImage img = null;
		model.setTileHeight(TILE_HEIGHT);
		model.setTileWidth(TILE_WIDTH);
		for (int i = 0, x = 0; i < model.getTilesInRow(); i++, x+= TILE_WIDTH){
			for (int j = 0, y = 0; j < model.getTilesInColumn(); j++, y+= TILE_HEIGHT){
				ShoreTileType type = modelTiles.get(i).get(j).getTileType();
				if(type == ShoreTileType.BEACH ){
					img = beachTileImg;
				}
				else if(type == ShoreTileType.OCEAN){
					img = oceanTileImg;
				}
				else if(type == ShoreTileType.DAMAGED){
					img = damagedTileImg;
				}
			
				g.drawImage(img, x, y, x+TILE_WIDTH, y+TILE_HEIGHT
				, 0, 0, 256, 256, null);
			}
		}	
	}	
	
	public void paint(Graphics g){
		//screen size
		final int SCREEN_WIDTH = getWidth();
		final int SCREEN_HEIGHT = getHeight();
		//tiles
		final int TILE_WIDTH = (int) (SCREEN_WIDTH/16);
		final int TILE_HEIGHT = (int) (SCREEN_HEIGHT/12);
		//toolbar size & color
		final int TOOLBAR_HEIGHT = TILE_HEIGHT;
		final int TOOLBAR_WIDTH = SCREEN_WIDTH;
		final Color TOOLBAR_COLOR = Color.GRAY;
		//shore health bar
		final int SHORE_HEALTH_BAR_HEIGHT = TOOLBAR_HEIGHT;
		final int SHORE_HEALTH_BAR_WIDTH = SCREEN_WIDTH/4;
		final Color SHORE_HEALTH_BAR_COLOR = Color.WHITE;
		//shore health level
		final double SHORE_HEALTH_LEVEL_PERCENT = model.getShoreHealth();
		final int SHORE_HEALTH_LEVEL_HEIGHT = SHORE_HEALTH_BAR_HEIGHT;
		final int SHORE_HEALTH_LEVEL_WIDTH = SHORE_HEALTH_BAR_WIDTH;
		final Color SHORE_HEALTH_LEVEL_COLOR = Color.RED;
		//rock item
		final int ROCK_ITEM_HEIGHT = (TOOLBAR_HEIGHT/2);
		final int ROCK_ITEM_WIDTH = ROCK_ITEM_HEIGHT;
		final Integer ROCK_ITEM_AMOUNT = model.getInventory().get(model.getItemRock());
		final Color ROCK_ITEM_COLOR = Color.BLACK;
		//oyster item
		final int OYSTER_ITEM_HEIGHT = ROCK_ITEM_HEIGHT;
		final int OYSTER_ITEM_WIDTH = ROCK_ITEM_WIDTH;
		final Integer OYSTER_ITEM_AMOUNT = model.getInventory().get(model.getItemOyster());
		final Color OYSTER_ITEM_COLOR = Color.LIGHT_GRAY;
		//seed item
		final int SEED_ITEM_HEIGHT = ROCK_ITEM_HEIGHT;
		final int SEED_ITEM_WIDTH = ROCK_ITEM_WIDTH;
		final Integer SEED_ITEM_AMOUNT = model.getInventory().get(model.getItemSeed());
		final Color SEED_ITEM_COLOR = Color.GREEN;
		//wall defense
		final int WALL_DEF_HEIGHT = TILE_HEIGHT;
		final int WALL_DEF_WIDTH = TILE_WIDTH;
		final Color WALL_DEF_COLOR = Color.DARK_GRAY;
		//gabion defense
		final int GABION_DEF_HEIGHT = TILE_HEIGHT;
		final int GABION_DEF_WIDTH = TILE_WIDTH;
		final Color GABION_DEF_COLOR = Color.WHITE;
		//plant defense
		final int PLANT_DEF_HEIGHT = TILE_HEIGHT;
		final int PLANT_DEF_WIDTH = TILE_WIDTH;
		final Color PLANT_DEF_COLOR = Color.GREEN;
		//wave
		final int WAVE_HEIGHT = TILE_HEIGHT;
		final int WAVE_WIDTH = TILE_WIDTH;
		final Color WAVE_COLOR = Color.CYAN;
		//boat
		final int BOAT_HEIGHT = TILE_HEIGHT;
		final int BOAT_WIDTH = TILE_WIDTH;
		final Color BOAT_COLOR = Color.BLACK;
		
		//draw tiles
		renderShore(g,SCREEN_WIDTH,SCREEN_HEIGHT);
		
		//draw toolbar
		g.setColor(TOOLBAR_COLOR);
		g.drawRect(0, 0, TOOLBAR_WIDTH, TOOLBAR_HEIGHT);
		g.fillRect(0, 0, TOOLBAR_WIDTH, TOOLBAR_HEIGHT);
		//draw shore health bar
		g.setColor(SHORE_HEALTH_BAR_COLOR);
		g.drawRect((SCREEN_WIDTH/2)+(SHORE_HEALTH_BAR_WIDTH/2) , 0
				, SHORE_HEALTH_BAR_WIDTH, SHORE_HEALTH_BAR_HEIGHT);
		g.fillRect((SCREEN_WIDTH/2)+(SHORE_HEALTH_BAR_WIDTH/2) , 0
				, SHORE_HEALTH_BAR_WIDTH, SHORE_HEALTH_BAR_HEIGHT);
		//draw shore health level
		g.setColor(SHORE_HEALTH_LEVEL_COLOR);
		g.drawRect((SCREEN_WIDTH/2)+(SHORE_HEALTH_BAR_WIDTH/2), 0 
				,(int) (SHORE_HEALTH_BAR_WIDTH * (SHORE_HEALTH_LEVEL_PERCENT/100))
				, SHORE_HEALTH_LEVEL_HEIGHT);
		g.fillRect((SCREEN_WIDTH/2)+(SHORE_HEALTH_BAR_WIDTH/2), 0 
				,(int) (SHORE_HEALTH_BAR_WIDTH * (SHORE_HEALTH_LEVEL_PERCENT/100))
				, SHORE_HEALTH_LEVEL_HEIGHT);
		//g.setColor(ROCK_ITEM_COLOR);
		//g.drawRect(200, 200, ROCK_ITEM_WIDTH, ROCK_ITEM_HEIGHT);
		//g.fillRect(200, 200, ROCK_ITEM_WIDTH,  ROCK_ITEM_HEIGHT);
		//paintComponent(g);
		//draw items
		
		for (ShoreItem it: model.getItems()){
			if (it.getType() == model.getItemRock()){
				g.setColor(ROCK_ITEM_COLOR);
				g.drawRect((int) (it.getContainedWithin().getTileOrigin().getShoreX()+(model.getTileWidth()/4)),(int) 
						(it.getContainedWithin().getTileOrigin().getShoreY()+(model.getTileHeight()/4)),  ROCK_ITEM_WIDTH,  ROCK_ITEM_HEIGHT);
				g.fillRect((int) (it.getContainedWithin().getTileOrigin().getShoreX()+(model.getTileWidth()/4)),(int) 
						(it.getContainedWithin().getTileOrigin().getShoreY()+(model.getTileHeight()/4)),  ROCK_ITEM_WIDTH,  ROCK_ITEM_HEIGHT);
			}
			else if (it.getType() == model.getItemOyster()){
				g.setColor(OYSTER_ITEM_COLOR);
				g.drawRect((int) (it.getContainedWithin().getTileOrigin().getShoreX()+(model.getTileWidth()/4)),(int) 
						(it.getContainedWithin().getTileOrigin().getShoreY()+(model.getTileHeight()/4)),  OYSTER_ITEM_WIDTH,  OYSTER_ITEM_HEIGHT);
				g.fillRect((int) (it.getContainedWithin().getTileOrigin().getShoreX()+(model.getTileWidth()/4)),(int) 
						(it.getContainedWithin().getTileOrigin().getShoreY()+(model.getTileHeight()/4)),  OYSTER_ITEM_WIDTH,  OYSTER_ITEM_HEIGHT);
			}
			else if (it.getType() == model.getItemSeed()){
				g.setColor(SEED_ITEM_COLOR);
				g.drawRect((int) (it.getContainedWithin().getTileOrigin().getShoreX()+(model.getTileWidth()/4)),(int) 
						(it.getContainedWithin().getTileOrigin().getShoreY()+(model.getTileHeight()/4)),  SEED_ITEM_WIDTH,  SEED_ITEM_HEIGHT);
				g.fillRect((int) (it.getContainedWithin().getTileOrigin().getShoreX()+(model.getTileWidth()/4)),(int) 
						(it.getContainedWithin().getTileOrigin().getShoreY()+(model.getTileHeight()/4)),  SEED_ITEM_WIDTH,  SEED_ITEM_HEIGHT);
			}
		}//draw defenses
		for (ShoreDefense def: model.getDefenses()){
			if (def.getType() == model.getDefenseWall()){
				g.setColor(WALL_DEF_COLOR);
				g.drawRect((int) (def.getContainedWithin().getTileOrigin().getShoreX()),(int) (def.getContainedWithin().getTileOrigin().getShoreY())
						, WALL_DEF_WIDTH, WALL_DEF_HEIGHT);
				g.fillRect((int) (def.getContainedWithin().getTileOrigin().getShoreX()),(int) (def.getContainedWithin().getTileOrigin().getShoreY())
						, WALL_DEF_WIDTH, WALL_DEF_HEIGHT);
			}
			else if (def.getType() == model.getDefenseGabion()){
				g.setColor(GABION_DEF_COLOR);
				g.drawRect((int) (def.getContainedWithin().getTileOrigin().getShoreX()),(int) (def.getContainedWithin().getTileOrigin().getShoreY())
						, GABION_DEF_WIDTH, GABION_DEF_HEIGHT);
				g.fillRect((int) (def.getContainedWithin().getTileOrigin().getShoreX()),(int) (def.getContainedWithin().getTileOrigin().getShoreY())
						, GABION_DEF_WIDTH, GABION_DEF_HEIGHT);
			}
			else if (def.getType() == model.getDefensePlant()){
				g.setColor(PLANT_DEF_COLOR);
				g.drawRect((int) (def.getContainedWithin().getTileOrigin().getShoreX()),(int) (def.getContainedWithin().getTileOrigin().getShoreY())
						, PLANT_DEF_WIDTH, PLANT_DEF_HEIGHT);
				g.fillRect((int) (def.getContainedWithin().getTileOrigin().getShoreX()),(int) (def.getContainedWithin().getTileOrigin().getShoreY())
						, PLANT_DEF_WIDTH, PLANT_DEF_HEIGHT);
			}
		}//draw boats
		for (ShoreBoat b: model.getBoats()){
			g.setColor(BOAT_COLOR);
			g.drawRect( (int)(b.getContainedWithin().getTileOrigin().getShoreX() + b.getXDisplacement()),(int)(b.getContainedWithin().getTileOrigin().getShoreY())
					, BOAT_WIDTH, BOAT_HEIGHT);
			//System.out.println((int) (SCREEN_SCALE_WIDTH*(b.getboatPos().getShoreX())));
			g.fillRect( (int)(b.getContainedWithin().getTileOrigin().getShoreX() + b.getXDisplacement()),(int)(b.getContainedWithin().getTileOrigin().getShoreY())
					, BOAT_WIDTH, BOAT_HEIGHT);
		}
		//draw waves
		for (ShoreWave w: model.getWaves()){
			g.setColor(WAVE_COLOR);
			g.drawRect((int) (w.getContainedWithin().getTileOrigin().getShoreX()),(int) (w.getContainedWithin().getTileOrigin().getShoreY() + w.getYDisplacement())
					, WAVE_WIDTH, WAVE_HEIGHT);
			g.fillRect((int) (w.getContainedWithin().getTileOrigin().getShoreX()),(int) (w.getContainedWithin().getTileOrigin().getShoreY() + w.getYDisplacement())
					, WAVE_WIDTH, WAVE_HEIGHT);
		}
		//model.getItems().remove(r1);
	}
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
//		int SCREEN_HEIGHT = getHeight();
//		int SCREEN_WIDTH = getWidth();
//		final int ROCK_ITEM_HEIGHT = (SCREEN_HEIGHT/12) * (4/5);
//		final int ROCK_ITEM_WIDTH = ROCK_ITEM_HEIGHT;
//		final Integer ROCK_ITEM_AMOUNT = model.getInventory().get(model.getItemRock());
//		//g.drawImage(rockItemImg, 200, 200, 200 + ROCK_ITEM_WIDTH, 200 + ROCK_ITEM_HEIGHT , 0, 0, 129, 129, this);
//		g.drawImage(rockItemImg, 200, 200, null);
	}
}

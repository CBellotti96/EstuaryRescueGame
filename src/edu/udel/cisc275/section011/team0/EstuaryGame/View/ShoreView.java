package edu.udel.cisc275.section011.team0.EstuaryGame.View;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
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
	private BufferedImage oceanTileImg[];
	private double oceanTileImageIndex = 0;
	private final int OCEAN_TILE_IMAGE_FRAME_COUNT = 15;
	
	private BufferedImage toolbarImg;
	
	private Rectangle timerRect;
		
	
	public ShoreView(ShoreModel model){
		this.model = model;
		this.modelTiles = model.getTiles();
		//ShoreItem r1 = new ShoreItem(new ShorePosition(10,10), model.getItemRock());
		try {
			beachTileImg = ImageIO.read(new File("Final Images/Backgrounds/tile_sand_center.png"));
			damagedTileImg = ImageIO.read(new File("Final Images/Backgrounds/tile_dirt_north.png"));
			oceanTileImg = new BufferedImage[OCEAN_TILE_IMAGE_FRAME_COUNT];
			BufferedImage oceanTileImgFull = ImageIO.read(new File("Final Images/Backgrounds/water_tile.png"));
			for (int i = 0; i < OCEAN_TILE_IMAGE_FRAME_COUNT; i++) {
				oceanTileImg[i] = oceanTileImgFull.getSubimage(i * model.getTileWidth(), 0, 
						model.getTileWidth(), model.getTileHeight());
			}
			//oceanTileImg = ImageIO.read(new File("Final Images/Backgrounds/tile_water_C.png"));
			rockItemImg = ImageIO.read(new File("Final Images/Animals/food_pellet.png"));
			oysterItemImg = ImageIO.read(new File("Final Images/Animals/clam_back_0.png"));
			seedItemImg = ImageIO.read(new File("Final Images/Plants/seed.png"));
			wallDefenseImg = ImageIO.read(new File("Final Images/UI Buttons, Icons, Symbols/Dialogue2.png"));
			gabionDefenseImg = ImageIO.read(new File("Final Images/Objects/net(1).png"));
			plantDefenseImg = ImageIO.read(new File("Final Images/Plants/milkweed_good.png"));
			waveImg = ImageIO.read(new File("Final Images/Objects/wave.png"));
			jetSkiImg = ImageIO.read(new File("Final Images/Objects/hotrod_vessel.png"));
			sailboatImg = ImageIO.read(new File("Final Images/Objects/cleanvessel.png"));
			commercialBoatImg = ImageIO.read(new File("Final Images/Objects/vessel.png"));
			
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
					g.drawImage(beachTileImg, x, y, x+TILE_WIDTH, y+TILE_HEIGHT
							, 0, 0, 256, 256, null);
				}
				else if(type == ShoreTileType.OCEAN){
					g.drawImage(oceanTileImg[(int) oceanTileImageIndex], x, y,
							TILE_WIDTH, TILE_HEIGHT, null);
				}
				//else if(type == ShoreTileType.DAMAGED){
					//img = damagedTileImg;
				//}
			}
		}
		oceanTileImageIndex = (oceanTileImageIndex + 0.05) % OCEAN_TILE_IMAGE_FRAME_COUNT;
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
		final BufferedImage ROCK_ITEM_IMAGE = rockItemImg;
		final int ROCK_ITEM_HEIGHT = (TOOLBAR_HEIGHT/2);
		final int ROCK_ITEM_WIDTH = ROCK_ITEM_HEIGHT;
		final Integer ROCK_ITEM_AMOUNT = model.getInventory().get(model.getItemRock());
		//oyster item
		final BufferedImage OYSTER_ITEM_IMAGE = oysterItemImg;
		final int OYSTER_ITEM_HEIGHT = ROCK_ITEM_HEIGHT;
		final int OYSTER_ITEM_WIDTH = ROCK_ITEM_WIDTH;
		final Integer OYSTER_ITEM_AMOUNT = model.getInventory().get(model.getItemOyster());
		//seed item
		final BufferedImage SEED_ITEM_IMAGE = seedItemImg;
		final int SEED_ITEM_HEIGHT = ROCK_ITEM_HEIGHT;
		final int SEED_ITEM_WIDTH = ROCK_ITEM_WIDTH;
		final Integer SEED_ITEM_AMOUNT = model.getInventory().get(model.getItemSeed());
		//wall defense
		final BufferedImage WALL_DEF_IMAGE = wallDefenseImg;
		final int WALL_DEF_HEIGHT = TILE_HEIGHT;
		final int WALL_DEF_WIDTH = TILE_WIDTH;
		//gabion defense
		final BufferedImage GABION_DEF_IMAGE = gabionDefenseImg;
		final int GABION_DEF_HEIGHT = TILE_HEIGHT;
		final int GABION_DEF_WIDTH = TILE_WIDTH;
		//plant defense
		final BufferedImage PLANT_DEF_IMAGE = plantDefenseImg;
		final int PLANT_DEF_HEIGHT = TILE_HEIGHT;
		final int PLANT_DEF_WIDTH = TILE_WIDTH;
		//wave
		final BufferedImage WAVE_IMAGE = waveImg;
		final int WAVE_HEIGHT = TILE_HEIGHT;
		final int WAVE_WIDTH = TILE_WIDTH;
		//boat
		final BufferedImage SAILBOAT_IMAGE = sailboatImg;
		final BufferedImage JETSKI_IMAGE = jetSkiImg;
		final BufferedImage COMMERCIAL_IMAGE = commercialBoatImg;
		final int BOAT_HEIGHT = TILE_HEIGHT;
		final int BOAT_WIDTH = TILE_WIDTH*2;
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
			if (it.getType() == model.itemRock){
				g.drawImage(ROCK_ITEM_IMAGE,(int) (it.getContainedWithin().getTileOrigin().getShoreX()+(model.getTileWidth()/4)),(int) 
						(it.getContainedWithin().getTileOrigin().getShoreY()+(model.getTileHeight()/4)),  ROCK_ITEM_WIDTH,  ROCK_ITEM_HEIGHT,null);
			}
			else if (it.getType() == model.itemOyster){
				g.drawImage(OYSTER_ITEM_IMAGE,(int) (it.getContainedWithin().getTileOrigin().getShoreX()+(model.getTileWidth()/4)),(int) 
						(it.getContainedWithin().getTileOrigin().getShoreY()+(model.getTileHeight()/4)),  OYSTER_ITEM_WIDTH,  OYSTER_ITEM_HEIGHT,null);
			}
			else if (it.getType() == model.itemSeed){
				g.drawImage(SEED_ITEM_IMAGE,(int) (it.getContainedWithin().getTileOrigin().getShoreX()+(model.getTileWidth()/4)),(int) 
						(it.getContainedWithin().getTileOrigin().getShoreY()+(model.getTileHeight()/4)),  SEED_ITEM_WIDTH,  SEED_ITEM_HEIGHT,null);
			}
		}//draw defenses
		for (ShoreDefense def: model.getDefenses()){
			if (def.getType() == model.defenseWall){
				g.drawImage(WALL_DEF_IMAGE,(int) (def.getContainedWithin().getTileOrigin().getShoreX()),(int) (def.getContainedWithin().getTileOrigin().getShoreY())
						, WALL_DEF_WIDTH, WALL_DEF_HEIGHT,null);
			}
			else if (def.getType() == model.defenseGabion){
				g.drawImage(GABION_DEF_IMAGE,(int) (def.getContainedWithin().getTileOrigin().getShoreX()),(int) (def.getContainedWithin().getTileOrigin().getShoreY())
						, GABION_DEF_WIDTH, GABION_DEF_HEIGHT,null);
			}
			else if (def.getType() == model.defensePlant){
				g.drawImage(PLANT_DEF_IMAGE,(int) (def.getContainedWithin().getTileOrigin().getShoreX()),(int) (def.getContainedWithin().getTileOrigin().getShoreY())
						, PLANT_DEF_WIDTH, PLANT_DEF_HEIGHT,null);
			}
		}//draw boats
		for (ShoreBoat b: model.getBoats()){
			if (b.getType() == model.boatSailboat){
				g.drawImage(SAILBOAT_IMAGE,(int)(b.getContainedWithin().getTileOrigin().getShoreX() + b.getXDisplacement()),(int)(b.getContainedWithin().getTileOrigin().getShoreY())
					, BOAT_WIDTH, BOAT_HEIGHT,null);
			}
			else if (b.getType() == model.boatJetSki){
				g.drawImage(JETSKI_IMAGE,(int)(b.getContainedWithin().getTileOrigin().getShoreX() + b.getXDisplacement()),(int)(b.getContainedWithin().getTileOrigin().getShoreY())
					, BOAT_WIDTH, BOAT_HEIGHT,null);
			}
			else if (b.getType() == model.boatCommercial){
				g.drawImage(COMMERCIAL_IMAGE,(int)(b.getContainedWithin().getTileOrigin().getShoreX() + b.getXDisplacement()),(int)(b.getContainedWithin().getTileOrigin().getShoreY())
					, BOAT_WIDTH, BOAT_HEIGHT,null);
			}
		}
		//draw waves
		for (ShoreWave w: model.getWaves()){
			g.drawImage(WAVE_IMAGE,(int) (w.getContainedWithin().getTileOrigin().getShoreX()),(int) (w.getContainedWithin().getTileOrigin().getShoreY() + w.getYDisplacement())
					, WAVE_WIDTH, WAVE_HEIGHT,null);
		}
		//draw inventory ints
		String s1 = ROCK_ITEM_AMOUNT.toString();
		String s2 = OYSTER_ITEM_AMOUNT.toString();
		String s3 = SEED_ITEM_AMOUNT.toString();
		g.drawString(s1, (int)(model.getTileWidth() - model.getTileWidth()/4), (int) (model.getTileHeight()/(3/2)));
		g.drawString(s2, (int)(model.getTileWidth()*3 - model.getTileWidth()/4), (int) (model.getTileHeight()/(3/2)));
		g.drawString(s3, (int)(model.getTileWidth()*5 - model.getTileWidth()/4), (int) (model.getTileHeight()/(3/2)));
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

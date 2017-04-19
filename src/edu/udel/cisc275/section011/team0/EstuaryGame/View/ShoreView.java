package edu.udel.cisc275.section011.team0.EstuaryGame.View;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import edu.udel.cisc275.section011.team0.EstuaryGame.Model.ShoreModel;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.ShoreTile;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.ShoreTileType;

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
	
	/*
	public Color tileColor(ShoreTileType t){
		switch(t) {
		case BEACH: return Color.YELLOW;
		case OCEAN: return Color.BLUE;
		case DAMAGED: return Color.BLACK;
		default: return Color.DARK_GRAY;
		}
	}	
	*/	
	
	
	
	public ShoreView(ShoreModel model){
		this.model = model;
		this.modelTiles = model.getTiles();
		try {
			beachTileImg = ImageIO.read(new File("Final Images/Backgrounds/sand_tile.jpg"));
			damagedTileImg = ImageIO.read(new File("Final Images/Backgrounds/tile_dirt_north.png"));
			oceanTileImg = ImageIO.read(new File("Final Images/Backgrounds/tile_water_C.png"));
			sailboatImg = ImageIO.read(new File("Final Images/Objects/cleanvessel.png"));
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
		BufferedImage img = null;
		for (int i = 0, x = 0; i < model.getTilesInRow(); i++, x+= model.getTileSize()){
			for (int j = 0, y = 0; j < model.getTilesInColumn(); j++, y+= model.getTileSize()){
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
			
				g.drawImage(img, x, y, x+model.getTileSize(), y+model.getTileSize()
				, 0, 0, 256, 256, null);
			}
		}	
	}	
	
	public void paint(Graphics g){
		//screen size
		final int SCREEN_WIDTH = getWidth();
		final int SCREEN_HEIGHT = getHeight();
		//toolbar size & color
		final int TOOLBAR_HEIGHT = SCREEN_HEIGHT/12;
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
	}
	
}

package edu.udel.cisc275.section011.team0.EstuaryGame.View;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

import edu.udel.cisc275.section011.team0.EstuaryGame.Model.ShoreModel;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.ShoreTile;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.ShoreTileType;

public class ShoreView extends JComponent {

	private ShoreModel model;
	private ShoreTile[][] modelTiles;
	
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
		//load images
		//toolbarImg = new BufferedImage(model.getGameWidth(),model.getGameHeight()/20,BufferedImage.TYPE_INT_RGB);
	}
	
	public void renderShore(Graphics g){
		for (int i = 0, x = 0; i < model.getTilesInRow(); i++, x+= model.getTileSize()){
			for (int j = 0, y = 0; j < model.getTilesInColumn(); j++, y+= model.getTileSize()){
				ShoreTileType type = modelTiles[i][j].getTileType();
				if(type == ShoreTileType.BEACH ){
					g.setColor(Color.YELLOW);
				}
				else if(type == ShoreTileType.OCEAN){
					g.setColor(Color.BLUE);
				}
				else if(type == ShoreTileType.DAMAGED){
					g.setColor(Color.BLACK);
				}
			}		
		}
		
	}	
	
	public void paint(Graphics g){
		return;
	}
	
}

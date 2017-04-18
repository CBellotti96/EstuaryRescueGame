package edu.udel.cisc275.section011.team0.EstuaryGame.View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

import edu.udel.cisc275.section011.team0.EstuaryGame.Model.MazeCrab;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.MazeModel;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.MazeWeather;

public class MazeView extends JComponent {
	
	private MazeModel model;
	
	private BufferedImage salineGaugeBgImg;
	
	private BufferedImage sunWeatherIconImg;
	private BufferedImage rainWeatherIconImg;
	
	private Rectangle timerRect;
	
	private BufferedImage miniMapImg;
	
	private BufferedImage crabImg;
	private BufferedImage predatorImg[];
	private BufferedImage obstacleImage[];
	
	private BufferedImage sandTileImg;
	private BufferedImage waterTileImg;
	
	public MazeView(MazeModel model) {
		this.model = model;
		// TODO load images
		miniMapImg = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
	}
	
	private Color redYellowGreenGradient(double percent) {
		float hue = (float) (percent * (1.0 / 3.0));
	    return Color.getHSBColor(hue, 1.0f, 1.0f);
	}
	
	private Color weatherColor(MazeWeather weather) {
		switch (weather) {
		case SUN: return Color.YELLOW;
		case RAIN: return Color.CYAN;
		default: return Color.BLACK;
		}
	}
	
	private void renderMazeAndEntities(Graphics g, int screenWidth, 
			int screenHeight, double zoom) {
		MazeCrab player = model.getPlayer();
		
		// draw maze
		int unit = (int) (zoom * screenWidth / 10);
		int centerOffsetX = screenWidth / 2 - unit / 2;
		int centerOffsetY = screenHeight / 2 - unit / 2;
		for (int x = 0, i = 0; x < screenWidth; x += unit, i++) {
			for (int y = 0, j = 0; y < screenHeight; y += unit, j++) {
				if (i % 2 == 0 && j % 2 == 0) {
					g.setColor(Color.ORANGE);
				} else if (i % 2 == 0 && j % 2 == 1) {
					g.setColor(Color.BLUE);
				} else if (i % 2 == 1 && j % 2 == 0) {
					g.setColor(Color.BLUE);
				} else if (i % 2 == 1 && j % 2 == 1) {
					g.setColor(Color.ORANGE);
				}
				
				//g.drawRect(x, y, unit, unit);
				//g.fillRect(x, y, unit, unit);
				g.drawRect(x - (int) (player.getXPos() * unit) + centerOffsetX, 
						y - (int) (player.getYPos() * unit) + centerOffsetY, 
						unit, unit);
				g.fillRect(x - (int) (player.getXPos() * unit) + centerOffsetX, 
						y - (int) (player.getYPos() * unit) + centerOffsetY, 
						unit, unit);
			}
		}
		
		// draw player
		g.setColor(Color.RED);
		//g.drawRect((int) (player.getXPos() * unit), (int) (player.getYPos() * unit), unit, unit);
		//g.fillRect((int) (player.getXPos() * unit), (int) (player.getYPos() * unit), unit, unit);
		g.drawRect(centerOffsetX, centerOffsetY, unit, unit);
		g.fillRect(centerOffsetX, centerOffsetY, unit, unit);
		
	}
	
	@Override
	public void paint(Graphics g){
		// screen dimensions
		final int SCREEN_WIDTH = getWidth();
		final int SCREEN_HEIGHT = getHeight();
		
		// saline gauge dimensions and colors
		final int SALINE_GAUGE_HEIGHT = SCREEN_HEIGHT / 4;
		final int SALINE_GAUGE_WIDTH = SALINE_GAUGE_HEIGHT / 3;
		final int SALINE_GAUGE_MARGIN = SALINE_GAUGE_WIDTH / 4;
		final Color SALINE_GAUGE_COLOR = Color.GRAY;
		
		// saline level dimensions and colors
		final double salinePercent = (model.getSalinity() - model.getMinSalinity()) 
				/ (model.getMaxSalinity() - model.getMinSalinity());
		final int SALINE_LEVEL_MARGIN = SALINE_GAUGE_WIDTH / 4;
		final int SALINE_LEVEL_WIDTH = SALINE_GAUGE_WIDTH / 2;
		final int SALINE_LEVEL_HEIGHT = (int) (salinePercent 
				* (SALINE_GAUGE_HEIGHT - SALINE_LEVEL_MARGIN * 2));
		final Color SALINE_LEVEL_COLOR = redYellowGreenGradient(salinePercent);
		
		// weather icon dimensions and colors
		final int WEATHER_ICON_WIDTH = SALINE_GAUGE_WIDTH;
		final int WEATHER_ICON_HEIGHT = WEATHER_ICON_WIDTH;
		final int WEATHER_ICON_MARGIN = SALINE_GAUGE_MARGIN;
		final Color WEATHER_ICON_COLOR = weatherColor(model.getWeather());
		
		// mini-map dimensions
		final int MINI_MAP_MARGIN = SALINE_GAUGE_MARGIN;
		final int MINI_MAP_WIDTH = Math.min(SCREEN_WIDTH, SCREEN_HEIGHT) / 4;
		final int MINI_MAP_HEIGHT = MINI_MAP_WIDTH;
		final Color MINI_MAP_BORDER_COLOR = Color.GRAY;
		
		// draw game
		renderMazeAndEntities(g, SCREEN_WIDTH, SCREEN_HEIGHT, 1.0);
		
		// draw mini-map
		Graphics2D miniMapImgGraphics = miniMapImg.createGraphics();
		renderMazeAndEntities(miniMapImgGraphics, 
				miniMapImg.getWidth(), miniMapImg.getHeight(), 0.5);
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		g.drawImage(miniMapImg, SCREEN_WIDTH - (MINI_MAP_WIDTH + MINI_MAP_MARGIN), 
				SCREEN_HEIGHT - (MINI_MAP_HEIGHT + MINI_MAP_MARGIN), 
				MINI_MAP_WIDTH, MINI_MAP_HEIGHT, null);
		miniMapImgGraphics.dispose();
		g.setColor(MINI_MAP_BORDER_COLOR);
		g.drawRect(SCREEN_WIDTH - (MINI_MAP_WIDTH + MINI_MAP_MARGIN), 
				SCREEN_HEIGHT - (MINI_MAP_HEIGHT + MINI_MAP_MARGIN), 
				MINI_MAP_WIDTH, MINI_MAP_HEIGHT);
		
		
		// draw saline gauge
		g.setColor(SALINE_GAUGE_COLOR);
		g.drawRect(SCREEN_WIDTH - (SALINE_GAUGE_WIDTH + SALINE_GAUGE_MARGIN), 
				SALINE_GAUGE_MARGIN, SALINE_GAUGE_WIDTH, SALINE_GAUGE_HEIGHT);
		g.fillRect(SCREEN_WIDTH - (SALINE_GAUGE_WIDTH + SALINE_GAUGE_MARGIN), 
				SALINE_GAUGE_MARGIN, SALINE_GAUGE_WIDTH, SALINE_GAUGE_HEIGHT);
		
		// draw saline level on gauge
		g.setColor(SALINE_LEVEL_COLOR);
		g.drawRect(SCREEN_WIDTH - (SALINE_GAUGE_WIDTH + SALINE_GAUGE_MARGIN) + SALINE_LEVEL_MARGIN, 
				(SALINE_GAUGE_HEIGHT + SALINE_GAUGE_MARGIN) - SALINE_LEVEL_MARGIN - SALINE_LEVEL_HEIGHT, 
				SALINE_LEVEL_WIDTH, SALINE_LEVEL_HEIGHT);
		g.fillRect(SCREEN_WIDTH - (SALINE_GAUGE_WIDTH + SALINE_GAUGE_MARGIN) + SALINE_LEVEL_MARGIN, 
				(SALINE_GAUGE_HEIGHT + SALINE_GAUGE_MARGIN) - SALINE_LEVEL_MARGIN - SALINE_LEVEL_HEIGHT, 
				SALINE_LEVEL_WIDTH, SALINE_LEVEL_HEIGHT);
		
		// draw weather icon
		g.setColor(WEATHER_ICON_COLOR);
		g.drawRect(SCREEN_WIDTH - (WEATHER_ICON_WIDTH + WEATHER_ICON_MARGIN), 
				SALINE_GAUGE_HEIGHT + SALINE_GAUGE_MARGIN + WEATHER_ICON_MARGIN, 
				WEATHER_ICON_WIDTH, WEATHER_ICON_HEIGHT);
		g.fillRect(SCREEN_WIDTH - (WEATHER_ICON_WIDTH + WEATHER_ICON_MARGIN), 
				SALINE_GAUGE_HEIGHT + SALINE_GAUGE_MARGIN + WEATHER_ICON_MARGIN, 
				WEATHER_ICON_WIDTH, WEATHER_ICON_HEIGHT);
	}
	
}

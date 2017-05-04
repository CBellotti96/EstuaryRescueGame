package edu.udel.cisc275.section011.team0.EstuaryGame.View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.Console;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import edu.udel.cisc275.section011.team0.EstuaryGame.Model.MazeCrab;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.MazeModel;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.MazeSection;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.MazeWeather;

public class MazeView extends JComponent {
	
	private MazeModel model;
	
	private BufferedImage salineGaugeBgImg;
	
	private BufferedImage sunWeatherIconImg;
	private BufferedImage rainWeatherIconImg;
	private BufferedImage defaultWeatherIconImg;
	
	
	private Rectangle timerRect;
	
	private BufferedImage miniMapImg;
	
	private BufferedImage crabImg;
	private BufferedImage predatorImg[];
	private BufferedImage obstacleImage[];
	
	private BufferedImage sandTileImg;
	private BufferedImage waterTileImg;
	
	public MazeView(MazeModel model){
		this.model = model;
		// TODO load images
		miniMapImg = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
		try {
			initializeWeatherIcon("./Final Images/Environment Misc/sunnyWeather.png", sunWeatherIconImg);
			initializeWeatherIcon("./Final Images/Environment Misc/rainyWeather.png", rainWeatherIconImg);
			initializeWeatherIcon("./Final Images/Environment Misc/variableWeather.png", defaultWeatherIconImg);
		}catch(IOException e){			
			e.printStackTrace();
			System.out.println("Image load failed");
			
		}
	}
	
	private void initializeWeatherIcon(String filePath, BufferedImage iconName) throws IOException{
		//Graphics2D iconGraphics = iconName.createGraphics();
		File file = new File(filePath);
		if (false == file.exists()){
			System.out.println(filePath + " failed to load");
			throw new IOException();
		}
		else{
			iconName = ImageIO.read(file);
		}
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
	
	private BufferedImage weatherIcon(MazeWeather weather){
		switch (weather){
		case SUN: return sunWeatherIconImg;
		case RAIN: return rainWeatherIconImg;
		default: return defaultWeatherIconImg;
		}
	}
	
	private void renderMazeAndEntities(Graphics g, int screenWidth, 
			int screenHeight, double zoom) {
		MazeCrab player = model.getPlayer();
		
		// draw maze
		final int TILE_SIZE = (int) (zoom * screenWidth / 10);
		final int PLAYER_SIZE = TILE_SIZE / 2;
		final int centerOffsetX = screenWidth / 2 - PLAYER_SIZE / 2;
		final int centerOffsetY = screenHeight / 2 - PLAYER_SIZE / 2;
		/*for (int x = 0, i = 0; x < screenWidth; x += unit, i++) {
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
		}*/
		g.setColor(Color.BLUE);
		g.drawRect(0, 0, screenWidth, screenHeight);
		g.fillRect(0, 0, screenWidth, screenHeight);
		MazeSection section = model.getCurrentSection();
		g.setColor(Color.ORANGE);
		for (int y = 0; y < section.getHeight(); y++) {
			for (int x = 0; x < section.getWidth(); x++) {
				if ((section.getCell(y, x) & MazeSection.W) == 0) {
					g.drawLine((int) ((x - player.getXPos()) * TILE_SIZE) + centerOffsetX,
							(int) ((y - player.getYPos()) * TILE_SIZE) + centerOffsetY, 
							(int) ((x - player.getXPos()) * TILE_SIZE) + centerOffsetX, 
							(int) ((y - player.getYPos()) * TILE_SIZE) + centerOffsetY + TILE_SIZE);
				}
				if ((section.getCell(y, x) & MazeSection.E) == 0) {
					g.drawLine((int) ((x - player.getXPos()) * TILE_SIZE) + centerOffsetX + TILE_SIZE,
							(int) ((y - player.getYPos()) * TILE_SIZE) + centerOffsetY, 
							(int) ((x - player.getXPos()) * TILE_SIZE) + centerOffsetX + TILE_SIZE, 
							(int) ((y - player.getYPos()) * TILE_SIZE) + centerOffsetY + TILE_SIZE);
				}
				if ((section.getCell(y, x) & MazeSection.N) == 0) {
					g.drawLine((int) ((x - player.getXPos()) * TILE_SIZE) + centerOffsetX,
							(int) ((y - player.getYPos()) * TILE_SIZE) + centerOffsetY, 
							(int) ((x - player.getXPos()) * TILE_SIZE) + centerOffsetX + TILE_SIZE, 
							(int) ((y - player.getYPos()) * TILE_SIZE) + centerOffsetY);
				}
				if ((section.getCell(y, x) & MazeSection.S) == 0) {
					g.drawLine((int) ((x - player.getXPos()) * TILE_SIZE) + centerOffsetX,
							(int) ((y - player.getYPos()) * TILE_SIZE) + centerOffsetY + TILE_SIZE, 
							(int) ((x - player.getXPos()) * TILE_SIZE) + centerOffsetX + TILE_SIZE, 
							(int) ((y - player.getYPos()) * TILE_SIZE) + centerOffsetY + TILE_SIZE);
				}
				/*g.setColor(Color.GREEN);
				if ((section.getCell(y, x) & MazeSection.EXIT) != 0) {
					g.fillRect((int) ((x - player.getXPos()) * TILE_SIZE) + centerOffsetX,
							(int) ((y - player.getYPos()) * TILE_SIZE) + centerOffsetY, 
							TILE_SIZE, 
							TILE_SIZE);
				}
				g.setColor(Color.PINK);
				if ((section.getCell(y, x) & MazeSection.ENTRANCE) != 0) {
					g.fillRect((int) ((x - player.getXPos()) * TILE_SIZE) + centerOffsetX,
							(int) ((y - player.getYPos()) * TILE_SIZE) + centerOffsetY, 
							TILE_SIZE, 
							TILE_SIZE);
				}*/
			}
			
		}
		
		// draw player
		g.setColor(Color.RED);
		//g.drawRect(centerOffsetX, centerOffsetY, PLAYER_SIZE, PLAYER_SIZE);
		//g.fillRect(centerOffsetX, centerOffsetY, PLAYER_SIZE, PLAYER_SIZE);
		g.drawOval(centerOffsetX, centerOffsetY, PLAYER_SIZE, PLAYER_SIZE);
		g.fillOval(centerOffsetX, centerOffsetY, PLAYER_SIZE, PLAYER_SIZE);
		
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
		final int SALINE_LEVEL_HEIGHT = (int) (salinePercent /*(1 - salinePercent) // FOR BLUE CRAB MODE*/ 
				* (SALINE_GAUGE_HEIGHT - SALINE_LEVEL_MARGIN * 2));
		final Color SALINE_LEVEL_COLOR = redYellowGreenGradient(salinePercent);
		
		// weather icon dimensions and colors
		final int WEATHER_ICON_WIDTH = SALINE_GAUGE_WIDTH;
		final int WEATHER_ICON_HEIGHT = WEATHER_ICON_WIDTH;
		final int WEATHER_ICON_MARGIN = SALINE_GAUGE_MARGIN;
		final Color WEATHER_ICON_COLOR = weatherColor(model.getWeather());
		final BufferedImage WEATHER_ICON = weatherIcon(model.getWeather());
		
		// mini-map dimensions
		final int MINI_MAP_MARGIN = SALINE_GAUGE_MARGIN;
		final int MINI_MAP_WIDTH = Math.min(SCREEN_WIDTH, SCREEN_HEIGHT) / 4;
		final int MINI_MAP_HEIGHT = MINI_MAP_WIDTH;
		final Color MINI_MAP_BORDER_COLOR = Color.GRAY;
		
		// draw game
		renderMazeAndEntities(g, SCREEN_WIDTH, SCREEN_HEIGHT, 2.0);
		
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
		
		/* here there be bugs
		Graphics2D weatherIconGraphics = WEATHER_ICON.createGraphics();
		renderMazeAndEntities(weatherIconGraphics, 
				WEATHER_ICON.getWidth(), WEATHER_ICON.getHeight(), 1.0);
		g.drawImage(WEATHER_ICON, SCREEN_WIDTH - (WEATHER_ICON_WIDTH + WEATHER_ICON_MARGIN), 
				SALINE_GAUGE_HEIGHT + SALINE_GAUGE_MARGIN + WEATHER_ICON_MARGIN, 
				WEATHER_ICON_WIDTH, WEATHER_ICON_HEIGHT, null);
		*/
	}
	
}

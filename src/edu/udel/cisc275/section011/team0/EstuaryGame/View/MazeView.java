package edu.udel.cisc275.section011.team0.EstuaryGame.View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.Console;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import edu.udel.cisc275.section011.team0.EstuaryGame.Model.Direction;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.MazeCrab;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.MazeGameMode;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.MazeModel;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.MazeObstacle;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.MazeObstacleType;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.MazePredator;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.MazeSection;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.MazeWeather;

public class MazeView extends JComponent {
	
	private MazeModel model;
	
	private final double SCREEN_ZOOM = 2.0;
	
	private BufferedImage salinityGaugeBgImg;
	
	private BufferedImage sunWeatherIconImg;
	private BufferedImage rainWeatherIconImg;
	private BufferedImage defaultWeatherIconImg;
	
	
	private Rectangle timerRect;
	
	private BufferedImage miniMapImg;
	private BufferedImage miniMapBorder;
	private final int MINIMAP_BORDER_CENTER_WIDTH = 227;
	private final int MINIMAP_BORDER_FULL_WIDTH = 256;
	private final double MIMIMAP_ZOOM = 0.8;
	
	private BufferedImage crabImg[];
	private double crabImgIndex = 0;
	private final int CRAB_IMG_FRAME_COUNT = 3;
	private final int CRAB_IMG_FRAME_WIDTH = 243;
	private final int CRAB_IMG_FRAME_HEIGHT = 119;
	
	private BufferedImage predatorImg;
	private BufferedImage obstacleImage[];
	
	private BufferedImage sandbarImg[];
	private final int SANDBAR_IMG_COUNT = Direction.NORTH.getFlag() 
			+ Direction.EAST.getFlag()
			+ Direction.SOUTH.getFlag()
			+ Direction.WEST.getFlag() + 1;
	private final int SANDBAR_IMG_SIZE = 64;
	
	private BufferedImage waterTileImg[];
	private double waterTileImgIndex = 0;
	private final int WATER_TILE_IMG_FRAME_COUNT = 15;
	private final int WATER_TILE_IMG_FRAME_SIZE = 64;
	
	private BufferedImage tutorialImg;
	private BufferedImage sectionImg[];
	private BufferedImage winImg;
	
	public MazeView(MazeModel model){
		this.model = model;

		miniMapImg = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
		
		try {
			crabImg = new BufferedImage[CRAB_IMG_FRAME_COUNT];
			BufferedImage crabImgFull = ImageIO.read(new File("Final Images/Animals/bluecrab.png"));
			for (int i = 0; i < CRAB_IMG_FRAME_COUNT; i++) {
				crabImg[i] = crabImgFull.getSubimage(i * CRAB_IMG_FRAME_WIDTH, 0, 
						CRAB_IMG_FRAME_WIDTH, CRAB_IMG_FRAME_HEIGHT);
			}
			
			obstacleImage = new BufferedImage[MazeObstacleType.values().length];
			obstacleImage[MazeObstacleType.SEAWEED.ordinal()] = ImageIO.read(new File("Final Images/Plants/seagrass.png"));
			obstacleImage[MazeObstacleType.TRASH.ordinal()] = ImageIO.read(new File("Final Images/Objects/crumbledpaper.png"));

			predatorImg = ImageIO.read(new File("Final Images/Animals/fish_bass_left.png"));
			
			salinityGaugeBgImg = ImageIO.read(new File("Final Images/UI Buttons, Icons, Symbols/salinity_gauge.png"));
			
			sunWeatherIconImg = ImageIO.read(new File("Final Images/Environment Misc/sunnyWeather.png"));
			rainWeatherIconImg = ImageIO.read(new File("Final Images/Environment Misc/rainyWeather.png"));
			defaultWeatherIconImg = ImageIO.read(new File("Final Images/Environment Misc/variableWeather.png"));
		
			waterTileImg = new BufferedImage[WATER_TILE_IMG_FRAME_COUNT];
			BufferedImage waterTileImgFull = ImageIO.read(new File("Final Images/Backgrounds/water_tile.png"));
			for (int i = 0; i < WATER_TILE_IMG_FRAME_COUNT; i++) {
				waterTileImg[i] = waterTileImgFull.getSubimage(i * WATER_TILE_IMG_FRAME_SIZE, 0, 
						WATER_TILE_IMG_FRAME_SIZE, WATER_TILE_IMG_FRAME_SIZE);
			}
			
			sandbarImg = new BufferedImage[SANDBAR_IMG_COUNT];
			sandbarImg[Direction.NORTH.getFlag() 
			           | Direction.EAST.getFlag() 
			           | Direction.SOUTH.getFlag()
			           | Direction.WEST.getFlag()] 
			        		   = ImageIO.read(new File("Final Images/Objects/sandbar_north_east_south_west.png"));
			sandbarImg[Direction.NORTH.getFlag() 
			           | Direction.EAST.getFlag() 
			           | Direction.SOUTH.getFlag()] 
			        		   = ImageIO.read(new File("Final Images/Objects/sandbar_north_east_south.png"));
			sandbarImg[Direction.EAST.getFlag() 
			           | Direction.SOUTH.getFlag()
			           | Direction.WEST.getFlag()] 
			        		   = ImageIO.read(new File("Final Images/Objects/sandbar_east_south_west.png"));
			sandbarImg[Direction.NORTH.getFlag() 
			           | Direction.SOUTH.getFlag()
			           | Direction.WEST.getFlag()] 
			        		   = ImageIO.read(new File("Final Images/Objects/sandbar_north_south_west.png"));
			sandbarImg[Direction.NORTH.getFlag() 
			           | Direction.EAST.getFlag() 
			           | Direction.WEST.getFlag()] 
			        		   = ImageIO.read(new File("Final Images/Objects/sandbar_north_east_west.png"));
			sandbarImg[Direction.NORTH.getFlag() 
			           | Direction.SOUTH.getFlag()] 
			        		   = ImageIO.read(new File("Final Images/Objects/sandbar_north_south.png"));
			sandbarImg[Direction.EAST.getFlag() 
			           | Direction.WEST.getFlag()] 
			        		   = ImageIO.read(new File("Final Images/Objects/sandbar_east_west.png"));
			sandbarImg[Direction.NORTH.getFlag() 
			           | Direction.EAST.getFlag()] 
			        		   = ImageIO.read(new File("Final Images/Objects/sandbar_north_east.png"));
			sandbarImg[Direction.EAST.getFlag() 
			           | Direction.SOUTH.getFlag()] 
			        		   = ImageIO.read(new File("Final Images/Objects/sandbar_east_south.png"));
			sandbarImg[Direction.SOUTH.getFlag()
			           | Direction.WEST.getFlag()] 
			        		   = ImageIO.read(new File("Final Images/Objects/sandbar_south_west.png"));
			sandbarImg[Direction.NORTH.getFlag() 
			           | Direction.WEST.getFlag()] 
			        		   = ImageIO.read(new File("Final Images/Objects/sandbar_north_west.png"));
			sandbarImg[Direction.NORTH.getFlag()] 
			        		   = ImageIO.read(new File("Final Images/Objects/sandbar_north.png"));
			sandbarImg[Direction.EAST.getFlag()] 
			        		   = ImageIO.read(new File("Final Images/Objects/sandbar_east.png"));
			sandbarImg[Direction.SOUTH.getFlag()] 
			        		   = ImageIO.read(new File("Final Images/Objects/sandbar_south.png"));
			sandbarImg[Direction.WEST.getFlag()] 
	        		   = ImageIO.read(new File("Final Images/Objects/sandbar_west.png"));
			sandbarImg[0] = ImageIO.read(new File("Final Images/Objects/sandbar_none.png"));
			
			miniMapBorder = ImageIO.read(new File("Final Images/UI Buttons, Icons, Symbols/minimap_border.png"));
		
			tutorialImg = ImageIO.read(new File("Final Images/UI Buttons, Icons, Symbols/mazekeysinfo1.png"));
			sectionImg = new BufferedImage[] {
					ImageIO.read(new File("Final Images/UI Buttons, Icons, Symbols/stage1.png")),
					ImageIO.read(new File("Final Images/UI Buttons, Icons, Symbols/stage2.png")),
					ImageIO.read(new File("Final Images/UI Buttons, Icons, Symbols/stage3.png")),
			};
			winImg = ImageIO.read(new File("Final Images/UI Buttons, Icons, Symbols/winscr.png"));
			
		} catch(IOException e) {			
			e.printStackTrace();
		}
	}
	
	private Color redYellowGreenGradient(double percent) {
		float hue = (float) (percent * (1.0 / 3.0));
	    return Color.getHSBColor(hue, 1.0f, 1.0f);
	}
	
	private BufferedImage weatherIcon(MazeWeather weather){
		switch (weather){
		case SUN: return sunWeatherIconImg;
		case RAIN: return rainWeatherIconImg;
		default: return defaultWeatherIconImg;
		}
	}
	
	private void renderMazeAndEntities(Graphics g, int screenWidth, 
			int screenHeight, double zoom, boolean minimap) {
		MazeCrab player = model.getPlayer();
		
		// draw maze
		final int TILE_SIZE = (int) (zoom * screenWidth / 10);
		final int PLAYER_SIZE = TILE_SIZE / 2;
		final int centerOffsetX = screenWidth / 2 - PLAYER_SIZE / 2;
		final int centerOffsetY = screenHeight / 2 - PLAYER_SIZE / 2;
		final int WATER_TILE_SIZE = minimap ? WATER_TILE_IMG_FRAME_SIZE : TILE_SIZE;
		for (int x = 0, i = 0; x < screenWidth + WATER_TILE_SIZE; x += WATER_TILE_SIZE, i++) {
			for (int y = 0, j = 0; y < screenHeight + WATER_TILE_SIZE; y += WATER_TILE_SIZE, j++) {
				g.drawImage(waterTileImg[(int) waterTileImgIndex], x, y,
						WATER_TILE_SIZE, WATER_TILE_SIZE, null);
			}
		}
		waterTileImgIndex = (waterTileImgIndex + 0.05) % WATER_TILE_IMG_FRAME_COUNT;

		MazeSection section = model.getCurrentSection();
		for (int y = 0; y <= section.getHeight(); y++) {
			for (int x = 0; x <= section.getWidth(); x++) {
				int directions = 0;
				if (y > 0 && (x > 0 && (section.getCell(y - 1, x - 1) & MazeSection.E) == 0
						|| x < section.getWidth() && (section.getCell(y - 1, x) & MazeSection.W) == 0)) {
					directions += Direction.NORTH.getFlag();
				}
				if (x > 0 && (y > 0 && (section.getCell(y - 1, x - 1) & MazeSection.S) == 0
						|| y < section.getHeight() && (section.getCell(y, x - 1) & MazeSection.N) == 0)) {
					directions += Direction.WEST.getFlag();
				}
				if (y < section.getHeight() && (x > 0 && (section.getCell(y, x - 1) & MazeSection.E) == 0
						|| x < section.getWidth() && (section.getCell(y, x) & MazeSection.W) == 0)) {
					directions += Direction.SOUTH.getFlag();
				}
				if (x < section.getWidth() && (y > 0 && (section.getCell(y - 1, x) & MazeSection.S) == 0
						|| y < section.getHeight() && (section.getCell(y, x) & MazeSection.N) == 0)) {
					directions += Direction.EAST.getFlag();
				}
				
				// don't draw walls outside frame
				final int TILE_X = (int) ((x - player.getXPos()) * TILE_SIZE) + centerOffsetX - TILE_SIZE / 2;
				final int TILE_Y = (int) ((y - player.getYPos()) * TILE_SIZE) + centerOffsetY - TILE_SIZE / 2;
				if (TILE_X > 0 - TILE_SIZE
						&& TILE_X < screenWidth
						&& TILE_Y > 0 - TILE_SIZE
						&& TILE_Y < screenHeight) {
					g.drawImage(sandbarImg[directions], 
							TILE_X, TILE_Y, TILE_SIZE, TILE_SIZE, null);
				}
			}
		}
		
		
		// draw obstacles
		for (MazeObstacle obstacle : model.getCurrentSection().getObstacles()) {
			int OBSTACLE_X = (int) ((obstacle.getXPos() - player.getXPos()) * TILE_SIZE) + centerOffsetX;
			int OBSTACLE_Y = (int) ((obstacle.getYPos() - player.getYPos()) * TILE_SIZE) + centerOffsetY;
			if (minimap) {
				g.setColor(Color.YELLOW);
				g.drawOval(OBSTACLE_X, OBSTACLE_Y, PLAYER_SIZE, PLAYER_SIZE);
				g.fillOval(OBSTACLE_X, OBSTACLE_Y, PLAYER_SIZE, PLAYER_SIZE);
			} else {
				g.drawImage(obstacleImage[obstacle.getType().ordinal()], 
						OBSTACLE_X, OBSTACLE_Y, PLAYER_SIZE, PLAYER_SIZE, null);
			}
		}
		
		// draw player
		if (minimap) {
			g.setColor(Color.GREEN);
			g.drawOval(centerOffsetX, centerOffsetY, PLAYER_SIZE, PLAYER_SIZE);
			g.fillOval(centerOffsetX, centerOffsetY, PLAYER_SIZE, PLAYER_SIZE);
		} else {
			g.drawImage(crabImg[(int) crabImgIndex], centerOffsetX, centerOffsetY, PLAYER_SIZE, PLAYER_SIZE, null);
			crabImgIndex = (waterTileImgIndex + 0.1) % CRAB_IMG_FRAME_COUNT;
		}
		
		// draw predators
		for (MazePredator predator : model.getCurrentSection().getPredators()) {

			int PREDATOR_X = (int) ((predator.getXPos() - player.getXPos()) * TILE_SIZE) + centerOffsetX;
			int PREDATOR_Y = (int) ((predator.getYPos() - player.getYPos()) * TILE_SIZE) + centerOffsetY;
			if (minimap) {
				g.setColor(Color.RED);		
				g.drawOval(PREDATOR_X, PREDATOR_Y, PLAYER_SIZE, PLAYER_SIZE);
				g.fillOval(PREDATOR_X, PREDATOR_Y, PLAYER_SIZE, PLAYER_SIZE);
			} else {
				g.drawImage(predatorImg, PREDATOR_X, PREDATOR_Y, PLAYER_SIZE, PLAYER_SIZE, null);
			}
		}
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		// screen dimensions
		final int SCREEN_WIDTH = getWidth();
		final int SCREEN_HEIGHT = getHeight();
		
		// saline gauge dimensions and colors
		final int SALINE_GAUGE_HEIGHT = SCREEN_HEIGHT / 4;
		final int SALINE_GAUGE_WIDTH = SALINE_GAUGE_HEIGHT / 2;
		final int SALINE_GAUGE_MARGIN = SALINE_GAUGE_WIDTH / 4;
		final Color SALINE_GAUGE_COLOR = Color.GRAY;
		
		// saline level dimensions and colors
		final int SALINE_LEVEL_MARGIN = SALINE_GAUGE_WIDTH / 4;
		final int SALINE_LEVEL_WIDTH = SALINE_GAUGE_WIDTH / 2;
		final int SALINE_LEVEL_HEIGHT = (int) ((1 - model.getSalinityPercent()) /*saline // FOR BLUE CRAB MODE*/ 
				* (SALINE_GAUGE_HEIGHT - SALINE_LEVEL_MARGIN * 2));
		final Color SALINE_LEVEL_COLOR = redYellowGreenGradient(model.getSalinityPercent());
		
		// weather icon dimensions and colors
		final int WEATHER_ICON_WIDTH = SALINE_GAUGE_WIDTH;
		final int WEATHER_ICON_HEIGHT = WEATHER_ICON_WIDTH;
		final int WEATHER_ICON_MARGIN = SALINE_GAUGE_MARGIN;
		final BufferedImage WEATHER_ICON = weatherIcon(model.getWeather());
		
		// mini-map dimensions
		final int MINI_MAP_MARGIN = SALINE_GAUGE_MARGIN;
		final int MINI_MAP_WIDTH = Math.min(SCREEN_WIDTH, SCREEN_HEIGHT) / 4;
		final int MINI_MAP_HEIGHT = MINI_MAP_WIDTH;
		final Color MINI_MAP_BORDER_COLOR = Color.GRAY;
		
		final int MINIMAP_X = SCREEN_WIDTH - (MINI_MAP_WIDTH + MINI_MAP_MARGIN);
		final int MINIMAP_Y = SCREEN_HEIGHT - (MINI_MAP_HEIGHT + MINI_MAP_MARGIN);
		int MINIMAP_BORDER_WIDTH = MINI_MAP_WIDTH * MINIMAP_BORDER_FULL_WIDTH 
				/ MINIMAP_BORDER_CENTER_WIDTH;
		int MINIMAP_BORDER_HEIGHT = MINIMAP_BORDER_WIDTH;
		int MINIMAP_BORDER_X = MINIMAP_X - (MINIMAP_BORDER_WIDTH - MINI_MAP_WIDTH) /2;
		int MINIMAP_BORDER_Y = MINIMAP_Y - (MINIMAP_BORDER_HEIGHT - MINI_MAP_HEIGHT) /2;
		
		// draw game
		renderMazeAndEntities(g, SCREEN_WIDTH, SCREEN_HEIGHT, SCREEN_ZOOM, false);
		
		// draw mini-map
		Graphics2D miniMapImgGraphics = miniMapImg.createGraphics();
		renderMazeAndEntities(miniMapImgGraphics, 
				miniMapImg.getWidth(), miniMapImg.getHeight(), MIMIMAP_ZOOM, true);
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		g.drawImage(miniMapImg, SCREEN_WIDTH - (MINI_MAP_WIDTH + MINI_MAP_MARGIN), 
				SCREEN_HEIGHT - (MINI_MAP_HEIGHT + MINI_MAP_MARGIN), 
				MINI_MAP_WIDTH, MINI_MAP_HEIGHT, null);
		miniMapImgGraphics.dispose();
		g.setColor(MINI_MAP_BORDER_COLOR);
		g.drawRect(MINIMAP_X ,MINIMAP_Y, MINI_MAP_WIDTH, MINI_MAP_HEIGHT);
		
		g.drawImage(miniMapBorder, MINIMAP_BORDER_X, MINIMAP_BORDER_Y,
				MINIMAP_BORDER_WIDTH, MINIMAP_BORDER_HEIGHT, null);
		
		
		// draw saline level beneath gauge
		g.setColor(SALINE_LEVEL_COLOR);
		g.drawRect(SCREEN_WIDTH - (SALINE_GAUGE_WIDTH + SALINE_GAUGE_MARGIN) + SALINE_LEVEL_MARGIN, 
				(SALINE_GAUGE_HEIGHT + SALINE_GAUGE_MARGIN) - SALINE_LEVEL_MARGIN - SALINE_LEVEL_HEIGHT, 
				SALINE_LEVEL_WIDTH, SALINE_LEVEL_HEIGHT);
		g.fillRect(SCREEN_WIDTH - (SALINE_GAUGE_WIDTH + SALINE_GAUGE_MARGIN) + SALINE_LEVEL_MARGIN, 
				(SALINE_GAUGE_HEIGHT + SALINE_GAUGE_MARGIN) - SALINE_LEVEL_MARGIN - SALINE_LEVEL_HEIGHT, 
				SALINE_LEVEL_WIDTH, SALINE_LEVEL_HEIGHT);
		
		// draw saline gauge
		g.drawImage(salinityGaugeBgImg, SCREEN_WIDTH - (SALINE_GAUGE_WIDTH + SALINE_GAUGE_MARGIN), 
				SALINE_GAUGE_MARGIN, SALINE_GAUGE_WIDTH, SALINE_GAUGE_HEIGHT, null);
		
		// draw weather icon
		g.drawImage(WEATHER_ICON, SCREEN_WIDTH - (WEATHER_ICON_WIDTH + WEATHER_ICON_MARGIN), 
				SALINE_GAUGE_HEIGHT + SALINE_GAUGE_MARGIN + WEATHER_ICON_MARGIN, 
				WEATHER_ICON_WIDTH, WEATHER_ICON_HEIGHT, null);
	
		// draw tutorial
		if (model.getMode() == MazeGameMode.TUTORIAL) {
			g.drawImage(tutorialImg, SCREEN_WIDTH / 2 - tutorialImg.getWidth() / 2, 
					SCREEN_HEIGHT / 2 - tutorialImg.getHeight() / 2, 
					tutorialImg.getWidth(), tutorialImg.getWidth(), null);
		}
		
		if (model.getMode() == MazeGameMode.SECTION_CHANGE) {
			g.drawImage(sectionImg[model.getCurrentSectionIndex()], 
					SCREEN_WIDTH / 2 - tutorialImg.getWidth() / 2, 
					SCREEN_HEIGHT / 2 - tutorialImg.getHeight() / 2, 
					tutorialImg.getWidth(), tutorialImg.getWidth(), null);
		}
		
		if (model.getMode() == MazeGameMode.WIN_SCREEN) {
			g.drawImage(winImg, SCREEN_WIDTH / 2 - tutorialImg.getWidth() / 2, 
					SCREEN_HEIGHT / 2 - tutorialImg.getHeight() / 2, 
					tutorialImg.getWidth(), tutorialImg.getWidth(), null);
		}
		
		//win screen
		
	}
	
}

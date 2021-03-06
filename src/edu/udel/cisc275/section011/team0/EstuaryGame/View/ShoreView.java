package edu.udel.cisc275.section011.team0.EstuaryGame.View;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import edu.udel.cisc275.section011.team0.EstuaryGame.Model.ShoreBoat;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.ShoreDefense;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.ShoreGameMode;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.ShoreItem;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.ShoreModel;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.ShorePosition;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.ShoreTile;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.ShoreTileType;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.ShoreWave;
/**
 * @author Chris Bellotti
 * @author Alvin Tang
 * A ShoreView extends JPanel and displays the contents of the Shore Defense minigame
 */
public class ShoreView extends JPanel {

	private ShoreModel model;
	private ArrayList<ArrayList<ShoreTile>> modelTiles;
	
	private BufferedImage rockItemImg;
	private BufferedImage oysterItemImg;
	private BufferedImage seedItemImg;
	private BufferedImage wallDefenseImg;
	private BufferedImage gabionDefenseImg;
	private BufferedImage plantDefenseGoodImg;
	private BufferedImage plantDefenseBadImg;
	private BufferedImage waveImg;
	private BufferedImage jetSkiImg;
	private BufferedImage sailboatImg;
	private BufferedImage commercialBoatImg;
	private BufferedImage healthImg;
	private BufferedImage continueImg;
	private BufferedImage oneImg;
	private BufferedImage twoImg;
	private BufferedImage threeImg;
	private BufferedImage arrowImg;
	private BufferedImage mouseImg;
	private BufferedImage winImg;
	private BufferedImage loseImg;
	
	private BufferedImage beachTileImg;
	private BufferedImage oceanTileImg[];
	private double oceanTileImageIndex = 0;
	private final int OCEAN_TILE_IMAGE_FRAME_COUNT = 15;
	
	private String tutorialText;
	private JTextArea tutorialPane;
	private int tutorialCountdown = 3;
		
	/**
	 * @author Chris Bellotti
	 * @author Alvin Tang
	 * ShoreView constructor, loads in images for the Shore Defense minigame
	 * @param model		The ShoreModel to be displayed
	 */
	public ShoreView(ShoreModel model){
		setLayout(null);
		this.model = model;
		this.modelTiles = model.getTiles();
		try {
			beachTileImg = ImageIO.read(new File("Final Images/Backgrounds/tile_sand_center.png"));
			oceanTileImg = new BufferedImage[OCEAN_TILE_IMAGE_FRAME_COUNT];
			BufferedImage oceanTileImgFull = ImageIO.read(new File("Final Images/Backgrounds/water_tile.png"));
			for (int i = 0; i < OCEAN_TILE_IMAGE_FRAME_COUNT; i++) {
				oceanTileImg[i] = oceanTileImgFull.getSubimage(i * model.getTileWidth(), 0, 
						model.getTileWidth(), model.getTileHeight());
			}
			rockItemImg = ImageIO.read(new File("Final Images/Animals/food_pellet.png"));
			oysterItemImg = ImageIO.read(new File("Final Images/Animals/clam_back_0.png"));
			seedItemImg = ImageIO.read(new File("Final Images/Plants/seed.png"));
			wallDefenseImg = ImageIO.read(new File("Final Images/UI Buttons, Icons, Symbols/Dialogue2.png"));
			gabionDefenseImg = ImageIO.read(new File("Final Images/Objects/gabion.jpg"));
			plantDefenseGoodImg = ImageIO.read(new File("Final Images/Plants/milkweed_good.png"));
			plantDefenseBadImg = ImageIO.read(new File("Final Images/Plants/sadmilkweed.png"));
			waveImg = ImageIO.read(new File("Final Images/Objects/wave.png"));
			jetSkiImg = ImageIO.read(new File("Final Images/Objects/hotrod_vessel.png"));
			sailboatImg = ImageIO.read(new File("Final Images/Objects/cleanvessel.png"));
			commercialBoatImg = ImageIO.read(new File("Final Images/Objects/vessel.png"));
			healthImg = ImageIO.read(new File("Final Images/UI Buttons, Icons, Symbols/redtogreen.png"));
			continueImg = ImageIO.read(new File("Final Images/UI Buttons, Icons, Symbols/continue1.png"));
			oneImg = ImageIO.read(new File("Final Images/UI Buttons, Icons, Symbols/1.png"));
			twoImg = ImageIO.read(new File("Final Images/UI Buttons, Icons, Symbols/2.png"));
			threeImg = ImageIO.read(new File("Final Images/UI Buttons, Icons, Symbols/3.png"));
			arrowImg = ImageIO.read(new File("Final Images/UI Buttons, Icons, Symbols/arrow.png"));
			mouseImg = ImageIO.read(new File("Final Images/UI Buttons, Icons, Symbols/computermouse.png"));
			winImg = ImageIO.read(new File("Final Images/UI Buttons, Icons, Symbols/win.png"));
			loseImg = ImageIO.read(new File("Final Images/UI Buttons, Icons, Symbols/lose.png"));
			tutorialPane = new JTextArea("");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @author Chris Bellotti
	 * @author Alvin Tang
	 * renderShore draws the shore for the Shore Defense minigame
	 * @param g				encapsulates state information needed for rendering operations
	 * @param screen_width	The width of the display
	 * @param screen_height The height of the display
	 */
	public void renderShore(Graphics g, int screen_width, int screen_height){
		int TILE_WIDTH = (int) (screen_width/model.getTilesInRow());
		int TILE_HEIGHT = (int) (screen_height/model.getTilesInColumn());
		model.setTileHeight(TILE_HEIGHT);
		model.setTileWidth(TILE_WIDTH);
		for (int i = 0, x = 0; i < model.getTilesInRow(); i++, x+= TILE_WIDTH){
			for (int j = 0, y = 0; j < model.getTilesInColumn(); j++, y+= TILE_HEIGHT){
				ShoreTileType type = modelTiles.get(i).get(j).getTileType();
				if(type == ShoreTileType.BEACH ){
					g.drawImage(beachTileImg, x, y, x+TILE_WIDTH, y+TILE_HEIGHT
							, 0, 0, 256, 256, null);
					if(modelTiles.get(i).get(j).getTileErosion() != 0){
						g.drawImage(oceanTileImg[(int) oceanTileImageIndex], x, y, TILE_WIDTH,
								(int) (TILE_HEIGHT/10 * modelTiles.get(i).get(j).getTileErosion()), null);
					}
				}
				else if(type == ShoreTileType.OCEAN){
					g.drawImage(oceanTileImg[(int) oceanTileImageIndex], x, y,
							TILE_WIDTH, TILE_HEIGHT, null);
				}
			}
		}
		oceanTileImageIndex = (oceanTileImageIndex + 0.05) % OCEAN_TILE_IMAGE_FRAME_COUNT;
	}	
	/**
	 * @author Chris Bellotti
	 * @author Alvin Tang
	 * paintComponent displays the visuals for the Shore Defense minigame
	 * @param g		encapsulates state information needed for rendering operations
	 */
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
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
		final BufferedImage SHORE_HEALTH_BAR_IMAGE = healthImg;
		final int SHORE_HEALTH_BAR_HEIGHT = TOOLBAR_HEIGHT;
		final int SHORE_HEALTH_BAR_WIDTH = SCREEN_WIDTH/4;
		//shore health level
		final double SHORE_HEALTH_LEVEL_PERCENT = model.getShoreHealth();
		final int SHORE_HEALTH_LEVEL_HEIGHT = SHORE_HEALTH_BAR_HEIGHT;
		final int SHORE_HEALTH_LEVEL_WIDTH = SHORE_HEALTH_BAR_WIDTH/100;
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
		final BufferedImage PLANT_DEF_GOOD_IMAGE = plantDefenseGoodImg;
		final BufferedImage PLANT_DEF_BAD_IMAGE = plantDefenseBadImg;
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
		//exit
		final String EXIT_STRING = "EXIT";
		//tutorial continue
		final BufferedImage CONTINUE_IMAGE = continueImg;
		final int CONTINUE_WIDTH = TILE_WIDTH*4;
		final int CONTINUE_HEIGHT = TILE_HEIGHT*2;
		final int CONTINUE_X = (int) (model.getTiles().get(model.getTilesInRow() - (CONTINUE_WIDTH/TILE_WIDTH)).get((int)(model.getTilesInColumn()-(CONTINUE_HEIGHT/TILE_HEIGHT)-1)).getTileOrigin().getShoreX());
		final int CONTINUE_Y = (int) (model.getTiles().get(model.getTilesInRow() - (CONTINUE_WIDTH/TILE_WIDTH)).get((int)(model.getTilesInColumn()-(CONTINUE_HEIGHT/TILE_HEIGHT)-1)).getTileOrigin().getShoreY());
		
		//draw tiles
		renderShore(g,SCREEN_WIDTH,SCREEN_HEIGHT);
		
		//draw toolbar
		g.setColor(TOOLBAR_COLOR);
		g.drawRect(0, 0, TOOLBAR_WIDTH, TOOLBAR_HEIGHT);
		g.fillRect(0, 0, TOOLBAR_WIDTH, TOOLBAR_HEIGHT);
		//draw shore health bar
		g.drawImage(SHORE_HEALTH_BAR_IMAGE,(SCREEN_WIDTH/2)+(SHORE_HEALTH_BAR_WIDTH/2) , 0
				, SHORE_HEALTH_BAR_WIDTH, SHORE_HEALTH_BAR_HEIGHT,null);
		//draw shore health level
		g.setColor(Color.BLACK);
		g.drawRect((int) (SCREEN_WIDTH/2 + (SHORE_HEALTH_BAR_WIDTH/2) + (SHORE_HEALTH_BAR_WIDTH * (SHORE_HEALTH_LEVEL_PERCENT/100))),
				0,(SHORE_HEALTH_LEVEL_WIDTH), SHORE_HEALTH_LEVEL_HEIGHT);
		g.fillRect((int) (SCREEN_WIDTH/2 + (SHORE_HEALTH_BAR_WIDTH/2) + (SHORE_HEALTH_BAR_WIDTH * (SHORE_HEALTH_LEVEL_PERCENT/100))),
				0,(SHORE_HEALTH_LEVEL_WIDTH), SHORE_HEALTH_LEVEL_HEIGHT);
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
				if(def.getIsGoodPlacement()){
					g.drawImage(PLANT_DEF_GOOD_IMAGE,(int) (def.getContainedWithin().getTileOrigin().getShoreX()),(int) (def.getContainedWithin().getTileOrigin().getShoreY())
						, PLANT_DEF_WIDTH, PLANT_DEF_HEIGHT,null);
				}
				else{
					g.drawImage(PLANT_DEF_BAD_IMAGE,(int) (def.getContainedWithin().getTileOrigin().getShoreX()),(int) (def.getContainedWithin().getTileOrigin().getShoreY())
							, PLANT_DEF_WIDTH, PLANT_DEF_HEIGHT,null);
				}
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
		g.setFont(new Font("Arial", Font.BOLD, (int)(model.getTileHeight()/3)));
		g.drawString(s1, (int)(model.getTileWidth()), (int) (model.getTileHeight()/1.5));
		g.drawString(s2, (int)(model.getTileWidth()*3), (int) (model.getTileHeight()/1.5));
		g.drawString(s3, (int)(model.getTileWidth()*5), (int) (model.getTileHeight()/1.5));
		
		//draw selected defense
		if(model.isBuildDefense()){
			if(model.getSavedDefenseType() == model.getDefenseWall()){
				g.drawRect(0, 0, (int)(model.getTileWidth()*1.5), model.getTileHeight());
			}
			else if(model.getSavedDefenseType() == model.getDefenseGabion()){
				g.drawRect((int)(model.getTileWidth()*2), 0, (int)(model.getTileWidth()*1.5), model.getTileHeight());
			}
			else{
				g.drawRect((int)(model.getTileWidth()*4), 0, (int)(model.getTileWidth()*1.5), model.getTileHeight());
			}
		}
		//draw exit
		g.drawString(EXIT_STRING, (int) (model.getTiles().get(model.getTilesInRow()-1).get(0).getTileOrigin().getShoreX() - (model.getTileWidth()/4)) , (int)((model.getTileWidth() * 6) /10));
		
		//draw tutorial
		if(model.getGameMode() == ShoreGameMode.TUTORIAL){
			if(model.getTutorialStage() > 0 && model.getTutorialStage() < 8){
				g.drawImage(CONTINUE_IMAGE, CONTINUE_X, CONTINUE_Y, CONTINUE_WIDTH,
					CONTINUE_HEIGHT, null);
			}
			switch(model.getTutorialStage()){
			case 1:
				g.drawImage(mouseImg, model.getTileWidth()*6, model.getTileHeight()*2, model.getTileWidth()*4, model.getTileHeight()*6, null);
				break;
			case 2:
				g.drawImage(arrowImg, model.getTileWidth()*5, model.getTileHeight()*8, model.getTileWidth(), model.getTileHeight(), null);
				g.drawImage(arrowImg, model.getTileWidth()*10, model.getTileHeight()*9, model.getTileWidth(), model.getTileHeight(), null);
				break;
			case 3:
				g.drawImage(arrowImg, (int)(model.getTileWidth()*5.5), 0, model.getTileWidth(), model.getTileHeight(), null);
				g.drawImage(WALL_DEF_IMAGE, (int)(model.getTileWidth()/2), (int)(model.getTileHeight()*3.5), model.getTileWidth(), model.getTileHeight(), null);
				g.drawImage(arrowImg, (int)(model.getTileWidth()*1.75), (int)(model.getTileHeight()*3.75), (int)(model.getTileWidth()/2), (int)(model.getTileHeight()/2), null);
				g.drawImage(ROCK_ITEM_IMAGE, (int) (model.getTileWidth()*2.5), (int)(model.getTileHeight()*3.5), model.getTileWidth(), model.getTileHeight(), null);
				g.drawString(new String("x3"), (int)(model.getTileWidth()*3.5), (int)(model.getTileHeight()*4.5));
				g.drawString(new String("Wall"), (int)(model.getTileWidth()*.75), (int)(model.getTileHeight()*4.75));
								
				g.drawImage(GABION_DEF_IMAGE, (int)(model.getTileWidth()*5.5), (int)(model.getTileHeight()*3.5), model.getTileWidth(), model.getTileHeight(), null);
				g.drawImage(arrowImg, (int)(model.getTileWidth()*6.75), (int)(model.getTileHeight()*3.75), (int)(model.getTileWidth()/2), (int)(model.getTileHeight()/2), null);
				g.drawImage(OYSTER_ITEM_IMAGE, (int) (model.getTileWidth()*7.5), (int)(model.getTileHeight()*3.5), model.getTileWidth(), model.getTileHeight(), null);
				g.drawString(new String("x3"), (int)(model.getTileWidth()*8.5), (int)(model.getTileHeight()*4.5));
				g.drawString(new String("Gabion"), (int)(model.getTileWidth()*5.5), (int)(model.getTileHeight()*4.75));
				
				
				g.drawImage(PLANT_DEF_GOOD_IMAGE, (int)(model.getTileWidth()*10.5), (int)(model.getTileHeight()*3.5), model.getTileWidth(), model.getTileHeight(), null);
				g.drawImage(arrowImg, (int)(model.getTileWidth()*11.75), (int)(model.getTileHeight()*3.75), (int)(model.getTileWidth()/2), (int)(model.getTileHeight()/2), null);
				g.drawImage(SEED_ITEM_IMAGE, (int) (model.getTileWidth()*12.5), (int)(model.getTileHeight()*3.5), model.getTileWidth(), model.getTileHeight(), null);
				g.drawString(new String("x1"), (int)(model.getTileWidth()*13.5), (int)(model.getTileHeight()*4.5));
				g.drawString(new String("Plant"), (int)(model.getTileWidth()*10.75), (int)(model.getTileHeight()*4.75));
				break;
			case 4:
				g.drawImage(WAVE_IMAGE, model.getTileWidth()*9, model.getTileHeight()*5, model.getTileWidth(), model.getTileHeight(), null);
				g.drawImage(PLANT_DEF_GOOD_IMAGE, model.getTileWidth()*9, model.getTileHeight()*8, model.getTileWidth(), model.getTileHeight(), null);
				g.drawImage(WAVE_IMAGE, model.getTileWidth()*5, model.getTileHeight()*5, model.getTileWidth(), model.getTileHeight(), null);
				g.drawImage(PLANT_DEF_GOOD_IMAGE, model.getTileWidth()*5, model.getTileHeight()*8, model.getTileWidth(), model.getTileHeight(), null);
				break;
			case 5:
				g.drawImage(arrowImg, model.getTileWidth()*3, model.getTileHeight()*7, model.getTileWidth(), model.getTileHeight(), null);
				g.drawImage(arrowImg, model.getTileWidth()*8, model.getTileHeight()*7, model.getTileWidth(), model.getTileHeight(), null);
				g.drawImage(arrowImg, model.getTileWidth()*13, model.getTileHeight()*7, model.getTileWidth(), model.getTileHeight(), null);
				break;
			case 6:
				g.drawImage(arrowImg, model.getTileWidth()*13, 0, model.getTileWidth(), model.getTileHeight(), null);
				break;
			case 8:
				switch(tutorialCountdown){
				case 3:
					g.drawImage(threeImg, (int)(model.getTileWidth()*6.5), (int)(model.getTileHeight()*3.5), model.getTileWidth()*2, model.getTileHeight()*4, null);
					break;
				case 2:
					g.drawImage(twoImg, (int)(model.getTileWidth()*6.5), (int)(model.getTileHeight()*3.5), model.getTileWidth()*2, model.getTileHeight()*4, null);
					break;
				case 1:
					g.drawImage(oneImg, (int)(model.getTileWidth()*6.5), (int)(model.getTileHeight()*3.5), model.getTileWidth()*2, model.getTileHeight()*4, null);
					if(tutorialPane != null){
						this.remove(tutorialPane);
						tutorialPane = null;
					}
					break;
				}
				break;
			case -1:
				g.drawImage(winImg, model.getTileWidth()*6, model.getTileHeight()*4, model.getTileWidth()*4, model.getTileHeight()*2, null);
				break;
			case -2:
				g.drawImage(loseImg, model.getTileWidth()*6, model.getTileHeight()*4, model.getTileWidth()*4, model.getTileHeight()*2, null);
				break;
			}
		}
	}
	/**
	 * @author Chris Bellotti
	 * @author Alvin Tang
	 * displayTextBox creates text boxes for the Tutorial
	 */
	public void displayTextbox(){
		switch(model.getTutorialStage()){
		case 1:
			tutorialText = "You only need to use the mouse for this game. Press continue when you are ready to learn more!";
			break;
		case 2:
			tutorialText = "Once the game starts, click on shore items to collect them. Keep collecting to build a defense.";
			break;
		case 3:
			tutorialText = "Once you have enough of an item to build its defense, click on the item in the top left and then \nwhere you want to place the defense on the beach.";
			break;
		case 4:
			tutorialText = "Boat wakes erode the shore, but plants placed behind that eroded section will heal it.";
			break;
		case 5:
			tutorialText = "Walls & Gabions placed on the shore or in front of eroded beach will protect from wakes, \nbut be careful where you place them!";
			break;
		case 6:
			tutorialText = "Fill the shore health meter and win the game by placing objects that are GOOD for the environment.";
			break;
		case 7:
			tutorialText = "Press continue when you are ready to play!";
			break;
		case 8:
			tutorialText = "Good Luck!!!";
			break;
		}		
		if(tutorialPane != null){
			tutorialPane.setText(tutorialText);
			tutorialPane.setEditable(false);
			tutorialPane.setFont(new Font("Arial", Font.BOLD, (int)(model.getTileHeight()/3)));
			tutorialPane.setBounds(0, (int) (model.getTilesInColumn()*model.getTileHeight()-(model.getTileHeight())),
					model.getTileWidth()*model.getTilesInRow(), model.getTileHeight());
			this.add(tutorialPane);
		}
	}
	public int getTutorialCountdown() {
		return tutorialCountdown;
	}


	public void setTutorialCountdown() {
		this.tutorialCountdown -= 1;
	}

}

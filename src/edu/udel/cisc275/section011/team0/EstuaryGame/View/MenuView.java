package edu.udel.cisc275.section011.team0.EstuaryGame.View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import edu.udel.cisc275.section011.team0.EstuaryGame.Model.MazeMenuItem;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.MenuModel;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.ShoreMenuItem;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.StoryMenuItem;

public class MenuView extends JComponent {
	
	private final MenuModel model;
	
	public int SCREEN_WIDTH;
	public int SCREEN_HEIGHT;
	
	public int MARGIN;
	
	public int BOX_WIDTH;
	public int BOX_HEIGHT;
	
	private BufferedImage mazeTextImg;
	private BufferedImage shoreTextImg;
	private BufferedImage storyTextImg;
	
	public MenuView (MenuModel model) {
		this.model = model;
		
		try {
			mazeTextImg = ImageIO.read(new File("Final Images/UI Buttons, Icons, Symbols/menu_maze_text.png"));
			shoreTextImg = ImageIO.read(new File("Final Images/UI Buttons, Icons, Symbols/menu_shore_text.png"));
			storyTextImg = ImageIO.read(new File("Final Images/UI Buttons, Icons, Symbols/menu_story_text.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void paint(Graphics g){
		// screen dimensions
		SCREEN_WIDTH = getWidth();
		SCREEN_HEIGHT = getHeight();
		
		g.setColor(Color.CYAN);
		g.drawRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		g.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		
		MARGIN = SCREEN_WIDTH / 24;
		BOX_WIDTH = (SCREEN_WIDTH - MARGIN * (model.getMenuItems().size() + 1)) 
				/ model.getMenuItems().size();
		BOX_HEIGHT = (int) (BOX_WIDTH * 0.75);
		
		for (int i = 0; i < model.getMenuItems().size(); i++) {
			int BOX_X = i * (BOX_WIDTH + MARGIN) + MARGIN;
			int BOX_Y = SCREEN_HEIGHT / 2 - BOX_HEIGHT / 2;
			
			((Graphics2D) g).setRenderingHint(RenderingHints.KEY_INTERPOLATION,
	                RenderingHints.VALUE_INTERPOLATION_BICUBIC);
			if (model.getMenuItems().get(i) instanceof MazeMenuItem) {
				g.drawImage(mazeTextImg, BOX_X, BOX_Y, BOX_WIDTH, BOX_HEIGHT, null);
			} else if (model.getMenuItems().get(i) instanceof ShoreMenuItem) {
				g.drawImage(shoreTextImg, BOX_X, BOX_Y, BOX_WIDTH, BOX_HEIGHT, null);
			} else if (model.getMenuItems().get(i) instanceof StoryMenuItem) {
				g.drawImage(storyTextImg, BOX_X, BOX_Y, BOX_WIDTH, BOX_HEIGHT, null);
			}
		}
		
	}
}

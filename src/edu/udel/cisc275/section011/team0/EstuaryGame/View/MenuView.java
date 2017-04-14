package edu.udel.cisc275.section011.team0.EstuaryGame.View;

import java.awt.Graphics;

import javax.swing.JComponent;

import edu.udel.cisc275.section011.team0.EstuaryGame.Model.MenuModel;

public class MenuView extends JComponent {
	
	private final MenuModel model;
	
	public int SCREEN_WIDTH;
	public int SCREEN_HEIGHT;
	
	public int MARGIN;
	
	public int BOX_WIDTH;
	public int BOX_HEIGHT;
	
	public MenuView (MenuModel model) {
		this.model = model;
	}
	
	public void paint(Graphics g){
		// screen dimensions
		SCREEN_WIDTH = getWidth();
		SCREEN_HEIGHT = getHeight();
		
		MARGIN = SCREEN_WIDTH / 24;
		BOX_WIDTH = (SCREEN_WIDTH - MARGIN * (model.getMenuItems().size() + 1)) 
				/ model.getMenuItems().size();
		BOX_HEIGHT = (int) (BOX_WIDTH * 0.8);
		
		for (int i = 0; i < model.getMenuItems().size(); i++) {
			int BOX_X = i * (BOX_WIDTH + MARGIN) + MARGIN;
			int BOX_Y = SCREEN_HEIGHT / 2 - BOX_HEIGHT / 2;
			g.drawRect(BOX_X, BOX_Y, BOX_WIDTH, BOX_HEIGHT);
			String title = model.getMenuItems().get(i).getName();
			int TITLE_WIDTH = g.getFontMetrics().stringWidth(title);
			int TITLE_HEIGHT = g.getFontMetrics().getHeight();
			g.drawString(title, BOX_X + BOX_WIDTH / 2 - TITLE_WIDTH / 2, 
					BOX_Y + BOX_HEIGHT / 2 - TITLE_HEIGHT / 2);
		}
		
	}
}

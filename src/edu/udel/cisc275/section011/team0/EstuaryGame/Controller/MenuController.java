package edu.udel.cisc275.section011.team0.EstuaryGame.Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;

import edu.udel.cisc275.section011.team0.EstuaryGame.Model.MenuModel;
import edu.udel.cisc275.section011.team0.EstuaryGame.View.MenuView;

public class MenuController extends MouseAdapter implements Controller {
	
	private MenuModel model;
	private MenuView view;
	
	public MenuController() {
		model = new MenuModel();
		view = new MenuView(model);
		view.addMouseListener(this);
	}
	
	@Override
	public void tick(){
		return;
	}

	@Override
	public JComponent getView() {
		return view;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		for (int i = 0; i < model.getMenuItems().size(); i++) {
			int BOX_X = i * (view.BOX_WIDTH + view.MARGIN) + view.MARGIN;
			int BOX_Y = view.SCREEN_HEIGHT / 2 - view.BOX_HEIGHT / 2;
			if (e.getX() > BOX_X && e.getX() < BOX_X + view.BOX_WIDTH
					&& e.getY() > BOX_Y && e.getY() < BOX_Y + view.BOX_HEIGHT){
				model.getMenuItems().get(i).onClick();
			}
		}
	}
	
}

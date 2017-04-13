package edu.udel.cisc275.section011.team0.EstuaryGame.Controller;

import java.awt.event.MouseAdapter;

import javax.swing.JComponent;

import edu.udel.cisc275.section011.team0.EstuaryGame.Model.MenuModel;
import edu.udel.cisc275.section011.team0.EstuaryGame.View.MenuView;

public class MenuController extends MouseAdapter implements Controller {
	
	private MenuModel model;
	private MenuView view;
	
	public MenuController() {
		model = new MenuModel();
		view = new MenuView();
	}
	
	@Override
	public void tick(){
		return;
	}

	@Override
	public JComponent getView() {
		return view;
	}
	
}

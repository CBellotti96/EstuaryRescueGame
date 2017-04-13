package edu.udel.cisc275.section011.team0.EstuaryGame.Controller;

import java.awt.event.MouseAdapter;

import javax.swing.JComponent;

public class MenuController extends MouseAdapter implements Controller {
	
	private MenuModel model;
	private MenuView view;
	
	@Override
	public void tick(){
		return;
	}

	@Override
	public JComponent getView() {
		return view;
	}
	
}

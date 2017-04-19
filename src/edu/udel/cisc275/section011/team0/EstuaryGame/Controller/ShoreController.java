package edu.udel.cisc275.section011.team0.EstuaryGame.Controller;

import java.awt.event.MouseAdapter;

import javax.swing.JComponent;

import edu.udel.cisc275.section011.team0.EstuaryGame.Model.ShoreModel;
import edu.udel.cisc275.section011.team0.EstuaryGame.View.ShoreView;

public class ShoreController extends MouseAdapter implements Controller {

	private ShoreModel model;
	private ShoreView view;
	
	public ShoreController(){
		
		model = new ShoreModel(800,600);
		view = new ShoreView(model);
		
	}
	
	@Override
	public void tick(){
		view.repaint();
	}

	@Override
	public JComponent getView() {
		return view;
	}
	
	
}

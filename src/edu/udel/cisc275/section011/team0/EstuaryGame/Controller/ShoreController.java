package edu.udel.cisc275.section011.team0.EstuaryGame.Controller;

import java.awt.event.MouseAdapter;

import javax.swing.JComponent;

import edu.udel.cisc275.section011.team0.EstuaryGame.Model.ShoreModel;
import edu.udel.cisc275.section011.team0.EstuaryGame.View.ShoreView;

public class ShoreController extends MouseAdapter implements Controller {

	private ShoreModel model;
	private ShoreView view;
	
	@Override
	public void tick(){
		return;
	}

	@Override
	public JComponent getView() {
		return view;
	}
	
	
}

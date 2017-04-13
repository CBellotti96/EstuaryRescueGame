package edu.udel.cisc275.section011.team0.EstuaryGame.Controller;

import java.awt.event.MouseAdapter;

import javax.swing.JComponent;

import edu.udel.cisc275.section011.team0.EstuaryGame.Model.StoryModel;
import edu.udel.cisc275.section011.team0.EstuaryGame.View.StoryView;

public class StoryController extends MouseAdapter implements Controller{

	private StoryModel model;
	private StoryView view;
	
	@Override
	public void tick(){
		return;
	}

	@Override
	public JComponent getView() {
		return view;
	}
	
	
}

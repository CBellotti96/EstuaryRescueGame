package edu.udel.cisc275.section011.team0.EstuaryGame.Controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import edu.udel.cisc275.section011.team0.EstuaryGame.Model.MazeModel;
import edu.udel.cisc275.section011.team0.EstuaryGame.View.MazeView;

public class MazeController extends KeyAdapter {

	private MazeModel model;
	private MazeView view;
	
	public MazeController() {
		model = new MazeModel();
		view = new MazeView();
		view.addKeyListener(this);
	}
	
	public void tick(){
		return;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

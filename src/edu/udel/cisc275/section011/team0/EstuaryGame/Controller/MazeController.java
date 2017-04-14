package edu.udel.cisc275.section011.team0.EstuaryGame.Controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JComponent;

import edu.udel.cisc275.section011.team0.EstuaryGame.Model.MazeCrab;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.MazeModel;
import edu.udel.cisc275.section011.team0.EstuaryGame.View.MazeView;

public class MazeController extends KeyAdapter implements Controller {

	private MazeModel model;
	private MazeView view;
	
	private Set<Integer> pressedKeys = new HashSet<>();
	
	public MazeController() {
		model = new MazeModel();
		view = new MazeView(model);
		view.addKeyListener(this);
	}
	
	@Override
	public void tick(){
		if (pressedKeys.contains(KeyEvent.VK_UP)) {
			MazeCrab player = model.getPlayer();
			player.setYPos(player.getYPos() - player.getSpeed());

			System.out.println("up");
		}
		if (pressedKeys.contains(KeyEvent.VK_DOWN)) {
			MazeCrab player = model.getPlayer();
			player.setYPos(player.getYPos() + player.getSpeed());
		}
		if (pressedKeys.contains(KeyEvent.VK_LEFT)) {
			MazeCrab player = model.getPlayer();
			player.setXPos(player.getXPos() - player.getSpeed());
		}
		if (pressedKeys.contains(KeyEvent.VK_RIGHT)) {
			MazeCrab player = model.getPlayer();
			player.setXPos(player.getXPos() + player.getSpeed());
		}
		
		view.repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		pressedKeys.add(arg0.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		pressedKeys.remove(arg0.getKeyCode());
		
	}

	@Override
	public JComponent getView() {
		return view;
	}
	
}

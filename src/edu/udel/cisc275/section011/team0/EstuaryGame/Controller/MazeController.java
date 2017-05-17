package edu.udel.cisc275.section011.team0.EstuaryGame.Controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JComponent;

import edu.udel.cisc275.section011.team0.EstuaryGame.Common.Main;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.MazeCrab;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.MazeGameMode;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.MazeModel;
import edu.udel.cisc275.section011.team0.EstuaryGame.View.MazeView;

/**
 * 
 * 
 * @author Alexandra Hurst
 * @author Emily McNeil
 */
public class MazeController extends KeyAdapter implements Controller {

	private MazeModel model;
	private MazeView view;
	
	private Set<Integer> pressedKeys = new HashSet<>();
	
	/**
	 * Constructor for MazeController.
	 * <p>
	 * Instantiates a {@link <MazeModel> MazeModel} and {@link <MazeView> MazeView}.
	 * Adds a KeyListener to listen for input.
	 * @see	{@link <MazeModel> MazeModel}
	 * @see {@link <MazeView> MazeView}
	 * @see {@link <KeyListener> KeyListener}
	 */
	public MazeController() {
		model = new MazeModel();
		view = new MazeView(model);
		view.addKeyListener(this);
	}
	
	/**
	 * Updates the model and then view in accordance with input.
	 * 
	 * @see	{@link MazeView#repaint}
	 * @see {@link MazeModel#tick}
	 */
	@Override
	public void tick(){
		if (pressedKeys.contains(KeyEvent.VK_ESCAPE)){
			Main.getInstance().setController(new MenuController());
		}
		
		if (model.getMode() == MazeGameMode.TUTORIAL
				&& !pressedKeys.isEmpty()){
			model.setMode(MazeGameMode.PLAYING);
		}
		
		if (model.getMode() == MazeGameMode.PLAYING) {
			if (pressedKeys.contains(KeyEvent.VK_UP)) {
				MazeCrab player = model.getPlayer();
				player.setYPos(player.getYPos() - player.getSpeed());
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
		}
		
		model.tick();
		
		view.repaint();
	}

	/**
	 * {@inheritDoc}
	 * @see java.awt.event.KeyAdapter#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent arg0) {
		pressedKeys.add(arg0.getKeyCode());
	}

	/**
	 * {@inheritDoc}
	 * @see java.awt.event.KeyAdapter#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent arg0) {
		pressedKeys.remove(arg0.getKeyCode());
		
	}

	@Override
	public JComponent getView() {
		return view;
	}
	
}

package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import edu.udel.cisc275.section011.team0.EstuaryGame.Common.Main;
import edu.udel.cisc275.section011.team0.EstuaryGame.Controller.MazeController;

/**
 * @author Emily McNeil
 * @author Alexandra Hurst
 * 
 * MazeMenuItem creates the model for a menu button leading to a new Maze game instance.
 */
public class MazeMenuItem implements MenuItem {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return "Maze";
	}

	/**
	 * {@inheritDoc}}
	 */
	@Override
	public void onClick() {
		Main.getInstance().setController(new MazeController());
	}

}

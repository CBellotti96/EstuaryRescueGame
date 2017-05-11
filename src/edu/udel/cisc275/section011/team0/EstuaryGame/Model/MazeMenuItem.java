package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import edu.udel.cisc275.section011.team0.EstuaryGame.Common.Main;
import edu.udel.cisc275.section011.team0.EstuaryGame.Controller.MazeController;

/**
 * MazeMenuItem creates the model for a menu button leading to a new Maze game instance.
 * 
 * @author Chris Bellotti
 * @author Alexandra Hurst
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

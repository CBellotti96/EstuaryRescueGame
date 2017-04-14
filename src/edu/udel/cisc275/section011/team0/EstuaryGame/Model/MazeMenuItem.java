package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import edu.udel.cisc275.section011.team0.EstuaryGame.Common.Main;
import edu.udel.cisc275.section011.team0.EstuaryGame.Controller.MazeController;

public class MazeMenuItem implements MenuItem {

	@Override
	public String getName() {
		return "Maze";
	}

	@Override
	public void onClick() {
		Main.getInstance().setController(new MazeController());
	}

}

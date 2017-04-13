package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import edu.udel.cisc275.section011.team0.EstuaryGame.Common.Main;
import edu.udel.cisc275.section011.team0.EstuaryGame.Controller.StoryController;

public class StoryMenuItem implements MenuItem {

	@Override
	public String getName() {
		return "Story Cubes";
	}

	@Override
	public void onClick() {
		// TODO Auto-generated method stub
		Main.getInstance().setController(new StoryController());

	}

}

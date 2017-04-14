package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import edu.udel.cisc275.section011.team0.EstuaryGame.Common.Main;
import edu.udel.cisc275.section011.team0.EstuaryGame.Controller.ShoreController;

public class ShoreMenuItem implements MenuItem {

	@Override
	public String getName() {
		return "Shore Defense";
	}

	@Override
	public void onClick() {
		Main.getInstance().setController(new ShoreController());
	}

}

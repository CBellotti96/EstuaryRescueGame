package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import edu.udel.cisc275.section011.team0.EstuaryGame.Common.Main;
import edu.udel.cisc275.section011.team0.EstuaryGame.Controller.MenuController;

public class MenuReturnItem implements MenuItem {

	@Override
	public String getName() {
		return "Main menu";
	}

	@Override
	public void onClick() {
		Main.getInstance().setController(new MenuController());
	}

}

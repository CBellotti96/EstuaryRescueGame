package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import edu.udel.cisc275.section011.team0.EstuaryGame.Common.Main;
import edu.udel.cisc275.section011.team0.EstuaryGame.Controller.ShoreController;
/**
 * 
 *  ShoreMenuItem is the the button on the main menu that 
 *  leads to the Shore Defense Game
 * @author Chris Bellotti 
 * @author Alvin Tang
 *
 */
public class ShoreMenuItem implements MenuItem {

	@Override
	public String getName() {
		return "Shore Defense";
	}
	/**
	 * Creates a new instance of ShoreController when ShoreMenuItem is clicked.
	 * @see ShoreController
	 * 
	 */
	@Override
	public void onClick() {
		Main.getInstance().setController(new ShoreController());
	}

}

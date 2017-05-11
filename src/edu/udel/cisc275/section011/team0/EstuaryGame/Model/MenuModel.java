package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chris Bellotti
 * @author Alexandra Hurst
 * @author Emily McNeil
 * 
 * MenuModel class is used to instantiate the main menu, which displays buttons for all three games.
 */
public class MenuModel {
	/**
	 * List containing all MenuItems held in the MenuModel.  
	 */
	private final List<MenuItem> menuItems = new ArrayList<>();

	/**
	 * Constructor.
	 */
	public MenuModel(){
		menuItems.add(new MazeMenuItem());
		menuItems.add(new ShoreMenuItem());
		menuItems.add(new StoryMenuItem());
	}

	/**
	 * Getter for {@link #menuItems}.
	 * @return	the list of {@link #menuItems}
	 */
	public List<MenuItem> getMenuItems(){
		return this.menuItems;
	}
}

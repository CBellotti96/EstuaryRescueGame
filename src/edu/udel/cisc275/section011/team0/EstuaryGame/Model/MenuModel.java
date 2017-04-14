package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import java.util.ArrayList;
import java.util.List;

public class MenuModel {
	List<MenuItem> menuItems = new ArrayList<>();
	
	
	public MenuModel(){
		menuItems.add(new MazeMenuItem());
		menuItems.add(new ShoreMenuItem());
		menuItems.add(new StoryMenuItem());
	}

}

package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

/**
 * MenuItem interface is used to streamline creation of button models for the menu.
 * 
 * @author Chris Bellotti
 */
public interface MenuItem {
	/**
	 * Getter for the name of the button.
	 * @return a string specifying the prefix name of the invoked Controller class.
	 */
	String getName();
	
	/**
	 * Creates a new instance of the specified Controller when MenuItem is clicked.
	 */
	void onClick();
	
}

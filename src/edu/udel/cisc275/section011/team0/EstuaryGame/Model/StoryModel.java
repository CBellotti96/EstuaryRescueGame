package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

/**
 * A StoryModel simulates the game, which is then displayed by the StoryView.
 * @see StoryController
 * @see StoryView
 * @author Ben Wiswell
 */

import java.util.ArrayList;

public class StoryModel {

	public final static int xCoordMax = 160;
	public final static int yCoordMax = 120;

	private ArrayList<StoryCube> cubes = new ArrayList<StoryCube>();
	private boolean rolled;

	public ArrayList<StoryCube> getCubes () {
		return this.cubes;
	}

	public boolean isRolled () {
		return this.rolled;
	}

	/**
	 * @author Ben Wiswell
	 * StoryModel constructor, initializes the story cubes.
	 */
	public StoryModel () {
		int n = 8;
		StoryCubePosition.initializePositions(n);
		for (int i = 0; i < n; i++) {
			StoryCube sc = new StoryCube(i);
			cubes.add(sc);
		}
	}

	/**
	 * @author Ben Wiswell
	 * Method to update the StoryModel. Rolls story cubes if necessary, and moves
	 * story cubes if they have been rolled.
	 */
	public void tick () {
		for (StoryCube sc : cubes) {
			if (sc.isRolling()) {
				sc.incrementRoll();
				if (sc.getRollState() % 3 == 0)
					sc.move();
			} else if (rolled) {
				sc.move();
			}
		}
	}

	/**
	 * @author Ben Wiswell
	 * Method to set the story cubes rolling and move them to their initial positions.
	 */
	public void roll () {
		this.rolled = true;
		for (StoryCube sc : cubes)
			sc.setRolling(StoryCubePosition.getStartPositions().get(sc.getID()));
	}
}

package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

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

	public StoryModel () {
		int n = 8;
		StoryCubePosition.initializePositions(n);
		for (int i = 0; i < n; i++) {
			StoryCube sc = new StoryCube(i);
			cubes.add(sc);
		}
	}

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

	public void roll () {
		this.rolled = true;
		for (StoryCube sc : cubes)
			sc.setRolling(StoryCubePosition.getStartPositions().get(sc.getID()));
	}
}

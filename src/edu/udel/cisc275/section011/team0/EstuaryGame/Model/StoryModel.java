package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import java.awt.Point;
import java.util.ArrayList;

public class StoryModel {

		private ArrayList<StoryCube> cubes = new ArrayList<StoryCube>();
		private boolean rolled;
		
		public ArrayList<StoryCube> getCubes () {
			return this.cubes;
		}
		
		public boolean isRolled () {
			return this.rolled;
		}
		
		public StoryModel () {
			int n = 6;
			StoryCubePosition.initializePositions(n);
			for (int i = 0; i < n; i++) {
				StoryCube sc = new StoryCube(i, StoryCubePosition.getStartPositions().get(i));
				cubes.add(sc);
			}
		}
		
		public void tick (Point mousePos) {
			if (rolled)
				for (StoryCube sc : cubes) {
					sc.move(mousePos);
					if (sc.isRolling())
						sc.incrementRoll();
				}
		}
		
		public void roll () {
			this.rolled = true;
			for (StoryCube sc : cubes)
				sc.setRolling(true);
		}
}

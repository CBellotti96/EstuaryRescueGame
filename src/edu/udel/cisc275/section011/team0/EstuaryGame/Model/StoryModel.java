package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

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
			for (int i = 0; i < 8; i++) {
				StoryCube sc = new StoryCube(i, StoryCubePosition.cubeStartPositions[i]);
				cubes.add(sc);
			}
		}
		
		public void tick () {
			if (rolled)
				for (StoryCube sc : cubes)
					sc.move();
		}
		
		public void roll () {
			this.rolled = true;
			for (StoryCube sc : cubes)
				sc.setRolling(true);
		}
		
		public StoryCube containedIn (StoryCubePosition scp) {
			for (StoryCube sc : cubes) {
				if (sc.getHome().equals(scp))
					return sc;
			}
			return null;
		}
}

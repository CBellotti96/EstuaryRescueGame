package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import java.util.ArrayList;

public class StoryModel {

		private String story; 
		private StoryMode mode;
		private ArrayList<StoryCube> cubes = new ArrayList<StoryCube>();
		private boolean rolled;
		
		public enum StoryMode{
			INPUT,PLAYBACK
		}
		
		public String getStory() {
			return story;
		}
		
		public void setStory(String story) {
			this.story = story;
		}
		
		public StoryMode getMode() {
			return mode;
		}
		
		public void setMode(StoryMode mode) {
			this.mode = mode;
		}
		
		public ArrayList<StoryCube> getCubes () {
			return this.cubes;
		}
		
		public boolean isRolled () {
			return this.rolled;
		}
		
		public void setRolled (boolean rolled) {
			this.rolled = rolled;
		}
		
		public StoryModel () {
			for (int i = 0; i < 8; i++) {
				StoryCube sc = new StoryCube();
				sc.setCubePosition(StoryCubePosition.cubeStartPositions[i]);
				cubes.add(sc);
			}
		}
		
		public StoryCube containedIn (StoryCubePosition scp) {
			for (StoryCube sc : cubes) {
				if (sc.getCubePosition().equals(scp))
					return sc;
			}
			return null;
		}
		
		public void roll () {
			for (StoryCube sc : cubes)
				sc.setRolling(true);
		}
}

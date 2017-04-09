package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

public class StoryModel {

		private String story; 
		private StoryMode mode;
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
}

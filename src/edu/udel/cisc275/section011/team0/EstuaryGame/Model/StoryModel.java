package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

/**
 * A StoryModel simulates the game, which is then displayed by the StoryView.
 * @see StoryController
 * @see StoryView
 * @author Ben Wiswell
 */

import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
		JFrame jf = new JFrame();
		JOptionPane optionPane = new JOptionPane();
		JSlider slider = getSlider(optionPane);
		optionPane.setMessage(new Object[] { "Select a number of die: ", slider });
		optionPane.setMessageType(JOptionPane.QUESTION_MESSAGE);
		optionPane.setOptionType(JOptionPane.OK_CANCEL_OPTION);
		JDialog dialog = optionPane.createDialog(jf, "Number of Story Cubes");
		dialog.setVisible(true);
		try {
			initializeModel((int) optionPane.getInputValue());
		} catch (Exception e) {
			initializeModel(8);
		}
	}
	
	private JSlider getSlider(JOptionPane optionPane) {
	    JSlider slider = new JSlider(JSlider.HORIZONTAL, 4, 10, 8);
	    slider.setMajorTickSpacing(2);
	    slider.setPaintTicks(true);
	    slider.setPaintLabels(true);
	    ChangeListener changeListener = new ChangeListener() {
	      public void stateChanged(ChangeEvent changeEvent) {
	    	  JSlider slider = (JSlider) changeEvent.getSource();
	    	  optionPane.setInputValue(slider.getValue());
	      }
	    };
	    slider.addChangeListener(changeListener);
	    return slider;
	  }
	
	public void initializeModel (int numCubes) {
		StoryCubePosition.initializePositions(numCubes);
		for (int i = 0; i < numCubes; i++) {
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

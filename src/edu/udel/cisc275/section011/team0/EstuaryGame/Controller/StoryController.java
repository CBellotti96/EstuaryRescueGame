package edu.udel.cisc275.section011.team0.EstuaryGame.Controller;

/**
 * A StoryController is the Controller of the Story Cubes minigame's MVC setup.
 * @see Controller
 * @see StoryModel
 * @see StoryView
 * @author Ben Wiswell
 */

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import edu.udel.cisc275.section011.team0.EstuaryGame.Model.StoryCube;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.StoryCubePosition;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.StoryModel;
import edu.udel.cisc275.section011.team0.EstuaryGame.View.StoryView;

public class StoryController extends MouseAdapter implements Controller {

	private StoryModel model;
	private StoryView view;
	private StoryCube selectedCube;
	
	/**
	 * @author Ben Wiswell
	 * StoryController constructor that initializes the StoryModel and StoryView
	 */
	public StoryController () {
		model = new StoryModel();
		view = new StoryView(model);
		view.addMouseListener(this);
	}
	
	/**
	 * @author Ben Wiswell
	 * Tick method to repaint the StoryView and update the StoryModel
	 */
	@Override
	public void tick() {
		view.repaint();
		model.tick();
	}

	@Override
	public JComponent getView() {
		return view;
	}
	
	public StoryModel getModel() {
		return this.model;
	}
	
	/**
	 * @author Ben Wiswell
	 * Reacts to a MouseEvent. Rolls the StoryModel if not already rolled,
	 * checks to see if an object is being selected or if an object is being placed,
	 * and executes the appropriate action.
	 * @param arg0	The MouseEvent that triggered the mouseClicked method
	 */
	@Override
	public void mouseClicked (MouseEvent arg0) {
		if (!model.isRolled()) {
			model.roll();
			view.initializeTextBoxes();
		} else if (selectedCube == null) {
			StoryCube selected = null;
			for (StoryCube sc : model.getCubes())
				if (sc.getRect(view.getScale(), view.getXMargin()).contains(arg0.getPoint()))
					selected = sc;
			if (selected != null) {
				selected.setSelected(true);
				this.selectedCube = selected;
			}
		} else {
			this.selectedCube.setSelected(false);
			StoryCubePosition endPosition = null;
			for (StoryCubePosition scp : StoryCubePosition.getEndPositions())
				if (scp.getRect(view.getScale(), view.getXMargin()).contains(arg0.getPoint()))
					endPosition = scp;
			if (endPosition != null) {
				boolean occupied = false;
				for (StoryCube sc : model.getCubes()) {
					if (sc.getCubePos().equals(endPosition)) {
						occupied = true;
					}
				}
				if (!occupied)
					this.selectedCube.setCubePos(endPosition);
			}
			this.selectedCube = null;
		}
	}
	
}

package edu.udel.cisc275.section011.team0.EstuaryGame.Controller;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;

import edu.udel.cisc275.section011.team0.EstuaryGame.Model.StoryCube;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.StoryCubePosition;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.StoryModel;
import edu.udel.cisc275.section011.team0.EstuaryGame.View.StoryView;

public class StoryController extends MouseAdapter implements Controller {

	private StoryModel model;
	private StoryView view;
	private StoryCube selectedCube;
	
	public StoryController () {
		model = new StoryModel();
		view = new StoryView(model);
		view.addMouseListener(this);
	}
	
	@Override
	public void tick() {
		view.repaint();
		model.tick();
	}

	@Override
	public JComponent getView() {
		return view;
	}
	
	@Override
	public void mouseClicked (MouseEvent arg0) {
		if (!model.isRolled()) {
			model.roll();
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

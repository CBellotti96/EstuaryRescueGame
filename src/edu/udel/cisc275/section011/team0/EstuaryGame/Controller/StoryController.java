package edu.udel.cisc275.section011.team0.EstuaryGame.Controller;

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
	public void tick(){
		view.repaint();
	}

	@Override
	public JComponent getView() {
		return view;
	}
	
	@Override
	public void mouseClicked (MouseEvent arg0) {
		if (selectedCube == null) {
			StoryCubePosition scp = view.containerOf(arg0, StoryCubePosition.values());
			if (scp == null)
				return;
			StoryCube sc = model.containedIn(scp);
			if (sc == null)
				return;
			view.setOffsets(arg0, sc);
			sc.setSelected(true);
			this.selectedCube = sc;
		} else {
			this.selectedCube.setSelected(false);
			StoryCubePosition scp = view.containerOf(arg0, StoryCubePosition.cubeEndPositions);
			if (scp != null) {
				StoryCube sc = model.containedIn(scp);
				if (sc == null)
					this.selectedCube.setCubePosition(scp);
			}			
			this.selectedCube = null;
		}
	}
	
}

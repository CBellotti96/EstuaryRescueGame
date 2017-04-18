package edu.udel.cisc275.section011.team0.EstuaryGame.View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;

import edu.udel.cisc275.section011.team0.EstuaryGame.Model.StoryCube;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.StoryCubePosition;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.StoryModel;

public class StoryView extends JComponent {
	
	private StoryModel model;
	
	private int HEIGHT;
	private int WIDTH;
	private int SIZE;
	private int MARGIN;
	
	public StoryView (StoryModel model) {
		this.model = model;
		HEIGHT = getHeight();
		WIDTH = getWidth();
		SIZE = Math.min(HEIGHT/12, WIDTH/16);
		MARGIN = Math.max(WIDTH - SIZE * 16, HEIGHT - SIZE * 12) / 2;
	}
	
	public void paint(Graphics g){
		HEIGHT = getHeight();
		WIDTH = getWidth();
		SIZE = Math.min(HEIGHT/12, WIDTH/16);
		MARGIN = Math.max(WIDTH - SIZE * 16, HEIGHT - SIZE * 12) / 2;
		renderFinalPositions(g);
		renderCubes(g);
	}
	
	private void renderFinalPositions (Graphics g) {
		g.setColor(Color.BLACK);
		for (StoryCubePosition scp : StoryCubePosition.cubeEndPositions) {
			scp.setSize(SIZE);
			scp.setMargin(MARGIN);
			Rectangle r = scp.getRect();
			g.drawRect(r.x, r.y, r.width, r.height);
		}
	}
	
	private void renderCubes (Graphics g) {
		for (StoryCube sc : this.model.getCubes()) {
			sc.setSize(SIZE);
			if (!model.isRolled()) {
				sc.setX(WIDTH/2 - SIZE + MARGIN);
				sc.setY(HEIGHT/2 - SIZE);
			}
			g.setColor(sc.getCubeFace().getColor());
			g.fillRect(sc.getX(), sc.getY(), sc.getSize(), sc.getSize());
		}
	}
}

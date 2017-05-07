package edu.udel.cisc275.section011.team0.EstuaryGame.View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import edu.udel.cisc275.section011.team0.EstuaryGame.Model.StoryCube;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.StoryCubePosition;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.StoryModel;

public class StoryView extends JPanel {
	
	private StoryModel model;
	
	private int height;
	private int width;
	private double scale;
	private int xMargin;
	
	private JTextArea story;
	
	public double getScale () {
		return this.scale;
	}
	
	public int getXMargin () {
		return this.xMargin;
	}
	
	public StoryView (StoryModel model) {
		this.model = model;
		this.story = new JTextArea(20, 200);
		story.setPreferredSize(new Dimension(100, 100));
		story.setLocation(200, 200);
		story.setBackground(Color.RED);
		story.setVisible(true);
		this.add(story);
	}
	
	public void updateParameters () {
		this.height = getHeight();
		this.width = getWidth();
		this.scale = Math.min(width / StoryModel.xCoordMax, height / StoryModel.yCoordMax);
		this.xMargin = (int) ((width - StoryModel.xCoordMax * scale) / 2);
	}
	
	public void paint(Graphics g){
		super.paintComponent(g);
		updateParameters();
		renderFinalPositions(g);
		renderCubes(g);
	}
	
	private void renderFinalPositions (Graphics g) {
		g.setColor(Color.BLACK);
		for (StoryCubePosition scp : StoryCubePosition.getEndPositions()) {
			Rectangle r = scp.getRect(scale, xMargin);
			g.drawRect(r.x, r.y, r.width, r.height);
		}
	}
	
	private void renderCubes (Graphics g) {
		if (scale != 0) {
			StoryCube selected = null;
			for (StoryCube sc : this.model.getCubes()) {
				if (sc.isSelected()) {
					selected = sc;
				} else {
					g.setColor(sc.getCubeFace().getColor());
					Rectangle r = sc.getRect(scale, xMargin);
					g.fillRect(r.x, r.y, r.width, r.height);
				}
			}
		
			if (selected != null) {
				g.setColor(selected.getCubeFace().getColor());
				Point mousePos = this.getMousePosition();
				int size = (int) (scale * StoryCube.size);
				g.fillRect(mousePos.x - size / 2, mousePos.y - size / 2, size, size);
			}
		}
	}
}

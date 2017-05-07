package edu.udel.cisc275.section011.team0.EstuaryGame.View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import edu.udel.cisc275.section011.team0.EstuaryGame.Model.StoryCube;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.StoryCubePosition;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.StoryModel;

public class StoryView extends JPanel {
	
	private StoryModel model;
	
	private int height;
	private int width;
	private double scale;
	private int xMargin;
	
	private JTextPane title;
	private JTextPane story;
	
	public double getScale () {return this.scale;}	
	public int getXMargin () {return this.xMargin;}
	
	public StoryView (StoryModel model) {
		this.model = model;
		this.setLayout(null);
	}
	
	@Override
	public String toString () {
		return "(" + height + ", " + width + "); (" + scale + " | " + xMargin + ")";
	}
	
	public void initializeTextBoxes () {
		this.title = new JTextPane();
		SimpleAttributeSet attribs = new SimpleAttributeSet();
		StyleConstants.setAlignment(attribs, StyleConstants.ALIGN_CENTER);
		title.setParagraphAttributes(attribs, true);
		title.setBackground(Color.RED);
		title.setText("Your title here!");
		this.add(title);
		
		this.story = new JTextPane();
		story.setParagraphAttributes(attribs, true);
		story.setBackground(Color.RED);
		story.setText("Your story here!");
		this.add(story);
	}
	
	public void updateParameters () {
		this.height = getHeight();
		this.width = getWidth();
		this.scale = Math.min(width / StoryModel.xCoordMax, height / StoryModel.yCoordMax);
		this.xMargin = (int) ((width - StoryModel.xCoordMax * scale) / 2);
		if (title != null)
			this.title.setBounds(width / 4, 0, width / 2, height / 16);
		if (story != null)
			this.story.setBounds(0, height - height / 8, width, height / 8);
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		super.paintComponents(g);
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

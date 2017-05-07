package edu.udel.cisc275.section011.team0.EstuaryGame.View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import edu.udel.cisc275.section011.team0.EstuaryGame.Model.StoryCube;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.StoryCubePosition;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.StoryModel;

public class StoryView extends JPanel {
	
	private StoryModel model;
	
	public final static int numImages = 15;
	private final static String[] filePaths = {"Final Images/Animals/bluecrab_1.png", "Final Images/Animals/bogturtle_right_2.png", 
												"Final Images/Animals/fish_catfish_right_0.png", "Final Images/Animals/heron_right.png",
												"Final Images/Animalshorseshoe_crab_right_0.png", "Final Images/Animals/redknot_right_0.png",
												"Final Images/Animals/clam_back_0.png", "Final Images/Environment Misc/rainyWeather.png",
												"Final Images/Environment Misc/sunnyWeather.png", "Final Images/Objects/vessel.png",
												"Final Images/People and Humanoids/captain_estuary_punch.png", 
												"Final Images/People and Humanoids/fisherman_1.png",
												"Final Images/People and Humanoids/monster_non_naked_large.png",
												"Final Images/People and Humanoids/researcher_withClipboard_angry.png",
												"Final Images/People and Humanoids/volunteer_whiteshirt_pickup_right_1.png"};
	private BufferedImage[] images = new BufferedImage[numImages];
	private BufferedImage background;
	private Color backgroundColor = new Color(127, 127, 255, 127);
	
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
		try {
			background = ImageIO.read(new File("Final Images/Backgrounds/2D_estuary.jpg"));
		} catch (IOException e) {
			background = null;
		}
		for (int i = 0; i < numImages; i++)
			try {
				images[i] = ImageIO.read(new File(filePaths[i]));
			} catch (IOException e) {
				images[i] = null;
			}
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
		title.setBackground(backgroundColor);
		title.setText("Your title here!");
		this.add(title);
		
		this.story = new JTextPane();
		story.setParagraphAttributes(attribs, true);
		story.setBackground(backgroundColor);
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
		g.drawImage(background, 0, 0, width, height, null);
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
					BufferedImage image = images[sc.getCubeFace()];
					Rectangle r = sc.getRect(scale, xMargin);
					g.setColor(backgroundColor);
					g.fillRect(r.x, r.y, r.width, r.height);
					g.drawImage(image, r.x, r.y, r.width, r.height, null);
					g.setColor(Color.BLACK);
					g.drawRect(r.x, r.y, r.width, r.height);
				}
			}
		
			if (selected != null) {
				BufferedImage image = images[selected.getCubeFace()];
				Point mousePos = this.getMousePosition();
				int size = (int) (scale * StoryCube.size);
				g.setColor(backgroundColor);
				g.fillRect(mousePos.x - size / 2, mousePos.y - size / 2, size, size);
				g.drawImage(image, mousePos.x - size / 2, mousePos.y - size / 2, size, size, null);
				g.setColor(Color.BLACK);
				g.drawRect(mousePos.x - size / 2, mousePos.y - size / 2, size, size);
			}
		}
	}
}

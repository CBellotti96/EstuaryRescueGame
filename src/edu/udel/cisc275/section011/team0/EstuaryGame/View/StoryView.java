package edu.udel.cisc275.section011.team0.EstuaryGame.View;

/**
 * A StoryView extends JPanel and displays the contents of the Story Cubes minigame
 * @see StoryController
 * @see StoryModel
 * @author Ben Wiswell
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import edu.udel.cisc275.section011.team0.EstuaryGame.Model.StoryCube;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.StoryCubePosition;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.StoryModel;

public class StoryView extends JPanel {

	private static final long serialVersionUID = -4744510256712300607L;

	private StoryModel model;
	
	public final static int numImages = 15;
	private final static String[] filePaths = {"Final Images/Animals/bluecrab_1.png", "Final Images/Animals/bogturtle_right_2.png", 
												"Final Images/Animals/fish_catfish_right_0.png", "Final Images/Animals/heron_right.png",
												"Final Images/Animals/horseshoe_crab_right_0.png", "Final Images/Animals/redknot_right_0.png",
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
	private final String titleText = "Your title here!";
	private final String storyText = "Your story here!";
	
	private JButton submit;
	private final String submitText = "Submit your story!";
	private boolean submitted;
	
	public double getScale () {return this.scale;}	
	public int getXMargin () {return this.xMargin;}
	
	
	/**
	 * @author Ben Wiswell
	 * StoryView constructor, loads in images of various story cube faces and the background
	 * @param model		The StoryModel to be displayed
	 */
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
		this.submitted = false;
		this.setLayout(null);
	}
	
	@Override
	public String toString () {
		return "(" + height + ", " + width + "); (" + scale + " | " + xMargin + ")";
	}
	
	/**
	 * @author Ben Wiswell
	 * Initializes the text panes for the title and story. Sets the text to align to the center of the pane
	 * and sets the text to reset when initially clicked.
	 */
	public void initializeTextBoxes () {	
		SimpleAttributeSet attribs = new SimpleAttributeSet();
		StyleConstants.setAlignment(attribs, StyleConstants.ALIGN_CENTER);
		MouseAdapter titleAdapter = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String text = title.getText();
				if (text.equalsIgnoreCase(titleText))
					title.setText("");
			}
		};
		MouseAdapter storyAdapter = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String text = story.getText();
				if (text.equalsIgnoreCase(storyText))
					story.setText("");
			}
		};
		ActionListener submitListener = new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				boolean allEndPos = true;
				for (StoryCube sc : model.getCubes()) {
					if (!StoryCubePosition.getEndPositions().contains(sc.getCubePos())) {
						allEndPos = false;
					}
				}
				if (allEndPos) {
					submitted = true;
				}
			}
		};

		this.title = new JTextPane();
		title.addMouseListener(titleAdapter);
		StyleConstants.setFontSize(attribs, 24);
		title.setParagraphAttributes(attribs, true);
		title.setBackground(backgroundColor);
		title.setText(titleText);
		this.add(title);
		
		this.story = new JTextPane();
		story.addMouseListener(storyAdapter);
		StyleConstants.setFontSize(attribs, 16);
		story.setParagraphAttributes(attribs, true);
		story.setBackground(backgroundColor);
		story.setText(storyText);
		this.add(story);
		
		this.submit = new JButton();
		submit.addActionListener(submitListener);
		StyleConstants.setFontSize(attribs, 24);
		submit.setBackground(backgroundColor);
		submit.setText(submitText);
		this.add(submit);
	}
	
	/**
	 * @author Ben Wiswell
	 * Updates the height, width, scale, and margin of the StoryView according to the size of the JPanel
	 */
	public void updateParameters () {
		this.height = getHeight();
		this.width = getWidth();
		this.scale = Math.min(width / StoryModel.xCoordMax, height / StoryModel.yCoordMax);
		this.xMargin = (int) ((width - StoryModel.xCoordMax * scale) / 2);
		if (title != null)
			title.setBounds(width / 4, 0, width / 2, height / 16);
		if (story != null)
			story.setBounds(0, height - height / 8, width, height / 8);
		if (submit != null)
			submit.setBounds(width / 2 - width / 8, height - height / 4, width / 4, height / 16);
	}
	
	/**
	 * @author Ben Wiswell
	 * Method to update the height, width, scale, and margin of the StoryView as well as paint the background, 
	 * text panes, final position outlines, and story cubes.
	 * @param g		The relevant graphics object
	 */
	@Override
	public void paint(Graphics g){
		updateParameters();
		super.paint(g);
		if (submitted) {
			this.removeAll();
			renderStory(g);
		} else {
			g.drawImage(background, 0, 0, width, height, null);
			super.paintComponents(g);
			renderFinalPositions(g);
			renderCubes(g);
		}
	}

	/**
	 * @author Ben Wiswell
	 * Method to paint the outlines of the final story cube positions.
	 * @param g		The relevant graphics object
	 */
	private void renderFinalPositions (Graphics g) {
		g.setColor(Color.BLACK);
		for (StoryCubePosition scp : StoryCubePosition.getEndPositions()) {
			Rectangle r = scp.getRect(scale, xMargin);
			g.drawRect(r.x, r.y, r.width, r.height);
		}
	}
	
	/**
	 * @author Ben Wiswell
	 * Method to paint the outlines of the story cubes.
	 * @param g		The relevant graphics object
	 */
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
	
	private void renderStory (Graphics g) {	
		int numCubes = model.getCubes().size();
		int scaledSize = (int) (scale * StoryCube.size);
		int borderSize = (width - numCubes * scaledSize) / 2;
		Rectangle leftBorder = new Rectangle(0, height - scaledSize, borderSize, scaledSize);
		Rectangle rightBorder = new Rectangle(width - borderSize, height - scaledSize, borderSize, scaledSize);
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(leftBorder.x, leftBorder.y, leftBorder.width, leftBorder.height);
		g.fillRect(rightBorder.x, rightBorder.y, rightBorder.width, rightBorder.height);
		
		StoryCube[] cubes = new StoryCube[numCubes];
		for (StoryCube sc : model.getCubes()) {
			cubes[StoryCubePosition.getEndPositions().indexOf(sc.getCubePos())] = sc;
		}
		for (int i = 0; i < numCubes; i++) {
			g.drawImage(images[cubes[i].getCubeFace()], borderSize + scaledSize * i, height - scaledSize, scaledSize, scaledSize, null);
		}
		
		SimpleAttributeSet attribs = new SimpleAttributeSet();
		StyleConstants.setAlignment(attribs, StyleConstants.ALIGN_CENTER);
		
		JTextPane titlePane = new JTextPane();
		JTextPane storyPane = new JTextPane();

		StyleConstants.setFontSize(attribs, 24);
		titlePane.setParagraphAttributes(attribs, true);
		titlePane.setBackground(Color.LIGHT_GRAY);
		titlePane.setText(title.getText());
		titlePane.setBounds(0, 0, width, height / 8);
		this.add(titlePane);

		StyleConstants.setFontSize(attribs, 24);
		storyPane.setParagraphAttributes(attribs, true);
		storyPane.setBackground(Color.LIGHT_GRAY);
		storyPane.setText(story.getText());
		storyPane.setBounds(0, height / 8, width, height - scaledSize);
		this.add(storyPane);
	}
}

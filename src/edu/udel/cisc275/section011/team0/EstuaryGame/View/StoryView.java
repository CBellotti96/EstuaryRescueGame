package edu.udel.cisc275.section011.team0.EstuaryGame.View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;

import edu.udel.cisc275.section011.team0.EstuaryGame.Model.StoryCube;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.StoryCubePosition;
import edu.udel.cisc275.section011.team0.EstuaryGame.Model.StoryModel;

public class StoryView extends JComponent {
	
	private StoryModel model;
	
	private int HEIGHT;
	private int WIDTH;
	private int SCALE;
	private int MARGIN;
	private int xOffset;
	private int yOffset;
	
	public void setOffsets (MouseEvent me, StoryCube sc) {
		this.xOffset = me.getX() - scale(sc.getX());
		this.yOffset = me.getY() - scale(sc.getY());
	}
	
	public StoryView (StoryModel model) {
		this.model = model;
	}
	
	public int scale (int n) {
		return n * SCALE;
	}
	
	public StoryCubePosition containerOf (MouseEvent me, StoryCubePosition[] scpArray) {
		for (StoryCubePosition scp : scpArray) {
			int size = scale(scp.getSize());
			int scX = scale(scp.getX());
			int scY = scale(scp.getY());
			int meX = me.getX();
			int meY = me.getY();
			if (scX <= meX && meX <= scX + size && scY <= meY && meY <= scY + size) {
				return scp;
			}
		}
		return null;
	}
	
	private void renderCubes (Graphics g) {
		for (StoryCube sc : this.model.getCubes()) {
			int scX, scY;
			int scSize = scale(sc.getSize());
			g.setColor(sc.getCubeFace().getColor());
			if (sc.isSelected()) {
				scX = MouseInfo.getPointerInfo().getLocation().x - xOffset;
				scY = MouseInfo.getPointerInfo().getLocation().y - yOffset;
			} else {
				scX = scale(sc.getX()) + MARGIN;
				scY = scale(sc.getY());
			}
			g.fillRect(scX, scY, scSize, scSize);
			g.setColor(Color.WHITE);
			g.drawString(Integer.toString(sc.getCubeFace().getID()), scX + scSize/2, scY + scSize/2);
		}
	}
	
	private void renderFinalPositions (Graphics g) {
		g.setColor(Color.BLUE);
		for (int i = 0; i < 8; i++) {
			int x = i * 2 * SCALE + MARGIN;
			int y = 5 * SCALE;
			int size = SCALE * 2;
			g.drawRect(x, y, size, size);
		}
	}
	
	public void paint(Graphics g){
		HEIGHT = getHeight();
		WIDTH = getWidth();
		SCALE = Math.min(HEIGHT/12, WIDTH/16);
		MARGIN = Math.max(WIDTH - SCALE * 16, HEIGHT - SCALE * 12) / 2;
		renderFinalPositions(g);
		renderCubes(g);
	}
}

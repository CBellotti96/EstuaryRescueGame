package edu.udel.cisc275.section011.team0.EstuaryGame.View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
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
	private final int speed = 5;
	
	public void setOffsets (MouseEvent me, StoryCube sc) {
		this.xOffset = me.getX() - sc.getX();
		this.yOffset = me.getY() - sc.getY();
	}
	
	public StoryView (StoryModel model) {
		this.model = model;
		HEIGHT = getHeight();
		WIDTH = getWidth();
		SCALE = Math.min(HEIGHT/12, WIDTH/16);
		MARGIN = Math.max(WIDTH - SCALE * 16, HEIGHT - SCALE * 12) / 2;
	}
	
	public int scale (int n) {
		return n * SCALE;
	}
	
	public StoryCubePosition containerOf (Point p, StoryCubePosition[] scpArray) {
		for (StoryCubePosition scp : scpArray) {
			int size = scale(scp.getSize());
			int scX = scale(scp.getX());
			int scY = scale(scp.getY());
			if (scX <= p.x && p.x <= scX + size && scY <= p.y && p.y <= scY + size) {
				return scp;
			}
		}
		return null;
	}
	
	private void renderCubes (Graphics g) {
		for (StoryCube sc : this.model.getCubes()) {
			int cpX = scale(sc.getCubePosition().getX());
			int cpY = scale(sc.getCubePosition().getY());
			int scSize = scale(sc.getCubePosition().getSize());
			sc.setSize(scSize);
			
			if (!sc.isRolled() && sc.isRolling()) {
				sc.setX(WIDTH/2 - scSize/2);
				sc.setY(HEIGHT/2 - scSize/2);
				sc.setRolled(true);
			} else if (sc.isRolling()) {
				boolean doneRollingX = false;
				if (sc.getX() < cpX - speed)
					sc.vX(speed);

				else if (sc.getX() > cpX + speed)
					sc.vX(-speed);
				else
					doneRollingX = true;
				
				if (sc.getY() < cpY - speed)
					sc.vY(speed);
				else if (sc.getY() > cpY + speed)
					sc.vY(-speed);
				else if (doneRollingX)
					sc.setRolling(false);
				
				if (sc.getX()%2 == 0)
					sc.randomFace();
				g.setColor(sc.getCubeFace().getColor());
				g.fillRect(sc.getX(), sc.getY(), scSize, scSize);
			} else {
				g.setColor(sc.getCubeFace().getColor());
				int scX, scY;
				if (!sc.isRolled()) {
					scX = WIDTH/2 - scSize/2;
					scY = HEIGHT/2 - scSize/2;
				} else if (sc.isSelected()) {
					scX = MouseInfo.getPointerInfo().getLocation().x - xOffset;
					scY = MouseInfo.getPointerInfo().getLocation().y - yOffset;
				} else {
					scX = cpX + MARGIN;
					scY = cpY;
				}
				g.fillRect(scX, scY, scSize, scSize);
			}
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

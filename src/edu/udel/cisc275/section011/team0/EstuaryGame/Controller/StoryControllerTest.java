package edu.udel.cisc275.section011.team0.EstuaryGame.Controller;

import static org.junit.Assert.*;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;

import org.junit.Test;

import edu.udel.cisc275.section011.team0.EstuaryGame.Model.StoryCube;
import edu.udel.cisc275.section011.team0.EstuaryGame.View.StoryView;

public class StoryControllerTest {

	@Test
	public void testMouseClickedMouseEvent1() {
		StoryController sc = new StoryController();
		MouseEvent me = new MouseEvent(sc.getView(), MouseEvent.MOUSE_CLICKED, System.currentTimeMillis(), 0, 5, 5, 1, false);
		sc.mouseClicked(me);
		assertTrue(sc.getModel().isRolled());
	}
	
	@Test
	public void testMouseClickedMouseEvent2() {
		StoryController sc = new StoryController();
		StoryCube testCube = sc.getModel().getCubes().get(1);
		JComponent testView = sc.getView();
		
		MouseEvent me = new MouseEvent(sc.getView(), MouseEvent.MOUSE_CLICKED, System.currentTimeMillis(), 0, 5, 5, 1, false);
		sc.mouseClicked(me);
		
		System.out.println(testView);
		
		StoryView testStoryView = (StoryView) testView;
		Rectangle r = testCube.getRect(testStoryView.getScale(), testStoryView.getXMargin());
		me = new MouseEvent(sc.getView(), MouseEvent.MOUSE_CLICKED, System.currentTimeMillis(), 0, (int) r.getCenterX(), (int) r.getCenterY(), 1, false);
		sc.mouseClicked(me);
		assertTrue(sc.getModel().getCubes().get(1).isSelected());
	}

}

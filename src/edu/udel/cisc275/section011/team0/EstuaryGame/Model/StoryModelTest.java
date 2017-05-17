package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JSlider;

import org.junit.Test;

public class StoryModelTest {

	@Test
	public void testInitializeModel() {
		int n = 4;
		StoryModel sm = new StoryModel(n);
		ArrayList<StoryCube> cubes = new ArrayList<StoryCube>();
		for (int i = 0; i < n; i++)
			cubes.add(new StoryCube(i));
		assertEquals(cubes.size(), sm.getCubes().size());
		
	}

	@Test
	public void testTick() {
		int n = 4;
		StoryModel sm = new StoryModel(n);
		sm.roll();
		int rollState = sm.getCubes().get(0).getRollState() + 1;
		StoryCube moveTestCube = sm.getCubes().get(1);
		StoryCubePosition target = moveTestCube.getCubePos();
		int x = target.getX() * 2;
		int y = target.getY() * 2;
		moveTestCube.setX(x);
		moveTestCube.setY(y);
		sm.tick();
		assertEquals(rollState, sm.getCubes().get(0).getRollState());
		assertEquals(x - StoryCube.speed, (int) moveTestCube.getRect(1, 0).getCenterX() - 1);
		assertEquals(y - StoryCube.speed, (int) moveTestCube.getRect(1, 0).getCenterY() - 1);
	}

	@Test
	public void testRoll() {
		int n = 4;
		StoryModel sm = new StoryModel(n);
		sm.roll();
		boolean allRolling = true;
		for (StoryCube sc : sm.getCubes())
			if (!sc.isRolling())
				allRolling = false;
		assertTrue(allRolling);
	}
	
	@Test
	public void testGetSlider() {
		int n = 4;
		StoryModel sm = new StoryModel(n);
		JOptionPane jop = new JOptionPane();
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 4, 10, 8);
	    slider.setMajorTickSpacing(2);
	    slider.setPaintTicks(true);
	    slider.setPaintLabels(true);
		assertEquals(10, sm.getSlider(jop).getMaximum());
		assertEquals(4, sm.getSlider(jop).getMinimum());
	}

}

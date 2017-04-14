package edu.udel.cisc275.section011.team0.EstuaryGame.Common;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import edu.udel.cisc275.section011.team0.EstuaryGame.Controller.Controller;
import edu.udel.cisc275.section011.team0.EstuaryGame.Controller.MazeController;
import edu.udel.cisc275.section011.team0.EstuaryGame.Controller.MenuController;

public class Main extends JFrame implements ActionListener {
	
	private static Main instance;
	
	public static Main getInstance() {
		return instance;
	}
	
	private Controller currentController;

	private Main() {
		setBackground(Color.gray);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setVisible(true);
	}

	public static void main (String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				instance = new Main();

				Timer timer = new Timer(16, instance);
				timer.setActionCommand("Tick");
				timer.setRepeats(true);
				timer.start();
				
				instance.setController(new MenuController());
			}
		});
	}

	public void setController (Controller controller) {
		currentController = controller;
		getContentPane().removeAll();
		getContentPane().add(controller.getView());
		controller.getView().requestFocusInWindow();
		pack();
		setSize(800, 600);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("Tick".equals(e.getActionCommand())) {
			currentController.tick();
		}
	}



}

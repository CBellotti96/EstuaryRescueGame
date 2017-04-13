package edu.udel.cisc275.section011.team0.EstuaryGame.View;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class MazeView extends JComponent {
	
	private Rectangle salineGuageRect;
	private BufferedImage salineGaugeImg[];
	
	private Rectangle weatherIconRect;
	private BufferedImage sunWeatherIconImg;
	private BufferedImage rainWeatherIconImg;
	
	private Rectangle timerRect;
	
	private Rectangle miniMapRect;
	private BufferedImage mimiMapImg;
	
	private BufferedImage crabImg;
	private BufferedImage predatorImg[];
	private BufferedImage obstacleImage[];
	
	private BufferedImage sandTileImg;
	private BufferedImage waterTileImg;
	
	public void paint(Graphics g){
		return;
	}
	
}

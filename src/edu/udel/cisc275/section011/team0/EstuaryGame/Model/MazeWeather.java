package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum MazeWeather {

	SUN(1.0),
	RAIN(0.75);
	
	private static final List<MazeWeather> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();
	private double salinitySensitivity;
	
	MazeWeather(double scale){
		this.salinitySensitivity = scale;
	}
	
	public static MazeWeather randomMazeWeather()  {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}
	
	public double getSalinitySensitivity(){
		return salinitySensitivity;
	}
	
}

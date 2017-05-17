package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import org.junit.Test;
import static org.junit.Assert.*;

public class MazeWeatherTest {
	
	@Test
	public void MazeWeatherValuesTest(){
		assertNotNull(MazeWeather.valueOf("SUN"));
		assertNotNull(MazeWeather.valueOf("RAIN"));
	}
	
	@Test
	public void randomMazeWeatherTest(){
		MazeWeather weather = MazeWeather.randomMazeWeather();
		boolean weatherIsInstance = false;
		
		if (MazeWeather.RAIN == weather || MazeWeather.SUN == weather){
			weatherIsInstance = true;
		}
		
		assertTrue(weatherIsInstance);
	}
	
	@Test
	public void getSalinitySensitivityTest(){
		MazeWeather rain = MazeWeather.RAIN;
		MazeWeather sun = MazeWeather.SUN;
		
		assertEquals(0.75, rain.getSalinitySensitivity(), 0);
		assertEquals(1.0, sun.getSalinitySensitivity(), 0);
	}
	
}

package edu.udel.cisc275.section011.team0.EstuaryGame.Model;

import org.junit.Test;
import static org.junit.Assert.*;

public class MazeGameModelEnumTest {

	@Test
	public void MazeGameModeValuesTest(){
		assertNotNull(MazeGameMode.valueOf("TUTORIAL"));
		assertNotNull(MazeGameMode.valueOf("NORMAL"));
		assertNotNull(MazeGameMode.valueOf("WON"));
		assertNotNull(MazeGameMode.valueOf("LOST"));
	}
}

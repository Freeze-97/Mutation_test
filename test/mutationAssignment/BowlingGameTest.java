package mutationAssignment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BowlingGameTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test1() { // Open frame
		BowlingGame bowlingGame = new BowlingGame("[3,6][2,6][5,1][3,6][1,4][3,3][6,3][3,5][8,1][1,6]");
		assertEquals(76, bowlingGame.getScore());
	}
	
	@Test
	void test2() { // One strike
		BowlingGame bowlingGame = new BowlingGame("[10,0][2,6][5,1][3,6][1,4][3,3][6,3][3,5][8,1][1,6]");
		assertEquals(85, bowlingGame.getScore());
	}

	@Test
	void test3() { // Multiple strikes
		BowlingGame bowlingGame = new BowlingGame("[10,0][10,0][5,1][3,6][1,4][3,3][6,3][3,5][8,1][1,6]");
		assertEquals(100, bowlingGame.getScore());
	}
	
	@Test
	void test4() { // Spare
		BowlingGame bowlingGame = new BowlingGame("[4,6][2,6][5,1][3,6][1,4][3,3][6,3][3,5][8,1][1,6]");
		assertEquals(79, bowlingGame.getScore());
	}
	
	@Test
	void test5() { // Multiple spares
		BowlingGame bowlingGame = new BowlingGame("[4,6][4,6][5,1][3,6][1,4][3,3][6,3][3,5][8,1][1,6]");
		assertEquals(88, bowlingGame.getScore());
	}
	
	@Test
	void test6() { // All spares
		BowlingGame bowlingGame = new BowlingGame("[5,5][5,5][5,5][5,5][5,5][5,5][5,5][5,5][5,5][5,5][5]");
		assertEquals(150, bowlingGame.getScore());
	}
	
	@Test
	void test7() { // Alternate between strike and open frame
		BowlingGame bowlingGame = new BowlingGame("[10,0][2,6][10,0][3,6][10,0][3,3][10,0][3,5][10,0][1,6]");
		assertEquals(126, bowlingGame.getScore());
	}
	
	@Test
	void test8() { // Alternate between spare and open fram
		BowlingGame bowlingGame = new BowlingGame("[4,6][2,6][5,5][3,6][2,8][3,3][6,4][3,5][8,2][1,6]");
		assertEquals(100, bowlingGame.getScore());
	}
	
	@Test
	void test9() { // Mix of strike, spare and open frame
		BowlingGame bowlingGame = new BowlingGame("[10,0][2,6][5,1][3,6][6,4][3,3][6,3][3,5][8,1][1,6]");
		assertEquals(93, bowlingGame.getScore());
	}
	
	@Test
	void test10() { // Strike being followed by a spare
		BowlingGame bowlingGame = new BowlingGame("[10,0][5,5][5,1][3,6][1,4][3,3][6,3][3,5][8,1][1,6]");
		assertEquals(94, bowlingGame.getScore());
	}
	
	@Test
	void test11() { // Spare in the last frame
		BowlingGame bowlingGame = new BowlingGame("[3,6][2,6][5,1][3,6][1,4][3,3][6,3][3,5][8,1][4,6][7]");
		assertEquals(86, bowlingGame.getScore());
	}
	
	@Test
	void test12() { // Strike in the last frame (has to lead to two bonus throws)
		BowlingGame bowlingGame = new BowlingGame("[3,6][2,6][5,1][3,6][1,4][3,3][6,3][3,5][8,1][10,0][5,2]");
		assertEquals(86, bowlingGame.getScore());
	}
	
	@Test
	void test13() { // Spare in the last frame followed by a strike in the bonus throw will not lead to more throws 
		BowlingGame bowlingGame = new BowlingGame("[3,6][2,6][5,1][3,6][1,4][3,3][6,3][3,5][8,1][2,8][10]");
		assertEquals(89, bowlingGame.getScore());
	}
	
	@Test
	void test14() { // Getting max score (2 bonus throws, both strikes)
		BowlingGame bowlingGame = new BowlingGame("[10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,10]");
		assertEquals(300, bowlingGame.getScore());
	}
	
	@Test
	void test15() { // Getting lowest score
		BowlingGame bowlingGame = new BowlingGame("[0,0][0,0][0,0][0,0][0,0][0,0][0,0][0,0][0,0][0,0]");
		assertEquals(0, bowlingGame.getScore());
	}
	
	@Test
	void test16() { //  Over 10 in one throw
		BowlingGame bowlingGame = new BowlingGame("[12,0][2,6][5,1][3,6][1,4][3,3][6,3][3,5][8,1][1,6]");
		assertEquals(-1, bowlingGame.getScore());
	}
	
	@Test
	void test17() { // Less than 0 in one throw (If its possible for the user to input anything)
		BowlingGame bowlingGame = new BowlingGame("[-1,6][2,6][5,1][3,6][1,4][3,3][6,3][3,5][8,1][1,6]");
		assertEquals(-1, bowlingGame.getScore());
	}
	
	@Test
	void test18() { // Combined number is too high in one frame 
		BowlingGame bowlingGame = new BowlingGame("[8,6][2,6][5,1][3,6][1,4][3,3][6,3][3,5][8,1][1,6]");
		assertEquals(-1, bowlingGame.getScore());
	}
	
	@Test
	void test19() { // Give too many frames – 11 frame however the program gives the right result by ignoring the last frame
		BowlingGame bowlingGame = new BowlingGame("[3,6][2,6][5,1][3,6][1,4][3,3][6,3][3,5][8,1][1,6][2,5]");
		assertEquals(76, bowlingGame.getScore());
	}
	
	@Test
	void test20() { //  Give too few frames for one ten-pin game (9 frames)
		BowlingGame bowlingGame = new BowlingGame("[3,6][2,6][5,1][3,6][1,4][3,3][6,3][3,5][8,1]");
		assertEquals(-1, bowlingGame.getScore());
	}
	
	@Test
	void test21() { // Not adding bonus round 
		BowlingGame bowlingGame = new BowlingGame("[10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0]");
		assertEquals(-1, bowlingGame.getScore());
	}
	
	@Test
	void test22() { // Last frame spare but no bonus round
		BowlingGame bowlingGame = new BowlingGame("[3,6][2,6][5,1][3,6][1,4][3,3][6,3][3,5][8,1][4,6]");
		assertEquals(-1, bowlingGame.getScore());
	}
	
	@Test
	void test23() { // Last is strike but no bonus round
		BowlingGame bowlingGame = new BowlingGame("[3,6][2,6][5,1][3,6][1,4][3,3][6,3][3,5][8,1][10,0]");
		assertEquals(-1, bowlingGame.getScore());
	}
	
	/*@Test
	void test24() { // Incorrect 12 frames 
		BowlingGame bowlingGame = new BowlingGame("[3,6][2,6][5,1][3,6][1,4][3,3][6,3][3,5][8,1][0,10][5,2][3,4]");
		assertEquals(-1, bowlingGame.getScore());
	}*/
	
}

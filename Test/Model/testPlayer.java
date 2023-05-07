package Model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class testPlayer {
	Pawn pawnYellow = new Pawn(PlayerColor.AMARELO);
	Pawn pawnYellow2 = new Pawn(PlayerColor.AMARELO);
	Pawn pawnYellow3 = new Pawn(PlayerColor.AMARELO);
	Pawn pawnYellow4 = new Pawn(PlayerColor.AMARELO);	
	Pawn pawnRed = new Pawn(PlayerColor.VERMELHO);
	Pawn pawnRed2 = new Pawn(PlayerColor.VERMELHO);
	Pawn pawnRed3 = new Pawn(PlayerColor.VERMELHO);
	Pawn pawnRed4 = new Pawn(PlayerColor.VERMELHO);
	Pawn pawnBlue = new Pawn(PlayerColor.AZUL);
	Pawn pawnBlue2 = new Pawn(PlayerColor.AZUL);
	Pawn pawnBlue3 = new Pawn(PlayerColor.AZUL);
	Pawn pawnBlue4 = new Pawn(PlayerColor.AZUL);
	Pawn pawnGreen = new Pawn(PlayerColor.VERDE);
	Pawn pawnGreen2 = new Pawn(PlayerColor.VERDE);
	Pawn pawnGreen3 = new Pawn(PlayerColor.VERDE);
	Pawn pawnGreen4 = new Pawn(PlayerColor.VERDE);
	Player playerYellow = new Player(2, pawnYellow, pawnYellow2, pawnYellow3, pawnYellow4);	
	Player playerRed = new Player(15, pawnRed, pawnRed2, pawnRed3, pawnRed4);
	Player playerBlue = new Player(28, pawnBlue, pawnBlue2, pawnBlue3, pawnBlue4);
	Player playerGreen = new Player(41, pawnGreen, pawnGreen2, pawnGreen3, pawnGreen4);
	ArrayList<Integer> positions = new ArrayList<Integer>();
	
	
	@Test
	void testsStartHouse() {
		assertEquals("The initial house of the yellow player was stored incorrectly.",2, playerYellow.getStartHouse());
		assertEquals("The initial house of the red player was stored incorrectly.",15, playerRed.getStartHouse());
		assertEquals("The initial house of the blue player was stored incorrectly.",28, playerBlue.getStartHouse());
		assertEquals("The initial house of the green player was stored incorrectly.",41, playerGreen.getStartHouse());
	}
	
    @Test
    void testIncPawnsFinished() {
        assertFalse("Error in the function pawnsFinished",playerYellow.isWinner());
        
        playerYellow.incPawnsFinished();
        assertFalse("Error in the function pawnsFinished",playerYellow.isWinner());
        
        playerYellow.incPawnsFinished();
        playerYellow.incPawnsFinished();
        assertFalse("Error in the function pawnsFinished",playerYellow.isWinner());
        
        playerYellow.incPawnsFinished();
        assertTrue("Error in the function pawnsFinished",playerYellow.isWinner());
    }

	@Test
	void testsPawnsnInBase() {
		assertEquals("Incorrect initialization of pawnsInBase",4,playerRed.getHowManyPawnsInBase());
		playerRed.decPawnsInBase();
		assertEquals("Incorrect count in decPawnsInBase",3,playerRed.getHowManyPawnsInBase());
		playerRed.decPawnsInBase();
		playerRed.decPawnsInBase();
		assertEquals("Incorrect count in decPawnsInBase",1,playerRed.getHowManyPawnsInBase());
		playerRed.incPawnsInBase();
		assertEquals("Incorrect count in incPawnsInBase",2,playerRed.getHowManyPawnsInBase());
		playerRed.incPawnsInBase();
		playerRed.decPawnsInBase();
		assertEquals("Incorrect count in incPawnsInBase in conjunction with decPawnsInBase",2,playerRed.getHowManyPawnsInBase());
		
	}
	
	@Test
	void testsPawnsMoveIndentification() { 
		pawnBlue.addMove(1);
		pawnBlue.addMove(6);
		pawnBlue.addMove(6);
		pawnBlue2.addMove(2);
		pawnBlue3.addMove(3);
		pawnBlue4.addMove(4);
		positions.add(41);
		positions.add(30);
		positions.add(31);
		positions.add(32);
		assertEquals("Error in adding pawn movements", positions, playerBlue.getAllPawnsBoardposition());
	}
	
}

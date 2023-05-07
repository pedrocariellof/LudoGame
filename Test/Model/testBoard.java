package Model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class testBoard {

	 SingletonBoard board = SingletonBoard.getInstance(52);
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

	    
	    @Test
	    void testHousePositions() {
	    	board.setBoard();
	        assertTrue("Error recognizing the initial house", board.isInitialHousePositions(2));
	        assertTrue("Error recognizing the initial house", board.isInitialHousePositions(15));
	        assertTrue("Error recognizing the initial house", board.isInitialHousePositions(28));
	        assertTrue("Error recognizing the initial house", board.isInitialHousePositions(41));
	        assertFalse("Error recognizing the initial house", board.isInitialHousePositions(1));
	    }
	    
	    @Test
	    void testSafeHousePositions() {
	        assertTrue("Error recognizing the safe house", board.isSafeHousePosition(10));
	        assertTrue("Error recognizing the safe house", board.isSafeHousePosition(23));
	        assertTrue("Error recognizing the safe house", board.isSafeHousePosition(36));
	        assertTrue("Error recognizing the safe house", board.isSafeHousePosition(49));
	        assertFalse("Error recognizing the safe house", board.isSafeHousePosition(5));
	    }

	    @Test
	    void testFinalHouse() {
	        assertTrue("Error recognizing the final house", board.isFinalHouse(0));
	        assertTrue("Error recognizing the final house", board.isFinalHouse(13));
	        assertTrue("Error recognizing the final house", board.isFinalHouse(26));
	        assertTrue("Error recognizing the final house", board.isFinalHouse(39));
	        assertFalse("Error recognizing the final house", board.isFinalHouse(12));
	    }
	    @Test
	    void testGetHousePosition() {
	        House house = board.getHousePosition(0);
	        assertNotNull("Function getHousePosition is not working properly",house);
	    }

	    @Test
	    void testHaveBarrier() {
	        House house = board.getHousePosition(2);
	        assertFalse("Function haveBarrier is not working properly",board.haveBarrier(house));
	        house.setBarrierUp();
	        assertTrue("Function haveBarrier is not working properly",board.haveBarrier(house));
	    }

	    @Test
	    void testComparePawns() {
	        House house = board.getHousePosition(3);
	        Pawn pawn = new Pawn(PlayerColor.AZUL);
	        Pawn pawn2 = new Pawn(PlayerColor.VERMELHO);
	        Pawn pawn3 = new Pawn(PlayerColor.AZUL);
	        house.addPawn(pawn);
	        assertFalse("Function comparePawns is not working properly",board.comparePawns(pawn2, house));
	        house.removePawn(pawn);
	        house.addPawn(pawn3);
	        assertTrue("Function comparePawns is not working properly",board.comparePawns(pawn3, house));
	    }

	    @Test
	    void testPossibleMove() {
	        // Test with a pawn that is in the initial house and has a possible move
	        assertTrue(board.possibleMove(pawnBlue, playerBlue, 2, 6));
	        House house = board.getHousePosition(4);
	        house.setBarrierUp();
	        // Test with a pawn that is in the initial house but has a barrier in front
	        assertFalse(board.possibleMove(pawnBlue, playerBlue, 1, 5));
	        house.setBarrierDown();
	        // Test with a pawn that is already in the final line and has a possible move
	        assertTrue(board.possibleMove(pawnGreen, playerGreen, 50, 2));
	        
	        // Test with a pawn that is already in the final line but would exceed the limit with the dice roll
	        assertFalse(board.possibleMove(pawnGreen, playerGreen, 40, 45));
	        
	        // Test with a pawn that is in an intermediate position and has a possible move
	        assertTrue(board.possibleMove(pawnRed, playerRed, 13, 4));
	        House house2 = board.getHousePosition(15);
	        house2.setBarrierUp();
	        // Test with a pawn that is in an intermediate position but has a barrier in front
	        assertFalse(board.possibleMove(pawnRed, playerRed, 13, 3));
	        house.addPawn(pawnYellow3);
	        // Test with a pawn that is in the initial house and has a same color pawn in front
	        assertFalse(board.possibleMove(pawnYellow, playerYellow, 1, 6));
	        house2.setBarrierDown();
	        house2.addPawn(pawnYellow4);
	        // Test with a pawn that is in an intermediate position and has a same color pawn in front
	        assertFalse(board.possibleMove(pawnYellow2, playerYellow, 9, 4));
	    }
}

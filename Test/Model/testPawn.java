package Model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.jupiter.api.Test;

class testPawn {
	Pawn pawnYellow = new Pawn(PlayerColor.AMARELO);
	Pawn pawnRed = new Pawn(PlayerColor.VERMELHO);
	Pawn pawnBlue = new Pawn(PlayerColor.AZUL);
	Pawn pawnGreen = new Pawn(PlayerColor.VERDE);

	@Test 
	void getColor() {
		assertEquals("PlayerColor.AMARELO generates the wrong color", 1024, pawnYellow.getColor());
		assertEquals("PlayerColor.VERMELHO generates the wrong color\"", 256, pawnRed.getColor());
		assertEquals("PlayerColor.AZUL generates the wrong color\"", 768, pawnBlue.getColor());
		assertEquals("PlayerColor.VERDE generates the wrong color\"", 512, pawnGreen.getColor());
	}
	
	@Test 
	void pawnMove() {
		assertEquals("Error on the pawn start location", 0, pawnYellow.getTotalMoves());
		pawnYellow.addMove(1);
		assertEquals("Error in pawn.addMove()", 1, pawnYellow.getTotalMoves());
		pawnYellow.addMove(2);
		assertEquals("Error in pawn.addMove()", 3, pawnYellow.getTotalMoves());
		pawnYellow.addMove(4);
		assertEquals("Error in pawn.addMove()", 7, pawnYellow.getTotalMoves());
		pawnYellow.addMove(5);
		assertEquals("Error in pawn.addMove()", 12, pawnYellow.getTotalMoves());
		pawnYellow.addMove(6);
		assertEquals("Error in pawn.addMove()", 18, pawnYellow.getTotalMoves());
		pawnYellow.setPawnToBase();
		assertEquals("Error in pawn.setPawnToBase()", 0, pawnYellow.getTotalMoves());
		for (int i = 0;i < 8;i++)
			pawnYellow.addMove(6);
		pawnYellow.addMove(4);
		assertEquals("Error in pawn.addMove()", 52, pawnYellow.getTotalMoves());
	}
	
	@Test
	void pawnCompare() {
		assertNotSame("Different pawns(yellow and blue) returning true in equals",pawnYellow.equals(pawnBlue));
		assertNotSame("Different pawns(yellow and red) returning true in equals",pawnYellow.equals(pawnRed));
		assertNotSame("Different pawns(yellow and green) returning true in equals",pawnYellow.equals(pawnGreen));
		assertNotSame("Different pawns(red and blue) returning true in equals",pawnBlue.equals(pawnRed));
		assertNotSame("Different pawns(green and blue) returning true in equals",pawnBlue.equals(pawnGreen));
		assertNotSame("Different pawns(green and red) returning true in equals",pawnGreen.equals(pawnRed));
	}
}


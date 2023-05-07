package Model;




import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class testRound {

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
	void testInitialQueue() {
		Round round = new Round();
		round.inicialQueue(playerYellow, playerRed, playerBlue, playerGreen);

		// Check if the queue is assigned correctly
		assertEquals("Error in round queue assignment", playerYellow, round.queue.peek());
		assertEquals("Error in round queue assignment", playerRed, round.queue.toArray()[1]);
		assertEquals("Error in round queue assignment", playerBlue, round.queue.toArray()[2]);
		assertEquals("Error in round queue assignment", playerGreen, round.queue.toArray()[3]);
	}

	@Test
	void testGetNextPlayer() {
		Round round = new Round();
		round.inicialQueue(playerYellow, playerRed, playerBlue, playerGreen);

		// Check if the players are passed correctly
		Player currentPlayer = round.getNextPlayer();
		assertEquals("Error in round passing", playerYellow, currentPlayer);

		currentPlayer = round.getNextPlayer();
		assertEquals("Error in round passing", playerRed, currentPlayer);

		currentPlayer = round.getNextPlayer();
		assertEquals("Error in round passing", playerBlue, currentPlayer);

		currentPlayer = round.getNextPlayer();
		assertEquals("Error in round passing", playerGreen, currentPlayer);

		// Now it should go back to playerYellow
		currentPlayer = round.getNextPlayer();
		assertEquals("Error in round passing", playerYellow, currentPlayer);
	}
} 
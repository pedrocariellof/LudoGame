package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * The class Player is relative for how color the player represet's 
 * in the Ludo game, that class are used in the Round class too
 * */
class Player {
	private int pawnsInBase = 4;
	private int pawnsFinished = 0;
	private int startHouse;
	private List<Pawn> pawnsBoardposition = new ArrayList<Pawn>(4);
	
	Player(int startHouse, Pawn p1, Pawn p2, Pawn p3, Pawn p4){
		this.startHouse = startHouse;
		
			pawnsBoardposition.add(p1);
			pawnsBoardposition.add(p2);
			pawnsBoardposition.add(p3);
			pawnsBoardposition.add(p4);
	}
	
	
	/**
	 * Function to return the start house of the pawn.
	 * */
	int getStartHouse() {return startHouse;}
	
	
	/**
	 * Function to increment the quantities of pawns finished.
	 * 
	 * This gone be useful in the round to see if player win the game.
	 * */
	void incPawnsFinished() {this.pawnsFinished++;}
	
	
	/**
	 * Function to see how many pawns in base that player have
	 * @return pawnsInBase The number of pawn in base
	 * */
	int getHowManyPawnsInBase() {return pawnsInBase;}
	
	
	/**
	 * Function to add a pawn in the base
	 * */
	void incPawnsInBase() {
		this.pawnsInBase++;
	}
	
	
	/**
	 * Function to decrement one pawn of the base 
	 * */
	void decPawnsInBase() {this.pawnsInBase--;}
	
	
	/**
	 * Function to see if the pawn is in final line.
	 * 
	 * @param p the pawn you want to know the position
	 * 
	 * @return A integer that represent the position in the board.
	 * */
	Integer getPawnPosition(Pawn p) {
		int soma = startHouse + p.getTotalMoves();
		
		if( soma > 51) {
			return soma - 51;
		}
		
		return soma;
	}
	
	
	/**
	 * Function to see all pawns position of the player object
	 * @return pawnsBoardposition a list with all pawns position
	 * */
	List<Integer> getAllPawnsBoardposition() {
		ArrayList<Integer> positions = new ArrayList<Integer>();
		
		for(Pawn p : pawnsBoardposition) {
			positions.add(getPawnPosition(p));
		}
		
		return positions;
	}
	
	/**
	 * Function to see if the player won the game or not.
	 * 
	 * @return true if player win the game.
	 * @return false if player not win the game.
	 * */
	boolean isWinner() {return pawnsFinished == 4;}
}

package Model;


/**
 * <pre>In this class we implement the pawn in a short and the methods in this class
 * make bit operations to get some rules previous decided.
 * 
 * Pawn ->  0000 0000 0000 0000
 *            |    |   |_____|
 *            |    |       |
 *       (finish)(color)(distance)
 * </pre> 
 * */
class Pawn {
	private short pawn;
	boolean inbase = true;
	
	Pawn(PlayerColor pC){
		pawn = pC.getValue();
	}
	
	/**
	 * Function to get the color of the paw represented by a short
	 * 
	 * @return A short with only the first 4 bits after the first byte
	 * */
	int getColor() {return pawn & 0x0f00;}
	
	
	/**
	 * Function to remove pawn in the base.
	 * */
	void removeFromBase() {inbase = false;}
	
	
	/**
	 * Function to used to get how many steps need to complete the
	 * turn in the board.
	 * 
	 * @return A short representing the total of moves that pawn did.
	 * */
	int getTotalMoves() {return pawn & 0x00ff;}
	
	
	/**
	 * Function to return the pawn to the base.
	 * */
	void setPawnToBase() {pawn &= 0x0f00;}
	
	
	/**
	 * Function to add the dice roll to the pawn selected.
	 * 
	 * @param diceRoll the value of the dice in determinate round.
	 * */
	void addMove(int diceRoll) {pawn += diceRoll;}
	
	
	/**
	 * Function overwrite the method equals used to compare pawns.
	 * 
	 * @param two the other pawn you want to make the comparison.
	 * */
	boolean equals(Pawn two) {return (this.getColor() == two.getColor());}
	
	
	/**
	 * Function to put the pawn in the final line.
	 * */
	void setFinalLine() {pawn |= 0x8000;}
	
	
	/**
	 * Function to see if the pawn is in final line.
	 * */
	boolean isInFinalLine() {return (pawn >> 12) == 8;}
	
	
	/**
	 * Function to see if the pawn complete the final line.
	 * 
	 * @return The boolean that represent the pawn finalize the path.
	 * */
	boolean haveFinished() {return this.getTotalMoves() == 57 ? true : false;}

	
}

package Model;

import java.util.LinkedList;


class House {
	private LinkedList<Pawn> pawnsInHouse = new LinkedList<Pawn>();
	private boolean initialHouse;
	private boolean barrierUp;
	private boolean Safe;
	private boolean finalHouse;
	
	
	House(boolean Safe, boolean finalHouse, boolean initialHouse){
		this.initialHouse = initialHouse;
		this.Safe = Safe;
		this.finalHouse = finalHouse;
	}
	
	
	/**
	 * Function to add a pawn inside the house.
	 * */
	void addPawn(Pawn pawn) {pawnsInHouse.add(pawn);}
	
	
	/**
	 * Function to remove a pawn in the specific house.
	 * 
	 * @return A boolean that represent if the remove method remove something or not.
	 * */
	boolean removePawn(Pawn pawn) {return pawnsInHouse.remove(pawn);}
	
	
	/**
	 * Function to overload the removePawm method.
	 * 
	 * The difference between this functions is this one remove the first one.
	 * */
	void removePawn() {pawnsInHouse.remove();}
	
	
	/**
	 * Function to return the boolean if the house is safe or not.
	 * 
	 * @return boolean if is safe or not.
	 * */
	boolean isSafe() {return Safe;}

	
	/**
	 * Function to return the boolean if the house is final or not.
	 * 
	 * @return boolean if is final or not.
	 * */
	boolean isFinalHouse() {return finalHouse;}
	
	
	/**
	 * Function to return the list of the pawns in the house.
	 * 
	 * @return A LinkedList of pawns.
	 * */
	LinkedList<Pawn> getPawnsInHouse() {return pawnsInHouse;}

	
	/**
	 * Function to return the boolean if the house is initial or not.
	 * 
	 * @return boolean if is initial or not.
	 * */
	boolean isInitialHouse() {return initialHouse;}

	
	/**
	 * Function to return the boolean if the house has barrier or not.
	 * 
	 * @return boolean if has barrier or not.
	 * */
	boolean isBarrierUp() {return barrierUp;}

	
	/**
	 * Function to set the boolean barrier to true.
	 * */
	void setBarrierUp() {this.barrierUp = true;}
	
	
	/**
	 * Function to set the boolean barrier to false.
	 * */
	void setBarrierDown() {this.barrierUp = false;}

}

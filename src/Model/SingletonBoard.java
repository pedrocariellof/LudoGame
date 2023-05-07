package Model;
import java.util.ArrayList;
import java.util.LinkedList;



public class SingletonBoard {
	private ArrayList<House> board;
	private int length;
	
	private static SingletonBoard boardInstance;
	 
	private SingletonBoard(int length) {
		this.length = length;
		board = new ArrayList<House>(length);
	}
	
	
	public static SingletonBoard getInstance(int lenght) {
		if(boardInstance == null) {
			boardInstance = new SingletonBoard(lenght);
		}
		return boardInstance;
	}
	
	/**
	 * Static definitions in the game
	 * */
	boolean isInitialHousePositions(int position) {
		return position == 2 || position == 15 || position == 28 || position == 41;
	}
	
	
	boolean isSafeHousePosition(int position) {
		return position == 10 || position == 23 || position == 36 || position == 49;
	}
	
	
	boolean isFinalHouse(int position) {
		return position == 0 || position == 13 || position == 26 || position == 39;
	}
	
	
	/**
	 * Function to initialize the board, considered the board of the phone game Ludo
	 * not the physically game one.
	 * */
	void setBoard() {
		int i = 0;
		while(i < length) {
			if(isInitialHousePositions(i)){
				board.add(new House(false, false, true));
			}
			
			else if(isSafeHousePosition(i)) {
				board.add(new House(true, false, false));
			}
			
			else if(isFinalHouse(i)) {
				board.add(new House(false, true, false));
			}
			
			else {
				board.add(new House(false, false, false));
			}
			
			i++;
		}
	}
	
	
	/**
	 * Function to get the house object of a specific position.
	 * 
	 * @param pos position in the ArrayList.
	 * 
	 * @return A House object 
	 * */
	House getHousePosition(int pos) {return board.get(pos);}
	
	
	/**
	 * Function to check if in this house have a barrier(two pawns of same type)
	 * 
	 * @param Object House 
	 * 
	 * @return Boolean that represent the barrier in the house
	 * */
	boolean haveBarrier(House house) {return house.isBarrierUp();}
	
	/**
	 * Function to check if the pawn in the selected house is the same or not.
	 * 
	 * @param p1 The pawn you want to move
	 * @param h2 The House you want to check
	 * 
	 * @return boolean representing if is equal or not
	 * */
	boolean comparePawns(Pawn p1, House h2) {
		LinkedList<Pawn> p2 = h2.getPawnsInHouse();
		Thread t1;
		for(int i = 0; i < p2.size(); i++) {
			if(!p1.equals(p2.get(i))) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Function to see if is possible to move the pawn to the actual position and the final position
	 * 
	 * @param p The Pawn object that be added in in the house
	 * @param position1 The position initial in the pawn
	 * @param position2 The position the pawn move
	 * */
	boolean possibleMove(Pawn pawn, Player player, int position1, int diceRoll) {
		
		int position2 = diceRoll + position1;
		
		if(position2 > 51) {
			position2 -= 51;
		}
		
		
		House h2 = board.get(position2);
		House inicial = board.get(player.getPawnPosition(pawn));
		
		LinkedList<Pawn> listH2 = h2.getPawnsInHouse();
		
		if(pawn.isInFinalLine()) {
			if(pawn.getTotalMoves() + diceRoll <= 57 &&
					h2.getPawnsInHouse() == null) {return true;}
			
			else {return false;}
		}
		
		else {
			for(int i = 1; i < diceRoll; i++) {
				if(pawn.getTotalMoves() + i == 52) {return true;}
				
				else if(haveBarrier(board.get(position1 + i))) {return false;}
			}
			
			if(pawn.inbase && diceRoll == 5 && 
					!comparePawns(pawn ,inicial)) {return true;}
			
			//don't have pawns
			else if(listH2.isEmpty()) {return true;}
			
			//is safe and don't have same color pawn
			else if(h2.isSafe() && listH2.size() < 2 &&
					!comparePawns(pawn ,h2)){return true;}
			
			//is initial house and don't have pawns of same color
			else if(h2.isInitialHouse() && 
					!comparePawns(pawn, h2)){return true;}
			
			//only have one pawn
			else if(listH2.size() < 2) {return true;}
			
			return false;
		}
	}
	
	
	/**
	 * Function to check's if is possible to eat a pawn in the position 
	 * the player can move.
	 * 
	 * @param p The Pawn object that be added in in the house
	 * @param position2 The position the pawn move
	 * */
	boolean possibleEat(Pawn p, int position2) {
		House h2 = board.get(position2);
		LinkedList<Pawn> listH2 = h2.getPawnsInHouse();
		
		if(listH2.size() == 1 && !h2.isSafe() && 
				!h2.isInitialHouse()) {return true;}
		
		return false;
	}
	
	
	/**
	 * Function to see all possible moves.
	 *  
	 * only move the pawn, don't increment the pawn distance and
	 * don't remove a possible pawn in the position 2
	 * 
	 * @param p The Pawn object that be added in in the house
	 * @param position1 The position initial in the pawn
	 * @param position2 The position the pawn move
	 **/
	void moveTo(Pawn p, int position1, int position2) {
		House h1 = board.get(position1);
		House h2 = board.get(position2);
		
		if(h1.isBarrierUp()) {
			h1.setBarrierDown();
		}
		
		h1.removePawn(p);
		
		h2.addPawn(p);
	}
	
	/**
	 * Function to remove a pawn of a specific location and add in the other
	 * position.
	 * 
	 * @param p The Pawn object that be added in in the house
	 * @param position1 The position initial in the pawn
	 * @param position2 The position the pawn move
	 * */
	void eatPawn(Pawn p, int position1, int position2) {
		House h1 = board.get(position1);
		House h2 = board.get(position2);
		
		if(h1.isBarrierUp()) {
			h1.setBarrierDown();
		}
		
		h1.removePawn(p);
		h2.removePawn();
		
		h2.addPawn(p);
	}
	
	void exitBase(Pawn pawn, Player player) {
		House h1 = board.get(player.getStartHouse());
		pawn.removeFromBase();
		h1.addPawn(pawn);
	}
	
	
	void makeMove(Pawn p, Player player, int position1, int diceRoll) {
		int position2 = position1 + diceRoll;
		House h2 = board.get(position2);
		
		if(possibleMove(p, null, position1, position2) && p.getTotalMoves() + diceRoll >= 52) {
			position2 = 51 + 6*(p.getColor() - 0x0100) + (p.getTotalMoves() - 51);
			
			moveTo(p, position1, position2);
			if(p.haveFinished()) {
				player.incPawnsFinished();
			}
		}
		
		if(possibleMove(p, player, position1, position2) && possibleEat(p, position2)) {
			eatPawn(p, position1, position2);
		}
		
		else if(possibleMove(p, player, position1, position2) && comparePawns(p ,h2) && !h2.isSafe()) {
			moveTo(p, position1, position2);
			
			h2.setBarrierUp();
		}
		
		else if(possibleMove(p, player, position1, position2)) {
			moveTo(p, position1, position2);
		}
	}
}


package Model;

import java.util.LinkedList;
import java.util.Queue;

class Round {
	Queue<Player> queue = new LinkedList<Player>();
	Player currentPlayer;
	
	
	/**
	 * Function to initialize the order of the players.
	 * */
	void inicialQueue(Player p1, Player p2, Player p3, Player p4) {
		queue.add(p1);
		queue.add(p2);
		queue.add(p3);
		queue.add(p4);
	}
	
	
	/**
	 * Function to get the next player in the queue, remove him to the first position
	 * and put him in last position.
	 * 
	 * @return A Player object that represent the actual player, who going to play this turn in the game.
	 * */
	Player getNextPlayer() {
		currentPlayer = queue.remove();
		queue.add(currentPlayer);
		
		return currentPlayer;
	}
}

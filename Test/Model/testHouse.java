package Model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class testHouse {
	Pawn pawnYellow = new Pawn(PlayerColor.AMARELO);
	Pawn pawnRed = new Pawn(PlayerColor.VERMELHO);
	Pawn pawnBlue = new Pawn(PlayerColor.AZUL);
	Pawn pawnGreen = new Pawn(PlayerColor.VERDE);
	House testHouseNotSafe = new House(false,false,false);
	House testHouseSafe = new House(true,false,false);
	House testFinalHouse = new House(false,true,false);
	House testNotFinalHouse = new House(false,false,false);
	House testInitialHouse = new House(false,false,true);
	House testNotInitialHouse = new House(false,false,false);
	House testAdd = new House(false,false,false);
	House testBarrier = new House(false,false,false);
	
	@Test
	void testsYellowPawns() {
		testHouseNotSafe.addPawn(pawnYellow);
		assertEquals("Wrong yellow pawn added", PlayerColor.AMARELO.getValue(), testHouseNotSafe.getPawnsInHouse().get(0).getColor());
		testHouseNotSafe.removePawn();
	}
	
	@Test
	void testsRedPawns() {
		testHouseNotSafe.addPawn(pawnRed);
		assertEquals("Wrong red pawn added", PlayerColor.VERMELHO.getValue(), testHouseNotSafe.getPawnsInHouse().get(0).getColor());
		testHouseNotSafe.removePawn();
	}
	
	@Test
	void testsBluePawns() {
		testHouseNotSafe.addPawn(pawnBlue);
		assertEquals("Wrong blue pawn added", PlayerColor.AZUL.getValue(), testHouseNotSafe.getPawnsInHouse().get(0).getColor());
		testHouseNotSafe.removePawn();
	}
	
	@Test
	void testsGreeenPawns() { 
		testHouseNotSafe.addPawn(pawnGreen);
		assertEquals("Wrong green pawn added", PlayerColor.VERDE.getValue(), testHouseNotSafe.getPawnsInHouse().get(0).getColor());
		testHouseNotSafe.removePawn();
	}
	
	@Test
	void testSafe() {
		assertTrue("Safe house does not return true in isSafe",testHouseSafe.isSafe());
		assertFalse("Non-safe house does not return false in isSafe",testHouseNotSafe.isSafe());
	}
	
	@Test
	void testFinal() {
		assertTrue("Final house does not return true in isFinalHouse",testFinalHouse.isFinalHouse());
		assertFalse("Non-final house does not return false in isFinalHouse",testNotFinalHouse.isFinalHouse());
	}
	
	@Test
	void testPawnsInHouse() {
		assertEquals("House starts with .size() different from 0",0,testAdd.getPawnsInHouse().size());
		testAdd.addPawn(pawnBlue);
		assertEquals("getPawnsInHouse().size() returns wrong value",1,testAdd.getPawnsInHouse().size());
		testAdd.addPawn(pawnYellow);
		assertEquals("getPawnsInHouse().size() returns wrong value",2,testAdd.getPawnsInHouse().size());
		testAdd.addPawn(pawnRed);
		testAdd.addPawn(pawnGreen);
		assertEquals("getPawnsInHouse().size() returns wrong value",4,testAdd.getPawnsInHouse().size());
	}
	
	@Test
	void testInitial() {
		assertTrue("Initial house does not return true in isInitialHouse",testInitialHouse.isInitialHouse());
		assertFalse("Non-initial house does not return false in isInitialHouse",testNotInitialHouse.isInitialHouse());
	}
	
	
	@Test
	void testBarrierUp() {
		assertFalse("House without barrier doesn't return false in isBarrierUp",testBarrier.isBarrierUp());
		testBarrier.setBarrierUp();
		assertTrue("House with barrier doesn't return true in isBarrierUp",testBarrier.isBarrierUp());
		testBarrier.setBarrierDown();
		assertFalse("House with barrier down doesn't return false in isBarrierUp",testBarrier.isBarrierUp());
	}
}

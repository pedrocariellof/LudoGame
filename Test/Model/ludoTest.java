package Model;

import org.junit.runner.RunWith;		
import org.junit.runners.Suite;

@RunWith(Suite.class)				
@Suite.SuiteClasses({
testPawn.class,
testBoard.class,
testPlayer.class,
testRound.class,
testHouse.class,
})

public class ludoTest{}
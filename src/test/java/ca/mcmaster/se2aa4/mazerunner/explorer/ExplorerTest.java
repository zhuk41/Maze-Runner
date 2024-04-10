package ca.mcmaster.se2aa4.mazerunner.explorer;


import ca.mcmaster.se2aa4.mazerunner.maze.Direction;
import ca.mcmaster.se2aa4.mazerunner.maze.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExplorerTest {
    @Test
    public void explorerTest(){
        Explorer explorer = new Explorer(new Point(0,0), Direction.EAST);
        assertEquals(new Point(0,0),explorer.getLocation());
        assertEquals(Direction.EAST,explorer.getFacing());
        explorer.moveForward();
        assertEquals(new Point(0,1),explorer.getLocation());
        explorer.turnRight();
        assertEquals(Direction.SOUTH,explorer.getFacing());
        explorer.moveForward();
        assertTrue(explorer.atPoint(new Point(1,1)));
    }

}
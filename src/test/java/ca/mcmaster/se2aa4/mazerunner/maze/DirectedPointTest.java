package ca.mcmaster.se2aa4.mazerunner.maze;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class DirectedPointTest {
    private DirectedPoint d1;
    @BeforeEach
    public void makePoints(){
        d1 = new DirectedPoint( new Point(0,0), Direction.EAST);
    }
    @Test
    void getDirection() {
        assertEquals(Direction.EAST,d1.getDirection());
    }

    @Test
    void nearbyPoint() {
        assertEquals(new Point(0,1), d1.nearbyPoint(d1.getDirection()));
    }
    @Test
    void getLocation() {
        assertEquals(new Point(0,0), d1.getLocation());
    }

    @Test
    void testEquals() {
        DirectedPoint d2 = new DirectedPoint( new Point(0,0), Direction.WEST);
        assertNotEquals(d2,d1);
    }
}
package ca.mcmaster.se2aa4.mazerunner.maze;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {
    @Test
    void pointTest(){
        Point pointA = new Point(0,0);
        Point pointB = new Point(1,1);
        Point pointC = new Point(0,0);
        assertNotEquals(pointA,pointB);
        assertEquals(pointA,pointC);
        Point pointD = pointA.nearbyPoint(Direction.EAST);
        Point pointE = pointD.nearbyPoint(Direction.SOUTH);
        assertEquals(pointB,pointE);
    }
}
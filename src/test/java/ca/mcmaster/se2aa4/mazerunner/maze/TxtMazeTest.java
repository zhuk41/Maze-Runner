package ca.mcmaster.se2aa4.mazerunner.maze;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TxtMazeTest {
    Maze maze = null;
    @BeforeEach
    public void makeMaze(){
        String[] mazeString = new String[]{"###########",
                "#         #",
                "### ### ###",
                "#     #   #",
                "# # ##### #",
                "# #     #  ",
                "### # #####",
                "#   #     #",
                "  # # ### #",
                "# # # #   #",
                "###########"};
        MazeBuilder mazeBuilder = new MazeBuilder();
        maze = mazeBuilder.stringArrayBuild(Arrays.asList(mazeString),true);
    }
    @Test
    public void startTest(){
        Point expectedStart = new Point(8,0);
        assertEquals(expectedStart,maze.getStart());
    }
    @Test
    public void exitTest(){
        Point expectedExit = new Point(5,10);
        assertEquals(expectedExit,maze.getExit());
    }
    @Test
    public void directionTest(){
        assertEquals(Direction.EAST,maze.getStartDirection());
    }
    @Test
    public void wallTest(){
        assertTrue(maze.isWall(new Point(0,0)));
        assertFalse(maze.isWall(new Point(1,1)));
    }

}
package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.maze.MazeBuilder;
import ca.mcmaster.se2aa4.mazerunner.mazepath.MazePath;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MazePathVerifierTest {
    @Test
    void verify() {
        String[] mazeString = new String[]{
                "###########",
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
        Maze maze = mazeBuilder.stringArrayBuild(Arrays.asList(mazeString),true);
        PathVerifier pathVerifier = new PathVerifier(maze);
        assertTrue(pathVerifier.verify(new MazePath("FLFRFFLFFFFFFRFFFFRFFLFFRFFLF")));
        assertTrue(pathVerifier.verify(new MazePath("FRFLLFFRFFRFFLLFFFFRFFRFFFFLLFFRFFFFRFFRFFLLFFLFFLFFFFRFFRFFLLFFFFRFFRFFLLFFRFFRFFFFRFFLFFRFFLF")));
        assertFalse(pathVerifier.verify(new MazePath("RRF")));
        assertFalse(pathVerifier.verify(new MazePath("FLFRFFLFFFFFFRFFFFRFFLFFRFFLFFF")));

    }
}
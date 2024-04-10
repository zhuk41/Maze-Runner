package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.maze.MazeBuilder;
import ca.mcmaster.se2aa4.mazerunner.path.Path;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PathVerifierTest {
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
        assertTrue(pathVerifier.verify(new Path("FLFRFFLFFFFFFRFFFFRFFLFFRFFLF")));
        assertTrue(pathVerifier.verify(new Path("FRFLLFFRFFRFFLLFFFFRFFRFFFFLLFFRFFFFRFFRFFLLFFLFFLFFFFRFFRFFLLFFFFRFFRFFLLFFRFFRFFFFRFFLFFRFFLF")));
        assertFalse(pathVerifier.verify(new Path("RRF")));
        assertFalse(pathVerifier.verify(new Path("FLFRFFLFFFFFFRFFFFRFFLFFRFFLFFF")));

    }
}
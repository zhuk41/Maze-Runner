package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.algorithem.MazeSolver;
import ca.mcmaster.se2aa4.mazerunner.algorithem.SolverFactory;
import ca.mcmaster.se2aa4.mazerunner.maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.maze.MazeBuilder;
import ca.mcmaster.se2aa4.mazerunner.path.Path;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolverTest {
    private static SolverFactory solverFactory;
    private static  Maze maze;
    @BeforeAll
    public static void makeFactory(){
        solverFactory = SolverFactory.getInstance();
        String[] mazeString = new String[]{
                        "#######" ,
                        "#      " ,
                        "### ###" ,
                        "#     #" ,
                        "### ###" ,
                        "      #" ,
                        "#######"};
        MazeBuilder mazeBuilder = new MazeBuilder();
        maze = mazeBuilder.stringArrayBuild(Arrays.asList(mazeString),true);
    }
    @Test
    public void rightHandTest(){
        MazeSolver solver = solverFactory.getSolver("righthand");
        Path path = solver.withMaze(maze).solve();
        PathVerifier pathVerifier = new PathVerifier(maze);
        assertTrue(pathVerifier.verify(path));
    }
    @Test
    public void bfsTest(){
        MazeSolver solver = solverFactory.getSolver("bfs");
        Path path = solver.withMaze(maze).solve();
        PathVerifier pathVerifier = new PathVerifier(maze);
        assertTrue(pathVerifier.verify(path));
    }


}

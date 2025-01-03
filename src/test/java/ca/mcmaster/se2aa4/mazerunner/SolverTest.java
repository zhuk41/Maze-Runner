package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.algorithem.MazeSolver;
import ca.mcmaster.se2aa4.mazerunner.algorithem.SolverFactory;
import ca.mcmaster.se2aa4.mazerunner.maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.maze.MazeBuilder;
import ca.mcmaster.se2aa4.mazerunner.mazepath.MazePath;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolverTest {
    private static SolverFactory solverFactory;
    private static  Maze maze;
    @BeforeAll
    static void makeFactory(){
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
    void rightHandTest(){
        MazeSolver solver = solverFactory.getSolver("righthand");
        MazePath mazePath = solver.withMaze(maze).solve();
        PathVerifier pathVerifier = new PathVerifier(maze);
        assertTrue(pathVerifier.verify(mazePath));
    }
    @Test
    void bfsTest(){
        MazeSolver solver = solverFactory.getSolver("bfs");
        MazePath mazePath = solver.withMaze(maze).solve();
        PathVerifier pathVerifier = new PathVerifier(maze);
        assertTrue(pathVerifier.verify(mazePath));
    }


}

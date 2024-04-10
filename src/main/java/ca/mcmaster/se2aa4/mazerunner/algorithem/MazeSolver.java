package ca.mcmaster.se2aa4.mazerunner.algorithem;
import ca.mcmaster.se2aa4.mazerunner.maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.mazepath.MazePath;

public interface MazeSolver {
    MazeSolver withMaze(Maze maze);
    MazePath solve();

}

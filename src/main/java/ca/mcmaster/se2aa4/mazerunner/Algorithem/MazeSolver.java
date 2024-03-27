package ca.mcmaster.se2aa4.mazerunner.Algorithem;
import ca.mcmaster.se2aa4.mazerunner.Maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.Path.Path;

public interface MazeSolver {
    Maze maze = null;
    Path path = null;
    Path solve();
}

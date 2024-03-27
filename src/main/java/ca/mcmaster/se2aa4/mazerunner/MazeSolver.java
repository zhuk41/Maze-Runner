package ca.mcmaster.se2aa4.mazerunner;

public interface MazeSolver {
    Maze maze = null;
    Path path = null;
    Path solve();
}

package ca.mcmaster.se2aa4.mazerunner.Maze;

public interface Maze {
    boolean isWall(Point p);
    boolean isWall(Point p, Direction d);
    Point getStart();
    Point getExit();
    Direction getStartDirection();
    boolean inMaze(Point p);
}

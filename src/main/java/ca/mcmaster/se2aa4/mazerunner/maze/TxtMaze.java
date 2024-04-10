package ca.mcmaster.se2aa4.mazerunner.maze;


import java.util.List;

public class TxtMaze implements Maze {
    private final List<String> maze;
    private final int width;
    private final int height;
    private final Point start;
    private final Point exit;
    private final Direction startDirection;

    public TxtMaze(List<String> maze, int width, int height, Point start, Point exit, Direction startDirection) {
        this.maze = maze;
        this.width = width;
        this.height = height;
        this.start = start;
        this.exit = exit;
        this.startDirection = startDirection;
    }

    public boolean isWall(Point p){
        String row  = maze.get(p.getRow());
        return row.charAt(p.getColumn()) == '#';
    }
    public boolean isWall(Point p, Direction d){
        return isWall(p.nearbyPoint(d));
    }

    public Direction getStartDirection(){
        return startDirection;
    }
    public Point getStart(){
        return start;
    }
    public Point getExit(){
        return exit;
    }
    public boolean inMaze(Point p){
        return (0 <= p.getRow()) && (p.getRow() < height) && (0 <= p.getColumn()) && (p.getColumn() < width);
    }
}

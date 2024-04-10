package ca.mcmaster.se2aa4.mazerunner.maze;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.AbstractList;
import java.util.ArrayList;

public class TxtMaze implements Maze {
    private final AbstractList<String> maze = new ArrayList<>();
    private final int width;
    private final int height;
    private final Point start;
    private final Point exit;
    private final Direction startDirection;
    public TxtMaze(BufferedReader reader, boolean leftStart) throws IOException {
        int i = 1;
        int leftOpeningRow = 0;
        int rightOpeningRow = 0;
        String firstRow =reader.readLine();
        width = firstRow.length();
        maze.add(firstRow);
        while (reader.ready()) {
            String row = reader.readLine();
            if (row == null){
                break;
            }
            maze.add(row);
            if (row.charAt(0)==' '){
                leftOpeningRow = i;
            }
            if (row.charAt(width-1)==' '){
                rightOpeningRow = i;
            }
            i++;
        }
        height = i;
        if (leftStart){
            start = new Point(leftOpeningRow,0);
            exit =  new Point(rightOpeningRow,width -1);
            startDirection =Direction.EAST;
        }
        else/*Right start*/{
            start = new Point(rightOpeningRow,width -1);
            exit = new Point(leftOpeningRow,0);
             startDirection = Direction.WEST;
        }
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

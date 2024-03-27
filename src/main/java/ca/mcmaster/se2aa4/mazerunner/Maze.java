package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

public class Maze {
    private final ArrayList<String> maze = new ArrayList<>();
    private final int width;
    private final int height;
    private final Point start,exit;
    private final Direction start_direction;
    public Maze (File file,boolean leftStart) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int i = 1;
        int left_opening_row = 0;
        int right_opening_row = 0;
        String first_row =reader.readLine();
        width = first_row.length();
        maze.add(first_row);
        while (reader.ready()) {
            String row = reader.readLine();
            maze.add(row);
            if (row.charAt(0)==' '){
                left_opening_row = i;
            }
            if (row.charAt(width-1)==' '){
                right_opening_row = i;
            }
            i++;
        }
        reader.close();
        height = i;
        if (leftStart){
            start = new Point(left_opening_row,0);
            exit =  new Point(right_opening_row,width -1);
            start_direction =Direction.EAST;
        }
        else/*Right start*/{
            start = new Point(right_opening_row,width -1);
            exit = new Point(left_opening_row,0);
             start_direction = Direction.WEST;
        }
    }
    public boolean isWall(Point p){
        String maze_row  = maze.get(p.row);
        return maze_row.charAt(p.column) == '#';
    }
    public Direction getStartDirection(){
        return start_direction;
    }
    public Point getStart(){
        return start;
    }
    public Point getExit(){
        return exit;
    }
    public boolean inMaze(Point p){
        return (0 <= p.row) && (p.row < height) && (0 <= p.column) && (p.column < width);
    }
}

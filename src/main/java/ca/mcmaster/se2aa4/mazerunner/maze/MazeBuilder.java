package ca.mcmaster.se2aa4.mazerunner.maze;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MazeBuilder {
    public Maze fileBuild(File file, boolean leftStart) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            List<String> maze = new ArrayList<>();
            while (reader.ready()) {
                maze.add(reader.readLine());
            }
            return stringArrayBuild(maze, leftStart);
        }

    }
    public Maze stringArrayBuild(List<String> maze, boolean leftStart){
        int width = maze.get(0).length();
        int height = maze.size();
        Direction startDirection;
        Point leftOpening = null;
        Point rightOpening = null;
        for (int i = 0; i < height; i++){
            if (maze.get(i).charAt(0) == ' '){
                leftOpening = new Point(i,0);
            }
            if (maze.get(i).charAt(width-1) == ' '){
                rightOpening = new Point(i,width -1);
            }
        }
        Point start;
        Point exit;
        if (leftStart){
            start = leftOpening;
            exit = rightOpening;
            startDirection =Direction.EAST;
        }
        else/*Right start*/{
            start = rightOpening;
            exit = leftOpening;
            startDirection = Direction.WEST;
        }
        return new TxtMaze(maze,  width,  height,  start,  exit,  startDirection);
    }
}

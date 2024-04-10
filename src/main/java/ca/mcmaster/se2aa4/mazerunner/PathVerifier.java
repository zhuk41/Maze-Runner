package ca.mcmaster.se2aa4.mazerunner;


import ca.mcmaster.se2aa4.mazerunner.explorer.Explorer;
import ca.mcmaster.se2aa4.mazerunner.maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.maze.Point;
import ca.mcmaster.se2aa4.mazerunner.mazepath.MazePath;

public class PathVerifier {
    private final Maze maze;

    PathVerifier(Maze maze){
        this.maze = maze;
    }
    public boolean verify(MazePath mazePath){
        Explorer explorer = new Explorer(maze.getStart(),maze.getStartDirection());
        for(int i = 0; i < mazePath.length(); i++ ){
            if (mazePath.stepAt(i) == 'R') {
                explorer.turnRight();
            }
            else if (mazePath.stepAt(i) =='L') {
                explorer.turnLeft();
            }
            else if (mazePath.stepAt(i) == 'F') {
                explorer.moveForward();
            }
            if (!maze.inMaze(explorer.getLocation())) {
                return false;
            }

            if (maze.isWall(explorer.getLocation())) {
                return false;
            }
        }
        Point exit = maze.getExit();
        return exit.equals(explorer.getLocation());
    }
}

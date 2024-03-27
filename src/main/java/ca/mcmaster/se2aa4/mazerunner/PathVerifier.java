package ca.mcmaster.se2aa4.mazerunner;


import ca.mcmaster.se2aa4.mazerunner.Explorer.Explorer;
import ca.mcmaster.se2aa4.mazerunner.Maze.*;
import ca.mcmaster.se2aa4.mazerunner.Path.Path;

public class PathVerifier {
    private final Maze maze;

    PathVerifier(Maze the_maze){
        maze = the_maze;
    }
    public boolean verify(Path path){
        Explorer explorer = new Explorer(maze.getStart(),maze.getStartDirection());
        for(int i = 0; i < path.length(); i++ ){
            if (path.stepAt(i) == 'R') explorer.turnRight();
            else if (path.stepAt(i) =='L') explorer.turnLeft();
            else if (path.stepAt(i) == 'F') explorer.moveForward();
            if (!maze.inMaze(explorer.getLocation()))return false;

            if (maze.isWall(explorer.getLocation()))return false;
        }
        Point exit =maze.getExit();
        return exit.equals(explorer.getLocation());
    }
}

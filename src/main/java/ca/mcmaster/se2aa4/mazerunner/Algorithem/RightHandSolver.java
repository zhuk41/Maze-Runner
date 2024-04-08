package ca.mcmaster.se2aa4.mazerunner.Algorithem;

import ca.mcmaster.se2aa4.mazerunner.Explorer.Explorer;
import ca.mcmaster.se2aa4.mazerunner.Maze.*;
import ca.mcmaster.se2aa4.mazerunner.Path.Path;

public class RightHandSolver implements MazeSolver {
    private Maze maze;
    public RightHandSolver(){}
    @Override
    public MazeSolver withMaze(Maze the_maze) {
        maze = the_maze;
        return this;
    }

    @Override
    public Path solve(){
        Path path = new Path();
        Explorer explorer = new Explorer(maze.getStart(), maze.getStartDirection());
        while(!explorer.atPoint(maze.getExit())){
            if (!maze.isWall(explorer.getLocation(),(explorer.getFacing().right()))) {
                explorer.turnRight();
                path.addStep('R');
                explorer.moveForward();
                path.addStep('F');
            }
            else if (!maze.isWall(explorer.getLocation(), explorer.getFacing())){
                explorer.moveForward();
                path.addStep('F');
            }
            else{
                explorer.turnLeft();
                path.addStep('L');
            }
        }
        return path;
    }
}

package ca.mcmaster.se2aa4.mazerunner.algorithem;

import ca.mcmaster.se2aa4.mazerunner.explorer.Explorer;
import ca.mcmaster.se2aa4.mazerunner.maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.path.Path;

public class RightHandSolver implements MazeSolver {
    private Maze maze;
    @Override
    public MazeSolver withMaze(Maze maze) {
        this.maze = maze;
        return this;
    }

    @Override
    public Path solve(){
        Path path = new Path();
        Explorer explorer = new Explorer(maze.getStart(), maze.getStartDirection());
        while(!explorer.atPoint(maze.getExit())){
            if (!maze.isWall(explorer.getLocation(),explorer.getFacing().right())) {
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

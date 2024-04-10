package ca.mcmaster.se2aa4.mazerunner.algorithem;

import ca.mcmaster.se2aa4.mazerunner.explorer.Explorer;
import ca.mcmaster.se2aa4.mazerunner.maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.mazepath.MazePath;

public class RightHandSolver implements MazeSolver {
    private Maze maze;
    @Override
    public MazeSolver withMaze(Maze maze) {
        this.maze = maze;
        return this;
    }

    @Override
    public MazePath solve(){
        MazePath mazePath = new MazePath();
        Explorer explorer = new Explorer(maze.getStart(), maze.getStartDirection());
        while(!explorer.atPoint(maze.getExit())){
            if (!maze.isWall(explorer.getLocation(),explorer.getFacing().right())) {
                explorer.turnRight();
                mazePath.addStep('R');
                explorer.moveForward();
                mazePath.addStep('F');
            }
            else if (!maze.isWall(explorer.getLocation(), explorer.getFacing())){
                explorer.moveForward();
                mazePath.addStep('F');
            }
            else{
                explorer.turnLeft();
                mazePath.addStep('L');
            }
        }
        return mazePath;
    }
}

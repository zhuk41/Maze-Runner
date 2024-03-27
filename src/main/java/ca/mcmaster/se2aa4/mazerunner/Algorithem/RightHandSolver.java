package ca.mcmaster.se2aa4.mazerunner.Algorithem;

import ca.mcmaster.se2aa4.mazerunner.Direction;
import ca.mcmaster.se2aa4.mazerunner.Explorer.Explorer;
import ca.mcmaster.se2aa4.mazerunner.MazeSolver;
import ca.mcmaster.se2aa4.mazerunner.Maze.*;
import ca.mcmaster.se2aa4.mazerunner.Path.Path;

public class RightHandSolver implements MazeSolver {
    private final Explorer explorer;
    private final Maze maze;
    private Path path;
    public RightHandSolver(Maze the_maze){
        maze = the_maze;
        path = new Path();
        explorer = new Explorer(maze.getStart(), maze.getStartDirection());
    }
    @Override
    public Path solve(){
        while(!explorer.atPoint(maze.getExit())){
            if (!explorer.isWall(Direction.right(explorer.getFacing()),maze)) {
                explorer.turnRight();
                path.addStep('R');
                explorer.moveForward();
                path.addStep('F');
            }
            else if (!explorer.isWall(explorer.getFacing(),maze)){
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

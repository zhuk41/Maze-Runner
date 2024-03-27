package ca.mcmaster.se2aa4.mazerunner;

public class RightHandSolver implements MazeSolver {
    Skeleton skeleton;
    Maze maze;
    Path path;
    public RightHandSolver(Maze the_maze){
        maze = the_maze;
        path = new Path();
        skeleton = new Skeleton(maze.getStart(), maze.getStartDirection());
    }
    @Override
    public Path solve(){
        while(!skeleton.atPoint(maze.getExit())){
            if (!skeleton.isWall(Direction.right(skeleton.facing),maze)) {
                skeleton.turnRight();
                path.addStep('R');
                skeleton.moveForward();
                path.addStep('F');
            }
            else if (!skeleton.isWall(skeleton.facing,maze)){
                skeleton.moveForward();
                path.addStep('F');
            }
            else{
                skeleton.turnLeft();
                path.addStep('L');
            }
        }
        return path;
    }
}

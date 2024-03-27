package ca.mcmaster.se2aa4.mazerunner;

public class PathVerifier {
    private final Maze maze;

    PathVerifier(Maze the_maze){
        maze = the_maze;
    }
    public boolean verify(Path path){
        Skeleton skeleton = new Skeleton(maze.getStart(),maze.getStartDirection());
        for(int i = 0; i < path.length();i++ ){
            if (path.stepAt(i) == 'R') skeleton.turnRight();
            else if (path.stepAt(i) =='L') skeleton.turnLeft();
            else if (path.stepAt(i) == 'F')skeleton.moveForward();
            if (!maze.inMaze(skeleton.location))return false;

            if (maze.isWall(skeleton.location))return false;
        }
        Point exit =maze.getExit();
        return exit.equals(skeleton.location);
    }
}

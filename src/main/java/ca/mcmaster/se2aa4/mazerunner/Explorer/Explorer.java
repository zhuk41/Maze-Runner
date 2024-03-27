package ca.mcmaster.se2aa4.mazerunner.Explorer;

import ca.mcmaster.se2aa4.mazerunner.Maze.Direction;
import ca.mcmaster.se2aa4.mazerunner.Maze.*;
public class Explorer {
    private Point location;
    private Direction facing;
    public Explorer(Point start, Direction starting_direction){
        facing = starting_direction;
        location = start;
    }
    public void turnRight(){
        facing = Direction.right(facing);
    }
    public void turnLeft(){
        facing = Direction.left(facing);
    }
    public void moveForward() {
        location = location.NearbyPoint(facing);
    }
    public boolean atPoint(Point point){
        return point.equals(location);
    }
    public boolean isWall(Direction direction,Maze maze){
        return maze.isWall(location, direction);
    }
    public Point getLocation(){
        return location;
    }

    public Direction getFacing() {
        return facing;
    }
}